/*
tree is not balanced when h(l) - h(r) != (0, 1, -1);
case 1 new node(3) added in LL(left k left mein) => rotate right(10) 
            10                                5
          /   \                             /   \
        5    T1                           3     10
      /  \                              /  \   /  \
    3    T2                            T3  T4 T2  T1
  /  \
T3    T4

case 2 new node(20) added in RR(right ke right mein) => rotate left(10)
            10                                15
          /   \                             /   \
        T1    15                           10     20
             /  \                        /  \   /  \
           T2    20                     T1  T2 T3  T4
                /  \
              T3    T4

case 3 new node(8) added in LR(left ke right mein) => rotate left +  rotate right
             TREE                             rotate left 5              rotate right 10
            10                                10                              8
          /   \                             /   \                           /  \
        5    T1                           8     T1                        5     10
      /  \                              /  \                            /  \   /  \ 
    T2    8                            5  T4                           T2  T3 T4  T1  
         /  \                        /  \
        T3    T4                    T2   T3


ase 4  new node(12) added in RL(right ke left mein) = > rotate right + rotate left
            TREE                          rotate right 15                     rotate left 12
            10                            10                                  12
           /  \                          /  \                                /   \
        T!     15                       T1   12                             10   15
              /  \                          /  \                           /  \  /  \
             12   T2                       T3   15                       T1  T3 T4  T2
            /  \                               /  \   
           T3   T4                            T4   T2 
*/        


class avl {
    static class Node {
        int data;
        Node left;
        Node right;
        int height;
        Node(int x){
            this.data = x;
            this.left = this.right = null;
            this.height = 1;
        }
    }

    public static int height(Node a){
        if(a == null){
            return 0;
        }
        return a.height;
    }
    /*
           a     =>              b
          /  \                  /  \
         b    t1               c    a
        / \                        / \
       c   temp                  temp  t1
    */
    public static Node rotateRight(Node a){
        Node b = a.left;
        Node temp = b.right;
        b.right = a;
        a.left = temp;
        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    /*
        a                                  b
       /  \                               /  \
      t1    b                            a    c
           / \                          / \
          temp c                       t1  temp
    */
    public static Node rotateLeft(Node a){
        Node b = a.right;
        Node temp = b.left;
        b.left = a;
        a.right = temp;
        a.height = Math.max(height(a.left), height(a.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    public Node insertToAVL(Node node, int data) {
        if(node == null){
            return new Node(data);
        }
        if(node.data > data){
            node.left = insertToAVL(node.left, data);
        }
        else if(node.data < data){
            node.right = insertToAVL(node.right, data);
        }

        int lh = height(node.left);
        int rh = height(node.right);
        node.height = Math.max(lh, rh) + 1;
        int diff = lh - rh;
        Node newNode = node;
        if(diff > 1 && node.left.data >= data){ //LL
            newNode = rotateRight(node);
        }
        else if(diff > 1 && node.left.data < data){ //LR
            node.left = rotateLeft(node.left);
            newNode = rotateRight(node);
        }
        else if(diff < -1 && node.right.data <= data){ //RR
            newNode = rotateLeft(node);
        }
        else if(diff < -1 && node.right.data > data){//RL
            node.right = rotateRight(node.right);
            newNode = rotateLeft(node);
        }
        return newNode;
    }

    public static Node max(Node node){
        if(node.right == null){
            return node;
        }
        else{
            return max(node.right);
        }
    }

    public static int getBalance(Node n){
        if(n == null) return 0;
        return height(n.left) - height(n.right);
    }

    public static Node deleteNode(Node node, int data){
        if(node == null) return null;
        if(node.data > data){
            node.left = deleteNode(node.left, data);
        }
        else if(node.data < data){
            node.right = deleteNode(node.right, data);
        }
        else{
            if(node.left == null && node.right == null){
                return null;
            }
            else if(node.right == null){
                return node.left;
            }
            else if(node.left == null){
                return node.right;
            }
            else{
                Node lmax = max(node.left);
                node.data = lmax.data;
                node.left = deleteNode(node.left, lmax.data);
            }
        }

        int lh = height(node.left);
        int rh = height(node.right);
        node.height = Math.max(lh, rh) + 1;
        int diff = lh - rh;
        Node newNode = node;
        if(diff > 1 && getBalance(node.left) >= 0){ //LL
            newNode = rotateRight(node);
        }
        else if(diff > 1 && getBalance(node.left) < 0){ //LR
            node.left = rotateLeft(node.left);
            newNode = rotateRight(node);
        }
        else if(diff < -1 && getBalance(node.right) <= 0){ //RR
            newNode = rotateLeft(node);
        }
        else if(diff < -1 && getBalance(node.right) > 0){//RL
            node.right = rotateRight(node.right);
            newNode = rotateLeft(node);
        }
        return newNode;
    }
}
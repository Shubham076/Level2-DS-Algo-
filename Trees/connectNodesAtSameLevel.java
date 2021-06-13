import java.util.*;
//leetcode 116,117
class connectNodesAtSameLevel{
    static class Node{
        int val;
        Node left;
        Node right;
        Node nextRight;
        Node(int val, Node left, Node right, Node nextRight){
            this.val = val;
            this.left = left;
            this.right = right;
            this.nextRight = nextRight;
        }
    }

    public static Node connect(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while(q.size() > 0){
            int s = q.size();
            Node prev = null;
            while(s-- > 0){
                Node rp = q.remove();
                if(prev == null){
                    prev = rp;
                }
                else{
                    prev.nextRight = rp;
                    prev = rp;
                }

                if(rp.left != null){
                    q.add(rp.left);
                }

                if(rp.right != null){
                    q.add(rp.right);
                }
            }
        }
        return root;
    }

    //without using extra space
    public static Node connect2(Node root){
        if(root == null) return null;
        //means next level is available
        Node actual = root;
        while(root.left != null){

            Node temp = root;
            while(temp != null){
                temp.left.nextRight = temp.right;
                if(temp.nextRight != null){
                    temp.right.nextRight = temp.nextRight.left;
                }
                temp = temp.nextRight;
            }
            root = root.left;
        }
        return actual;
    }
    public static Node constructTree(Integer[] arr){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(arr[0], null, null, null));
        Node root = null;
        int i = 1;
        while(q.size() > 0 && i < arr.length){
            Node rp = q.remove();
            if(root == null){
                root = rp;
            }

            //adding the left child
            if(arr[i] != null){
                rp.left = new Node(arr[i], null, null, null);
                q.add(rp.left);
            }
            i++;

            if(i >= arr.length) break;
            
            //adding the right child
            if(arr[i] != null){
                rp.right = new Node(arr[i], null, null, null);
                q.add(rp.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args){
        Integer[] arr = {1, 2, 3, 4, 5};
        Node root = constructTree(arr);
        connect(root);
    }
}
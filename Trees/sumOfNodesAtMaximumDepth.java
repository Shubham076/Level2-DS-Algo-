/*
Sum of nodes at maximum depth of a Binary Tree. Given a
root node to a tree, find the sum of all the leaf nodes which are at maximum
depth from root node.
*/
import java.util.*;
class sumOfNodesAtMaximumDepth{
	static class Node{
        int data;
        Node left;
        Node right;
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString(){
            return this.data + "";
        }
    }

    public static Node constructTree(Integer[] arr){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(arr[0], null, null));
        Node root = null;
        int i = 1;
        while(q.size() > 0 && i < arr.length){
            Node rp = q.remove();
            if(root == null){
                root = rp;
            }

            //adding the left child
            if(arr[i] != null){
                rp.left = new Node(arr[i], null, null);
                q.add(rp.left);
            }
            i++;

            if(i >= arr.length) break;
            
            //adding the right child
            if(arr[i] != null){
                rp.right = new Node(arr[i], null, null);
                q.add(rp.right);
            }
            i++;
        }
        return root;
    }

    static int sum = 0;
    static int maxLevel = 0;
    public static void calculateSum(Node root, int l){
    	if(root == null){
    		return;
    	}

    	if(l > maxLevel){
    		sum = root.data;
    		maxLevel = l;
    	}
    	else if(l == maxLevel){
    		sum += root.data;
    	}
    	calculateSum(root.left, l + 1);
    	calculateSum(root.right, l + 1);
    }
    public static void main(String[] args){
        Integer[] arr = {1, 2, 3, 4, 6};
        Node root = constructTree(arr);
        calculateSum(root, 0);
        System.out.println(sum);
    }
}
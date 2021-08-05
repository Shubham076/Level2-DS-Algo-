class flattenBinaryTreeToCicularDLL {
	static class Node {
		int data;
		Node left, right;
		Node(int d) {
			data = d;
			left = right = null;
		}
	}
	//function accept the tails DLL
	public static Node mergeDLL(Node t1, Node t2){
	 	Node h1 = t1.right;
	 	Node h2 = t2.right;
	 	
	 	t1.right = h2;
	 	h2.left = t1;
	 	h1.left = t2;
	 	t2.right = h1;

	 	return t2;
	 }
	 
	 static Node bTreeToClist(Node root){
	     return convert(root).right;
	 }

	 static Node convert(Node root){
        if(root == null) return null;
        Node lt = convert(root.left);
        Node rt = convert(root.right);

        if(root.left == null && root.right == null){
        	root.left = root;
        	root.right = root;
        	return root; 
        }
        else if(root.right == null){
        	root.left = root;
        	root.right = root;
        	return mergeDLL(lt, root);
        }
        else if(root.left == null){
        	root.left = root;
        	root.right = root;
        	return mergeDLL(root, rt);
        }
        else{
        	Node right = root.right;
        	root.left = root;
        	root.right = root;
        	Node t1 = mergeDLL(lt, root);
        	Node t2 = mergeDLL(t1, rt);
        	return t2;
        }
    }
}
package Tree;

public class TreeTraversals {
	static class Node{
		int data;
		Node left,right;
		public Node(int data){
			this.data=data;
		}
	}
	public static void main(String[] args) {
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		
		System.out.println("Preorder traversal of binary tree is ");
		printPreorder(root);
	
		System.out.println("Inorder traversal of binary tree is \n");
		printInorder(root);  
	
		System.out.println("Postorder traversal of binary tree is \n");
		printPostorder(root);
	}
	static void printPreorder(Node node){
		if(node==null)
			return;
		
		System.out.println(node.data);
		
		printPreorder(node.left);
		
		printPreorder(node.right);
	}
	static void printInorder(Node node){
		if(node==null)
			return;
		
		printInorder(node.left);

		System.out.println(node.data);
		
		printInorder(node.right);
	}
	static void printPostorder(Node node){
		if(node==null)
			return;
		
		printPostorder(node.left);

		printPostorder(node.right);
		
		System.out.println(node.data);
	}
}

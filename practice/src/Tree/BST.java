package Tree;

public class BST {

	static class Node{
		int key;
		Node left,right;
		public Node(int key){
			this.key=key;
			
		}
	}
	public static void main(String[] args) {
		Node root=insert(null,50);
		insert(root, 30);
		insert(root, 20);
		insert(root, 40);
		insert(root, 70);
		insert(root, 60);
		insert(root, 80);
		
		inorder(root);
		minValue(root);
		
	}
	static void minValue(Node node){
		while(node.left!=null){
			node=node.left;
		}
		System.out.println(node.key);
	}
	static Node insert(Node node,int key){
		if(node==null)
			return new Node(key);
		
		if(key<node.key)
			node.left=insert(node.left,key);
		else if(key>node.key)
			node.right=insert(node.right,key);
		
		return node;
	}
	static void inorder(Node node){
		if(node!=null){
			inorder(node.left);
			System.out.println(node.key);
			inorder(node.right);
		}
	}
}

package Tree;

public class PrintBSTKeysInTheGivenRange {
	static class Node{
		int key;
		Node left,right;
		public Node(int key){
			this.key=key;
		}
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
	static void print(Node root,int k1,int k2){
		if(root==null)
			return;
		
		if(k1<root.key)
			print(root.left,k1,k2);
		
		if(k1<root.key&&k2>root.key)
			System.out.println(root.key);
		
		if(k2>root.key)
			print(root.right,k1,k2);
	}
	public static void main(String[] args) {
		Node root=insert(null,20);
		insert(root,8);
		insert(root,22);
		insert(root,4);
		insert(root,12);
		
		int k1=10,k2=25;
		print(root,k1,k2);
	}

}

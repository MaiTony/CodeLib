package Tree;

public class LCA_BST {
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
	public static void main(String[] args) {
		Node root=insert(null,20);
		insert(root,8);
		insert(root,22);
		insert(root,4);
		insert(root,12);
		insert(root,10);
		insert(root,14);
		
		int n1=10,n2=14;
		Node t=lca_1(root,n1,n2);
		System.out.println(String.format("LCA of %d and %d is %d ", n1, n2, t.key));

		n1=14;
		n2=8;
		t=lca_1(root,n1,n2);
		System.out.println(String.format("LCA of %d and %d is %d ", n1, n2, t.key));

		n1=10;n2=22;
		t=lca_1(root,n1,n2);
		System.out.println(String.format("LCA of %d and %d is %d ", n1, n2, t.key));
		
		n1=10;
		n2=14;
		t=lca_2(root,n1,n2);
		System.out.println(String.format("LCA of %d and %d is %d ", n1, n2, t.key));

		n1=14;
		n2=8;
		t=lca_2(root,n1,n2);
		System.out.println(String.format("LCA of %d and %d is %d ", n1, n2, t.key));

		n1=10;n2=22;
		t=lca_2(root,n1,n2);
		System.out.println(String.format("LCA of %d and %d is %d ", n1, n2, t.key));


	}
	static Node lca_1(Node root,int n1,int n2){
		if(root==null)
			return root;
		
		if(root.key>n1&&root.key>n2){
			return lca_1(root.left,n1,n2);
		}
		
		if(root.key<n1&&root.key<n2){
			return lca_1(root.right,n1,n2);
		}
		return root;
	}
	static Node lca_2(Node root,int n1,int n2){
		while(root!=null){
			if(root.key>n1&&root.key>n2)
				root=root.left;
			else if(root.key<n1&&root.key<n2)
				root=root.right;
			else
				break;
		}
		return root;
	}
}

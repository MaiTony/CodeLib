package Tree;

public class IntervalTree {
	static class Node{
		int max;
		Node left,right;
		int[] data;
		public Node(int[] data){
			this.data=data;
			this.max=data[1];
		}
	}
	public static void main(String[] args) {
		int[][] interval={{15,20},{10,30},{17,19},{5,20},{12,15},{30,40}};
		int i,n=interval.length;
		Node root=null;
		for(i=0;i<n;i++)
			root=insert(root,interval[i]);
		
		System.out.println("Inorder traversal of constructed Interval Tree is");
		inorder(root);
		
		int[] x={6,7};
		System.out.println(String.format("Searching for interval [%d,%d]",x[0],x[1]));
		int[] y=overlapSearch(root, x);
		if(y==null)
			System.out.println("No Overlapping Interval");
		else
			System.out.println(String.format("Overlaps with [%d,%d]",y[0],y[1]));
		
	}
	static int[] overlapSearch(Node root,int[] x){
		if(root==null)
			return null;
		
		if(doOVerlap(root.data,x))
			return root.data;
		
		if(root.left!=null&&root.left.max>=x[0])
			return overlapSearch(root.left, x);
		
		return overlapSearch(root.right, x);
	}
	static boolean doOVerlap(int[] y,int[] x){
		if(y[0]<=x[1]&&x[0]<=y[1])
			return true;
		return false;
	}
	static void inorder(Node root){
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.println(String.format("[%d,%d] max=%d", root.data[0],root.data[1],root.max));
		inorder(root.right);
		
	}
	static Node insert(Node root, int[] data){
		if(root==null)
			return new Node(data);
		
		int l=root.data[0];
		if(data[0]<l)
			root.left=insert(root.left,data);
		else
			root.right=insert(root.right,data);
		
		root.max=Math.max(root.max, data[1]);
		
		return root;
	}
}

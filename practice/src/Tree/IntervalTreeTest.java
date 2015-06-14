package Tree;

public class IntervalTreeTest {
	static class Composer{
		String name;
		int birth,death;
		public Composer(String name,int birth,int death){
			this.name=name;
			this.birth=birth;
			this.death=death;
		}
	}
	static class Node{
		int max;
		Node left,right,parent;
		int[] data;
		public Node(int[] data){
			this.data=data;
			this.max=data[1];
		}
	}
	static Node insert(Node node,int a,int b,int min,int max){
		if (a<=min&&max<=b){
		}
		return node;
	}
	static void inorder(Node root){
		if(root!=null){
			inorder(root.left);
			System.out.println(root.data[0]+","+root.data[1]);
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		int i,n=6;
		//String[] name={"(A)Stravinsky","(B)Schoenberg","(C)Grieg","(D)Schubert","(E)Mozart","(F)Schuetz"};
		int[] birth={1888,1874,1843,1779,1756,1585};
		int[] death={1971,1951,1907,1828,1791,1672};
		
		Node root=null;
		for(i=0;i<n;i++){
			root=insert(root,birth[i],death[i],Integer.MIN_VALUE,Integer.MAX_VALUE);
		}

		inorder(root);
		
		System.out.println();
		
	}

}

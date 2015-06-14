package Tree;

public class InorderSuccessor_BST {
	static class Node{
		int key;
		Node left,right,parent;
		public Node(int key){
			this.key=key;
		}
	}
	static Node insert(Node node,int key){
		if(node==null)
			return new Node(key);
		
		if(key<node.key){
			node.left=insert(node.left,key);
			node.left.parent=node;
		}else if(key>node.key){
			node.right=insert(node.right,key);
			node.right.parent=node;
		}
		return node;
	}
	static Node inOrderSuccessor1(Node root,Node n){
		if(n.right!=null)
			return minValue(n.right);
		
		Node p=n.parent;
		while(p!=null&&n==p.right){
			n=p;
			p=p.parent;
		}
		return p;
	}
	static Node minValue(Node node){
		while(node.left!=null)
			node=node.left;
		return node;
	}
	static Node inOrderSuccessor2(Node root,Node n){
		if(n.right!=null)
			return minValue(n.right);
		Node p=null;
		while(root!=null){
			if(n.key<root.key){
				p=root;
				root=root.left;
			}else if(n.key>root.key){
				root=root.right;
			}else{
				break;
			}
		}
		return p;
	}
	public static void main(String[] args) {
		Node root=insert(null,20);
		root=insert(root,8);
		root=insert(root,22);
		root=insert(root,4);
		root=insert(root,12);
		root=insert(root,10);
		root=insert(root,14);
		
		Node temp=root.left.right.right;
		Node succ=inOrderSuccessor1(root,temp);
		if(succ!=null)
			System.out.println(String.format("Inorder Successor of %d is %d ", temp.key, succ.key));
		else
			System.out.println("Inorder Successor doesn't exit");
		
		succ=inOrderSuccessor2(root,temp);
		if(succ!=null)
			System.out.println(String.format("Inorder Successor of %d is %d ", temp.key, succ.key));
		else
			System.out.println("Inorder Successor doesn't exit");
	}

}

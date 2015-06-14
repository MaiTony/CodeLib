package Tree;

public class LinkedListSet2 {
	static class Node{
		int data;
		Node next=null;
		public Node(int data){
			this.data=data;
		}
	}
	
	static Node append(Node head,int data){
		Node node=new Node(data);
		if(head==null){
			head=node;
			return head;
		}
		Node last=head;
		while(last.next!=null)
			last=last.next;
		last.next=node;
		return head;
	}
	
	static void push(Node head,int data){
		Node node=new Node(data);
		if(head==null){
			head=node;
			return;
		}
		node.next=head;
		head=node;
	}
	
	static void insertAfter(Node prev_node,int data){
		Node node=new Node(data);
		
		node.next=prev_node.next;
		prev_node.next=node;
	}
	
	static void printList(Node node){
		while(node!=null){
			System.out.print(node.data+"->");
			node=node.next;
		}
	}
	
	public static void main(String[] args) {
		Node head=null;
		head=append(head,6);
		push(head,7);
		push(head, 1);
		append(head,4);
		insertAfter(head.next,8);
		printList(head);
	}

}

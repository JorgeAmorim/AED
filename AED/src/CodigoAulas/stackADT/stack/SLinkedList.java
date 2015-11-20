package CodigoAulas.stackADT.stack;
import java.util.EmptyStackException;

public class SLinkedList<E> implements Stack<E>{
	public class Node {
		private E data;
		private Node next;
		
		public Node(E item) {
			data = item;
		}
	}
	
	private Node head;
	
	public SLinkedList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public E push(E item) {
		Node x = new Node(item);
		if (head == null) head = x; 
		else {
			x.next = head;
			head = x;
		}
		return x.data;
	}
	
	public E pop() {
		if (head == null) throw new EmptyStackException();
		Node x = head;
		head = head.next;
		return x.data;
	}
	
	public E peek() {
		if (head == null) throw new EmptyStackException();
		return head.data;
	}
}

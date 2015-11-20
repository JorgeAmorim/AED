package CodigoAulas.stackADT.stack;
import java.util.EmptyStackException;

public class StackArray<E> implements Stack<E>{
	private E[] s;
	private int top;

	public StackArray(int max) {
		s = (E[]) new Object[max]; //solução!
		top = 0;
	}

	public boolean isEmpty(){ 
		return top == 0; 
	}

	public E push(E item) {
		if( top == s.length ) return null;	// stack full
		s[top++] = item; return item;
	}

	public E pop() {
		if(isEmpty()) throw new EmptyStackException();
		E item = s[--top];
		return item;
	}
	
	public E peek() {
		if(isEmpty()) throw new EmptyStackException();
		return s[top-1]; 
	}
 }

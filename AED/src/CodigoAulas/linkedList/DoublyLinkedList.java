package CodigoAulas.linkedList;

public class DoublyLinkedList {
	
	public static <E> boolean isEmpty(Node<E> list){ 
		return list == null;
	}
	
	// Adiciona o elemento à cabeça da lista
	public static <E> Node<E> insert(Node<E> list, E e) { 		
		Node<E> x = new Node<E>();
		x.value = e; x.next = list;
		if(list != null)
			list.previous = x; 	
		list = x;
		return list;
	}
	
	// Procura o elemento e na lista
	public static <E> Node<E> search(Node<E> list, E key){
		Node<E> x = list;
		while(x != null && !x.value.equals(key))
			x = x.next;
		return x;
	}
	
	// Remove o elemento à cabeça da lista
	public static <E> Node<E> delete(Node<E> list){
		if (list != null) { 
			if (list.next != null) list.next.previous = null;
			list = list.next;
		}
		return list;
	}
	
	// Remove o primeiro elemento da lista igual a e
	public static <E> Node<E> delete(Node<E> list, E e){
		Node<E> x = search(list, e);
		if (x != null){
			if (x.previous != null) x.previous.next = x.next;
			else list = x.next;
			if (x.next != null) x.next.previous = x.previous;
		}
		return list;
	}
	
	public static <E> void show(Node<E> list) {
		System.out.println("------------");
		Node<E> curr = list;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}

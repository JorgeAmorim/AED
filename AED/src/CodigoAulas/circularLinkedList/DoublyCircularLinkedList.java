package CodigoAulas.circularLinkedList;

public class DoublyCircularLinkedList {
	
	public static <E> Node<E> createList(){
		Node<E> list = new Node<E>();
		list.previous = list.next = list;
		return list;
	}	
	
	public static <E> boolean isEmpty(Node<E> list){ 
		return list.next == list;
	}
	
	// Adiciona o elemento à cabeça da lista
	public static <E> void insert(Node<E> list, E e) { 		
		Node<E> x = new Node<E>();
		x.value = e;
		x.next = list.next;
	    list.next.previous = x;
	    list.next = x;
	    x.previous = list;
	}
	
	// Adiciona o elemento à cabeça da lista reutilizando o nó
	public static <E> void insert(Node<E> list, Node<E> x) { 
		x.next = list.next;
	    list.next.previous = x;
	    list.next = x;
	    x.previous = list;
	}
	
	// Adiciona o elemento no fim da lista
	public static <E> void insertLast(Node<E> list, E e) { 		
		Node<E> x = new Node<E>();
		x.value = e;
		x.previous = list.previous;
	    list.previous.next = x;
	    list.previous = x;
	    x.next = list;
	}
	
	// Adiciona o elemento no fim da lista reutilizando o nó
	public static <E> void insertLast(Node<E> list, Node<E> x) {
		x.previous = list.previous;
	    list.previous.next = x;
	    list.previous = x;
	    x.next = list;
	}

	// Procura o elemento e na lista
	public static <E> Node<E> search(Node<E> list, E key){
		Node<E> x = list.next;
		list.value = key;
		while (!x.value.equals(key))
			x = x.next;
		return x;
	}

	// Remove o primeiro elemento da lista igual a e
	public static <E> void delete(Node<E> list, E e){
		Node<E> x = search(list, e);
		if (x != list){
			x.previous.next = x.next;
		    x.next.previous = x.previous;
		}
	}
	
	// Remove o elemento à cabeça da lista
	public static <E> void delete(Node<E> list){
		Node<E> x = list.next;
		x.previous.next = x.next;
		x.next.previous = x.previous;
	}
	
	public static <E> void show(Node<E> list) {
		Node<E> curr = list.next;
		while (curr != list) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}

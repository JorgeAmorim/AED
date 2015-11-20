package exercicios.nodes;

/**
 * Modo circulares sem sentinela
 */
public class DoublyLinkedList {

    public static <E> boolean isEmpty(Node<E> list){ return list == null; }

    public static <E> Node<E> search(Node<E> list, E key){
        Node<E> x = list;
        while(x != null &&!(x.value.equals(key)))
            x = x.next;
        return x;
    }

    public static <E>  Node<E> insert(Node<E> list, E e){
        Node<E> x= new Node<E>();
        x.value = e;
        x.next = list;
        if(list != null)
            list.previous = x;
        list = x;
        return list;
    }

    public static <E> Node<E> delete(Node<E> list, E key){
        Node<E> x = search(list, key);
        if(x != null){
            if(x.previous != null)
                x.previous.next = x.next;
            else list = x.next;
            x.next.previous = x.previous;
        }
        return list;
    }
}

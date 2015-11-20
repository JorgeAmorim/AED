package exercicios.nodes;

/**
 * listas duplamente ligadas circulares com sentinela
 */
public class DoublyCircularLinkedList {

    /**
     * cria uma lista ligada com sentinela
     * @param <E>
     * @return
     */
    public static <E> Node<E> createList(){
        Node<E> list = new Node<E>();
        list.previous = list;
        list.next = list;
        return list;
    }

    public static <E> boolean isEmpty(Node<E> list){ return list.next == list;}

    public static <E> Node<E> search(Node<E> list, E key){
        Node<E> x = list.next;
        list.value = key;
        while(!x.value.equals(key))
            x = x.next;
        return x;
    }

    public static <E> void delete(Node<E> list, E key){
        Node<E> x = search(list, key);
        if(x != list){
            x.previous.next = x.next;
            x.next.previous = x.previous;
        }
    }

    /**
     * insere a cabeça
     * @param list
     * @param e
     * @param <E>
     */
    public static <E> void insert(Node<E> list, E e){
        Node<E> x = new Node<E>();
        x.value = e;
        x.next = list.next;
        list.next.previous = x;
        list.next = x;
        x.previous = list;
    }

    /**
     * insere no fim
     * @param list
     * @param e
     * @param <E>
     */
    public static <E> void insertLast(Node<E> list, E e){
        Node<E> x = new Node<E>();
        x.value = e;
        x.previous = list.previous;
        list.previous.next = x;
        list.previous = x;
        x.next = list;
    }
 }

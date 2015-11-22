package series.serie2;

import java.util.Comparator;

public class ListUtils {

    /**
     *que retorna uma lista duplamente ligada circular e com sentinela, resultante da jun��o, de modo
     * intercalado, das listas duplamente ligadas circulares e com sentinelas, presentes em list.
     */
    public static <E> Node<E> interleaved( Node< Node < E >> list ) {
        Node<E> newList = new Node<E>();
        newList.next = newList.previous = newList;

        Node<Node<E>> list2 = list;

        if(list.next == list)
            return newList;

        int n = 0;
        while(n<5){

            Node<Node<E>>  curr = list2.next;

            while(curr != list2){
                Node<E> sublist = curr.value;
                if(sublist.next != sublist){
                    sublist.next.previous = newList.previous;
                    newList.previous.next = sublist.next;
                    newList.previous = sublist.next;
                    sublist.next.next = newList;
                }
                curr = curr.next;
            }

            Node<Node<E>> aux = list2;
            list2.previous = list2.next = list2;

            while(aux != list){
                Node<E> aux2 = aux.value;
                if(aux2.next != aux2){
                    aux2.next.previous = list2.value.previous;
                    list2.value.previous.next = aux2.next;
                    list2.value.previous = aux2.next;
                    aux2.next.next = list2.value;
                }
                aux = aux.next;
            }
            n++;
        }

        list.previous = list.next = list;
        return newList;
    }

	public static <E> E mostOccurrent(Node<E>[] lists, Comparator<E> cmp){

        int maxVal = 0;
        int n = lists.length;



        throw new UnsupportedOperationException();
	}

}

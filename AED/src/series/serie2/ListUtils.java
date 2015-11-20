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

        Node<Node<E>> list2 = new Node<Node<E>>();
        list2.next = list2.previous = list2;

        if(list.next == list)
            return newList;

        int n = 5;
        while(n != 0){
            Node<Node<E>>  curr = list.next;
            while(curr != list){
                    Node<E> sublist = curr.value;
                    if(sublist.next != sublist){
                        sublist.next.previous = newList.previous;
                        newList.previous.next = sublist.next;
                        newList.previous = sublist.next;
                        sublist.next.next = newList;
                    }
                //falta apagar 1ª posiçao
                curr = curr.next;
            }
            list2 = list.next;
            n--;
        }
        list.previous = list.next = list;
        return newList;

    }

	public static <E> E mostOccurrent(Node<E>[] lists, Comparator<E> cmp){

        cmp.compare(lists[0].value, lists[1].value);

        throw new UnsupportedOperationException();
	}

}

package exercicios;

import exercicios.nodes.Node;
import java.util.Comparator;

public class ExNodes{

    /**
     * listas duplamente ligadas, circulares com sentinela
     *
     *  list1 =  ||||-||1||-||3||-||5||;
     *  list2 =  ||||-||2||-||4||;;
     *  newList = ||||-||1||-||3||-||5||-||2||-||4||;
     *  lista1 e 2 ficam vazias
     */
    public static <E> Node<E> concat(Node<E> list1, Node<E> list2){
        Node<E> newList= new Node<E>();
        newList.previous = newList.next = newList;

        newList.next = list1.next;
        newList.previous = list2.previous;
        list1.next.previous = newList;
        list2.previous.next = newList;
        list1.previous.next = list2.next;
        list2.next.previous = list1.previous;

        //colocar as listas 1 e 2 vazias
        list1.previous = list1.next = list1;
        list2.previous = list2.next = list2;

        return newList;
    }

    /**
     * list = || ||-|| ||-|| ||-|| ||;
     *                |     |     |
     *                |     |   || ||-||6||
     *                |     |
     *                |   || ||-||2||-||4||
     *                |
     *              || ||-||1||-||3||-||5||;
     *
     * newList = || ||-||1||-||3||-||5||-||2||-||4||-||6||;
     */
    public static <E> Node<E> concat(Node<Node<E>> list){
        Node<E> newList = new Node<E>();
        newList.previous = newList.next = newList;

        Node<Node<E>> curr = list.next;
        while(curr != list){
            Node<E> sublist = curr.value;
            if(sublist.next != sublist){
                //insere no fim da nova lista
                sublist.next.previous = newList.previous;
                newList.previous.next = sublist.next;
                newList.previous = sublist.previous;
                sublist.previous.next = newList;
            }
            curr = curr.next;
        }
        list.previous = list.next = list;
        return newList;
    }

    /**
     * Dado um array com listas duplamente ligadas nao circulares e sem sentinela, ordenadas de modo decrescente
     * pelo comparador cmp, retorna uma lista duplamente ligada circular e com sentinela consituida pelos k maiores
     * elementos presentes nas listas. Caso o nº total de elementos no array list seja <=k, a lista a retornar deverá
     * ter todos os elementos. A lista resultante deverá estar ordenada de modo crescente e reutilizar os nós presentes
     * em lists.
     *
     * list =       || ||-|| ||-|| ||;
     *                |     |     |
     *                |     |   ||5||-||4||
     *                |     |
     *                |   ||9||-||7||-||2||
     *                |
     *              ||8||-||6||-||1||
     *
     * newList = || ||-||7||-||8||-||9|| para k = 3;
     */
    public static <E> Node<E> kGreatestElements(Node<E>[] lists, Comparator<E> cmp, int k){
        Node<E> newList = new Node<E>();
        newList.previous = newList.next = newList;
        int n = lists.length;
        buildMaxHeap(lists, n, cmp); //construcao do heap
        while(n!=0 && k!=0){
            Node<E> x = lists[0]; //x contem o maior
            lists[0] = x.next; //remoçao a cabeça do maior duma
            if(x.next != null)
                x.next.previous = null; //duplamente ligada nao circular sem sentinela

            x.next = newList.next; //inserçao a cabeça na nova lista
            newList.next.previous = x; //duplamente ligada circular com sentinela
            x.previous = newList;
            newList.next = x;

            if(lists[0] == null) { // acualizaçao do heap
                lists[0] = lists[n - 1];
                n--;
            }
            maxHeapify(lists, 0, n, cmp);
            k--;
        }
        return newList;
    }

    private static <E> void maxHeapify(Node<E>[] lists, int i, int n, Comparator<E> cmp) {

    }

    private static <E> void buildMaxHeap(Node<E>[] lists, int n, Comparator<E> cmp) {

    }

    public static void main(String[] args){
    }
}

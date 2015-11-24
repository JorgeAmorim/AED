package series.serie2;

import java.util.Comparator;

public class ListUtils {

    public static <E> Node<E> interleaved( Node< Node < E >> list ) {
        Node<E> newList = new Node<E>();
        newList.next = newList.previous = newList;

        Node<Node<E>> list2 = list;

        if(list.next == list)
            return newList;
        if(list.value == null){
            list.next = list.previous = list;
            return newList;}

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

            Node<Node<E>> aux = list2.next;
            list2.previous = list2.next = list2;

            while(aux.next != aux){//ver while
                Node<E> aux2 = aux.next.value;
                if(aux2.next != aux2){
                    aux2.next.previous = list2.previous.value;
                    list2.previous.next.value = aux2;
                    list2.previous.value = aux2;
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

        if(lists[0] == null)
            return null;

        int maxVal = 0;
        int maxValaux = 0;
        int n = lists.length;
        buildMinHeap(lists, n, cmp);
        minHeapify(lists, 0,  n, cmp);
        Node<E> max = lists[0];
        Node<E> aux = null;

        while(n != 0){
            Node<E> x = lists[0];
            lists[0] = x.next;
            if(x.next != null)
                x.next.previous = null;

            if(x.value == max.value)
                maxVal++;
            else{
                if(aux == null){
                    aux = x;
                    maxValaux++;
                }
                else if(aux.value == x.value){
                    maxValaux++;
                }
                else if(maxValaux > maxVal){
                    max = aux;
                    maxVal = maxValaux;
                    aux = x;
                    maxValaux = 1;
                }
            }

            if(lists[0] == null) {
                lists[0] = lists[n - 1];
                n--;
            }
            minHeapify(lists, 0, n, cmp);
        }

        return max.value;
	}

    private static <E> void buildMinHeap(Node<E>[] list, int heapSize, Comparator<E> cmp) {
        for (int i = (heapSize/2)-1; i>0; --i)
            minHeapify(list,i,heapSize,cmp);
    }

    private static <E> void minHeapify(Node<E>[] list,int ix,int n, Comparator<E> cmp) {
        int left = (ix*2)+1; // Calculo do filho esquerdo.
        int right = (ix*2)+2; // Calculo do filho direito.
        int smallest = ix; // Guarda-se o valor de ix, para não perder o seu valor.
        // Verificação se o limite esquerdo é menor que o count e o valor do limite esquerdo é maior que o valor do ix, muda-se o valor do largest para o valor do limite esquerdo.
        if(left<n && right < n )
            if(left <= n && cmp.compare(list[left].value, list[ix].value) < 0)
                smallest = left;
        // Verificação se o limite direito é menor que o count e o valor do limite direito é maior que o valor do ix, muda-se o valor do largest para o valor do limite direito.
        if(left<n && right < n )
            if (right <= n && cmp.compare(list[right].value, list[smallest].value) < 0)
                smallest = right;

        // Se o valor de largest tem valor de limite esquerdo ou de limite direito.
        if(smallest!=ix)
        {
            Node<E> aux = list[ix];//Guarda-se o valor do reader do array.
            list[ix] = list[smallest]; //Troca posição no array
            list[smallest] = aux;//Troca posição no array
            minHeapify(list, smallest,n, cmp);//Volta a chamar o metodo para ordenar os valores abaixo.
        }
    }
}

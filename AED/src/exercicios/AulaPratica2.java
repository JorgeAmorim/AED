package exercicios;
import CodigoAulas.heaps.Heap;

public class AulaPratica2{

    /**
     * 1. Implemente o método que recebendo um max_heap de dimensão size_heap, retira os elementos repetidos
     * e retorna o numero de elementos distintos(count) presentes no array. Este metodo deve reorganizar o array
     * de forma a que apos sua execução, os primeiros count elementos sejam os elementos distintos e continuem a
     * representar um max_heap
     */
    public static int uniques(int[] maxHeap, int sizeHeap){
        //iterativo
        Heap.heapSort(maxHeap, sizeHeap);// O(n log n)
        int countDups = deleteDups(maxHeap, sizeHeap);// O(n)
        Heap.buildMaxHeap(maxHeap, sizeHeap-countDups);// O(n)

        return sizeHeap-countDups; // O(1)
    } // O(n log n)

    //recebe array ordenado e desloca os repetidos para a esquerda. (retorna quantos estavam duplicados)
    public static int deleteDups(int[] v, int size){
        if(size <=1) return size;
        else{
            int count = 0;
            for(int i = 1, j= 0; i<size; i++){
                if(v[i] != v[j]){
                    j++;
                    v[j] = v[i];
                }
                else count++;
            }
            return count;
        }
    }

    /**
     * 2. Implemente o método que recebendo dois max_heaps de dimensão size_heaps verifica se ambos os max_heaps
     * contêm o mesmo conjunto de valores (mesmo que com organizaçºoes diferentes
     */
    public static boolean sameValues(int[] maxHeap1, int[] maxHeap2, int sizeHeaps){
        while(sizeHeaps > 0){ //O(n)
            if(maxHeap1[0] != maxHeap2[0]) return false;//O(1)
            else{
                maxHeap1[0] = maxHeap1[sizeHeaps-1];//O(1)
                maxHeap2[0] = maxHeap2[sizeHeaps-1];//O(1)
                sizeHeaps--;
                Heap.maxHeapify(maxHeap1, 0, sizeHeaps);//O(log n)
                Heap.maxHeapify(maxHeap2, 0, sizeHeaps);//O(log n)
            }
        }
        return true;
    }// O(n).(O(1) + O(1) + (log n) + O(log n)) = O(n log n)

    /**
     * 3. Implemente o método que dado um max_heap representado pelos primeiros count elementos do array maxHeap
     * retira o elemento presente no indice idx. Após a execução do método, os primeiros count-1 elementos de maxHeap
     * representam um max_heap
     */
    public static void removeFromMaxHeap(int[] maxHeap, int count, int idx){
        maxHeap[idx] = maxHeap[count-1]; //O(1)
        count--;//O(1)
        Heap.maxHeapify(maxHeap, idx,  count);//O(log n)
    } //O(log n)
}

package series.serie1;

import CodigoAulas.*;
import CodigoAulas.heaps.Heap;

import java.util.NoSuchElementException;

public class Arrays {

    public static int findKthSmallest(int[] array1, int[] array2, int k) {
        int totalSize=array1.length+array2.length;
        if(k>totalSize || k<1)
            throw new NoSuchElementException();

        if(array1.length==0)
            return array2[k-1];
        if(array2.length==0)
            return array1[k-1];

        int i=0;
        int j=0;
        while(true) {
            if (i == array1.length)
                return array2[k - 1 - i];
            if (j == array2.length)
                return array1[k - 1 - j];
            if (i + j + 1 == k)
                return (array1[i] < array2[j]) ? array1[i] : array2[j];
            if (array1[i] < array2[j])
                i++;
            else
                j++;
        }
    }

    public static int countInverses(String[] v, int l, int r) {
        int count = 0;
        if (v.length < 1)
            return 0;
        else if (v.length == 1 && v[0].length() == 1)
            return ++count;
        else
        {
            for (int i = 0; i <= r-1; ++i)
            {
                if(v[i+1].length()==1) {
                    count += 1;
                    break;
                }
                String aux1 = v[i];
                String aux2 = "";
                for (int k = aux1.length()-1; k >= 0; --k)
                    aux2 += aux1.charAt(k);
                for (int j = i + 1; j <= r; ++j)
                {
                    if (aux2.equals(v[j]))
                        count+=1;
                }
            }
            return count;
        }
    }

    public static int partitionPoint(int[] v, int val) {
        int low = 0, high = v.length - 1, mid = 0;
        if (v.length != 0) {
            while (high != low) {
                mid = low + (high - low) / 2;
                if (v[mid] >= val) {
                    high = mid;
                } else {
                    low = mid;
                    break;
                }
            }
            for (int i = low; i <= high; i++) {
                if (v[i] >= val) return i;
            }
        }
        return v.length;
    }

    public static int removeSmallerThan(int[] minHeap, int sizeHeap, int k) {
        Heap.heapSort(minHeap, sizeHeap);
        int count = sizeHeap;
        if (sizeHeap == 0 || (sizeHeap == 1 && k > minHeap[0]))
            return 0;
        if (k > minHeap[sizeHeap - 1] && k > minHeap[sizeHeap - 2])
            return 0;
        //verifica se a posi�ao actual e menor que o k e se a ultima e maior pa substituir a posi�ao i pela ultima
        for(int i = 0; i<=sizeHeap-1; i++) {
            if (minHeap[i] < k && minHeap[count-1] >= k) {
                minHeap[i] = minHeap[count - 1];
                //count(ultima posi�ao do array(length-1) verificada)
                count--;
            }
            //se a posi�ao em que estamos j� e maior como o array esta ordenado ja n e preciso fazer mais trocas
            if(minHeap[i]>=k)
                break;
        }
        //constroi-se o novo minHeap e retorna-se o num de elementos que nao foram "removidos"
        Heap.buildMinHeap(minHeap,count);
        return count;
    }

}
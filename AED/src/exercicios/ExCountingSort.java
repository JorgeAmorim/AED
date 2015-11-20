package exercicios;


public class ExCountingSort {

    /**
     * l=1 u=5
     * u-l+1 = 5-1+1 = 5
     * F[A[i]-l]++
     */
    /**
     * Array [2,5,3,1,2,3,1,3]
     * Array frequencias [2,2,3,0,1]
     * Array distribuiçao [2,4,7,7,8]
     *
     * Array ordenado [1,1,2,2,3,3,3,5]
     */

    public static int countingSortEx(int[] a, int min, int max){
        int n = a.length;
        int aux=-1;
        int index=-1;
        int[] f = new int[max - min + 1];
        for (int i = 0; i < n; i++)
            f[a[i] - min]++;					// compute frequencies
        for (int i = 0;i<f.length;i++){
            if(f[i]>aux) {
                index = i + min;
                aux=f[i];
            }
        }

        return index;
    }

    /**
     * EX Radix Sort*
     *Realize um metodo estatico que dado um array V em que os elementos pertencem ao intervalo
     * [min,max], retorna o elemento nele presente que tenha o maior numero de ocorrencias. Em
     * caso de empate, retorna o 1º encontrado, A soluçao deve ser de complexidade O(n) em que
     * n=v.length. COnsidere que max-min <= v.length
     *
     * v= {19,2,5,2,3,4,10,17,5,5,19,10,10,2,3,5,17,17}
     * min = 2, max = 19, min-max = 17, n=18
     */

    public static int greatestOccurrence(int[] v, int min, int max){
        int[] freq = new int[max-min +1];
        for(int i = 0; i<v.length;i++)
            freq[v[i]-min]++;
        int maxOc = 0;
        for(int i = 0; i<freq.length;i++)
            if(freq[i] > freq[maxOc]) maxOc = i;
        return maxOc + min;
    }

    public static void main(String[] args){
        System.out.println(countingSortEx(new int[]{19, 2, 5, 2, 3, 4, 10, 17, 5, 5, 19, 10, 10, 2, 3, 5, 17, 17}, 2, 19));
        System.out.println(greatestOccurrence(new int[]{19, 2, 5, 2, 3, 4, 10, 17, 5, 5, 19, 10, 10, 2, 3, 5, 17, 17}, 2, 19));
    }
}

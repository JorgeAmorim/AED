package series.serie2;

public class Utils {

    /**
     * Método que retorna o n-ésimo menor elemento do sub-array (v; l; r).
     */
	public static int NElement( int[] array, int l, int r, int n ) {
        //ordena o array
        int[] sortedArray = bubbleSort(array, l, r);
        //verificação para array nulo
        if(sortedArray == null)
            return 0;
        //verificação se o n é superior ao tamanho do array
        if(n > sortedArray.length)
            return sortedArray.length;
        //retorno do n-ésimo menor elemento
        else
            return sortedArray[n-1];
    }

    /**
     * código adaptado do bubbleSorte dado nas aulas
     */
    public static int[] bubbleSort(int[] table,int first,int last){
        for (int i = first; i < last; i++) {
            for (int j = last; j > i; j--)
                if (table[j] < table[j - 1]) {
                    int aux = table[j];
                    table[j] = table[j - 1];
                    table[j - 1] = aux;
                    }
                }
                return table;
        }
}



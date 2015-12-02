package exercicios;

import CodigoAulas.hashTable.HashNode;
import exercicios.nodes.Node;
import java.util.Comparator;

public class ExHashMap {

    /**
     * Implemente um metodo que calcula e devolve o factor da carga n/m de uma tabela de dispersao
     */
    public static <E> double loadFactor(HashNode<E>[] buckets){
        int n = 0, m = buckets.length;
        for(int i = 0; i<m; i++){
            HashNode<E> curr = buckets[i];
            while(curr != null){
                n++;
                curr = curr.next;
            }
        }
        return (double) n/m;
    }

    /**
     * Implemente um metodo que dadas duas tabelas de dispersao hTable1 e hTable2 de igual dimensao
     * com encadeamento externo em listas simplesmente ligadas e ordenadas pelo comparador cmp, verifica
     * se os elementos presentes em hTable1 estao contidos em hTable2
     */
    public static <E> boolean containsAllV1(HashNode<E>[] hTable1, HashNode<E>[] hTable2, Comparator<E> cmp){
        //precorrer a tabela 1 e procurar se existe na 2
        int m = hTable1.length;
        for(int i = 0; i<m; i++){
            HashNode<E> curr1 = hTable1[i];
            while(curr1 != null){
                int h = curr1.value.hashCode() % m;
                h = (h<0) ? h+m : h;
                HashNode<E> curr2 = hTable2[h];
                boolean found = false;
                while(curr2 != null){
                    if(cmp.compare(curr1.value, curr2.value) != 0){
                        found = true;
                        break;
                    }
                    curr2 = curr2.next;
                }
                if(!found) return false;
                curr1 = curr1.next;
            }
        }
        return true;
    }

    public static <E> boolean containsAllV2(HashNode<E>[] hTable1, HashNode<E>[] hTable2, Comparator<E> cmp){
        int m = hTable1.length;
        for(int i = 0; i<m; i++){
            if(hTable1[i] != null && hTable2[i] != null) {
                HashNode<E> curr1 = hTable1[i], curr2 = hTable2[i];
                while (curr1 != null && curr2 != null) {
                    int res = cmp.compare(curr1.value, curr2.value);
                    if (res == 0) {
                        curr1 = curr1.next;
                        curr2 = curr2.next;
                    } else if (res < 0) return false;
                    else curr2 = curr2.next;
                }
                if (curr1 != null) return false;
            }
            else if(hTable1[i] != null) return false;
        }
        return true;
    }

    /**
     * Implemente um metodo que retorna uma tabela de dispersao com encadeamento externo de dimensao
     * hashTableSize, com todos os elementos presentes na lista duplamente ligada circular e com sentinela
     * list. Os nos da lista list deverão ser reutilizados
     */
    public static Node<Integer>[] getHashTable(Node<Integer> list, int sizeHashTable){
        Node<Integer>[] table = (Node<Integer>[]) new Node[sizeHashTable];
        Node<Integer> curr = list.next;
        while(curr != list){
            Node<Integer> x = curr;
            curr = curr.next;
            int h = x.value.hashCode() % sizeHashTable;
            h = (h<0) ? h+sizeHashTable : h;
            x.next = table[h]; x.previous = null;
            table[h] = x;
        }
        return table;
    }

    /**
     * Realize o método que dados os mapas hashMap1 e hashMap2 com a mesma dimensao, retorna um novo mapa com a mesma
     * dimensao, contendo apenas os pares chave-valor presentes em ambos os mapas. Após a execuçao deste metodo, os
     * mapas hashMap1 e hashMap2 deverão ficar vazios. Assuma que os mapas foram implementados recorrendo a uma tabela
     * de dispersao com encadeamento externo em listas duplamente ligadas, nao circulares e sem sentinela, em que
     * cada lista se encontra ordenada segundo o comparador cmp
     */
    /**public static <K,V> Node<K,V>[] commonElements(Node<K,V>[] hashMap1, Node<K,V>[] hashMap2, Comparator<K> cmp){
        Node<K,V>[] resMap = (Node<K,V>[]) new Node[hashMap1.length];
        for(int i = 0; i<hashMap1.length; i++){
            Node<K,V> curr1 = hashMap1[i];
            Node<K,V> curr2 = hashMap2[i];
            while(curr1 != null && curr2 != null){
                int res = cmp.compare(curr1.key, curr2.key);
                if(res == 0){
                    Node<K,V> x1 = curr1;
                    curr1 = curr1.next;
                    curr2 = curr2.next;
                    x1.next = resMap[i];
                    if(resMap[i] != null) resMap[i].previous = x1;
                    x1.previous = null;
                    resMap[i] = x1;
                }
                else if(res<0) curr1 = curr1.next;
                else curr2 = curr2.next;
            }
            hashMap1[i] = null;
            hashMap2[i] = null;
        }
        return resMap;
    }**/
}

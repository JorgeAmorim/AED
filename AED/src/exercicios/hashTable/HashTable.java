package exercicios.hashTable;
/**
 * Created by Jorge on 25/11/15.
 */

public class HashTable {

    public static <E> HashNode<E>[] create(int m) {
        if (m <= 0) m = 100;
        HashNode<E>[] hashTable = (HashNode<E>[]) new HashNode[m];
        return hashTable;
    }

    public static <E> int index(HashNode<E>[] hashTable, E key) {
        int m = hashTable.length;
        int h = key.hashCode() % m;
        /*utilizar o hashcode do java, da o valor inteiro unico que pode ser negativo ou positivo.
        vai funcionar como chave*, podendo ser um objecto qualquer */
        return (h < 0) ? h + m : h; //podia-se tambem fazer o abs para o valor ficar positivo
    }

    public static <E> void insert(HashNode<E>[] hashTable, E e) {
        /*recebe a tabela de dispersao e o valor do no a colocar.
        temos que saber onde colocar o valor*/
        int i = index(hashTable, e); //tenho o indice onde colocar
        //agora insere-se a cabeca, alocando um novo no
        HashNode<E> x = new HashNode<E>();
        //preenchemos o value do no com o valor
        x.value = e;
        //inserir a cabeca de uma lista simplesmente ligada
        //x.next recebe a cabeça da lista, o primeiro elemento
        x.next = hashTable[i];
        hashTable[i] = x;
    } //novo elemento ligado.

    //procura-se a chave e devolve-se o valor total
    public static <E> E search(HashNode<E>[] hashTable, E key)
    {
        int i = index(hashTable, key);
        //procurar na lista de colisoes
        HashNode<E>curr = hashTable[i]; //recebe a cabeça da lista
        while(curr != null)
        {
            if(key.equals(curr.value))
                return curr.value;
            curr = curr.next;
        }
        return null;
    }

    public static <E> boolean delete(HashNode<E>[] hashTable, E e)
    {
        //procurar elemento e se existir remover || nao se pode utilizar o search porque
        //tem que ligar o anterior ao seguinte e na funcao base search isso nao esta implementado
        int i = index(hashTable, e);
        //guardar o apontador corrente e o apontador anterior
        HashNode<E> curr = hashTable[i], prev = null;
        //curr com a cabeça da lista e o previous com null;
        //agora percorre-se a lista a procura do elemento que queremos remover
        while(curr != null)
        {
            //prev.next tera que ser o proximo do curr, para ser feita a remocao
            if(e.equals(curr.value))
            {
                //se o previous for null, quer dizer que estou a remover a cabeça
                if(prev == null)
                    hashTable[i] = curr.next;
                else
                    prev.next = curr.next;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false; //nao encontrei o elemento a remover
    }
}

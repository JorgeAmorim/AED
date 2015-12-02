package exercicios.hashMap;

public class HashMap
{
    public static <K,V> HashNode<K, V>[] create(int m){
        if (m<0) m = 100;
        HashNode<K,V>[] hashMap = (HashNode<K,V>[]) new HashNode[m]; //instanciamos um array de hash nodes, mas temos que fazer o cast
        return hashMap;
    }

    //para calcular a função de expressão - e a chave que determina qual e a posicao
    private static <K,V> int index(HashNode<K,V>[] hashMap, K k)
    {
        int m = hashMap.length;
        //utilizamos o hashcode do java
        int h = k.hashCode() % m ;
        return (h<0)? h + m: h;
    }

    public static <K,V> void put(HashNode<K,V>[] hashMap, K key, V value)
    {
        //funcao de expressao -> primeira coisa que se faz
        int i = index(hashMap, key);
        //inserir o elemento a cabeca
        HashNode<K,V> x = new HashNode<K,V>();
        x.pair = new Pair<K,V>(key,value);
        x.next = hashMap[i];
        hashMap[i] = x;
    }

    public static <K,V> V get(HashNode<K,V>[] hashMap, K key)
    {
        int i = index(hashMap, key);
        HashNode<K,V> curr = hashMap[i];
        while(curr != null){
            if(key.equals(curr.pair.key))
                return curr.pair.value;
            curr = curr.next;
        }
        return null;
    }

    public static <K,V> boolean containsValue(HashNode<K,V>[] hashMap, V value){
        for(int i = 0; i<hashMap.length; i++){
            HashNode<K,V> curr = hashMap[i];
            while(curr != null){
                if(value.equals(curr.pair.value))
                    return true;
                curr = curr.next;
            }
        }
        return false;
    }

    public static <K,V> V remove(HashNode<K,V>[] hashMap, K key){
        int i = index(hashMap, key);
        HashNode<K,V> curr = hashMap[i], prev = null;

        while(curr != null){
            if(key.equals(curr.pair.key)){
                if(prev == null)
                    hashMap[i] = curr.next;
                else
                    prev.next = curr.next;
                return curr.pair.value;
            }
            prev = curr; curr = curr.next;
        }
        return null;
    }
}

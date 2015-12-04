package series.serie2.problema;

public class Entry<K,V> {

    public K key;
    public V value;
    public Entry<K,V> next;

    public Entry(){}

    public Entry(K k, V v){
        key=k;
        value=v;
    }
}

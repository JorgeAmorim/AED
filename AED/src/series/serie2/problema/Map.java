package series.serie2.problema;

import java.util.AbstractCollection;
import java.util.AbstractSet;

public class Map<K,V> {

    public K key;
    public V value;

    public Map(){}
    public Map(K k, V v){
        key=k;
        value=v;
    }

    public V put(K key, V value){
        return value;
    }

    public V get(K key){
        return value;
    }

    public V remove(K key){
        return value;
    }

    public boolean replace(K oldK, K newK, V newV){
        return true;
    }

    public int size(){
        return 0;
    }

    public boolean isEmpty(){
        return true;
    }

    /*public set<Map.Entry<K,V>> entrySet(){
        throw new UnsupportedOperationException();
    }

    public set<Map.Entry<K,V>> keySet(){
        throw new UnsupportedOperationException();
    }

    public Collection<Map.Entry<K,V>> values(){
        throw new UnsupportedOperationException();
    }*/
}

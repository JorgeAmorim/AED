package series.serie2.problema;

import java.util.*;

public class Map<K,V>
{

    public Map(){}
    public Entry<K,V>[] ent = new Entry[100];
    public int counter = 0;

    public int index(K k)
    {
        int capacity = ent.length;
        int m = k.hashCode() % capacity;
        return (m<0)? m+capacity : m;
    }

    public V put(K key, V value)
    {
        int k = index(key); //index guardado
        boolean isNull = ent[k]==null; //guardamos info sobre se a posicao esta a null ou nao
        V formerValue;
        Entry<K, V> x = new Entry<K, V>(key, value); //cria-se uma nova entry
        Entry<K,V> aux = ent[k];
        if (isNull){
            ent[k] = x;
            counter+=1;
            return null;
        }
        while(!isNull)
        {
            if(aux.key == key){
                formerValue = aux.value;
                ent[k].value = value;
                return formerValue;
            }
            else if(aux.next != null)
                aux = ent[k].next;
            else
            {
                aux.next = x;
                counter+=1;
                return null;
            }
        }

        return null;
    }

    public V get(K key)
    {
        int k = index(key);
        Entry<K,V> aux = ent[k];
        while(aux != null){
            if(key.equals(aux.key))
                return aux.value;
            aux = aux.next;
        }
        return null;
    }

    public V remove(K key)
    {
        int k = index(key);
        if(ent[k] == null)
            return null;
        Entry<K,V> aux = ent[k];
        Entry<K,V> prev = ent[k];
        V oldValue = null;

        if(aux.key == key){
            oldValue = aux.value;
            ent[k] = aux.next;
            counter-=1;
        }
        while(aux.next != null){
            aux=aux.next;
            if(aux.key.equals(key)){
                oldValue = aux.value;
                if (aux.next == null) {
                    prev.next = null;
                }
                else {
                    prev.next = aux.next;
                }
                counter-=1;
                return oldValue;
            }
            prev = prev.next;
        }
        return oldValue;
    }

    public boolean replace(K oldK, K newK, V newV)
    {
        int k = index(oldK);
        Entry<K,V> aux = ent[k];
        boolean isNull = (ent[k] == null);
        if(isNull)
            return false;
        while (aux != null)
        {
            if(aux.key.equals(oldK)){
                if(oldK.equals(newK)){
                    aux.value = newV;
                    aux.key = newK;
                }
                else
                {
                    remove(oldK);
                    put(newK, newV);
                }
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    public int size()
    {
        return counter;
    }

    public boolean isEmpty()
    {
        return (counter == 0) ? true : false;
    }

    public Set<Entry<K,V>> entrySet()
    {
        Set<Entry<K,V>> setEntry = new HashSet<Entry<K, V>>();
        for(int i = 0; i<ent.length; ++i){
            Entry<K,V> aux = ent[i];
            if(aux != null) {
                setEntry.add(aux);
                while (aux.next != null) {
                    aux = aux.next;
                    setEntry.add(aux);
                }
            }
        }
        return setEntry;
    }

    public Set<K> keySet(){
        Set<K> setKey = new HashSet<K>();
        for(int i = 0; i<ent.length; ++i){
            Entry<K,V> aux = ent[i];
            if(aux != null) {
                setKey.add(aux.key);
                while (aux.next != null) {
                    aux = aux.next;
                    setKey.add(aux.key);
                }
            }
        }
        return setKey;
    }

    public Collection<V> values(){
        Collection<V> coll = new HashSet<V>();
        for(int i = 0; i<ent.length; ++i) {
            Entry<K, V> aux = ent[i];
            if (aux != null) {
                coll.add(aux.value);
                while (aux.next != null) {
                    aux = aux.next;
                    coll.add(aux.value);
                }
            }
        }
        return coll;
    }
}

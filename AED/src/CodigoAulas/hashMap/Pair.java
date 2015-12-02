package CodigoAulas.hashMap;

public class Pair<K,V>{
  public K key;
  public V value;
  
  public Pair(K key, V value){
    this.key = key;
    this.value = value;
  }
  
  /*
  public boolean equals(Object o){
	  if( !(o instanceof Pair)) return false;
	  Pair<K,V> pair=(Pair<K,V>) o;
	  return this.key.equals(pair.key) && this.value.equals(pair.value); 
  }
  */
}

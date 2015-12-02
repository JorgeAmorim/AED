package CodigoAulas.hashMap;

public class HashMap {
	
	public static <K,V> HashNode<K,V>[] createHashMap(int m) {
		if (m <= 0) m = 100;
		HashNode<K,V>[] hashTable = (HashNode<K,V>[]) new HashNode[m];
		return hashTable;
	}
		
	private static <K,V> int index(HashNode<K,V>[] hashTable, K k){
		int m = hashTable.length;
		int h = k.hashCode() % m;
		return (h < 0) ? h + m : h;
	}
	
	public static <K,V> void put(HashNode<K,V>[] hashTable, K k, V v){
		int i = index(hashTable, k);
		HashNode<K,V> x = new HashNode<K,V>();
		x.pair = new Pair<K,V>(k, v);
		x.next = hashTable[i];
		hashTable[i] = x;
	}
	
	public static <K,V> V get(HashNode<K,V>[] hashTable, K k){
		int i = index(hashTable, k);
		HashNode<K,V> curr = hashTable[i];
		while(curr != null){
			if (k.equals(curr.pair.key))
				return curr.pair.value;
			curr = curr.next;
		}
		return null;
	}
	
	public static <K,V> boolean containsKey(HashNode<K,V>[] hashTable, K k){
		int i = index(hashTable, k);
		HashNode<K,V> curr = hashTable[i];
		while(curr != null){
			if (k.equals(curr.pair.key))
				return true;
			curr = curr.next;
		}
		return false;
	}
	
	public static <K,V> boolean containsValue(HashNode<K,V>[] hashTable, V v){
		HashNode<K,V> curr = null;
		for (int i = 0; i < hashTable.length; i++) {
			curr = hashTable[i];
			while(curr != null){
				if (v.equals(curr.pair.value))
					return true;
				curr = curr.next;
			}
		}
		return false;
	}
	
	public static <K,V> V remove(HashNode<K,V>[] hashTable, K k){
		int i = index(hashTable, k);
		HashNode<K,V> curr = hashTable[i], prev = null;
		while(curr != null){
			if (k.equals(curr.pair.key)){
				if (prev == null) hashTable[i] = hashTable[i].next;
				else prev.next = curr.next;
				return curr.pair.value;
			}
			prev = curr; curr = curr.next;
		}
		return null;
	}
	
	public static <K,V> int size(HashNode<K,V>[] hashTable) {
		int count = 0;
		HashNode<K,V> curr = null;
		for (int i = 0; i < hashTable.length; i++) {
			curr = hashTable[i];
			while(curr != null){
				count++;
				curr = curr.next;
			}
		}
		return count;
	}
	
	public static <K,V> boolean isEmpty(HashNode<K,V>[] hashTable) {
		return size(hashTable) == 0;
	}
	
	public static <K,V> void show(HashNode<K,V>[] hashTable) {
		System.out.println("-------------------------");
		for (int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null) {
				HashNode<K,V> curr = hashTable[i];
				while (curr != null) {
					System.out.print(curr.pair.key + " " + curr.pair.value + " | ");
					curr = curr.next;
				}
				System.out.println();
			}
		System.out.println("-------------------------");
	}
}
 
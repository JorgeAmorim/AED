package CodigoAulas.hashTable;

public class HashTable {
		
	public static <E> HashNode<E>[] createHashTable(int m) {
		if (m <= 0) m = 100;
		HashNode<E>[] hashTable = (HashNode<E>[]) new HashNode[m];
		return hashTable;
	}
	
	private static <E> int index(HashNode<E>[] hashTable, E e){
		int m = hashTable.length;
		int h = e.hashCode() % m;
		return (h < 0) ? h + m : h;
	}
	
	public static <E> void insert(HashNode<E>[] hashTable, E e){
		int i = index(hashTable, e);
		HashNode<E> x = new HashNode<E>();
		x.value = e;
		x.next = hashTable[i];
		hashTable[i] = x;
	}
	
	public static <E> E search(HashNode<E>[] hashTable, E k){
		int i = index(hashTable, k);
		HashNode<E> curr = hashTable[i];
		while(curr != null){
			if (k.equals(curr.value))
				return curr.value;
			curr = curr.next;
		}
		return null;
	}
	
	public static <E> boolean delete(HashNode<E>[] hashTable, E e){
		int i = index(hashTable, e);
		HashNode<E> curr = hashTable[i];
		HashNode<E> prev = null;
		while(curr != null){
			if (e.equals(curr.value)){
				if (prev == null) hashTable[i] = hashTable[i].next;
				else prev.next = curr.next;
				return true;
			}
			prev = curr; curr = curr.next;
		}
		return false;
	}
	
	public static <E> void show(HashNode<E>[] hashTable) {
		System.out.println("------------");
		for (int i = 0; i < hashTable.length; i++)
			if (hashTable[i] != null) {
				HashNode<E> curr = hashTable[i];
				while (curr != null) {
					System.out.print(curr.value + " ");
					curr = curr.next;
				}
				System.out.println();
			}
	}
	
}
 
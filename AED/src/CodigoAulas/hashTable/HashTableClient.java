package CodigoAulas.hashTable;

import static CodigoAulas.hashTable.HashTable.*;

public class HashTableClient {

	public static void main(String[] args) {

		final int HASH_LENGTH = 20;
		HashNode<Integer>[] list = createHashTable(HASH_LENGTH);
			
		insert(list, 32); insert(list, 17); 
		insert(list, 142); insert(list, 80); 
		insert(list, 1899); insert(list, 40); 
		insert(list, 999); insert(list, 86); 
		insert(list, 83); insert(list, 20);
		insert(list, 23); insert(list, 22);		
		show(list);
		
		System.out.println("Search: " + search(list, 40));
		System.out.println("Delete: " + delete(list, 40));
		show(list);
	}
}

package CodigoAulas.hashMap;

import static CodigoAulas.hashMap.HashMap.*;

public class HashMapClient {

	public static void main(String[] args) {

		final int HASH_LENGTH = 11;
		HashNode<Integer,String>[] map = createHashMap(HASH_LENGTH);
			
		put(map, 100, "1_Euro"); 
		put(map, 200, "2_Euros"); 
		put(map, 1, "1_Centimo");
		put(map, 2, "2_Centimos");
		put(map, 5, "5_Centimos");
		put(map, 10, "10_Centimos");
		put(map, 20, "20_Centimos");
		put(map, 50, "50_Centimos"); 
		show(map);
		
		System.out.println("get(100): " + get(map, 100));
		System.out.println("containsKey(100): " + containsKey(map, 100));
		System.out.println("containsValue('1_Euro'): " + containsValue(map, "1_Euro"));
		System.out.println("remove(1): " + remove(map, 1));
		System.out.println("containsKey(1): " + containsKey(map, 1));
		System.out.println("isEmpty: " + isEmpty(map));
		System.out.println("size: " + size(map));
	}
}

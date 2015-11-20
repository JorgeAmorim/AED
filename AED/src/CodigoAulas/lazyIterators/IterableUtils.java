package CodigoAulas.lazyIterators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableUtils {
	
	public static List<Integer> makeSet() {
		List<Integer> set = new ArrayList<Integer>(); 
		set.add(2); set.add(4); set.add(4); set.add(4); set.add(4);
		set.add(5); set.add(5); set.add(5); set.add(9);
		set.add(9); set.add(10); set.add(11); set.add(11); set.add(13);
		return set;
	}
	
	public static List<Iterable<String>> makeSetStr() {
		List<Iterable<String>> setStr = new ArrayList<Iterable<String>>();
		List<String> set = new ArrayList<String>(); 
		set.add("mar"); set.add("terra"); set.add("sol"); set.add("lua"); 
		setStr.add(set);
		set = new ArrayList<String>();
		set.add("universo"); set.add("galaxia");
		setStr.add(set);
		set = new ArrayList<String>();
		set.add("marte"); set.add("mercurio"); set.add("urano");
		setStr.add(set);
		set = new ArrayList<String>();
		set.add("meteorito"); set.add("astro"); set.add("mar");
		setStr.add(set);
		return setStr;
	}
	
	public static void main(String[] args) {
		List<Integer> list = makeSet();			// A collection (from makeSet() method)
		
		System.out.print("Original set: ");
		// Original set
		for (Integer x : list) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		// Using iterator distint
		System.out.print("Distint: ");
		for (Integer x : LazyIterators.distinct(list)) {
			System.out.print(x + " ");
		}		
		System.out.println();
		
		// Using iterator distinct; another loop
		System.out.print("Distint: ");
		Iterator<Integer> it = LazyIterators.distinct(list).iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		// Using iterator evenOdd
		System.out.print("EvenOdd: ");
		it = LazyIterators.evenOdd(list).iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		// Using iterator getValuesBetween
		System.out.print("getValuesBetween: ");
		it = LazyIterators.getValuesBetween(list, 4, 9).iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		// Using iterator getValuesLessThan
		System.out.print("GetValuesLessThan: ");
		it = LazyIterators.getValuesLessThan(list, 9).iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		// Using iterator takeWhile
		System.out.print("TakeWhile: ");
		it = LazyIterators.takeWhile(list, new Even()).iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		
		// Using iterator takeWhile
		System.out.print("GetValues: ");
		Iterable<Iterable<String>> listStr = makeSetStr();
		Iterator<String> itStr = LazyIterators.getValues(listStr, new EvenLength()).iterator();
		while (itStr.hasNext())
			System.out.print(itStr.next() + " ");
		System.out.println();
	}
}
		
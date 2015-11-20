package CodigoAulas.linkedList;

import static CodigoAulas.linkedList.DoublyLinkedList.*;

public class DoulyLinkedListClient {

	public static void main(String[] args) {

		Node<Integer> myList = null;
		
		myList = insert(myList, 22);
		myList = insert(myList, 44);
		myList = insert(myList, 77);
       show(myList);
        
        System.out.println("Search 77: ");
        if (search(myList, 77) != null) System.out.println("Found"); else System.out.println("Not found");
        System.out.println("Remove 77: "); 
        myList = delete(myList, 77);
        show(myList);
        System.out.println("Remove: "); 
        myList = delete(myList);
        show(myList);
        myList = delete(myList);
        show(myList);
	}
}

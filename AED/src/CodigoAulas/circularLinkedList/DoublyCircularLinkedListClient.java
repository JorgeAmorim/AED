package CodigoAulas.circularLinkedList;

import static CodigoAulas.circularLinkedList.DoublyCircularLinkedList.*;

public class DoublyCircularLinkedListClient {

	public static Node<Integer> createMyList() {
		Node<Integer> list = createList();
        insert(list, 7);
        insert(list, 5);
        insert(list, 3);
        insert(list, 1);
        return list;
	}

  private static void insert(Node<Integer> list, int i) {
    }

    public static void main(String[] args) {

		Node<Integer> myList = createMyList();
        insertLast(myList, 77);
        System.out.println("List: ");
        show(myList);
        
        System.out.println("Search 77: ");
        if (search(myList, 77) != myList) System.out.println("Found"); else System.out.println("Not found");
        System.out.println("Remove 77: "); 
        delete(myList, 77);
        show(myList);
        
	}
}

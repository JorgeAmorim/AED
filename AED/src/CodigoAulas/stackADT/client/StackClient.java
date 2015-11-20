package CodigoAulas.stackADT.client;
import CodigoAulas.stackADT.stack.SLinkedList;
import CodigoAulas.stackADT.stack.Stack;
import CodigoAulas.stackADT.stack.StackArray;

public class StackClient {
	
	public static void main(String[] args) {
        final int MAX = 10;
        
        Stack<Employee> list = new StackArray<Employee>(MAX);
        
        list.push(new Employee(1, "Frank", 28));
        list.push(new Employee(2, "Jorge", 19));
        list.push(new Employee(3, "Bill", 34));
        list.push(new Employee(4, "Michel", 10));
        list.push(new Employee(5, "Simpson", 8));
        list.push(new Employee(6, "Clerk",16 ));
        list.push(new Employee(7, "Lee", 40));
        list.push(new Employee(8, "Mark", 30));
        
        System.out.println("Stack Array");
        showList(list);
        
        list = new SLinkedList<Employee>();
        
        list.push(new Employee(1, "Frank", 28));
        list.push(new Employee(2, "Jorge", 19));
        list.push(new Employee(3, "Bill", 34));
        list.push(new Employee(4, "Michel", 10));
        list.push(new Employee(5, "Simpson", 8));
        list.push(new Employee(6, "Clerk",16 ));
        list.push(new Employee(7, "Lee", 40));
        list.push(new Employee(8, "Mark", 30));
     
        System.out.println("Stack Linked List");
        showList(list);
    }
	
	public static void showList(Stack<Employee> list) {
		while (!list.isEmpty()) {
			Employee e = list.pop();
			System.out.println(e.getEmpId() + "\t" + e.getName() + "\t" + e.getAge());
		}
	}
}

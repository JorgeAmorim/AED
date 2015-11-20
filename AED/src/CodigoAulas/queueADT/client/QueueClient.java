package CodigoAulas.queueADT.client;

import CodigoAulas.queueADT.queue.Queue;
import CodigoAulas.queueADT.queue.QueueArray;

public class QueueClient {
	
	public static void main(String[] args) {
        final int MAX = 10;
        
        Queue<Employee> list = new QueueArray<Employee>(MAX);
        list.enqueue(new Employee(1, "Frank", 28));
        list.enqueue(new Employee(2, "Jorge", 19));
        list.enqueue(new Employee(3, "Bill", 34));
        list.enqueue(new Employee(4, "Michel", 10));
        list.enqueue(new Employee(5, "Simpson", 8));
        list.enqueue(new Employee(6, "Clerk",16 ));
        list.enqueue(new Employee(7, "Lee", 40));
        list.enqueue(new Employee(8, "Mark", 30));
        
        showList(list);
    }
	
	public static void showList(Queue<Employee> list) {
		while (!list.isEmpty()) {
			Employee e = list.dequeue();
			System.out.println(e.getEmpId() + "\t" + e.getName() + "\t" + e.getAge());
		}
	}
}

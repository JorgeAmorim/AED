package CodigoAulas.queueADT.client;

public class Employee implements Comparable<Employee>{
    private int empId;
    private String name;
    private int age;

    public Employee(int empId, String name, int age) {
        this.empId = empId;
        this.name = name;
        this.age = age;
    }
    
    public int getEmpId() {
    	return this.empId;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getAge() {
    	return this.age;
    }
    
    public void setEmpId(int newId) {
    	this.empId = newId;
    }
    
    public void setName(String newName) {
    	this.name = newName;
    }
    
    public void setAge(int newAge) {
    	this.age = newAge;
    }
    
    /**
     * Compare a given Employee with this object.
     * If employee id of this object is greater than the received object,
     * then this object is greater than the other.
     */
    public int compareTo(Employee aEmp) {
        return this.empId - aEmp.empId ;
    }
}

package java8.DesignPattern.creational;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EmployeeList implements Cloneable
{
	private List<String> names;
	public EmployeeList(List<String> employees) {
		names = employees;
	}
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		List<String> tempList = new ArrayList<>();
		
		for(String s : names)
		{
			tempList.add(s);
		}
		return new EmployeeList(tempList);
	}
}

public class PrototypePatternDeepClone_Test {

	public static void main(String args[])
	{
		// creating a prototype
		EmployeeList employeeList = new EmployeeList(Arrays.asList("Sovon","Sougata","SS"));
		
		System.out.println("Employe names: "+employeeList.getNames());
		// cloning object
		EmployeeList clone1 = null;
		EmployeeList clone2 = null;
		try {
			clone1 = (EmployeeList) employeeList.clone();
			clone2 = (EmployeeList) employeeList.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// modifying the object as required
		List<String> names = clone1.getNames();
		names.add("nawaz");
		
		System.out.println("Employe names: "+clone1.getNames());
		System.out.println("Employe names: "+clone2.getNames());
	}
	
}

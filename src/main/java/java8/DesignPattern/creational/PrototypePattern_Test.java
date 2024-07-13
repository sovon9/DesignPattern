package java8.DesignPattern.creational;

interface EmployeeProfile
{
	EmployeeProfile getClone();
}

class DevEmployeeProfile implements EmployeeProfile
{
	private String name;
	private int solvedDefects;

	public DevEmployeeProfile(String name, int solvedDefects) {
		super();
		this.name = name;
		this.solvedDefects = solvedDefects;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSolvedDefects() {
		return solvedDefects;
	}

	public void setSolvedDefects(int solvedDefects) {
		this.solvedDefects = solvedDefects;
	}

	@Override
	public EmployeeProfile getClone() {
		return new DevEmployeeProfile(name, solvedDefects);
	}
	
}

public class PrototypePattern_Test {

	public static void main(String args[])
	{
		// creating a prototype
		DevEmployeeProfile employeeProfile = new DevEmployeeProfile("Sovon", 20);
		
		System.out.println("Employe name: "+employeeProfile.getName()+" solved defects: "+employeeProfile.getSolvedDefects());
		// cloning object
		DevEmployeeProfile clone = (DevEmployeeProfile) employeeProfile.getClone();
		// modifying the object as required
		clone.setName("Sougata");
		clone.setSolvedDefects(10);
		System.out.println("Employe name: "+clone.getName()+" solved defects: "+clone.getSolvedDefects());
	}
	
}

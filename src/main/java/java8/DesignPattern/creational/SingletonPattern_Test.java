package java8.DesignPattern.creational;

class DBAccess
{
	/*
	 * private static, 
	 * private for not let it be called using Class.instance
	 * static so that it's only will be initialized once when class loading
	 */
	private static DBAccess instance; 
	
	private DBAccess() // private constructor for stopping NEW initialization
	{
		
	}
	
	public static DBAccess getInstance()
	{
	    if(null == instance) // initialize only for the first time
	    {
	    	instance = new DBAccess();
	    }
	    return instance;
	}
	
	public void performDbAction()
	{
		System.out.println("performing Db operations with object = "+this.hashCode());
	}
	
}

public class SingletonPattern_Test {

	public static void main(String[] args) {

		DBAccess dbAccess = DBAccess.getInstance();
		DBAccess dbAccess1 = DBAccess.getInstance();
		dbAccess.performDbAction();
		dbAccess1.performDbAction();

	}

}

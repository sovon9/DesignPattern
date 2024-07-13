package java8.DesignPattern.creational;

class Vehicle
{
	// mandatory parameters
	private String engine;
	private int wheels;
	
	//optional parameters
	private int airbags;

	// constructor is private since it will used by VehicleBuilder only
	private Vehicle(VehicleBuilder builder)
	{
		this.engine=builder.engine;
		this.wheels=builder.wheels;
		this.airbags=builder.airbags;
	}
	
	/*
	 * only getter method as all settings will be done inside Builder class
	 */
	public String getEngine() {
		return engine;
	}

	public int getWheels() {
		return wheels;
	}

	public int getAirbags() {
		return airbags;
	}
	
	// Builder class to build Vehicle object
	public static class VehicleBuilder
	{
		private String engine;
		private int wheels;
		
		//optional parameters
		private int airbags;
		
		// Constructor is public to be called when building object
		// only all required parameters will be in this constructor
		public VehicleBuilder(String engine , int wheels)
		{
			this.engine = engine;
			this.wheels = wheels;
		}
		
		// options parameter will be set separately
		public VehicleBuilder setAirbags(int airbags)
		{
			this.airbags = airbags;
			return this;
		}
		
		// building Vehicle object
		public Vehicle build()
		{
			return new Vehicle(this);
		}
		
	}

	@Override
	public String toString() {
		return "Vehicle [engine=" + engine + ", wheels=" + wheels + ", airbags=" + airbags + "]";
	}
	
}

public class BuilderPattern_Test {

	public static void main(String[] args) {

		/*
		 * creating builder constructor to build vehicle object and setting optional value airbags
		 */
		Vehicle car =  new Vehicle.VehicleBuilder("12v 1200cc",4).setAirbags(4).build();
		
		Vehicle bike =  new Vehicle.VehicleBuilder("4v 200cc",2).build(); // no optional value
		
		System.out.println("car = "+car);
		System.out.println("bike = "+bike);
		
	}

}

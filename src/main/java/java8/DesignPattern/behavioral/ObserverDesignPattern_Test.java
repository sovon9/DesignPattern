package java8.DesignPattern.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Subject
{
	void register(Observer obs);
	void unregister(Observer obs);
	void notifyObservers();
}

class DeliveryData implements Subject
{
	List<Observer> observers;
	String location;
	
	public DeliveryData() {
		super();
		observers = new ArrayList<>();
	}

	@Override
	public void register(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void unregister(Observer obs) {
		observers.remove(obs);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers)
		{
			o.update(location);
		}
	}
	
}

interface Observer
{
	void update(String location);
}

class User implements Observer
{

	@Override
	public void update(String location) {
		System.out.println("User Notification=> Your pkg has been arrived at: "+location);
	}
	
}

class Seller implements Observer
{

	@Override
	public void update(String location) {
		System.out.println("Seller Notification=> Pkg has been arrived at: "+location);
	}
	
}

public class ObserverDesignPattern_Test {

	public static void main(String[] args) {

		DeliveryData subject = new DeliveryData();
		
		Observer observer1 = new User();
		Observer observer2 = new Seller();
		
		subject.register(observer1);
		subject.register(observer2);
		
		subject.setLocation("HWH");
		
		subject.setLocation("BWN");
		System.out.println("\nUnregistering the serller observer.......");
		subject.unregister(observer2);
		subject.setLocation("home");
		
	}

}

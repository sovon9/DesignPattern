package java8.DesignPattern.creational;

interface Notification
{
	 void notifyUser();
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an Email notification");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification");
    }
}

class PushNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending a Push notification");
    }
}
/*
 * Factory call for generating Notification objects
 */
class NotificationFactory {
    
    public Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) {
            return null;
        }
        switch (channel) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown channel " + channel);
        }
    }
}

public class FactoryPattern_Test {

	public static void main(String[] args) {

		NotificationFactory notificationFactory = new NotificationFactory();

        // Get an object of EmailNotification and call its notifyUser method.
        Notification notification1 = notificationFactory.createNotification("EMAIL");
        notification1.notifyUser();

        // Get an object of SMSNotification and call its notifyUser method.
        Notification notification2 = notificationFactory.createNotification("SMS");
        notification2.notifyUser();

        // Get an object of PushNotification and call its notifyUser method.
        Notification notification3 = notificationFactory.createNotification("PUSH");
        notification3.notifyUser();
		
	}

}

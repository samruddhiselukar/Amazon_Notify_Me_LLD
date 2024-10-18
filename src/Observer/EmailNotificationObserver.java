package Observer;

import Observable.StockObservable;

public class EmailNotificationObserver implements NotificationAlertObserver{
    //using constructor injection instead of instanceOf
    String emailId;
    StockObservable observable;

    public EmailNotificationObserver(String emailId, StockObservable observable){
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "Product is in stock, HURRY UP!");
    }

    public void sendEmail(String emailId, String msg){
        System.out.println("Message sent to:" + emailId);
    }
}

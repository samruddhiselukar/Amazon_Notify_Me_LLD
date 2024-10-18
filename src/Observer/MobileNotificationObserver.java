package Observer;

import Observable.StockObservable;

public class MobileNotificationObserver implements NotificationAlertObserver{

    String userId;
    StockObservable observable;

    public MobileNotificationObserver(String userId, StockObservable observable){
        this.userId = userId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMsg(userId, "Product is in stock, HURRY UP!");
    }

    public void sendMsg(String userId, String msg){
        System.out.println("Message sent to:" + userId);
    }
}

package Observable;

import Observer.NotificationAlertObserver;

public interface StockObservable {
    //add
    public void add(NotificationAlertObserver observer);
    //remove
    public void remove(NotificationAlertObserver observer);
    //notify
    public void notifyUsers();
    //set data
    public void setStockCount(int newStockAdded);
    //get Data
    public int getStockCount();
}

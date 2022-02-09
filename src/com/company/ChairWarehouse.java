package com.company;

public class ChairWarehouse {
    private static ChairWarehouse instance = new ChairWarehouse();
    private static Object key = new Object();

    private int numberOfChairsLeft;

    private ChairWarehouse() {
    }

    public synchronized void buyStockForChairWarehouse(int numberOfNewChairs) {
        this.numberOfChairsLeft += numberOfNewChairs;
    }

    public synchronized void sellChairFromStock(int numberOfChairsToBeSold) {
        if (numberOfChairsToBeSold > numberOfChairsLeft) {
            System.out.println("Not enough stock, buying extra " + (numberOfChairsToBeSold - numberOfChairsLeft)
                    + " chairs to be able to sell to the client!");

            numberOfChairsLeft += numberOfChairsToBeSold;
        }
        numberOfChairsLeft -= numberOfChairsToBeSold;
        System.out.println("Sold " + numberOfChairsToBeSold + " chair to the client!");
    }


    public static ChairWarehouse getInstance() {
        if (instance == null) {
            synchronized (key) {
                if (instance == null) {
                    System.out.println("Chair Warehouse created!!!");
                    instance = new ChairWarehouse();
                }
            }
        }

        return instance;
    }
}

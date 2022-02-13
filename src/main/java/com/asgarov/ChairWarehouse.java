package com.asgarov;

public class ChairWarehouse {
    private static volatile ChairWarehouse instance;
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
        System.out.println("Sold " + numberOfChairsToBeSold + " chairs to the client!");
    }

    public synchronized int getCurrentStockQuantity() {
        return ChairWarehouse.getInstance().numberOfChairsLeft;
    }


    public static ChairWarehouse getInstance() {
        if (instance == null) {
            synchronized (ChairWarehouse.class) {
                if (instance == null) {
                    System.out.println("Chair Warehouse created!!!");
                    instance = new ChairWarehouse();
                }
            }
        }

        return instance;
    }
}

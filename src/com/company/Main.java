package com.company;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                ChairWarehouse.getInstance();
                ChairWarehouse.getInstance().sellChairFromStock(1);
            }).start();
        }
    }
}

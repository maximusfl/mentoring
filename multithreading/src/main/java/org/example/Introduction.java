package org.example;

public class Introduction {
    public static void main(String[] args) {
       new Thread(()->{
           for (int i = 0; i < 100; i++) {
               System.out.println("Hello from CustomThread");
           }
       }).start();
        System.out.println("Hello from main thread");
    }
}

class FirstWrapper {
    public void mainWork() {
        CustomThread customThread = new CustomThread();
        customThread.start();
        System.out.println("Hello from Main thread");
    }

}

class SecondWrapper {


    public void dowork() {
       new FirstWrapper().mainWork();
    }

}

class CustomThread extends Thread {
    @Override
    public void run() {
        print(3);
    }

    void print(int b){
        methot2lvlDepth(2);
    }

    void methot2lvlDepth(int a){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello from CustomThread");
        }

    }
}



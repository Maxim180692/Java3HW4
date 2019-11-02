

public class HomeWork4 {
    public static void main(String[] args) {

        task1();
        //task2();
        //task3();
    }

    public static void task1() {
        Task12 t = new Task12();
        new Thread(() -> t.printA()).start();
        new Thread(() -> t.printB()).start();
        new Thread(() -> t.printC()).start();
    }


}

class Task12 {
    private final Object obj = new Object();
    private volatile char litera = 'A';

    public void printA() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (litera != 'A') obj.wait();
                    System.out.print("A");
                    litera = 'B';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (litera != 'B') obj.wait();
                    System.out.print("B");
                    litera = 'C';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printC() {
        synchronized (obj) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (litera != 'C') obj.wait();
                    System.out.print("C");
                    litera = 'A';
                    obj.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


package MultiThreading.Synchronization;

public class Counter {
    private int count = 0;

    public void increament() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

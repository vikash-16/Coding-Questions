package Synchronization;

public class Inter_Thread_Communication {

}
class Account {
    int amount = 10000;
     synchronized void withrow(int amount) {
        System.out.println("withrowing");
        if(this.amount < amount) {
            System.out.println("less balance in acoount wait for deposite amount");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.amount-=amount;
            System.out.println(amount+" withrow from account");
            System.out.println("remaining amount in account "+this.amount);
        }
    }
     synchronized void deposite(int amount) {
        System.out.println(amount+" going for deposite");
        this.amount+=amount;
        System.out.println("amount after deposite "+this.amount);
        notify();
    }


    public static void main(String[] args) {
        final Account account = new Account();
        Thread t1 = new Thread(() -> {
            account.withrow(15000);
        });
        Thread t2 = new Thread(() -> {
            account.deposite(15000);
        });
        t1.start();
        t2.start();
    }
}

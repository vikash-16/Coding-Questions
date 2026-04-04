package DSAPractice;

public class LocalInterface {
    public void myMethod() {

        interface MyInterface {

            default void display() {
                System.out.println("Local interface");
            }
        }
        new MyInterface() {
            @Override
            public void display() {
                System.out.println("1 interface");
            }
        }.display();
    }

    public static void main(String[] args) {
        LocalInterface local = new LocalInterface();
        local.myMethod();
    }
}
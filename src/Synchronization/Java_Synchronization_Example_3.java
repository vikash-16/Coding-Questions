package Synchronization;
class Sender {
    public void SenderMsg(String msg) {
        System.out.println("\nSending a Message: "  + msg);
        try
        {
            Thread.sleep(800);
        }
        catch (Exception e)
        {
            System.out.println("Thread interrupted.");
        }
        System.out.println("\n" +msg+ "Sent");
    }
}
class SenderWThreads extends Thread
{
    private String msg;
    Sender sd;

    // Receiver method to receive a message object and a message to be sent
    SenderWThreads(String m, Sender obj)
    {
        msg = m;
        sd = obj;
    }

    public void run()
    {
        // Checks that only one thread sends a message at a time.
        synchronized(sd)
        {
            // synchronizing the sender object
            sd.SenderMsg(msg);
        }
    }
}
public class Java_Synchronization_Example_3 {
    public static void main(String[] args) {
        Sender sender = new Sender();
        SenderWThreads sender1 = new SenderWThreads( "Hola " , sender);
        SenderWThreads sender2 =  new SenderWThreads( "Welcome to Javatpoint website ", sender);
        sender1.start();
        sender2.start();
        try {
            sender1.join();
            sender2.join();
            System.out.println(System.currentTimeMillis());
        }catch (Exception e) {
            System.out.println("Interrupted");
        }
    }

}

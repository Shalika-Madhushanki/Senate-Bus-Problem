import javax.swing.plaf.SeparatorUI;
import java.util.concurrent.Semaphore;

class Rider extends Thread{

//    private int  waiting;
//    private Semaphore mutex;
//    private Semaphore bus;
//    private Semaphore boarded;
    private int id;

    public Rider(int id) {
        this.id=id;
        System.out.println("Rider "+ this.id + " arrived at the bus...");

    }

    public void board(){
        System.out.println("Rider "+ this.id + " boarded to the bus...");
    }

    public void run() {
        try {
            Shared.mutex.acquire();

            Shared.waiting = Shared.waiting + 1;
            Shared.mutex.release();
            Shared.Bus.acquire();


            board();
            Shared.boarded.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
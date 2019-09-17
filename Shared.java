import java.util.Random;
import java.util.concurrent.Semaphore;

public class Shared {
    public static volatile int waiting =0;
    public static volatile Semaphore mutex = new Semaphore(1);
    public static volatile Semaphore Bus = new Semaphore(0);
    public static volatile Semaphore boarded = new Semaphore(0);


    public Semaphore getMutex(){
        return mutex;
    }

    public Semaphore getBus(){
        return Bus;
    }

    public Semaphore getBoarded(){
        return boarded;
    }
    public int getWaiting(){
        return waiting;
    }

    public void setMutex(Semaphore m){
        this.mutex = m;
    }
    public void setBus(Semaphore b){
        this.Bus = b;
    }
    public void setBoarded(Semaphore b){
        this.boarded = b;
    }
    public void setWaiting(int w){
        this.waiting= w;
    }
}

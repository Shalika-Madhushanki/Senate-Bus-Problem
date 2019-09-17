import java.util.Random;

import static java.lang.Thread.sleep;

public class RiderGenerator  extends Thread {
    Shared shared;
    int counter = 1 ;
    Random random = new Random();

    public RiderGenerator() {
    }

    public void run(){

        while(!Thread.currentThread().isInterrupted()) {

            //        double lambda = 1 / 5*1000;
            float u =random.nextFloat();
            long x = (long) ((-1 * 30*1000) * (Math.log(1 - u)));
            try {
                Rider rider = new Rider(counter);
                rider.start();
                counter =counter+1;
                sleep(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}

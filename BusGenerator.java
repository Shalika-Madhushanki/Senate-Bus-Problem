import java.util.Random;

public class BusGenerator extends Thread {
    Shared shared;
    int counter = 1;
    Random random = new Random();


    public BusGenerator() {
    }

    public void run(){

        while(!Thread.currentThread().isInterrupted()){
            //        double lambda = 1 / 1 *1000;
            float u =random.nextFloat();
            long x = (long) ((-1* 60*1000*20) * (Math.log(1 - u)));
            Bus bus = new Bus(counter);
            bus.start();
            counter = counter+1;
            try {
                sleep(x);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }

}

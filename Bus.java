import java.util.concurrent.Semaphore;

class Bus extends Thread{
    private int id ;


    public Bus(int id) {
        this.id =id;
        System.out.println("Bus "+ this.id + " arrived...");

    }

    public void depart(){
        System.out.println("Bus " + this.id+ " departed...");
    }

    public void run() {

        try {
            Shared.mutex.acquire();

            int n = Math.min(Shared.waiting, 50);
            for (int i = 0; i < n; i++) {
                Shared.Bus.release();
                Shared.boarded.acquire();

            }

            Shared.waiting = (Math.max(Shared.waiting - 50, 0));
            Shared.mutex.release();
            depart();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
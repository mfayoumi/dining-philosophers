import java.util.Random;

public class ForkHandler {


//    private Boolean status;
    private Boolean available;
    protected Integer forkId;

    /**
     * Initialize the fork ID and set make it un-picked by setting the status true
     * @param forkId
     */
    ForkHandler(Integer forkId) {
        this.forkId = forkId;
        this.available = true;
    }

    /***
     * Release the fork after finishing by setting the status True
     * Synchronized method: No multi threads can access this method at the same time
     * @throws InterruptedException
     */
    public synchronized void releaseFork() throws InterruptedException {available = true;}

    /**
     *
     * Synchronized method: No multi threads can access this method at the same time
     * @return Fork picking status: Picked => True, not Picked => False
     * @throws InterruptedException
     */
    public synchronized boolean pickFork(Integer philosopherId, Integer forkId , String direction) throws  InterruptedException {

        int counter = 0;
        int waitUntil = new Random().nextInt(10) + 5;
        while (!available) { // Fork already in use
            Thread.sleep(new Random().nextInt(100) + 50 );

            counter ++;
            if (counter > waitUntil) {
                System.out.println("The Philosopher " + philosopherId + " picked the " +direction+ " FORK "  +forkId+ " and LOCKED it");
                return false;
            }
        }

        available = false;

        return true;
    }
}

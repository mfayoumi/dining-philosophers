import java.util.Random;

public class Philosopher {

    private Integer philosopherId;
    private ForkHandler left;
    private ForkHandler right;

    public Philosopher(Integer philosopherId) {
        this.philosopherId = philosopherId;
    }

    /**
     * If the philosopher cant eat it will think
     * @throws InterruptedException
     */
    public void think() throws InterruptedException {
        System.out.println("The Philosopher " + philosopherId + " is thinking now =======");
        Thread.sleep(new Random().nextInt(1000) + 100); // Think with random duration of time
        System.out.println("The Philosopher " + philosopherId + " stopped thinking ===:)===");

    }

    /**
     * Start eating process
     * @throws InterruptedException
     */
    public void eat() throws InterruptedException {

        /**
         * Assuming that both Forks are unavailable
         */
        boolean rightPick = false;
        boolean leftPick = false;

        System.out.println("The Philosopher " + philosopherId + " is hungry and wants to eat.");

        System.out.println("The Philosopher " + philosopherId + " is picking up the LEFT FORK " + left.forkId);
        leftPick = left.pickFork(philosopherId, left.forkId, "LEFT"); // Try to pick the left fork

        if (!leftPick) {  // Left fork unavailable => exit
            System.out.println("LEFT FORK " + left.forkId + " BUSY");
            return;
        }

        System.out.println("The Philosopher " + philosopherId + " is picking up THE RIGHT FORK " + right.forkId);
        rightPick = right.pickFork(philosopherId, right.forkId, "RIGHT"); // Try to pick the right fork

        if (!rightPick) { // Right fork unavailable => exit
            left.releaseFork(); // Release the left fork if the right one is not available
            System.out.println("RIGHT FORK " + right.forkId + " BUSY");
            System.out.println("philosopherId RELEASED THE LEFT FORK " + left.forkId);
            return;
        }

        System.out.println("The Philosopher " + philosopherId + " is now EATING .........");

        Thread.sleep(new Random().nextInt(1000) + 100); // Eating within Random duration

        /**
         * Release both forks after finish eating
         */
        left.releaseFork();
        right.releaseFork();

        System.out.println("The Philosopher " + philosopherId + " has FINISHED eating AND FORKS LEFT[" +left.forkId+ "] RIGHT[" +right.forkId+ "] RELEASED *****");


    }

    /**
     * Start eating or thinking randomly
     * @param left
     * @param right
     * @throws InterruptedException
     */
    public void start(ForkHandler left, ForkHandler right) throws InterruptedException {
        this.left = left; // Left fork setter
        this.right = right; // Right fork setter

        while (true) {
            if(new Random().nextBoolean()) { // Random choice
                eat();
            } else {
                think();
            }
        }
    }
}

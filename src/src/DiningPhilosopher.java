import java.util.ArrayList;
import java.util.List;

public class DiningPhilosopher {

    private List<Philosopher> philosophersList = new ArrayList<>();
    private List<ForkHandler> forksList = new ArrayList<>();
    private List<Thread> threadsList = new ArrayList<>();
    private Integer philosophersNumber;

    public DiningPhilosopher() {}
    public DiningPhilosopher(Integer philosophersNumber) {
        this.philosophersNumber = philosophersNumber;
    }

    /**
     * Initiate the eating table with limited number of Philosopher
     */
    public void tableInitializer() {

        for (int i = 0; i < philosophersNumber; i++) {
            philosophersList.add(i, new Philosopher(i+1)); // Initiate a list of Philosopher with fixed length
            forksList.add(i, new ForkHandler(i+1));  // Initiate a list of Forks with fixed length
        }

    }

    /**
     *
     * Initiate
     */
    public void startThinkingEating() {
        for (int i = 0; i < philosophersNumber; i++) {
            final int index = i;
            threadsList.add(i, new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        /**
                         * Start method with take a cyclic philosophers e.g. if number = 3 then [(0,1), (1,2), (2,3), (3,0)]
                         */
                        philosophersList.get(index).start(
                                forksList.get(index), // Left Fork index
                                forksList.get((index + 1) % (philosophersNumber)) // Right Fork index
                        );
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }));

            threadsList.get(i).start(); // Run a thread by index ID
        }
    }
}

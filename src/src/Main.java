public class Main {

    public static void main(String[] args) {
        DiningPhilosopher diningPhilosopher = new DiningPhilosopher(5); // Initializing 5 philosophers
        diningPhilosopher.tableInitializer();
        diningPhilosopher.startThinkingEating();
    }
}

# Dining Philosophers problem simulation
## Eating and Thinking processes are randomly chosen

### Run
Pass the number of Philosophers to set up the table and forks in the Main class

```java
DiningPhilosopher diningPhilosopher = new DiningPhilosopher(100); // Initializing 100 philosophers
```
 ### Output sample with 3 Philosophers
```shell
The Philosopher 1 is hungry and wants to eat.
The Philosopher 2 is hungry and wants to eat.
The Philosopher 3 is thinking now =======
The Philosopher 2 is picking up the LEFT FORK 2
The Philosopher 1 is picking up the LEFT FORK 1
The Philosopher 2 is picking up THE RIGHT FORK 3
The Philosopher 1 is picking up THE RIGHT FORK 2
The Philosopher 2 is now EATING .........
The Philosopher 3 stopped thinking ===:)===
The Philosopher 3 is hungry and wants to eat.
The Philosopher 3 is picking up the LEFT FORK 3
The Philosopher 3 picked the LEFT FORK 3 and LOCKED it
LEFT FORK 3 BUSY
The Philosopher 3 is hungry and wants to eat.
The Philosopher 3 is picking up the LEFT FORK 3
The Philosopher 1 picked the RIGHT FORK 2 and LOCKED it
RIGHT FORK 2 BUSY
philosopherId RELEASED THE LEFT FORK 1
The Philosopher 1 is hungry and wants to eat.
The Philosopher 1 is picking up the LEFT FORK 1
The Philosopher 1 is picking up THE RIGHT FORK 2
The Philosopher 1 is now EATING .........
The Philosopher 1 has FINISHED eating AND FORKS LEFT[1] RIGHT[2] RELEASED *****
The Philosopher 1 is hungry and wants to eat.
The Philosopher 1 is picking up the LEFT FORK 1
The Philosopher 1 is picking up THE RIGHT FORK 2
The Philosopher 1 is now EATING .........
The Philosopher 3 picked the LEFT FORK 3 and LOCKED it
LEFT FORK 3 BUSY
The Philosopher 2 has FINISHED eating AND FORKS LEFT[2] RIGHT[3] RELEASED *****
The Philosopher 3 is hungry and wants to eat.
.
.
.
The Philosopher 3 is picking up the LEFT FORK 3
The Philosopher 2 is hungry and wants to eat.
The Philosopher 3 is picking up THE RIGHT FORK 1
The Philosopher 2 is picking up the LEFT FORK 2
```

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();

        User user1 = new User(1, 2, 5, elevator);
        User user2 = new User(2, 3, 2, elevator);

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elevator.start();
    }
}
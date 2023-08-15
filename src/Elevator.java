import java.util.ArrayList;
import java.util.List;

public class Elevator extends Thread {
    private int currentFloor;
    private ElevatorState state;
    private List<User> passengers;

    public Elevator() {
        this.currentFloor = 1;
        this.state = ElevatorState.STOPPED;
        this.passengers = new ArrayList<>();
    }

    public synchronized void move(int targetFloor) {
        state = targetFloor > currentFloor ? ElevatorState.MOVING_UP : ElevatorState.MOVING_DOWN;
        System.out.println(state + ": " + targetFloor + "층으로 이동하고 있습니다.");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentFloor = targetFloor;
        state = ElevatorState.STOPPED;
        System.out.println(currentFloor + "층으로 이동했습니다.");
        unloadPassengers();
    }

    public synchronized void addPassenger(User user) {
        passengers.add(user);
    }

    private synchronized void unloadPassengers() {
        passengers.removeIf(user -> user.getTargetFloor() == currentFloor);
        System.out.println(currentFloor + "층에서 내렸습니다.");
    }
}

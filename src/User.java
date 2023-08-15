public class User extends Thread {
    private int userId;
    private int currentFloor;
    private int targetFloor;
    private Elevator elevator;

    public User(int userId, int currentFloor, int targetFloor, Elevator elevator) {
        this.userId = userId;
        this.currentFloor = currentFloor;
        this.targetFloor = targetFloor;
        this.elevator = elevator;
    }

    public int getUserId() {
        return userId;
    }

    public int getTargetFloor() {
        return targetFloor;
    }

    public void callElevator() {
        System.out.println("User " + userId + "가 " + currentFloor + "층으로 엘리베이터를 불렀습니다.");
        elevator.addPassenger(this);
    }

    public void enterElevator() {
        System.out.println("User " + userId + "가 " + currentFloor + "층에 있는 엘리베이터를 탔습니다.");
        elevator.move(targetFloor);
    }

    @Override
    public void run() {
        callElevator();
        enterElevator();
    }
}

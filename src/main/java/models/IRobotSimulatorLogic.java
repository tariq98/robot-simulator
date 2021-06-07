package models;

public interface IRobotSimulatorLogic {
    public void place(Position position, MoveDirection moveDirection);
    public void move();
    public void rotate(RotationDirection rotationDirection);
    public String report();
}

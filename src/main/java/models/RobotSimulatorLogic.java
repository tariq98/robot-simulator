package models;

public class RobotSimulatorLogic implements IRobotSimulatorLogic {
    private Position position;
    private MoveDirection moveDirection;

    public RobotSimulatorLogic() {
        position = new Position();
        moveDirection = MoveDirection.NORTH;
    }

    public void place(Position position, MoveDirection moveDirection) {
        if(!position.isValid()) {
            return;
        }
        this.position = position;
        this.moveDirection = moveDirection;
    }

    public void move() {
        Position newPosition = new Position();

        switch(moveDirection) {
            case NORTH:
                newPosition = new Position(position.getX(), position.getY() + 1);
                break;
            case SOUTH:
                newPosition = new Position(position.getX(), position.getY() - 1);
                break;
            case EAST:
                newPosition = new Position(position.getX() + 1, position.getY());
                break;
            case WEST:
                newPosition = new Position(position.getX() - 1, position.getY());
                break;
        }

        if(newPosition.isValid())
            position = newPosition;
    }

    public void rotate(RotationDirection rotationDirection) {
        switch(rotationDirection) {
            case LEFT:
                rotateLeft();
                break;
            case RIGHT:
                rotateRight();
                break;
        }
    }

    private void rotateLeft() {
        switch(moveDirection) {
            case NORTH:
                moveDirection = MoveDirection.WEST;
                break;
            case SOUTH:
                moveDirection = MoveDirection.EAST;
                break;
            case EAST:
                moveDirection = MoveDirection.NORTH;
                break;
            case WEST:
                moveDirection = MoveDirection.SOUTH;
                break;
        }
    }

    private void rotateRight() {
        switch(moveDirection) {
            case NORTH:
                moveDirection = MoveDirection.EAST;
                break;
            case SOUTH:
                moveDirection = MoveDirection.WEST;
                break;
            case EAST:
                moveDirection = MoveDirection.SOUTH;
                break;
            case WEST:
                moveDirection = MoveDirection.NORTH;
                break;
        }
    }

    public String report() {
        return position.getX() + "," + position.getY() + "," + moveDirection;
    }
}
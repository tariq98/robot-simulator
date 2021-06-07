package models;

public class RobotSimulatorLogic implements IRobotSimulatorLogic {
    private Position position;
    private MoveDirection moveDirection;
    private boolean isPlaced;

    public RobotSimulatorLogic() {
        position = new Position();
        moveDirection = MoveDirection.NORTH;
        isPlaced = false;
    }

    public void place(Position position, MoveDirection moveDirection) {
        if(position.isOutOfBounds())
            return;

        this.position = position;
        this.moveDirection = moveDirection;
        this.isPlaced = true;
    }

    public void move() {
        if(!isPlaced)
            return;

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

        if(!newPosition.isOutOfBounds())
            position = newPosition;
    }

    public void rotate(RotationDirection rotationDirection) {
        if(!isPlaced)
            return;

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
        if(!isPlaced)
            return "Not placed";

        return position.getX() + "," + position.getY() + "," + moveDirection;
    }
}
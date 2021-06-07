import models.*;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotSimulatorLogicTests {
    private IRobotSimulatorLogic robotSimulatorLogic;

    public RobotSimulatorLogicTests() {
        robotSimulatorLogic = new RobotSimulatorLogic();
    }

    @Test
    public void RobotSimulatorLogicFunctionalityTest1() {
        robotSimulatorLogic.place(new Position(0, 0), MoveDirection.NORTH);
        robotSimulatorLogic.move();
        assertEquals(robotSimulatorLogic.report(), "0,1,NORTH");
    }

    @Test
    public void RobotSimulatorLogicFunctionalityTest2() {
        robotSimulatorLogic.place(new Position(0, 0), MoveDirection.NORTH);
        robotSimulatorLogic.rotate(RotationDirection.LEFT);
        assertEquals(robotSimulatorLogic.report(), "0,0,WEST");
    }

    @Test
    public void RobotSimulatorLogicFunctionalityTest3() {
        robotSimulatorLogic.place(new Position(1, 2), MoveDirection.EAST);
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.rotate(RotationDirection.LEFT);
        robotSimulatorLogic.move();
        assertEquals(robotSimulatorLogic.report(), "3,3,NORTH");
    }

    @Test
    public void robotNotOutOfBoundsTest() {
        robotSimulatorLogic.place(new Position(0, 0), MoveDirection.NORTH);
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.rotate(RotationDirection.RIGHT);
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        robotSimulatorLogic.move();
        assertEquals(robotSimulatorLogic.report(), "4,4,EAST");
    }
}

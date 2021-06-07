import models.MoveDirection;
import models.Position;
import models.RobotSimulatorModel;
import models.RotationDirection;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RobotSimulatorModelTests {
    private RobotSimulatorModel robotSimulatorModel;

    public RobotSimulatorModelTests() {
        robotSimulatorModel = new RobotSimulatorModel();
    }

    @Test
    public void testCase1() {
        robotSimulatorModel.place(new Position(0, 0), MoveDirection.NORTH);
        robotSimulatorModel.move();
        assertEquals(robotSimulatorModel.report(), "0,1,NORTH");
    }

    @Test
    public void testCase2() {
        robotSimulatorModel.place(new Position(0, 0), MoveDirection.NORTH);
        robotSimulatorModel.rotate(RotationDirection.LEFT);
        assertEquals(robotSimulatorModel.report(), "0,0,WEST");
    }

    @Test
    public void testCase3() {
        robotSimulatorModel.place(new Position(1, 2), MoveDirection.EAST);
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.rotate(RotationDirection.LEFT);
        robotSimulatorModel.move();
        assertEquals(robotSimulatorModel.report(), "3,3,NORTH");
    }

    @Test
    public void robotNotOutOfBoundsTest() {
        robotSimulatorModel.place(new Position(0, 0), MoveDirection.NORTH);
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.rotate(RotationDirection.RIGHT);
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        robotSimulatorModel.move();
        assertEquals(robotSimulatorModel.report(), "4,4,EAST");
    }
}

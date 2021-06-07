package robotSimulatorApp;

import models.MoveDirection;
import models.Position;
import models.RobotSimulatorModel;
import models.RotationDirection;

import java.util.Scanner;

public class Main {
    public static void main(String args []) {
        Scanner scan = new Scanner(System.in);
        RobotSimulatorModel robotSimulatorModel = new RobotSimulatorModel();

        while(true) {
            String input = scan.nextLine();

            switch(input.split("\\s+")[0]) {
                case "PLACE":
                    String[] placeCommand = input.split("\\s+")[1].split(",");
                    robotSimulatorModel.place(
                            new Position(Integer.parseInt(placeCommand[0]), Integer.parseInt(placeCommand[1])),
                            MoveDirection.valueOf(placeCommand[2]));
                    break;
                case "MOVE":
                    robotSimulatorModel.move();
                    break;
                case "LEFT":
                case "RIGHT":
                    robotSimulatorModel.rotate(RotationDirection.valueOf(input));
                    break;
                case "REPORT":
                    System.out.println(robotSimulatorModel.report());
                    break;
            }
        }
    }
}

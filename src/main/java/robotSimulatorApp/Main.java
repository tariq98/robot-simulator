package robotSimulatorApp;

import models.*;

import java.util.Scanner;

public class Main {
    public static void main(String args []) {
        Scanner scan = new Scanner(System.in);
        IRobotSimulatorLogic robotSimulatorLogic = new RobotSimulatorLogic();

        while(true) {
            String input = scan.nextLine();

            switch(input.split("\\s+")[0]) {
                case "PLACE":
                    String[] placeCommand = input.split("\\s+")[1].split(",");
                    robotSimulatorLogic.place(
                            new Position(Integer.parseInt(placeCommand[0]), Integer.parseInt(placeCommand[1])),
                            MoveDirection.valueOf(placeCommand[2]));
                    break;
                case "MOVE":
                    robotSimulatorLogic.move();
                    break;
                case "LEFT":
                case "RIGHT":
                    robotSimulatorLogic.rotate(RotationDirection.valueOf(input));
                    break;
                case "REPORT":
                    System.out.println(robotSimulatorLogic.report());
                    break;
            }
        }
    }
}

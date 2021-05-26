
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private ShotsStorage storage = new ShotsStorage();

    public void startReadingCommands() {
        int command = getCommand();
        switch (command) {
            case 1: {
                getShot();
                break;
            }
            case 2: {
                printShots();
                break;
            }
            case 3: {
                exit();
                break;
            }
            default: {
                System.out.println("Wrong command code. Please, enter code of command");
                startReadingCommands();
                break;
            }
        }
    }

    private void writeHelp() {
        System.out.println("1 - shot");
        System.out.println("2 - print shots");
        System.out.print("3 - exit");
    }

    private void getShot() {
        System.out.println("Enter X");
        double x = getCoordinate();
        System.out.println("Enter Y");
        double y = getCoordinate();
        System.out.println("Enter R");
        double r = getRad();
        Shot shot = new Shot(x, y, r);
        storage.addShot(shot);
    }

    private void printShots() {
        Arrays.stream(storage.getShots()).forEachOrdered(shot -> System.out.println(shot.toString()));
    }

    private void exit() {
        System.exit(0);
    }

    private int getCommand() {
        int command = 0;
        while (true) {
            writeHelp();
            System.out.println("Write code of command");
            System.out.print("> ");
            String str = scanner.nextLine();
            try {
                command = Integer.parseInt(str);
                break;
            } catch (Exception e) {
                System.out.println("Wrong, command must be int");
            }
        }
        if (command < 1 || command > 3) {
            System.out.println("Wrong command code. Please, enter code of command");
            return getCommand();
        }
        return command;
    }

    private double getCoordinate() {
        double doub = 0;
        while (true) {
            System.out.print("> ");
            String str = scanner.nextLine();
            try {
                doub = Double.parseDouble(str);
                break;
            } catch (Exception e) {
                System.out.println("Must be double");
            }
        }
        return doub;
    }

    private double getRad() {
        double doub = 0;
        while (true) {
            doub = getCoordinate();
            if (doub > 0) {
                return doub;
            } else {
                System.out.println("Rad must be higher than 0");
            }
        }
    }


}

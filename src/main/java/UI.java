import java.util.Scanner;

public class UI {
    private static Scanner scanner = new Scanner(System.in);


    public static void mainMenu() {
        boolean isQuit = false;
        do {
            System.out.printf("%nEnter 'c' to continue to Color Code finder for Copper. " +
                    "%nEnter 'f' for Color Code finder for Fiber." +
                    "%nEnter 'i' for more information about color codes. " +
                    "%nEnter 'q' to quit.%n%n");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("q")) {
                isQuit = true;
            } else if (userInput.equalsIgnoreCase("c")){
                CopperColorCode.colorFinder();
            } else if( userInput.equalsIgnoreCase("i")) {
                Information.informationMenu();
            } else if (userInput.equalsIgnoreCase("f")) {
                FiberColorCode.fiberColorFinder();
            } else {
                System.out.println("Invalid entry. Try again.");
            }
        } while (!isQuit);
    }

}

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FiberColorCode {


    public static void fiberColorFinder() {
        Scanner scanner = new Scanner(System.in);
        boolean isQuit = false;

        do {
            System.out.println("Enter a fiber number (integer) up to 12: ");
            System.out.println("If searching more than one fiber, separate each pair by a space.");
            String fiberString = scanner.nextLine();
            String[] fiberArr = fiberString.split(" ");

            for (String fiber : fiberArr) {
                if (Calc.isNumeric(fiber)) {
                    if (Integer.parseInt(fiber) > 0 && Integer.parseInt(fiber) <= 12) {
                        int fiberNumber = Integer.parseInt(fiber);
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.printf("%nFor fiber %s, the color is: %s %n",fiberNumber, fiberColor(fiberNumber));
                        System.out.printf("----------------------------------------------------------------------------------%n%n");
                    }
                } else if (fiber.equalsIgnoreCase("q")) {
                    isQuit = true;
                } else {
                    System.out.println("Invalid entry. Try again.");
                }
            }
        } while (!isQuit);
    }

    private static String fiberColor(int fiberNum) {
        int fiberRemain = fiberNum % 12;
        String fiberColor = "";

        Map<Integer, String> fiberMap = new HashMap<>();
        fiberMap.put(1,"blue");
        fiberMap.put(2,"orange");
        fiberMap.put(3,"green");
        fiberMap.put(4,"brown");
        fiberMap.put(5,"slate");
        fiberMap.put(6,"white");
        fiberMap.put(7,"red");
        fiberMap.put(8,"black");
        fiberMap.put(9,"yellow");
        fiberMap.put(10,"violet");
        fiberMap.put(11,"rose");
        fiberMap.put(0,"aqua");

        return fiberColor = fiberMap.get(fiberRemain);


    }


}

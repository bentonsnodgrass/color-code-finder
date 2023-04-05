import java.util.Scanner;

public class CopperColorCode {

    public static void colorFinder() {
        Scanner scanner = new Scanner(System.in);
        boolean isQuit = false;

        do {
            System.out.println("Enter a pair number (integer) up to 3000: ");
            System.out.println("If searching more than one pair, separate each pair by a space.");
            String pairString = scanner.nextLine();
            String[] pairArr = pairString.split(" ");

            for (String pair : pairArr) {
                if (Calc.isNumeric(pair)) {
                    if (Integer.parseInt(pair) > 0 && Integer.parseInt(pair) < 3001) {
                        int pairNumber = Integer.parseInt(pair);
                        System.out.println("----------------------------------------------------------------------------------");
                        System.out.printf("%nFor pair %s, the super binder is: %s %n",pairNumber, superBinderColor(pairNumber));
                        System.out.printf("the binder color is: %s%n", binderColor(pairNumber));
                        System.out.printf("and the pair color is: %s%n", pairColor(pairNumber));
                        System.out.printf("----------------------------------------------------------------------------------%n");
                    }
                } else if (pair.equalsIgnoreCase("q")) {
                    isQuit = true;
                } else {
                    System.out.println("Invalid entry. Try again.");
                }
            }
        } while (!isQuit);
    }


    public static String superBinderColor(int pairNumber){
        int count600 = ((pairNumber-1)/600*5)+1;
        return tipColor(count600);
    }

    public static String binderColor(int pairNumber) {
        int binderNumber = pairNumber;
        int pairDivide = pairNumber;
        if (pairNumber > 600) {
            pairDivide = pairNumber /600;
            pairNumber = pairNumber - (pairDivide*600);
        }
        binderNumber = ((pairNumber -1) / 25)+1;
        return  pairColor(binderNumber);
    }


    public static String pairColor(int pairNumber) {
        int pairDivide = pairNumber%25;
        if (pairDivide == 0) {
                pairDivide = 25;
        }
        String pairColor = tipColor(pairDivide) + "/"+ ringColor(pairDivide);
        return pairColor;

    }

    public static String ringColor(int pairNumber) {
        String pairColor = "";
        int pairRemain = pairNumber % 5;
        if (pairRemain == 0) {
            pairColor = "slate";
        } else if (pairRemain == 1 ) {
            pairColor = "blue";
        } else if (pairRemain == 2 ) {
            pairColor = "orange";
        } else if (pairRemain == 3 ) {
            pairColor = "green";
        } else if (pairRemain == 4 ) {
            pairColor = "brown";
        }
        return pairColor;
    }

    public static String tipColor(int pairNumber) {
        int pairDivide5 = ((pairNumber -1) / 5);
        String pairColor = "";
        if (pairDivide5 == 0) {
            pairColor = "white";
        } else if (pairDivide5 == 1 ) {
            pairColor = "red";
        } else if (pairDivide5 == 2 ) {
            pairColor = "black";
        } else if (pairDivide5 == 3 ) {
            pairColor = "yellow";
        } else if (pairDivide5 == 4 ) {
            pairColor = "violet";
        }
        return pairColor;
    }




}

import java.util.Scanner;

public class ColorCodeFinder {

    public static void main(String[] args) {
        boolean isQuit = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the color code finder!");

        do {
            System.out.printf("%n%nEnter 'c' to continue. %nEnter 'i' for more information, %nEnter 'q' to quit.%n%n");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("q")) {
                isQuit = true;
            } else if (userInput.equalsIgnoreCase("c")){
                colorFinder();
            } else if( userInput.equalsIgnoreCase("i")) {
                Information.informationMenu();
            }
        } while (!isQuit);

    }

    public static void colorFinder() {
        Scanner scanner = new Scanner(System.in);
        boolean isQuit = false;
        // what is the 25 pair color code?
        // it's for POTS (Plain Old Telephone Service)
        // https://en.wikipedia.org/wiki/25-pair_color_code


        do {
            System.out.println("Enter a pair number (integer) up to 3000: ");
            String pairString = scanner.nextLine();
            String[] pairArr = pairString.split(" ");


            if (pairString.equalsIgnoreCase("q")) {
                isQuit = true;
            } else if (Integer.parseInt(pairString) > 0 && Integer.parseInt(pairString) < 3001) {
                int pairNumber = Integer.parseInt(pairString);
                System.out.println("----------------------------------------------------------------------------------");
                System.out.printf("%nFor pair %s, the super binder is: %s %n",pairNumber, superBinderColor(pairNumber));
                System.out.printf("the binder color is: %s%n", binderColor(pairNumber));
                System.out.printf("and the pair color is: %s%n", pairColor(pairNumber));
                System.out.println("----------------------------------------------------------------------------------");
            } else {
                System.out.println("Invalid entry, try again.");
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
//            pairDivide = (pairNumber-1) / 25;
//            pairNumber = pairNumber - (pairDivide*25);
        }
        String pairColor = tipColor(pairDivide) + "/"+ ringColor(pairDivide);
        return pairColor;

    }

    public static String ringColor(int pairNumber) {
        String pairColor = "";
        int pairRemain = pairNumber % 5;
        if (pairRemain == 0) {
            pairColor = pairColor.concat("slate");
        } else if (pairRemain == 1 ) {
            pairColor = pairColor.concat("blue");
        } else if (pairRemain == 2 ) {
            pairColor = pairColor.concat("orange");
        } else if (pairRemain == 3 ) {
            pairColor = pairColor.concat("green");
        } else if (pairRemain == 4 ) {
            pairColor = pairColor.concat("brown");
        }
        return pairColor;
    }

    public static String tipColor(int pairNumber) {
        int pairDivide5 = ((pairNumber -1) / 5);
        String pairColor = "";
        if (pairDivide5 == 0) {
            pairColor = pairColor.concat("white");
        } else if (pairDivide5 == 1 ) {
            pairColor = pairColor.concat("red");
        } else if (pairDivide5 == 2 ) {
            pairColor = pairColor.concat("black");
        } else if (pairDivide5 == 3 ) {
            pairColor = pairColor.concat("yellow");
        } else if (pairDivide5 == 4 ) {
            pairColor = pairColor.concat("violet");
        }
        return pairColor;
    }

}

import java.util.Scanner;

public class ColorCodeFinder {
    public static void main(String[] args) {
    colorFinder();


    }

    public static void colorFinder() {
        Scanner scanner = new Scanner(System.in);
        // what is the 25 pair color code?
        // it's for POTS (Plain Old Telephone Service)
        // https://en.wikipedia.org/wiki/25-pair_color_code
        System.out.println("Welcome to the color code finder!");
        System.out.printf("%nWhat is the 25 pair color code?%n");
        System.out.println("For more information, press 'y'. Otherwise press any key to continue.");
        String moreInfo = scanner.nextLine();
        if (moreInfo.equals("y")) {
            explanationText();
        }


        System.out.println("Enter a pair number (integer): ");

        String pairString = scanner.nextLine();
        String[] pairArr = pairString.split(" ");

//        for (int i = 0; i < 601; i++) {
//            int pairNumber = i;
//            System.out.println("---------------------------------------------------------------");
//            System.out.printf("%nFor pair %s binder is: %s and the pair color is: %s%n%n",pairNumber,binderColor(pairNumber),pairColor(pairNumber));
//            System.out.println("---------------------------------------------------------------");
//        }



        for (String num : pairArr) {
          int pairNumber = Integer.parseInt(num);
            System.out.println("----------------------------------------------------------------------------------");
            System.out.printf("%nFor pair %s, the super binder is: %s %n",pairNumber, superBinderColor(pairNumber));
            System.out.printf("the binder color is: %s%n", binderColor(pairNumber));
            System.out.printf("and the pair color is: %s%n", pairColor(pairNumber));
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

    public static void explanationText() {
        System.out.println("It is a color code for telecommunications wiring.");
        System.out.println("This color code is most commonly used for identifying ");
        System.out.println("copper cable pairs for POTS (Plain Old Telephone Service)");
        System.out.printf("as well as DSL and VDSL services.%n%n");

        System.out.println("Each pair of wires is given a numeric value which corresponds");
        System.out.println("to a color combination. If you've ever seen a whole rats nest of");
        System.out.println("multicolored telecommunications wiring, this color code is what ");
        System.out.println("allows people to tell each wire apart.");
        System.out.println();
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
        int pairDivide = pairNumber;
        if (pairNumber > 25) {
            pairDivide = (pairNumber-1) / 25;
            pairNumber = pairNumber - (pairDivide*25);
        }
        String pairColor = tipColor(pairNumber) + "/"+ ringColor(pairNumber);
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

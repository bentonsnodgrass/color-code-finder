import java.util.Scanner;

public class Information {


    public static void explanationText() {
        System.out.println("It is a color code for telecommunications wiring.");
        System.out.println("This color code is most commonly used for identifying ");
        System.out.println("copper cable pairs for POTS (Plain Old Telephone Service)");
        System.out.printf("as well as DSL and VDSL services.%n%n");

        System.out.println("Each pair of wires is given a numeric value which corresponds");
        System.out.println("to a color combination. If you've ever seen a whole rats nest of");
        System.out.println("multicolored telecommunications wiring, this color code is what ");
        System.out.println("allows people to tell each wire apart.");

        System.out.printf("%nFor more information, check out the wikipedia page!");
        System.out.println(" https://en.wikipedia.org/wiki/25-pair_color_code ");
    }

    public static void informationMenu() {
        boolean isQuit = false;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.printf("%nWhat is the 25 pair color code?%n");
            explanationText();

            System.out.println("Press 'q' to return to main menu.");
            String moreInfo = scanner.nextLine();

            if (moreInfo.equalsIgnoreCase("q")){
                isQuit = true;
            } else if (!moreInfo.equalsIgnoreCase("q")) {
                System.out.println("Invalid entry. Try again.");
            }
        }while (!isQuit);
//        new ColorCodeFinder();

    }


}

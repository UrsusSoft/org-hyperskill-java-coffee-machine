package machine;
import java.util.Scanner;

public class CoffeeMachineStage4 {
    private static final Scanner scanner = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;

    public static void main(String[] args) {

        showCurrentState();

        System.out.println("Write action (buy, fill, take):");

        String action = scanner.nextLine();

        switch (action) {
            case "buy" :
                toBuy();
                showCurrentState();
                break;
            case "fill" :
                toFill();
                showCurrentState();
                break;
            case "take" :
                toTake();
                showCurrentState();
                break;
        }
    }

    static void showCurrentState () {
        System.out.println("The coffee machine has:");
        System.out.printf("%s ml of water\n", water);
        System.out.printf("%s ml of milk\n", milk);
        System.out.printf("%s g of coffee beans\n", beans);
        System.out.printf("%s disposable cups\n", cups);
        System.out.printf("$%s of money\n", money);
        System.out.println();
    }

    static void toBuy () {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int select = scanner.nextInt();

        switch (select) {
            case 1 :
                makeEspresso();
                break;
            case 2 :
                makeLatte();
                break;
            case 3:
                makeCappuccino();
                break;
        }

        System.out.println();
    }

    static void toFill () {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
        System.out.println();
    }

    static void toTake () {
        System.out.printf("I gave you $%s\n", money);
        money -= money;
        System.out.println();
    }

    static void makeEspresso() {
        water -= 250;
        beans -= 16;
        --cups;
        money += 4;
    }

    static void makeLatte () {
        water -= 350;
        milk -= 75;
        beans -= 20;
        --cups;
        money += 7;
    }

    static void makeCappuccino () {
        water -= 200;
        milk -= 100;
        beans -= 12;
        --cups;
        money += 6;
    }
}

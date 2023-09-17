package machine;
import java.util.Scanner;

public class CoffeeMachineStage5 {
    private static final Scanner scanner = new Scanner(System.in);
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;

    public static void main(String[] args) {

        String action;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");

            action = scanner.next();

            switch (action) {
                case "buy":
                    toBuy2();
                    break;
                case "fill":
                    toFill();
                    break;
                case "take":
                    toTake();
                    break;
                case "remaining":
                    showCurrentState();
                    break;
            }
        } while (!action.equals("exit"));
    }

    static void showCurrentState () {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.printf("%s ml of water\n", water);
        System.out.printf("%s ml of milk\n", milk);
        System.out.printf("%s g of coffee beans\n", beans);
        System.out.printf("%s disposable cups\n", cups);
        System.out.printf("$%s of money\n", money);
        System.out.println();
    }

    static void toBuy () {
        System.out.println();

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

    static void toBuy2 () {
        System.out.println();

        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String select = scanner.next();

        if (!select.equals("back")) {
            isItEnough(select);
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

    static void isItEnough (String typeOfCoffee) {
        switch (typeOfCoffee) {
            case "1" :
                if (water >= 250 && beans >= 16 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    makeEspresso ();
                } else {
                    if (water < 250) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (beans < 16) {
                        System.out.println("Sorry, not enough beans!");
                    }
                    if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;
            case "2" :
                if (water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    makeLatte ();
                } else {
                    if (water < 350) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (milk < 75) {
                        System.out.println("Sorry, not enough milk!");
                    }
                    if (beans < 20) {
                        System.out.println("Sorry, not enough beans!");
                    }
                    if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;
            case "3" :
                if (water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    makeCappuccino ();
                } else {
                    if (water < 200) {
                        System.out.println("Sorry, not enough water!");
                    }
                    if (milk < 100) {
                        System.out.println("Sorry, not enough milk!");
                    }
                    if (beans < 12) {
                        System.out.println("Sorry, not enough beans!");
                    }
                    if (cups < 1) {
                        System.out.println("Sorry, not enough cups!");
                    }
                }
                break;

        }
    }
}

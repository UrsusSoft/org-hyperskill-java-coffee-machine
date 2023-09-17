package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private CoffeeMachineState state;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
        this.state = CoffeeMachineState.IDLE;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":
                    state = CoffeeMachineState.BUYING;
                    break;
                case "fill":
                    state = CoffeeMachineState.FILLING;
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    showCurrentState();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid action. Try again.");
                    continue;
            }

            handleState(scanner);
        }
    }

    private void showCurrentState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", beans);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n\n", money);
    }

    private void takeMoney() {
        System.out.printf("\nI gave you $%d\n", money);
        money = 0;
    }

    private void handleState(Scanner scanner) {
        switch (state) {
            case BUYING:
                buyCoffee(scanner);
                state = CoffeeMachineState.IDLE;
                break;
            case FILLING:
                fillMachine(scanner);
                state = CoffeeMachineState.IDLE;
                break;
            default:
                break;
        }
    }

    private void buyCoffee(Scanner scanner) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String choice = scanner.next();

        switch (choice) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                break;
            default:
                System.out.println("Invalid choice. Try again.");
                break;
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && beans >= beansNeeded && cups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
            cups--;
            money += cost;
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    private void fillMachine(Scanner scanner) {
        System.out.println("\nWrite how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cups += scanner.nextInt();
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.run();
    }
}

enum CoffeeMachineState {
    IDLE,
    BUYING,
    FILLING
}
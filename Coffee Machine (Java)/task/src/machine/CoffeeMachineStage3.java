package machine;

import java.util.Scanner;

public class CoffeeMachineStage3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int beans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsRequest = scanner.nextInt();

        int cupsInWater = water/200;
        int cupsInMilk = milk/50;
        int cupsInBeans = beans/15;

        int availableCups = cupsInWater;

        if (availableCups > cupsInMilk) {
            availableCups = cupsInMilk;
        }

        if (availableCups > cupsInBeans) {
            availableCups = cupsInBeans;
        }

        if (cupsRequest == availableCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsRequest > availableCups) {
            System.out.printf("No, I can make only %s cup(s) of coffee\n", availableCups);
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %s more than that)\n", availableCups - cupsRequest);
        }
    }
}

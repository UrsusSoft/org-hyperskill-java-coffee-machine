import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCups = scanner.nextInt();
        boolean isItWeekends = scanner.nextBoolean();

        boolean result = ((numberOfCups >= 10 && numberOfCups <= 20) && (isItWeekends == false)) ||
            ((numberOfCups >= 15 && numberOfCups <= 25) && (isItWeekends == true));

        System.out.println(result);
    }
}

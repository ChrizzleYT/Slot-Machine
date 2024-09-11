import java.util.Scanner;
import java.util.Random;

public class SlotMachine {
    
    public static void main(String[] args) {

        // declare variables
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] symbols = {"Cherry", "Lemon", "Orange", "Seven", "Bell"};
        String firstSymbol = "";
        String secondSymbol = "";
        String thirdSymbol = "";
        String choice = "";
        int balance;
        int stake;
        int profit;

        // enter and print balance
        System.out.println("Enter your balance:");
        balance = scanner.nextInt();
        System.out.println("Your starting balance is " + balance + ".");

        // while loop which ends when choice equals "no"
        while (!choice.equalsIgnoreCase("no")) {

            // check if balance is less or equal than zero
            if (balance <= 0) {
                break;
            }

            // ask user if he wants to play
            System.out.println("Play?");
            choice = scanner.nextLine();


            // game
            if (choice.equalsIgnoreCase("yes")) {
                System.out.println("Enter your stake (maximum " + balance + " Jetons):");
                stake = scanner.nextInt();

                // check if stake is more than balance
                if (stake > balance) {
                    System.out.println("Your stake is invalid. Try again!");
                    continue;
                }

                // assign random symbols to variables
                firstSymbol = symbols[random.nextInt(symbols.length)];
                secondSymbol = symbols[random.nextInt(symbols.length)];
                thirdSymbol = symbols[random.nextInt(symbols.length)];

                // print symbols
                System.out.println(firstSymbol + " | " + secondSymbol + " | " + thirdSymbol);

                // calculate profit
                if (firstSymbol.equals(secondSymbol) && secondSymbol.equals(thirdSymbol)) {
                    profit = stake * 20;
                    balance += profit;
                    System.out.println("Jackpot! Won " + profit + " Jetons.");
                } else if (firstSymbol.equals(secondSymbol) || secondSymbol.equals(thirdSymbol) || firstSymbol.equals(thirdSymbol)) {
                    profit = stake * 2;
                    balance += profit;
                    System.out.println("Jackpot! Won " + profit + " Jetons.");
                    System.out.println("Your balance is");
                } else {
                    balance -= stake;
                    System.out.println("You lost " + stake + " Jetons!");
                    System.out.println("Your balance is " + balance + ".");
                }
            }
        }

        // print goodbye
        System.out.println("Goodbye, see you next time!");

        // close scanner
        scanner.close();
    }
}



import java.util.Scanner;

public class Project4 {
    static String[] nameUsers = new String[100];
    static int index = 0;
    static double[] balanceUsers = new double[100];

    public static void menu() {
        Scanner input = new Scanner(System.in);
        int startMenu;

        while (true) {
            System.out.print("===== BANK MANAGEMENT SYSTEM ======");
            System.out.print("\n1. Create Accounts");
            System.out.print("\n2. View All Accounts");
            System.out.print("\n3. Deposit");
            System.out.print("\n4. Withdraw");
            System.out.print("\n5. Transfer Money");
            System.out.print("\n6. Exit");

            System.out.print("\nChoose option: ");
            startMenu = input.nextInt();

            switch (startMenu) {
                case 1:
                    createAccount();
                    break;

                case 2: 
                    viewAccount();
                    break;
            
                default:
                    System.out.print("Invalid Option!");
            }
        }
    }

    public static void createAccount() {
        Scanner input = new Scanner(System.in);
        String name;
        int deposit;

        System.out.print("\n\nEnter account holder name: ");
        name = input.nextLine();

        System.out.print("Enter initial deposit: ");
        deposit = input.nextInt();

        nameUsers[index] = name;
        balanceUsers[index] += deposit;

        System.out.print("\nAccount successfully created!");
        System.out.print("\nAccount Number: " + (1001 + index));
        System.out.print("\nCurrent Balance: " + balanceUsers[index] + "\n\n");

        index++;
    }

    public static void viewAccount() {
        
        if (index > 0) {
            System.out.print("\n========== ACCOUNT LIST ==========");

            for (int i = 0; i < index; i++) {
                System.out.print("\nAccount No: " + (1001 + index));
                System.out.print("\nName: " + nameUsers[i]);
                System.out.print("\nBalance: " + balanceUsers[i]);
                System.out.print("\n---------------------------------");
            }

        } else {
            System.out.print("\nThere are none account to display...");
        }

        System.out.print("\n\n");
    }

    public static void main(String[] args) {
        menu();
    }
}

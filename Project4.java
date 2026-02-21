import java.util.Scanner;

public class Project4 {
    static String[] nameUsers = new String[100];
    static int index = 0;
    static double[] balanceUsers = new double[100];
    static Scanner input = new Scanner(System.in);  // SATU scanner sahaja

    public static void menu() {
        int startMenu;

        while (true) {
            System.out.print("\n===== BANK MANAGEMENT SYSTEM ======");
            System.out.print("\n1. Create Accounts");
            System.out.print("\n2. View All Accounts");
            System.out.print("\n3. Deposit");
            System.out.print("\n4. Withdraw");
            System.out.print("\n5. Transfer Money");
            System.out.print("\n6. Exit");

            System.out.print("\nChoose option: ");
            startMenu = input.nextInt();
            input.nextLine(); // BUANG newline selepas angka

            switch (startMenu) {
                case 1:
                    createAccount();
                    break;

                case 2: 
                    viewAccount();
                    break;
                    
                case 3:
                    deposit();
                    break;

                case 4:
                    withdraw();
                    break;
                    
                case 5:
                    transferMoney();
                    break;
                    
                case 6:
                    System.out.print("\nThank you for using Bank Management System!");
                    System.exit(0);
            
                default:
                    System.out.print("\nInvalid Option!");
            }
        }
    }

    public static void createAccount() {
        String name;
        double deposit;

        System.out.print("\n\nEnter account holder name: ");
        name = input.nextLine();  // baca nama

        System.out.print("Enter initial deposit: ");
        deposit = input.nextDouble();
        input.nextLine(); // BUANG newline

        nameUsers[index] = name;
        balanceUsers[index] = deposit;

        System.out.print("\nAccount successfully created!");
        System.out.print("\nAccount Number: " + (1001 + index));
        System.out.print("\nCurrent Balance: RM " + balanceUsers[index] + "\n\n");

        index++;
    }

    public static void viewAccount() {
        if (index > 0) {
            System.out.print("\n========== ACCOUNT LIST ==========");
            for (int i = 0; i < index; i++) {
                System.out.print("\nAccount No: " + (1001 + i));
                System.out.print("\nName: " + nameUsers[i]);
                System.out.print("\nBalance: RM " + balanceUsers[i]);
                System.out.print("\n---------------------------------");
            }
        } else {
            System.out.print("\nThere are no accounts to display...");
        }
        System.out.print("\n\n");
    }
    
    public static void deposit() {
        int accountNumber;
        double depositValue;

        System.out.print("\nEnter account number: ");
        accountNumber = input.nextInt();
        input.nextLine(); // BUANG newline

        int accountIndex = accountNumber - 1001;
        
        if (accountIndex >= 0 && accountIndex < index) {
            System.out.print("Enter amount to deposit: ");
            depositValue = input.nextDouble();
            input.nextLine(); // BUANG newline
            
            if (depositValue > 0) {
                balanceUsers[accountIndex] += depositValue;
                System.out.print("\n\nDeposit successful!");
                System.out.print("\nNew Balance: RM " + balanceUsers[accountIndex]);
            } else {
                System.out.print("\n\nInvalid amount! Deposit must be positive.");
            }
        } else {
            System.out.print("\nInvalid Account Number!");
        }
        System.out.print("\n\n");
    }

    public static void withdraw() {
        int accountNumber;
        double withdrawValue;

        System.out.print("\nEnter account number: ");
        accountNumber = input.nextInt();
        input.nextLine(); // BUANG newline

        int accountIndex = accountNumber - 1001;
        
        if (accountIndex >= 0 && accountIndex < index) {
            System.out.print("Enter amount to withdraw: ");
            withdrawValue = input.nextDouble();
            input.nextLine(); // BUANG newline
            
            if (withdrawValue <= 0) {
                System.out.print("\n\nInvalid amount! Withdrawal must be positive.");
            }
            else if (withdrawValue <= balanceUsers[accountIndex]) {
                balanceUsers[accountIndex] -= withdrawValue;
                System.out.print("\n\nWithdrawal successful!");
                System.out.print("\nNew Balance: RM " + balanceUsers[accountIndex]);
            } else {
                System.out.print("\n\nInsufficient balance!");
                System.out.print("\nCurrent Balance: RM " + balanceUsers[accountIndex]);
            }
        } else {
            System.out.print("\nInvalid Account Number!");
        }
        System.out.print("\n\n");
    }
    
    public static void transferMoney() {
        int fromAccount, toAccount;
        double transferAmount;

        System.out.print("\nEnter your account number: ");
        fromAccount = input.nextInt();
        input.nextLine();
        
        System.out.print("Enter destination account number: ");
        toAccount = input.nextInt();
        input.nextLine();

        int fromIndex = fromAccount - 1001;
        int toIndex = toAccount - 1001;
        
        if (fromIndex >= 0 && fromIndex < index && toIndex >= 0 && toIndex < index) {
            if (fromIndex == toIndex) {
                System.out.print("\n\nCannot transfer to the same account!");
            } else {
                System.out.print("Enter amount to transfer: ");
                transferAmount = input.nextDouble();
                input.nextLine();
                
                if (transferAmount <= 0) {
                    System.out.print("\n\nInvalid amount! Transfer must be positive.");
                }
                else if (transferAmount <= balanceUsers[fromIndex]) {
                    balanceUsers[fromIndex] -= transferAmount;
                    balanceUsers[toIndex] += transferAmount;
                    System.out.print("\n\nTransfer successful!");
                    System.out.print("\nYour new balance: RM " + balanceUsers[fromIndex]);
                } else {
                    System.out.print("\n\nInsufficient balance!");
                    System.out.print("\nYour current balance: RM " + balanceUsers[fromIndex]);
                }
            }
        } else {
            System.out.print("\nInvalid Account Number(s)!");
        }
        System.out.print("\n\n");
    }

    public static void main(String[] args) {
        menu();
    }
}
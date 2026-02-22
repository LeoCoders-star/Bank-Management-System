import java.util.Scanner;

public class ForBackup4 {
    static String[] nameUsers = new String[100];
    static int index = 0, positionSender, positionReceiver;
    static int[] accountNumber = new int[100];
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
            System.out.print("\n6. Search Account");
            System.out.print("\n7. Exit");

            System.out.print("\nChoose option: ");
            startMenu = input.nextInt();

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
                    searchAccount();
                    break;

                case 7:
                    System.out.print("\nThank You for using Bank Management System.");
                    System.out.print("\nProgram terminated.");
                    return; 
                default:
                    System.out.print("Invalid Option!");
            }
        }
    }

    public static int findAccount(int account) {
        for (int i = 0; i < index; i++) {
            if (accountNumber[i] == account) {
                return i;
            } 
        }

        return -1;
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
        accountNumber[index] = 1001 + index;

        System.out.print("\nAccount successfully created!");
        System.out.print("\nAccount Number: " + accountNumber[index]);
        System.out.print("\nCurrent Balance: " + balanceUsers[index] + "\n\n");

        index++;
    }

    public static void viewAccount() {
        
        if (index > 0) {
            System.out.print("\n========== ACCOUNT LIST ==========");

            for (int i = 0; i < index; i++) {
                System.out.print("\nAccount No: " + accountNumber[i]); 
                System.out.print("\nName: " + nameUsers[i]);
                System.out.print("\nBalance: " + balanceUsers[i]);
                System.out.print("\n---------------------------------");
            }

        } else {
            System.out.print("\nThere are none account to display...");
        }

        System.out.print("\n\n");
    }

    public static void deposit() {

        Scanner input = new Scanner(System.in);
        int accountNumber, position;
        double depositValue;

        System.out.print("\nEnter account number: ");
        accountNumber = input.nextInt();

        position = accountNumber - 1001;
        // position is a value of index at array.

        if (position >= 0 && position < index) {
            System.out.print("Enter amount to deposit: ");
            depositValue = input.nextDouble();

            balanceUsers[position] += depositValue;

            System.out.print("\n\nDeposit successful!");
            System.out.print("\nNew Balance: " + balanceUsers[position] + "\n\n");

        } else {
            System.out.print("\nInvalid Account!\n\n");
        }
    }

    public static void withdraw() {

        Scanner input = new Scanner(System.in);
        int accountNumber, position;
        double withdrawValue;

        System.out.print("\nEnter account number: ");
        accountNumber = input.nextInt();

        position = accountNumber - 1001;

        if (position >= 0 && position < index) {
            System.out.print("Enter amount to withdraw: ");
            withdrawValue = input.nextDouble();
            
            if (withdrawValue <= balanceUsers[position]) {

                balanceUsers[position] -= withdrawValue;

                System.out.print("\n\nWithdrawal successful!");
                System.out.print("\nNew Balance: " + balanceUsers[position] + "\n\n");

            } else {
                System.out.print("Error! Insufficient balance. ");
            }   

        } else {
            System.out.print("\nInvalid Account!\n\n");
        }

    }

    public static boolean checkTransfer(double tranferValue) {
        if (tranferValue <= balanceUsers[positionSender]) {
            return true;
        } else {
            return false;
        }
    }

    public static void transferMoney() {

        Scanner input = new Scanner(System.in);
        int accountNumberSender, accountNumberReceiver;
        double tranferValue;

        System.out.print("Enter sender account number: "); 
        accountNumberSender = input.nextInt();

        positionSender = accountNumberSender - 1001;

        int searchAccountSender = findAccount(accountNumberSender);
        // return = index || -1

        if (searchAccountSender != -1) {
            System.out.print("\nEnter receiver account number: ");
            accountNumberReceiver = input.nextInt();

            positionReceiver = accountNumberReceiver - 1001;

            int searchAccountReceiver = findAccount(accountNumberReceiver);

            if (searchAccountReceiver != -1) {
                System.out.print("Enter amount to transfer: ");
                tranferValue = input.nextDouble();

                boolean checkingTransferValue = checkTransfer(tranferValue);

                if (checkingTransferValue == true) {

                    balanceUsers[positionSender] -= tranferValue;
                    balanceUsers[positionReceiver] += tranferValue;

                    System.out.print("\n\nTransfer successful!");
                    System.out.print("\nSender New Balance: " + balanceUsers[positionSender]);
                    System.out.print("\nReceiver New Balance: " + balanceUsers[positionReceiver] + "\n\n");
                    
                } else {
                    System.out.print("\nError! Insufficient Balance.\n\n");
                }

            } else {
                System.out.print("\nInvalid Account!\n\n");
            }
        } else {
            System.out.print("\nInvalid Account!\n\n");
        }

    }

    public static void searchAccount() {

        Scanner input = new Scanner(System.in);
        int accountNumber, position;

        System.out.print("\nEnter account number: ");
        accountNumber = input.nextInt();

        position = accountNumber - 1001;

        int searchAccount = findAccount(accountNumber);

        if (searchAccount != -1) {
            System.out.print("\n\nAccount Found!");
            System.out.print("\nName: " + nameUsers[position]);
            System.out.print("\nBalance: " + balanceUsers[position] + "\n\n");
        } else {
            System.out.print("\n\nAccount not found! \n");
        }

    }

    public static void main(String[] args) {
        menu();
    }
}
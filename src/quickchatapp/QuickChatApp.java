//Ryan Jeffries
//Programming POE Assignment
package quickchatapp;

import java.util.Scanner;

public class QuickChatApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("*=== Welcome to QuickChat ===*");

        String firstName;
        String lastName;
        String username;
        String password;
        String cell;

        // ---------------- FIRST NAME ----------------
        System.out.print("\nEnter first name: ");
        firstName = input.nextLine();

        // ---------------- LAST NAME ----------------
        System.out.print("Enter last name: ");
        lastName = input.nextLine();

        // ---------------- USERNAME ----------------
        while (true) {
            System.out.println("\nCreate a username:");
            System.out.println("• Must contain '_' "); //Copy and pasted bullet points
            System.out.println("• Must be no more than 5 characters");

            System.out.print("Enter username: ");
            username = input.nextLine();

            if (login.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted. Try again.");
            }
        }

        // ---------------- PASSWORD ----------------
        while (true) {
            System.out.println("\nCreate a password:");
            System.out.println("• At least 8 characters");
            System.out.println("• Must contain a capital letter");
            System.out.println("• Must contain a number");
            System.out.println("• Must contain a special character");

            System.out.print("Enter password: ");
            password = input.nextLine();

            if (login.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted. Try again.");
            }
        }

        // ----------------- CELL NUMBER -----------------
        while (true) {
            System.out.println("\nEnter SA cell number:");
            System.out.println("• Do NOT include 0");
            System.out.println("• Example: 826118188");

            System.out.print("Enter cell number: ");
            String inputCell = input.nextLine();

            // Auto add +27
            cell = "+27" + inputCell;

            if (login.checkCellPhoneNumber(cell)) {
                System.out.println("Cell phone number successfully added.");
                break;
            } else {
                System.out.println("Invalid number. Try again.");
            }
        }

        // ---------------- REGISTER USER ----------------
        System.out.println("\nRegistering user...");
        String registerMessage = login.registerUser(firstName, lastName, username, password, cell);
        System.out.println(registerMessage);

        System.out.println("\nYou are now registered. Please login.");

        // ---------------- LOGIN ----------------
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("\n--- Login ---");

            System.out.print("Enter username: ");
            String loginUser = input.nextLine();

            System.out.print("Enter password: ");
            String loginPass = input.nextLine();

            loggedIn = login.loginUser(loginUser, loginPass);

            System.out.println(login.returnLoginStatus(loggedIn));
        }

        System.out.println("\nWelcome to QuickChat.");
        MessageManager manager = new MessageManager();

        int choice = 0;
        while (choice != 3) //Menu keeps runnign till user selects option 3
        {
            //Display the menu
            System.out.println("\n--- QuickChat Menu ---");
            System.out.println("1. Send Messages");
            System.out.println("2. Show recently sent messages");
            System.out.println("3. Quit");

            System.out.print("Choose option: ");
            choice = Integer.parseInt(input.nextLine());

            switch (choice) //Using a switch to control the menu options
            {
                case 1:

                    System.out.print("How many messages would you like to send? ");
                    int amount = Integer.parseInt(input.nextLine());
                    //Loop runs depending on amount entered
                    for (int i = 1; i <= amount; i++) {

                        System.out.println("\nMessage " + i);

                        String recipient;

                        while (true) {
                            System.out.print("Enter recipient number (+27...): ");
                            recipient = input.nextLine();

                            if (manager.checkRecipientCell(recipient)) {
                                break;
                            } else {
                                System.out.println("Invalid number.");
                            }
                        }

                        String text;

                        while (true) {
                            System.out.print("Enter message: ");
                            text = input.nextLine();

                            if (manager.checkMessageLength(text)) {
                                break;
                            } else {
                                System.out.println("Message exceeds 250 characters.");
                            }
                        }

                        String id = manager.generateMessageID();

                        Message msg = new Message(id, i, recipient, text);

                        manager.addMessage(msg);

                        System.out.println("Message sent.");
                        System.out.println("Message ID: " + id);
                    }

                    System.out.println("Total messages sent: " + manager.returnTotalMessages());

                    break;

                case 2:
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}

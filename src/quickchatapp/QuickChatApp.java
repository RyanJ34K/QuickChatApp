//Ryan Jeffries
//Programming POE Assignment
package quickchatapp;

import java.util.Scanner;
import java.util.ArrayList;

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

        // ---------------- QUICKCHAT MENU ----------------
        Scanner messageInput = new Scanner(System.in);
        // Store sent messages
        ArrayList<Message> sentMessages = new ArrayList<>();

        int option = 0;

        while (option != 3) {

            System.out.println("\nChoose an option:");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Enter option: ");
            option = messageInput.nextInt();
            messageInput.nextLine();

            switch (option) {

                case 1:

                    int messageCount = 1;
                    boolean sendMore = true;

                    while (sendMore) {

                        System.out.println("\nMessage " + messageCount);

                        // Enter recipient number
                        System.out.print("Enter recipient number: ");
                        String recipient = messageInput.nextLine();

                        // Enter message
                        System.out.print("Enter your message: ");
                        String messageText = messageInput.nextLine();

                        // Create message object
                        Message message = new Message(
                                messageCount,
                                recipient,
                                messageText
                        );

                        // Check recipient number
                        if (!message.checkRecipientCell()) {

                            System.out.println(
                                    "Cell phone number incorrectly formatted."
                            );

                        } // Check message length
                        else if (!message.checkMessageLength()) {

                            int extraCharacters
                                    = messageText.length() - 250;

                            System.out.println(
                                    "Message exceeds 250 characters by "
                                    + extraCharacters
                                    + ", please reduce size."
                            );

                        } else {

                            System.out.println("\nMessage successfully created.");

                            // Display message details
                            message.printMessage();

                            // Add message to ArrayList
                            sentMessages.add(message);
                        }

                        // Ask user what to do next
                        System.out.println("\n1) Send another message");
                        System.out.println("2) Return to menu");

                        System.out.print("Choose option: ");
                        int nextChoice = messageInput.nextInt();
                        messageInput.nextLine();

                        if (nextChoice == 1) {

                            messageCount++;

                        } else {

                            sendMore = false;

                        }
                    }

                    break;

                case 2:

                    if (sentMessages.isEmpty()) {

                        System.out.println("\nNo messages sent yet.");

                    } else {

                        System.out.println("\nRECENTLY SENT MESSAGES:");

                        for (Message sentMessage : sentMessages) {

                            System.out.println("---------------------");

                            System.out.println(
                                    sentMessage.getMessageDetails()
                            );
                        }
                    }

                    break;

                case 3:

                    System.out.println("Goodbye!");

                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }
    }
}

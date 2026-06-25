//Ryan Jeffries
//Message storage class
package quickchatapp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MessageStorage {

    private ArrayList<Message> sentMessages;
    private ArrayList<Message> storedMessages;
    private ArrayList<Message> disregardedMessages;

    private ArrayList<String> messageHashes;
    private ArrayList<String> messageIDs;
    // Constructor

    public MessageStorage() {

        sentMessages = new ArrayList<>();

        storedMessages = new ArrayList<>();

        disregardedMessages = new ArrayList<>();

        messageHashes = new ArrayList<>();

        messageIDs = new ArrayList<>();

    }
    // Add a sent message

    public void addSentMessage(Message message) {

        sentMessages.add(message);
        messageHashes.add(message.messageHash);
        messageIDs.add(message.messageID);

    }

    // Add a stored message
    public void addStoredMessage(Message message) {

        storedMessages.add(message);
        messageHashes.add(message.messageHash);
        messageIDs.add(message.messageID);

    }

// Add a disregarded message
    public void addDisregardedMessage(Message message) {

        disregardedMessages.add(message);
        messageHashes.add(message.messageHash);
        messageIDs.add(message.messageID);

    }

    // Return all sent messages
    public ArrayList<Message> getSentMessages() {

        return sentMessages;

    }

// Return all stored messages
    public ArrayList<Message> getStoredMessages() {

        return storedMessages;

    }

// Return all disregarded messages
    public ArrayList<Message> getDisregardedMessages() {

        return disregardedMessages;

    }

// Return all message hashes
    public ArrayList<String> getMessageHashes() {

        return messageHashes;

    }

// Return all message IDs
    public ArrayList<String> getMessageIDs() {

        return messageIDs;

    }
// Display sender and recipient of stored messages

    public void displayStoredMessages() {

        if (storedMessages.isEmpty()) {

            System.out.println("\nNo stored messages found.");

        } else {

            System.out.println("\nStored Messages:");

            for (Message message : storedMessages) {

                System.out.println("-------------------------");
                System.out.println("Sender: You");
                System.out.println("Recipient: " + message.recipient);

            }

        }

    }
    // Display the longest stored message

    public void displayLongestStoredMessage() {

        if (storedMessages.isEmpty()) {

            System.out.println("\nNo stored messages found.");

            return;

        }

        Message longestMessage = storedMessages.get(0);

        for (Message message : storedMessages) {

            if (message.message.length() > longestMessage.message.length()) {

                longestMessage = message;

            }

        }

        System.out.println("\nLongest Stored Message:");
        System.out.println("-------------------------");
        System.out.println(longestMessage.message);

    }

    // Search for a message using its ID
    public void searchMessageID(String messageID) {

        boolean found = false;

        for (Message message : storedMessages) {

            if (message.messageID.equals(messageID)) {

                System.out.println("\nMessage Found");
                System.out.println("-------------------------");
                System.out.println("Recipient: " + message.recipient);
                System.out.println("Message: " + message.message);

                found = true;
                break;
            }
        }

        if (!found) {

            System.out.println("Message ID not found.");

        }

    }

    // Search for messages using recipient number
    public void searchRecipient(String recipient) {

        boolean found = false;

        for (Message message : storedMessages) {

            if (message.recipient.equals(recipient)) {

                System.out.println("-------------------------");
                System.out.println("Message ID: " + message.messageID);
                System.out.println("Message: " + message.message);

                found = true;
            }
        }

        if (!found) {

            System.out.println("No messages found.");

        }

    }

// Delete message using hash
    public void deleteMessage(String hash) {

        for (int i = 0; i < storedMessages.size(); i++) {

            if (storedMessages.get(i).messageHash.equals(hash)) {

                storedMessages.remove(i);
                messageHashes.remove(i);
                messageIDs.remove(i);

                System.out.println("Message successfully deleted.");

                return;

            }

        }

        System.out.println("Message hash not found.");

    }

// Display all stored messages
    public void displayReport() {

        if (storedMessages.isEmpty()) {

            System.out.println("No stored messages.");

            return;

        }

        System.out.println("\nMESSAGE REPORT");

        for (Message message : storedMessages) {

            System.out.println(message.getMessageDetails());

        }

    }

    // Save message to JSON file
    public static void saveMessage(Message message) {

        try {

            FileWriter writer = new FileWriter(
                    "messages.json",
                    true
            );

            writer.write(
                    "{\n"
                    + "\"MessageID\":\"" + message.messageID + "\",\n"
                    + "\"Recipient\":\"" + message.recipient + "\",\n"
                    + "\"Message\":\"" + message.message + "\",\n"
                    + "\"MessageHash\":\"" + message.messageHash + "\"\n"
                    + "}\n\n"
            );

            writer.close();

            System.out.println("Message saved to JSON file.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving message."
            );
        }
    }
}

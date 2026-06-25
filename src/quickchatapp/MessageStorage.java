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

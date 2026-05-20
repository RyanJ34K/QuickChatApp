//Ryan Jeffries
//Message class for Part 2
package quickchatapp;

import java.util.Random;

public class Message {

    // Variables
    String messageID;
    int messageNumber;
    String recipient;
    String message;
    String messageHash;

    // Constructor
    public Message(int messageNumber, String recipient, String message) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.message = message;

        // Generate values
        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();
    }

    // Generate random 10 digit message ID
    public String generateMessageID() {

        Random random = new Random();

        long number = 1000000000L + (long) (random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    // Check message ID length
    public boolean checkMessageID() {

        return messageID.length() <= 10;
    }

    // Check recipient cell number
    public boolean checkRecipientCell() {

        return recipient.matches("^\\+27\\d{9}$");
    }

    // Check message length
    public boolean checkMessageLength() {

        return message.length() <= 250;
    }

    // Create message hash
    public String createMessageHash() {

        String[] words = message.split(" ");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return messageID.substring(0, 2)
                + ":"
                + messageNumber
                + ":"
                + firstWord.toUpperCase()
                + lastWord.toUpperCase();
    }

    // Display message details
    public void printMessage() {

        System.out.println("Message ID: " + messageID);
        System.out.println("Message Hash: " + messageHash);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + message);
    }
}

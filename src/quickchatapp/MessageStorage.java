//Ryan Jeffries
//Message storage class
package quickchatapp;

import java.io.FileWriter;
import java.io.IOException;

public class MessageStorage {

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

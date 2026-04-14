//Ryan Jeffries
//Created Message Class Part 2
package quickchatapp;

public class Message 
{

    String messageID;
    int messageNumber;
    String recipient;
    String messageText;

    public Message(String messageID, int messageNumber, String recipient, String messageText) //Constructor
    {
        this.messageID = messageID;
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;
    }
}

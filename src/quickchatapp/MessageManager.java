//Ryan jeffries
//Message Manager using ArrayList. Similar code to Grade12 PAT
package quickchatapp;

import java.util.ArrayList;
import java.util.Random;

public class MessageManager {

    ArrayList<Message> sentMessages = new ArrayList<>();

    public String generateMessageID() 
    {

        Random random = new Random();
        long number = 1000000000L + (long)(random.nextDouble() * 9000000000L);

        return String.valueOf(number);
    }

    public boolean checkRecipientCell(String cell) 
    {
        return cell.matches("^\\+27\\d{9}$");
    }

    public boolean checkMessageLength(String message)
    {
        return message.length() <= 250;
    }

    public void addMessage(Message msg)
    {
        sentMessages.add(msg);
    }

    public int returnTotalMessages() 
    {
        return sentMessages.size();
    }
}
//Ryan Jeffries

package quickchatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class MessageTest {

    // Test valid message length
    @Test
    public void testMessageLengthSuccess() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hello Mike"
        );

        assertTrue(message.checkMessageLength());
    }

    // Test invalid message length
    @Test
    public void testMessageLengthFailure() {

        String longMessage
                = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        Message message = new Message(
                1,
                "+27718693002",
                longMessage
        );

        assertFalse(message.checkMessageLength());
    }

    // Test valid recipient number
    @Test
    public void testRecipientNumberSuccess() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        assertTrue(message.checkRecipientCell());
    }

    // Test invalid recipient number
    @Test
    public void testRecipientNumberFailure() {

        Message message = new Message(
                1,
                "0812345678",
                "Hello"
        );

        assertFalse(message.checkRecipientCell());
    }

    // Test message ID generation
    @Test
    public void testMessageIDLength() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        assertTrue(message.checkMessageID());
    }

    // Test message hash creation
    @Test
    public void testMessageHash() {

        Message message = new Message(
                1,
                "+27718693002",
                "Hi Mike"
        );

        String hash = message.createMessageHash();

        assertTrue(hash.contains("HIMIKE"));
    }
}

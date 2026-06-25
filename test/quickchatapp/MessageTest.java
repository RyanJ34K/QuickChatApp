//Ryan Jeffries
package quickchatapp;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

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
    // Test sent messages ArrayList

    @Test
    public void testSentMessagesArray() {

        MessageStorage storage = new MessageStorage();

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        storage.addSentMessage(message);

        assertEquals(1, storage.getSentMessages().size());
    }

// Test stored messages ArrayList
    @Test
    public void testStoredMessagesArray() {

        MessageStorage storage = new MessageStorage();

        Message message = new Message(
                1,
                "+27718693002",
                "Stored Message"
        );

        storage.addStoredMessage(message);

        assertEquals(1, storage.getStoredMessages().size());
    }

// Test disregarded messages ArrayList
    @Test
    public void testDisregardedMessagesArray() {

        MessageStorage storage = new MessageStorage();

        Message message = new Message(
                1,
                "+27718693002",
                "Discarded Message"
        );

        storage.addDisregardedMessage(message);

        assertEquals(1, storage.getDisregardedMessages().size());
    }

// Test message hashes ArrayList
    @Test
    public void testMessageHashArray() {

        MessageStorage storage = new MessageStorage();

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        storage.addStoredMessage(message);

        assertEquals(1, storage.getMessageHashes().size());
    }

// Test message IDs ArrayList
    @Test
    public void testMessageIDArray() {

        MessageStorage storage = new MessageStorage();

        Message message = new Message(
                1,
                "+27718693002",
                "Hello"
        );

        storage.addStoredMessage(message);

        assertEquals(1, storage.getMessageIDs().size());
    }
}

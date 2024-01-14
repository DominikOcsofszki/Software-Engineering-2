package de.hbrs.se2.womm.chat;

import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ChatList {

    private MessageListItem messageWithCurrentTimeStamp(String userName, String text) {
        MessageListItem newMessage = new MessageListItem(
                text,
                Instant.now(),
                userName);
        newMessage.setUserColorIndex(1);
        return newMessage;
    }


    public List<MessageListItem> getListOfMessages() {
        return listOfMessages;
    }

    List<MessageListItem> listOfMessages = new LinkedList<>();

    private void addMessageToList(MessageListItem messageListItem) {
        listOfMessages.add(messageListItem);
    }

    public void sendMessage(String userName, String text) {
        addMessageToList(messageWithCurrentTimeStamp(userName, text));
    }

    public static void main(String[] args) {
        ChatList chatList = new ChatList();
        chatList.sendMessage("Hans", "Hallo");
        chatList.sendMessage("Hans", "Wie gehts?");
        chatList.sendMessage("Hans", "Gut");
        chatList.sendMessage("Hans", "Und dir?");
        chatList.sendMessage("Dom", "Auch gut");
        chatList.sendMessage("Dom", "Danke der Nachfrage");
        chatList.sendMessage("Hans", "Schön");
        System.out.println(chatList.listOfMessages);
    }
}

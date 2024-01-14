package de.hbrs.se2.womm.chat;

import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.ChatDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.chat.ChatService;
import de.hbrs.se2.womm.services.AboStudentUnternehmenService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.views.extra.ASSETS;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.ROUTING;
import de.hbrs.se2.womm.views.layouts.StudentLayout;
import jakarta.annotation.security.RolesAllowed;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Route(value = ROUTING.STUDENT.SChatView, layout = StudentLayout.class)
@RolesAllowed({"ADMIN", "STUDENT"})
@PageTitle("ChatView")
public class SChatView extends AViewWomm {
    ChatService chatService;
    StudentDTO studentDTO;
    AboStudentUnternehmenService aboStudentUnternehmenService;
    String nameLastName;
    ChatList chatList = new ChatList();

    SChatView(StudentService studentService, SecurityService securityService,
              ChatService chatService, AboStudentUnternehmenService aboStudentUnternehmenService) {
        this.aboStudentUnternehmenService = aboStudentUnternehmenService;
        this.chatService = chatService;
        this.studentDTO = studentService.getByNutzerId(securityService.getLoggedInNutzerID());
        this.nameLastName = studentDTO.getStudentVorname() + " " + studentDTO.getStudentName();
        addSomeItems();
    }

    void addSomeItems() {
        sendMessageFromStudent("Hallo");

        List<MessageListItem> listOfMessages = chatList.getListOfMessages();
        startChhat(listOfMessages);
    }

    private void sendMessageFromStudent(String text) {
        int chatId = 1; // TODO:
        ChatDTO ongoingChatDTO = chatService.getById(chatId) == null ?
                ChatDTO.builder()
                        .chatId(chatId)
                        .chatVerlauf(new String[]{})
                        .student(studentDTO)
                        .build() :
                chatService.getById(chatId);
        String[] newStringArr = new String[ongoingChatDTO.getChatVerlauf().length + 1];
        String [] stringArr = ongoingChatDTO.getChatVerlauf();
        System.arraycopy(stringArr, 0, newStringArr, 0, stringArr.length);

        newStringArr[stringArr.length] = text;

//        ongoingChatDTO.setChatVerlauf(new String[]{"Hallo", "Wie gehts?"});
        ongoingChatDTO.setChatVerlauf(newStringArr);
//        chatService.saveChatDTO(ChatDTO.builder()
//                .chatVerlauf(new String[]{"Hallo", "Wie gehts?"})
//                .student(studentDTO)
//                .build());
        chatService.saveChatDTO(ongoingChatDTO);
        chatList.sendMessage(nameLastName, text);
        System.out.println("ChatDTO: " + ongoingChatDTO);
    }

//    private void setUpChat() {
//        List<ChatDTO> listChats = chatService.getChatByStudentId(studentDTO.getStudentId());
//        System.out.println("Chat: " + listChats);
//        ChatDTO chatDTO = ChatDTO.builder()
//                        .chatId(1)
//                        .chatVerlauf(new String[]{"Hallo", "Wie gehts?"})
//                        .student(studentDTO)
//                        .build();
//        System.out.println("ChatDTO: " + chatDTO);
//        chatService.saveChatDTO(chatDTO);
//    }

    private void startChhat(List<MessageListItem> listOfMessages) {
        MessageList list = new MessageList();
        MessageInput input = new MessageInput();
        addInputFieldListener(input, list);
        list.setItems(listOfMessages);

        VerticalLayout chatLayout = new VerticalLayout(list, input);
        chatLayout.setHeight("500px");
        chatLayout.setWidth("600px");
        chatLayout.expand(list);
        add(chatLayout);
    }

    private void addInputFieldListener(MessageInput input, MessageList list) {
        input.addSubmitListener(submitEvent -> {
            MessageListItem newMessage = new MessageListItem(
                    submitEvent.getValue(),
                    Instant.now(),
                    studentDTO.getStudentVorname() + " " + studentDTO.getStudentName());
            newMessage.setUserColorIndex(3);
            List<MessageListItem> items = new ArrayList<>(list.getItems());
            items.add(newMessage);
            list.setItems(items);
        });
    }

}

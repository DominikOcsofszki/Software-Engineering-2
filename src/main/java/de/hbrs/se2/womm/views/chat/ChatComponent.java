package de.hbrs.se2.womm.views.chat;

import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.services.UnternehmenService;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class ChatComponent extends VerticalLayout {
    long nutzerIDFromLoggedIn;
    long otherNutzerIDFromParameterOrElse;
    boolean isStudent;
    ChatNewService chatNewService;
    SecurityService securityService;
    StudentService studentService;
    UnternehmenService unternehmenService;
    List<ChatNewDTO> msgListFromDB;
//    long bewerbungIDOrParameter;

    /////////
    String studentName;
    String unternehmenName;


    public ChatComponent(long nutzerIDFromLoggedIn, long otherNutzerIDFromParameterOrElse, boolean isStudent,
                         SecurityService securityService, ChatNewService chatNewService,
                         StudentService studentService, UnternehmenService unternehmenService) {
        this.nutzerIDFromLoggedIn = nutzerIDFromLoggedIn;
        this.otherNutzerIDFromParameterOrElse = otherNutzerIDFromParameterOrElse;
        this.isStudent = isStudent;
        this.chatNewService = chatNewService;
        this.securityService = securityService;
        this.studentService = studentService;
        this.unternehmenService = unternehmenService;
//        this.bewerbungIDOrParameter = bewerbungIDOrParameter;
        setUpAll();
    }

    void setUpUnternehmenToStudent() {
        throw new RuntimeException("Not implemented yet");
    }

    void setUpAll() {

        if (isStudent) {
            setUpStudentToUnternehmen();

        } else {
            setUpStudentToUnternehmen();

//            setUpUnternehmenToStudent();
        }
    }

    void setUpStudentToUnternehmen() {
        System.out.println("nutzerIDFromLoggedIn" + nutzerIDFromLoggedIn);
        System.out.println("otherNutzerIDFromParameterOrElse" + otherNutzerIDFromParameterOrElse);

        this.studentName = studentService.getByNutzerId(nutzerIDFromLoggedIn).getStudentVorname() + " " + studentService.getByNutzerId(nutzerIDFromLoggedIn).getStudentName();
        this.unternehmenName = unternehmenService.getByNutzerId(otherNutzerIDFromParameterOrElse).getName();
        this.msgListFromDB = chatNewService.getByTwoNutzerIds(
                nutzerIDFromLoggedIn,
                otherNutzerIDFromParameterOrElse
        );
        List<MessageListItem> listOfMessages = prepareMsgToShow(msgListFromDB);
        prepareChat(listOfMessages);
    }

//    private void sendMessageFromUnternehmenToStudent(String text) {
//        ChatNewDTO ongoingChatDTO = ChatNewDTO.builder()
//                .nutzerid1(this.nutzerIDFromLoggedIn)
//                .nutzerid2(this.otherNutzerIDFromParameterOrElse)
//                .msg(text)
//                .date(LocalDate.now())
//                .build();
//        chatNewService.saveChatNewDTO(ongoingChatDTO);
//    }
    private void sendMessageFromStudentToUnternehmen(String text) {
        ChatNewDTO ongoingChatDTO = ChatNewDTO.builder()
                .nutzerid1(this.nutzerIDFromLoggedIn)
                .nutzerid2(this.otherNutzerIDFromParameterOrElse)
                .msg(text)
                .date(LocalDate.now())
                .build();
        chatNewService.saveChatNewDTO(ongoingChatDTO);
    }
    private void addInputFieldListenerStudent(MessageInput input, MessageList list, boolean isStudent) {
        String name = isStudent? studentName : unternehmenName;
        input.addSubmitListener(submitEvent -> {
            MessageListItem newMessage = new MessageListItem(
                    submitEvent.getValue(),
                    Instant.now(),
                    name
            );
            sendMessageFromStudentToUnternehmen(submitEvent.getValue());
            newMessage.setUserColorIndex(3);
            List<MessageListItem> items = new ArrayList<>(list.getItems());
            items.add(newMessage);
            list.setItems(items);
        });
    }

    private void prepareChat(List<MessageListItem> listOfMessages) {
        MessageList list = new MessageList();
        MessageInput input = new MessageInput();
        addInputFieldListenerStudent(input, list, isStudent);
        list.setItems(listOfMessages);

        VerticalLayout chatLayout = new VerticalLayout(list, input);
        chatLayout.setHeight("500px");
        chatLayout.setWidth("600px");
        chatLayout.expand(list);
        add(chatLayout);
    }



    private List<MessageListItem> prepareMsgToShow(List<ChatNewDTO> chatNewDTO) {
        List<MessageListItem> listOfMessages = new ArrayList<>();
        if (chatNewDTO == null) return listOfMessages;
        String name = !isStudent? studentName : unternehmenName;
        chatNewDTO.forEach(chat -> {
            LocalDate date = chat.getDate();
            Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
            MessageListItem newMessage = new MessageListItem(
                    chat.getMsg(),
                    instant,  //TODO change time
                    name
            );
            listOfMessages.add(newMessage);
        });
        return listOfMessages;
    }


}

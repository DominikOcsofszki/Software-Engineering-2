package de.hbrs.se2.womm.views.chat;//package de.hbrs.se2.womm.views.student;
//
//import com.vaadin.flow.component.html.H1;
//import com.vaadin.flow.component.messages.MessageInput;
//import com.vaadin.flow.component.messages.MessageList;
//import com.vaadin.flow.component.messages.MessageListItem;
//import com.vaadin.flow.component.orderedlayout.VerticalLayout;
//import com.vaadin.flow.router.PageTitle;
//import com.vaadin.flow.router.Route;
//import de.hbrs.se2.womm.config.SecurityService;
//import de.hbrs.se2.womm.views.chat.ChatNewDTO;
//import de.hbrs.se2.womm.dtos.StudentDTO;
//import de.hbrs.se2.womm.services.AboStudentUnternehmenService;
//import de.hbrs.se2.womm.services.ChatNewService;
//import de.hbrs.se2.womm.services.StudentService;
//import de.hbrs.se2.womm.views.components.GridFilterAboFromStudent;
//import de.hbrs.se2.womm.views.layouts.AViewWomm;
//import de.hbrs.se2.womm.views.layouts.ROUTING;
//import de.hbrs.se2.womm.views.layouts.StudentLayout;
//import jakarta.annotation.security.RolesAllowed;
//
//import java.time.Instant;
//import java.util.ArrayList;
//import java.util.List;
//
//@Route(value = "ChatNew", layout = StudentLayout.class)
//@RolesAllowed({"STUDENT","ADMIN"})
//@PageTitle("AboStudentView")
//public class ChatNewView extends  AViewWomm{
//
//    List<ChatNewDTO> chatNewDTOS;
//    long nutzerID;
//    GridFilterAboFromStudent gridFilterAboFromStudent = new GridFilterAboFromStudent();
//    public ChatNewView(ChatNewService chatNewService, SecurityService securityService) {
//        nutzerID = securityService.getLoggedInNutzerID();
//        long otherNutzerID = 2;
//        chatNewDTOS = chatNewService.getByNutzerId(nutzerID,otherNutzerID);
//        chatNewDTOS.forEach(AboDTO -> {
//            System.out.println(AboDTO.getMsg());
//            add(AboDTO.getMsg());
//        });
//        H1 top = getWommBuilder().H1.create("New chat");
//        add(top);
//
////        gridFilterAboFromStudent.setUpFromOutside(chatNewDTOS);
////        add(gridFilterAboFromStudent);
//    }
//
//}

import com.vaadin.flow.component.messages.MessageInput;
import com.vaadin.flow.component.messages.MessageList;
import com.vaadin.flow.component.messages.MessageListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.hbrs.se2.womm.config.SecurityService;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.services.AboStudentUnternehmenService;
import de.hbrs.se2.womm.services.StudentService;
import de.hbrs.se2.womm.services.UnternehmenService;
import de.hbrs.se2.womm.views.layouts.AViewWomm;
import de.hbrs.se2.womm.views.layouts.UnternehmenLayout;
import jakarta.annotation.security.RolesAllowed;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Route(value = "UChatNew", layout = UnternehmenLayout.class)
@RolesAllowed({"ADMIN", "UNTERNEHMEN"})
@PageTitle("ChatView")
public class UChatNewView extends AViewWomm {
    ChatNewService chatService;
    StudentDTO studentDTO;
    AboStudentUnternehmenService aboStudentUnternehmenService;
    String nameLastName;
    String nameLastNameOther;
    List<ChatNewDTO> chatList;

    long nutzerIdLoggedIn;
    long nutzerIdOther = 1;

    UChatNewView(StudentService studentService, SecurityService securityService,
                 ChatNewService chatService, UnternehmenService unternehmenService) {
//        this.aboStudentUnternehmenService = aboStudentUnternehmenService;
        this.chatService = chatService;
        this.nutzerIdLoggedIn = securityService.getLoggedInNutzerID();
        boolean isStudent = false;
        if(isStudent) {
            this.studentDTO = studentService.getByNutzerId(nutzerIdOther);
            this.nameLastName = studentDTO.getStudentVorname() + " " + studentDTO.getStudentName();
            this.nameLastNameOther = unternehmenService.getByNutzerId(this.nutzerIdOther).getName();
            this.chatList = chatService.getByTwoNutzerIds(nutzerIdLoggedIn, nutzerIdOther);

        } else {
            this.studentDTO = studentService.getByNutzerId(nutzerIdOther);
            this.nameLastName = unternehmenService.getByNutzerId(this.nutzerIdLoggedIn).getName();
            this.nameLastNameOther = studentDTO.getStudentVorname() + " " + studentDTO.getStudentName();
            this.chatList = chatService.getByTwoNutzerIds(nutzerIdOther, nutzerIdLoggedIn);
        }
        System.out.println("ChatList: " + chatList);
//        this.chatList = chatService.getByTwoNutzerIds(nutzerIdLoggedIn, nutzerIdOther);
        this.chatList = chatService.getByUnternehmenStudent(nutzerIdLoggedIn, nutzerIdOther);
        addSomeItems();
    }

    void addSomeItems() {
        sendMessageFromStudent("Hallo");

        List<MessageListItem> listOfMessages = prepareMsgToShow(chatList);
        startChhat(listOfMessages);
    }
    private List<MessageListItem> prepareMsgToShow(List<ChatNewDTO> chatNewDTO) {
        List<MessageListItem> listOfMessages = new ArrayList<>();
        if(chatNewDTO == null) return listOfMessages;
        chatNewDTO.forEach(chat -> {
            MessageListItem newMessage = new MessageListItem(
                    chat.getMsg(),
                    Instant.now(),
                    studentDTO.getStudentVorname() + " " + studentDTO.getStudentName());
            listOfMessages.add(newMessage);
        });
        return listOfMessages;
    }


    private void sendMessageFromStudent(String text) {
        int chatId = 1; // TODO:
//        List<ChatNewDTO> ongoingChatDTO = chatService.getByTwoNutzerIds(this.nutzerIdLoggedIn,this.NutzerIdOther);
        ChatNewDTO ongoingChatDTO = ChatNewDTO.builder()
                        .nutzerid1(this.nutzerIdLoggedIn)
                        .nutzerid2(this.nutzerIdOther)
                        .msg(text)
                        .build();
        chatService.saveChatNewDTO(ongoingChatDTO);
//        chatList.sendMessage(nameLastName, text);
//        System.out.println("ChatDTO: " + ongoingChatDTO);
    }


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
            chatService.saveChatNewDTO(ChatNewDTO.builder()
                    .nutzerid1(this.nutzerIdLoggedIn)
                    .nutzerid2(this.nutzerIdOther)
                    .msg(submitEvent.getValue())
                    .build());
            newMessage.setUserColorIndex(3);
            List<MessageListItem> items = new ArrayList<>(list.getItems());
            items.add(newMessage);
            list.setItems(items);
        });
    }

}

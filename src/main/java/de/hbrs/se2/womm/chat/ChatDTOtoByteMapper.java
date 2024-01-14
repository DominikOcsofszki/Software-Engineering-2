package de.hbrs.se2.womm.chat;

import de.hbrs.se2.womm.dtos.ChatDTO;
import de.hbrs.se2.womm.dtos.NutzerDTO;
import de.hbrs.se2.womm.dtos.StudentDTO;
import de.hbrs.se2.womm.dtos.UnternehmenDTO;
import de.hbrs.se2.womm.entities.Chat;
import de.hbrs.se2.womm.entities.Nutzer;
import de.hbrs.se2.womm.entities.Student;
import de.hbrs.se2.womm.entities.Unternehmen;
import de.hbrs.se2.womm.mapper.ChatStudentUnternehmenMapper;
import org.springframework.util.SerializationUtils;

import java.util.Arrays;
import javax.annotation.processing.Generated;

public class ChatDTOtoByteMapper {

    public Chat chatDTOToChat(ChatDTO chatDTO) {
        if (chatDTO == null) {
            return null;
        }

        Chat.ChatBuilder chat = Chat.builder();

//        chat.chatVerlauf( stringArrayTobyteArray( chatDTO.getChatVerlauf() ) );
        byte[] chatDTOasByte = SerializationUtils.serialize(chatDTO);
        chat.chatVerlauf(chatDTOasByte);
        chat.chatId(chatDTO.getChatId());
        chat.student(studentDTOToStudent(chatDTO.getStudent()));
        chat.unternehmen(unternehmenDTOToUnternehmen(chatDTO.getUnternehmen()));

        return chat.build();
    }

    public ChatDTO chatToChatDTO(Chat chat) {
        if (chat == null) {
            return null;
        }

        ChatDTO.ChatDTOBuilder chatDTO = ChatDTO.builder();

        chatDTO.chatId(chat.getChatId());
        chatDTO.student(studentToStudentDTO(chat.getStudent()));
        chatDTO.unternehmen(unternehmenToUnternehmenDTO(chat.getUnternehmen()));

        chatDTO.chatVerlauf(byteArrayToStringArray(chat.getChatVerlauf()));
        ChatDTO deserializedChatDTO = (ChatDTO) SerializationUtils.deserialize(chat.getChatVerlauf());
        return deserializedChatDTO;
//        return chatDTO.build();
    }

//    protected byte[] stringArrayTobyteArray(String[] stringArray) {
//        if (stringArray == null) {
//            return null;
//        }
//
//        byte[] byteTmp = new byte[stringArray.length];
//        int i = 0;
//        for (String string : stringArray) {
//            byteTmp[i] = Byte.parseByte(string);
//            i++;
//        }
//
//        return byteTmp;
//    }

    protected Nutzer nutzerDTOToNutzer(NutzerDTO nutzerDTO) {
        if (nutzerDTO == null) {
            return null;
        }

        Nutzer.NutzerBuilder nutzer = Nutzer.builder();

        nutzer.nutzerId(nutzerDTO.getNutzerId());
        nutzer.nutzerMail(nutzerDTO.getNutzerMail());
        nutzer.nutzerAktiv(nutzerDTO.getNutzerAktiv());
        nutzer.nutzerOrt(nutzerDTO.getNutzerOrt());
        byte[] nutzerProfilbild = nutzerDTO.getNutzerProfilbild();
        if (nutzerProfilbild != null) {
            nutzer.nutzerProfilbild(Arrays.copyOf(nutzerProfilbild, nutzerProfilbild.length));
        }

        return nutzer.build();
    }

    protected Unternehmen unternehmenDTOToUnternehmen(UnternehmenDTO unternehmenDTO) {
        if (unternehmenDTO == null) {
            return null;
        }

        Unternehmen.UnternehmenBuilder unternehmen = Unternehmen.builder();

        if (unternehmenDTO.getUnternehmenId() != null) {
            unternehmen.unternehmenId(unternehmenDTO.getUnternehmenId().intValue());
        }
        unternehmen.name(unternehmenDTO.getName());
        unternehmen.beschreibung(unternehmenDTO.getBeschreibung());
        unternehmen.gruendung(unternehmenDTO.getGruendung());
        unternehmen.nutzer(nutzerDTOToNutzer(unternehmenDTO.getNutzer()));

        return unternehmen.build();
    }

    protected Student studentDTOToStudent(StudentDTO studentDTO) {
        if (studentDTO == null) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        student.studentId(studentDTO.getStudentId());
        student.studentVorname(studentDTO.getStudentVorname());
        student.studentName(studentDTO.getStudentName());
        student.studentGeburtstag(studentDTO.getStudentGeburtstag());
        student.studentBenachrichtigung(studentDTO.isStudentBenachrichtigung());
        student.studentBio(studentDTO.getStudentBio());
        student.studentSpezialisierung(studentDTO.getStudentSpezialisierung());
        student.studentSemester(studentDTO.getStudentSemester());
        student.nutzer(nutzerDTOToNutzer(studentDTO.getNutzer()));

        return student.build();
    }

    protected String[] byteArrayToStringArray(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }

        String[] stringTmp = new String[byteArray.length];
        int i = 0;
        for (byte byte1 : byteArray) {
            stringTmp[i] = String.valueOf(byte1);
            i++;
        }

        return stringTmp;
    }

    protected NutzerDTO nutzerToNutzerDTO(Nutzer nutzer) {
        if (nutzer == null) {
            return null;
        }

        NutzerDTO.NutzerDTOBuilder nutzerDTO = NutzerDTO.builder();

        nutzerDTO.nutzerId(nutzer.getNutzerId());
        nutzerDTO.nutzerMail(nutzer.getNutzerMail());
        nutzerDTO.nutzerAktiv(nutzer.getNutzerAktiv());
        nutzerDTO.nutzerOrt(nutzer.getNutzerOrt());
        byte[] nutzerProfilbild = nutzer.getNutzerProfilbild();
        if (nutzerProfilbild != null) {
            nutzerDTO.nutzerProfilbild(Arrays.copyOf(nutzerProfilbild, nutzerProfilbild.length));
        }

        return nutzerDTO.build();
    }

    protected StudentDTO studentToStudentDTO(Student student) {
        if (student == null) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.nutzer(nutzerToNutzerDTO(student.getNutzer()));
        studentDTO.studentId(student.getStudentId());
        studentDTO.studentVorname(student.getStudentVorname());
        studentDTO.studentName(student.getStudentName());
        studentDTO.studentGeburtstag(student.getStudentGeburtstag());
        if (student.getStudentBenachrichtigung() != null) {
            studentDTO.studentBenachrichtigung(student.getStudentBenachrichtigung());
        }
        studentDTO.studentBio(student.getStudentBio());
        studentDTO.studentSpezialisierung(student.getStudentSpezialisierung());
        studentDTO.studentSemester(student.getStudentSemester());

        return studentDTO.build();
    }

    protected UnternehmenDTO unternehmenToUnternehmenDTO(Unternehmen unternehmen) {
        if (unternehmen == null) {
            return null;
        }

        UnternehmenDTO.UnternehmenDTOBuilder unternehmenDTO = UnternehmenDTO.builder();

        if (unternehmen.getUnternehmenId() != null) {
            unternehmenDTO.unternehmenId(unternehmen.getUnternehmenId().longValue());
        }
        unternehmenDTO.name(unternehmen.getName());
        unternehmenDTO.beschreibung(unternehmen.getBeschreibung());
        unternehmenDTO.gruendung(unternehmen.getGruendung());
        unternehmenDTO.nutzer(nutzerToNutzerDTO(unternehmen.getNutzer()));

        return unternehmenDTO.build();
    }
}

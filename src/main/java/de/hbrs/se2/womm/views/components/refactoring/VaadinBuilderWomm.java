package de.hbrs.se2.womm.views.components.refactoring;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.textfield.TextField;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class VaadinBuilderWomm {

    //ToDo Add button for showing all querry-selector
    public ButtonBuilder Button = new ButtonBuilder();
    public TextFieldBuilder TextField = new TextFieldBuilder();
    public H1Builder H1 = new H1Builder();
    public H2Builder H2 = new H2Builder();
    public TextBuilder Text = new TextBuilder();
    public ParagraphBuilder Paragraph = new ParagraphBuilder();
    private static Map<String, String> translateTextMap = TranslateMap.translateMap;
//    private static Set<String> setOfText = new HashSet<>(translateTextMap.keySet());
    private static Set<String> newTextNeedsToBeTranslated = new HashSet<>();

    public class H1Builder {
        private int countH1 = 0;

        public H1 create(String text) {
            String translatedText = translateText(text);
            countH1++;
            String querryId = "h1-builder-" + this.countH1;
            H1 h1 = new H1(translatedText);
            h1.setText(translatedText);
            h1.setId(querryId);
            return h1;
        }
    }
    public class H2Builder {
        private int countH2 = 0;

        public H2 create(String text) {
            String translatedText = translateText(text);
            countH2++;
            String querryId = "h2-builder-" + this.countH2;
            H2 h2 = new H2(translatedText);
            h2.setText(translatedText);
            h2.setId(querryId);
            return h2;
        }
    }
    public class ParagraphBuilder {
        private int countParagraph = 0;

        public Paragraph create(String text) {
            String translatedText = translateText(text);
            countParagraph++;
            String querryId = "paragraph-builder-" + this.countParagraph;
            Paragraph paragraph = new Paragraph(translatedText);
            paragraph.setText(translatedText);
            paragraph.setId(querryId);
            return paragraph;
        }
    }

    public class TextBuilder {
        private int countTextBuilder = 0;

        public Text create(String text) {
            String translatedText = translateText(text);
            countTextBuilder++;
            String querryId = "text-builder-" + this.countTextBuilder;
            Text textText = new Text(translatedText);
            textText.setText(translatedText);
//            textText.setId(querryId);//ToDo update, how to set Querry Id
            return textText;
        }
    }

    public class ButtonBuilder {
        private int countButtonOnView = 0;

        public Button create(String text) {

            String translatedText = translateText(text);
            this.countButtonOnView++;
            String buttonId = "button-builder-" + this.countButtonOnView;
            Button button = new Button(translatedText);
            button.setText(translatedText);
            button.setId(buttonId);
            return button;
        }
    }

    public class TextFieldBuilder {
        private int countTextFieldOnView = 0;

        public TextField create(String textAbove){
            String translatedTextAbove = translateText(textAbove);
            return create(translatedTextAbove, null);
        }
        public TextField create(String textAbove, String textValuePlaceholder) {
            String translatedTextAbove = translateText(textAbove);
            String translatedTextTextValuePlaceholder = translateText(textValuePlaceholder);

            this.countTextFieldOnView++;
            String textFieldId = "text-field-builder-" + this.countTextFieldOnView;
            TextField textField = new TextField(translatedTextAbove);
            if (textValuePlaceholder != null) textField.setValue(translatedTextTextValuePlaceholder);
            textField.setId(textFieldId);
            return textField;
        }
    }
    public static String translateText(String text) {
        if(text == null) return null;
        return addTextToFrontEndCheck(text);
    }
    private static String addTextToFrontEndCheck(String text) {
        boolean alreadyContainsText = (translateTextMap.containsKey(text));
        if (alreadyContainsText) {
            return translateTextMap.get(text);
        } else {
            newTextNeedsToBeTranslated.add(text);
            System.out.println("put(\""+text+"\", \"" + text+"<-TranslationNeeded\");");
            translateTextMap.put(text,"put(\""+text+"\" \"" + text+"<-TranslationNeeded\");");
            return text;
        }
    }
    public static void printAllTextNotTranslatedToConsole(){
        if(newTextNeedsToBeTranslated.isEmpty()){
            System.out.println("Nothing to translate");
            System.out.println("Translation can be found in TranslateMap.java");
            return;
        }
        System.out.println("Not translated:");
        System.out.println(newTextNeedsToBeTranslated);
        System.out.println("------------");
        System.out.println("Add this to TranslateMap.java");
        for(String translateMe : newTextNeedsToBeTranslated) {
            System.out.println("put(\""+translateMe+"\", \"" + translateMe+"<-TranslationNeeded\");");
        }
    }

}

package de.hbrs.se2.womm.views.components.refactoring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.textfield.TextField;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class VaadinBuilderWomm {

    //ToDo Add button for showing all querry-selector
    public ButtonBuilder ButtonBuilder = new ButtonBuilder();
    public TextFieldBuilder TextFieldBuilder = new TextFieldBuilder();
    private static Map<String, String> translateTextMap = TranslateMap.translateMap;
//    private static Set<String> setOfText = new HashSet<>(translateTextMap.keySet());
    private static Set<String> newTextNeedsToBeTranslated = new HashSet<>();

    public class ButtonBuilder {
        private int countButtonOnView = 0;

        public Button createButton(String text) {

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

        public TextField createTextField(String textAbove){
            String translatedTextAbove = translateText(textAbove);
            return createTextField(translatedTextAbove, null);
        }
        public TextField createTextField(String textAbove, String textValuePlaceholder) {
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

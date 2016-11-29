package HomeWorkPart1;

import HomeWorkPart1.core.Translation;
import HomeWorkPart1.core.TranslationRequest;
import HomeWorkPart1.core.Translator;
import HomeWorkPart1.core.TranslatorException;
import HomeWorkPart1.core.language.Language;
import HomeWorkPart1.core.language.LanguageDetector;
import HomeWorkPart1.core.language.LanguageDetectorException;
import HomeWorkPart1.core.language.UnknownLanguageException;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws LanguageDetectorException, IOException {
        LanguageDetector languageDetector = new YandexLanguageDetector("trnsl.1.1.20161117T100947Z.0424d88a18c42e86.3c04638cdd22e09723f535107a7b455b90cac3ef");
        Translator translator = new YandexTranslator("trnsl.1.1.20161117T100947Z.0424d88a18c42e86.3c04638cdd22e09723f535107a7b455b90cac3ef", languageDetector);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            if ("exit".equals(text)) {
                break;
            }

            try {
                String targetLanguage = scanner.nextLine();
                TranslationRequest translationRequest = new TranslationRequest(text, Language.find(targetLanguage));
                Translation translation = translator.translate(translationRequest);

                System.out.println("Original text: " + translation.getOriginalText());
                System.out.println("Original language: " + translation.getOriginalLanguage());

                System.out.println("Translated text: " + translation.getTranslatedText());
                System.out.println("Target language: " + translation.getTargetLanguage());
            } catch (UnknownLanguageException e) {
                System.out.println("Language '" + e.getUnknownLanguage() + "' is not supported yet");
                break;
            } catch (TranslatorException e) {
                System.out.println("Something went wrong during translating");
                break;
            }
        }
    }
}
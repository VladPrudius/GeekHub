package HomeWorkPart1;

import HomeWorkPart1.core.Translation;
import HomeWorkPart1.core.TranslationRequest;
import HomeWorkPart1.core.Translator;
import HomeWorkPart1.core.TranslatorException;
import HomeWorkPart1.core.language.Language;
import HomeWorkPart1.core.language.LanguageDetector;
import HomeWorkPart1.core.language.LanguageDetectorException;
import HomeWorkPart1.util.IOUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class YandexTranslator implements Translator {

    private static final String YANDEX_TRANSLATOR_API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=%s&text=%s&lang=%s";
    private final String apiKey;
    private final LanguageDetector languageDetector;

    public YandexTranslator(String apiKey, LanguageDetector languageDetector) {
        this.apiKey = apiKey;
        this.languageDetector = languageDetector;
    }

    @Override
    public Translation translate(TranslationRequest translationRequest) throws TranslatorException {
        try {
            Language originalLanguage = languageDetector.detect(translationRequest.getText());
            if (originalLanguage == translationRequest.getTargetLanguage()) {
                return new Translation(
                    translationRequest.getText(),
                    originalLanguage,
                    translationRequest.getText(),
                    translationRequest.getTargetLanguage()
                );
            }

            URL preparedUrl = prepareUrl(translationRequest.getText(), originalLanguage, translationRequest.getTargetLanguage());
            String response = IOUtils.toString(preparedUrl.openStream());
            String translatedText = parseResponse(response);
            return new Translation(
                translationRequest.getText(),
                originalLanguage,
                translatedText,
                translationRequest.getTargetLanguage()
            );
        } catch (LanguageDetectorException | IOException e) {
            throw new TranslatorException(e);
        }
    }

    private URL prepareUrl(String text, Language from, Language to) throws MalformedURLException {
        return new URL(String.format(YANDEX_TRANSLATOR_API_URL, apiKey, text, prepareLanguageDirection(from, to)));
    }

    private String prepareLanguageDirection(Language from, Language to) {
        return from.getCode() + "-" + to.getCode();
    }

    private String parseResponse(String text) {
        String parsedResponse = new JSONObject(text).get("text").toString();
        return parsedResponse.substring(2, parsedResponse.length() - 2);
    }
}
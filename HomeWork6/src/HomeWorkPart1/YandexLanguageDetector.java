package HomeWorkPart1;

import HomeWorkPart1.core.language.Language;
import HomeWorkPart1.core.language.LanguageDetector;
import HomeWorkPart1.core.language.LanguageDetectorException;
import HomeWorkPart1.core.language.UnknownLanguageException;
import HomeWorkPart1.util.IOUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class YandexLanguageDetector implements LanguageDetector {

    private static final String YANDEX_LANGUAGE_DETECTOR_API_URL = "https://translate.yandex.net/api/v1.5/tr.json/detect?key=%s&text=%s";
    private final String apiKey;

    public YandexLanguageDetector(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Language detect(String text) throws LanguageDetectorException {
        try {
            URL preparedUrl = prepareUrl(text);
            String response = IOUtils.toString(preparedUrl.openStream());
            String language = parseLanguage(response);
            return Language.find(language);
        } catch (IOException | UnknownLanguageException e){
            throw new LanguageDetectorException(e);
        }
    }

    private URL prepareUrl(String text) throws MalformedURLException {
        return new URL(String.format(YANDEX_LANGUAGE_DETECTOR_API_URL, apiKey, text));
    }

    private String parseLanguage(String languageJson) {
        return new JSONObject(languageJson).get("lang").toString();
    }
}
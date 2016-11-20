package HomeWorkPart1;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import HomeWorkPart1.source.URLSourceProvider;

/**
 * Provides utilities for translating texts to russian language.<br/>
 * Uses Yandex Translate API, more information at <a href="http://api.yandex.ru/translate/">http://api.yandex.ru/translate/</a><br/>
 * Depends on {@link URLSourceProvider} for accessing Yandex Translator API service
 */
public class Translator {
    /**
     * Yandex Translate API key could be obtained at <a href="http://api.yandex.ru/key/form.xml?service=trnsl">http://api.yandex.ru/key/form.xml?service=trnsl</a>
     * to do that you have to be authorized.
     */
    private static final String YANDEX_API_KEY = "trnsl.1.1.20161117T100947Z.0424d88a18c42e86.3c04638cdd22e09723f535107a7b455b90cac3ef";
    private static final String TRANSLATION_DIRECTION = "ru";

    private URLSourceProvider urlSourceProvider;

    public Translator(URLSourceProvider urlSourceProvider) {
        this.urlSourceProvider = urlSourceProvider;
    }

    /**
     * Translates text to russian language
     *
     * @param original text to translate
     * @return translated text
     * @throws IOException
     */
    public String translate(String original) throws TranslateException {
        String s = "";
        try {
            URL url = new URL(prepareURL(original));
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            while (in.readLine() != null) {
                s += in.readLine().toString();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseContent(s);
    }

    /**
     * Prepares URL to invoke Yandex Translate API service for specified text
     *
     * @param text to translate
     * @return url for translation specified text
     */
    private String prepareURL(String text) throws IOException {
        return "https://translate.yandex.net/api/v1.5/tr/translate?key=" + YANDEX_API_KEY + "&text=" + encodeText(text) + "&lang=" + TRANSLATION_DIRECTION;
    }

    /**
     * Parses content returned by Yandex Translate API service. Removes all tags and system texts. Keeps only translated text.
     *
     * @param content that was received from Yandex Translate API by invoking prepared URL
     * @return translated text
     */
    private String parseContent(String content) {
        int firstIndex = content.indexOf("<text>") + 6;
        int lastIndex = content.lastIndexOf("</text>");
        return content.substring(firstIndex, lastIndex);
    }

    /**
     * Encodes text that need to be translated to put it as URL parameter
     *
     * @param text to be translated
     * @return encoded text
     */
    private String encodeText(String text) throws IOException {
        String stringToReverse = URLEncoder.encode(text, "UTF-8");
        return stringToReverse;
    }
}
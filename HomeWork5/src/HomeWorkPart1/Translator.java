package HomeWorkPart1;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import HomeWorkPart1.source.URLSourceProvider;

public class Translator {

    private static final String YANDEX_API_KEY = "trnsl.1.1.20161117T100947Z.0424d88a18c42e86.3c04638cdd22e09723f535107a7b455b90cac3ef";
    private static final String TRANSLATION_DIRECTION = "ru";

    private URLSourceProvider urlSourceProvider;

    public Translator(URLSourceProvider urlSourceProvider) {
        this.urlSourceProvider = urlSourceProvider;
    }

    public String translate(String original) throws TranslateException {
        String translateText = "";
        try {
            URL url = new URL(prepareURL(original));
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            while (in.readLine() != null) {
                translateText += in.readLine().toString();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parseContent(translateText);
    }

    private String prepareURL(String text) throws IOException {
        return "https://translate.yandex.net/api/v1.5/tr/translate?key=" + YANDEX_API_KEY + "&text=" + encodeText(text) + "&lang=" + TRANSLATION_DIRECTION;
    }

    private String parseContent(String content) {
        int firstIndex = content.indexOf("<text>") + 6;
        int lastIndex = content.lastIndexOf("</text>");
        return content.substring(firstIndex, lastIndex);
    }

    private String encodeText(String text) throws IOException {
        String stringToReverse = URLEncoder.encode(text, "UTF-8");
        return stringToReverse;
    }
}
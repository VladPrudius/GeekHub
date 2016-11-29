package HomeWorkPart1;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import HomeWorkPart1.source.URLSourceProvider;
import HomeWorkPart1.source.util.IOUtils;

public class Translator {

    private static final String YANDEX_API_KEY = "trnsl.1.1.20161117T100947Z.0424d88a18c42e86.3c04638cdd22e09723f535107a7b455b90cac3ef";
    private static final String TRANSLATION_DIRECTION = "ru";

    private URLSourceProvider urlSourceProvider;

    public Translator(URLSourceProvider urlSourceProvider) {
        this.urlSourceProvider = urlSourceProvider;
    }

    public String translate(String original) throws TranslateException {
        try {
            URL preparedUrl = new URL(prepareURL(original));
            String response = IOUtils.toString(preparedUrl.openStream());
            return parseContent(response);
        } catch (IOException e) {
            throw new TranslateException(e);
        }
    }

    private String prepareURL(String text) throws IOException {
        return "https://translate.yandex.net/api/v1.5/tr/translate?key=" + YANDEX_API_KEY + "&text=" + encodeText(text) + "&lang=" + TRANSLATION_DIRECTION;
    }

    private String encodeText(String text) throws IOException {
        return URLEncoder.encode(text, "UTF-8");
    }

    private String parseContent(String content) {
        return content.substring(content.indexOf("<text") + 6, content.lastIndexOf("</text>"));
    }
}
package HomeWorkPart1.core.language;

public interface LanguageDetector {

    Language detect(String text) throws LanguageDetectorException;
}

package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;

import java.io.IOException;

public interface SourceProvider {

    boolean isAllowed(String pathToSource);

    String load(String pathToSource) throws SourceLoadingException;
}
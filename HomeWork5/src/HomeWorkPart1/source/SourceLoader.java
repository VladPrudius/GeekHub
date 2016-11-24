package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * SourceLoader should contain all implementations of SourceProviders to be able to load different sources.
 */
public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        sourceProviders.add(new FileSourceProvider());
        sourceProviders.add(new URLSourceProvider());
    }

    public String loadSource(String pathToSource) throws SourceLoadingException {
        File pathToFile = new File(pathToSource);

        if (pathToFile.isFile()) {
            FileSourceProvider fileSourceProvider = new FileSourceProvider();
            return (fileSourceProvider.isAllowed(pathToSource) ? fileSourceProvider.load(pathToSource) : null);
        } else {
            URLSourceProvider urlSourceProvider = new URLSourceProvider();
            return (urlSourceProvider.isAllowed(pathToSource) ? urlSourceProvider.load(pathToSource) : null);
        }
    }
}
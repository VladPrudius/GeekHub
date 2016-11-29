package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;
import HomeWorkPart1.source.util.IOUtils;

import java.io.*;
import java.net.URL;

public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        return new File(pathToSource).isFile();
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        try {
            FileInputStream fis = new FileInputStream(pathToSource);
            return IOUtils.toString(fis);
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}
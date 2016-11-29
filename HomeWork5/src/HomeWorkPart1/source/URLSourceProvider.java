package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;
import HomeWorkPart1.source.util.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        try {
            new URL(pathToSource);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        try {
            URL url = new URL(pathToSource);
            return IOUtils.toString(url.openStream());
        }catch (IOException e){
            throw new SourceLoadingException(e);
        }
    }
}
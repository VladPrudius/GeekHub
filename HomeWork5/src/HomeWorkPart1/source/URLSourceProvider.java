package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        try {
            URL url = new URL(pathToSource);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        String path = pathToSource;
        String contents = "";
        String line;
        try {
            URL url = new URL(path);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            while ((line = in.readLine()) != null) {
                contents += line;
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contents.toString();
    }
}
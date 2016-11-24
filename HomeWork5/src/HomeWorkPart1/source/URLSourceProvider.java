package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Implementation for loading content from specified URL.<br/>
 * Valid paths to load are http://someurl.com, https://secureurl.com, ftp://frpurl.com etc.
 */
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
        String s = pathToSource;
        String contents = "";
        String a;
        try {
            URL url = new URL(s);
            URLConnection connection = url.openConnection();
            connection.setDoOutput(true);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream()));

            while ((a = in.readLine()) != null) {
                contents += a;
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
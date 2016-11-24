package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;
import java.io.*;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */
public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        File file =  new File(pathToSource);
        return file.isFile();
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        StringBuilder bilder = new StringBuilder();
        File file = new File(pathToSource);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    bilder.append(s);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bilder.toString();
    }
}
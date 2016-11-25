package HomeWorkPart1.source;

import HomeWorkPart1.SourceLoadingException;

import java.io.*;

public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        File file = new File(pathToSource);
        return file.isFile();
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        StringBuilder bilder = new StringBuilder();
        File file = new File(pathToSource);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    bilder.append(line);
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
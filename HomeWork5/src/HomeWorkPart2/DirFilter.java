package HomeWorkPart2;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DirFilter extends IOException {

    public String list(String szDir) throws IOException {
        try (ZipOutputStream txtZip = new ZipOutputStream(new FileOutputStream("/txt.zip"));
             ZipOutputStream bmpZip = new ZipOutputStream(new FileOutputStream("/bmp.zip"));
             ZipOutputStream musicZip = new ZipOutputStream(new FileOutputStream("/mp3.zip"));) {
            File file = new File(szDir);
            File[] dirList = file.listFiles();
            String name;
            String path;

            for (File list : dirList) {
                File fileOrDirectory = new File(list.getCanonicalPath());
                if (fileOrDirectory.isFile()) {
                    name = fileOrDirectory.getName();
                    path = fileOrDirectory.getParent();
                    int lastIndex = name.lastIndexOf('.');
                    String typeOfFile = name.substring(lastIndex);
                    if (typeOfFile.equals(".txt")) {
                        addFileToZip(txtZip, path, name);
                    } else if (typeOfFile.equals(".mp3")) {
                        addFileToZip(musicZip, path, name);
                    } else if (typeOfFile.equals(".bmp")) {
                        addFileToZip(bmpZip, path, name);
                    }
                } else {
                    list(list.getCanonicalPath());
                }
            }
            txtZip.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return szDir;
    }

    static void addFileToZip(ZipOutputStream zip, String path, String name) throws IOException {

        ZipEntry file = new ZipEntry(name);
        zip.putNextEntry(file);

        FileInputStream fileInputStream = new FileInputStream(path + File.separator + name);
        byte[] buf = new byte[500];
        int nLength;
        while (true) {
            nLength = fileInputStream.read(buf);
            if (nLength < 0)
                break;
            zip.write(buf, 0, nLength);
        }
        zip.flush();
        zip.closeEntry();
        fileInputStream.close();
    }
}

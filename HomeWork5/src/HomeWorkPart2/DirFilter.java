package HomeWorkPart2;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class DirFilter extends IOException {

    public String list(String szDir) throws IOException {
        try (ZipOutputStream txtZip = new ZipOutputStream(new FileOutputStream("/txt.zip"));
             ZipOutputStream bmpZip = new ZipOutputStream(new FileOutputStream("/bmp.zip"));
             ZipOutputStream musicZip = new ZipOutputStream(new FileOutputStream("/mp3.zip"));) {
            File f = new File(szDir);
            File[] sDirList = f.listFiles();
            String name;
            String path;

            for (File list : sDirList) {
                File f1 = new File(list.getCanonicalPath());
                if (f1.isFile()) {
                    name = f1.getName();
                    path = f1.getParent();
                    int lastIndex = name.lastIndexOf('.');
                    String str = name.substring(lastIndex);
                    if (str.equals(".txt")) {
                        addFileToZip(txtZip, path, name);
                    } else if (str.equals(".mp3")) {
                        addFileToZip(musicZip, path, name);
                    } else if (str.equals(".bmp")) {
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

    static void addFileToZip(ZipOutputStream zos, String szPath, String szName) throws IOException {

        System.out.println(szPath + szName);
        ZipEntry ze;
        ze = new ZipEntry(szName);
        zos.putNextEntry(ze);

        FileInputStream fis = new FileInputStream(szPath + File.separator + szName);
        byte[] buf = new byte[500];
        int nLength;
        while(true)
        {
            nLength = fis.read(buf);
            if(nLength < 0)
                break;
            zos.write(buf, 0, nLength);
        }
        zos.flush();
        zos.closeEntry();
        fis.close();

    }
}

package HomeWorkPart2;

import java.io.File;
import java.io.IOException;


public class DirList {
    public static void main(String[] args) {
        String pathToLoad = "/TestHomeWork5";
        DirFilter dirFilter = new DirFilter();
        try {
            dirFilter.list(pathToLoad);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


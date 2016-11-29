package HomeWorkPart2;

import java.io.BufferedReader;
import java.io.StringReader;

public class PerformanceTest {

    protected void pervormancedTest() {

        BufferedReader reader = new BufferedReader(new StringReader("Hello World"));
        long log = System.currentTimeMillis();
        String line = "";
        for (int i = 0; i <= 10000; i++) {
            line += "d";
        }
        System.out.println(System.currentTimeMillis() - log);
        log = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 10000; i++) {
            sb.append("H");
        }
        System.out.println(System.currentTimeMillis() - log);

        log = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i <= 10000; i++) {
            stringBuffer.append("H");
        }
        System.out.println(System.currentTimeMillis() - log);
    }
}

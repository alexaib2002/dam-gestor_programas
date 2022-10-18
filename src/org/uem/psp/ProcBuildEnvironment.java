package org.uem.psp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class ProcBuildEnvironment {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();

        Map env = processBuilder.environment();
        for (Object key : env.keySet()) {
            System.out.println(key + " = " + env.get(key));

        }

        processBuilder = new ProcessBuilder("ls", "-l");

        List<String> procArgs = processBuilder.command();
        int i = 0;
        for (String arg : procArgs) {
            System.out.printf("Argument %s: %s", i++, arg);
        }

        try {
            Process process = processBuilder.start();

            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

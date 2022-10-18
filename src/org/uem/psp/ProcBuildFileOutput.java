package org.uem.psp;

import java.io.File;

public class ProcBuildFileOutput {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("bash", "ls");
        File fileOutput = new File("output.txt");
    }
}

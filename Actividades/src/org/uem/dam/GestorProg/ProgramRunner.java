package org.uem.dam.GestorProg;

/*
This class runs the selected program
 */

import java.io.IOException;

public class ProgramRunner {
    public ProgramRunner(String programName) {
        try {

            ProcessBuilder pb = new ProcessBuilder(programName);
            pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process process = pb.start();

        } catch (IOException e) {
            System.err.println("Excepción de E/S");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Se ha producido un error");
        }

    }
}

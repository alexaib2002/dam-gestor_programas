package org.uem.dam.GestorProg;

/*
This class runs the selected program
 */

import javax.print.attribute.standard.PresentationDirection;
import java.io.IOException;

public class ProgramRunner {
    public void ProgramRunner(String programName) {
        try {

            ProcessBuilder pb = new ProcessBuilder(programName);
            pb.redirectInput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            Process process = pb.start();

        } catch (IOException e) {
            System.err.println("Excepción de E/S");
        } catch (Exception e) {
            System.err.println("Se ha producido un error");
        }

    }
}

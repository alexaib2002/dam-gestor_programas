package org.uem.psp.exercices;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Execute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            try {
                System.out.print(":>");
                String strCom = sc.nextLine();
                ProcessBuilder processBuilder = new ProcessBuilder(strCom.split(" "));
                Process process = processBuilder.start();
                process.inputReader().lines().forEach(System.out::println);
            } catch (IOException ioException) {
                System.err.println("Error de entada y salida");
                ioException.printStackTrace();
            }  catch (Exception e) {
                System.err.println("La ejecucion ha finalizado con errores");
                loop = false;
                e.printStackTrace();
            }
        }
        sc.close();
    }
}

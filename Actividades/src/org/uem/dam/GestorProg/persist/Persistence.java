package org.uem.dam.GestorProg.persist;

import java.io.*;
import java.util.ArrayList;

public final class Persistence {

    public static final String SAVE_FILE_PATH = "history.dat";

    public static ArrayList<String> readHistoryElements() {
        ArrayList<String> historyElements = new ArrayList<>(); // better than null
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(SAVE_FILE_PATH))) {
            historyElements = (ArrayList<String>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Data file not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        } catch (ClassNotFoundException e) {
            System.err.println("Data file objects couldn't be bounded to scope classes");
        }
        return historyElements;
    }

    public static void writeHistoryElements(ArrayList<String> historyElements) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_PATH))) {
            outputStream.writeObject(historyElements);
            System.out.println("History elements written to save file");
        } catch (FileNotFoundException e) {
            System.err.println("Data file not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }
}

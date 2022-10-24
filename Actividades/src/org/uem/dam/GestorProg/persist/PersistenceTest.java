package org.uem.dam.GestorProg.persist;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PersistenceTest {

    @org.junit.jupiter.api.Test
    void readWriteTest() {
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("Hello");
        testList.add("world");
        Persistence.writeHistoryElements(testList);
        int i = 0;
        for (String element : Persistence.readHistoryElements()) {
            assertEquals(element, testList.get(i++));
        }
        removeTestingFile();
    }

    void removeTestingFile() {
        new File(Persistence.SAVE_FILE_PATH).delete();
    }
}
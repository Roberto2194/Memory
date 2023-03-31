package src.replay;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static src.utility.GameConstants.*;

public class ReplayPanel extends JPanel {

    public ReplayPanel() {
        loadLastGameFromFile();
    }

    // TODO: - LOAD LAST GAME FROM FILE
    private void loadLastGameFromFile() {
        try {
            FileReader fileReader = new FileReader(GAME_LAST_GAME_FILE);
            int data = fileReader.read();

            // when read() returns -1, the is no more data to be read.
            while (data != -1) {
                data = fileReader.read();
                System.out.print((char) data);
            }

            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

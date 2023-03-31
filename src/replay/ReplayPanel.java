package src.replay;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import static src.utility.GameConstants.*;

public class ReplayPanel extends JPanel {

    int rows;
    int cols;
    ArrayList<String> cards = new ArrayList<>();
    ArrayList<String> moves = new ArrayList<>();

    public ReplayPanel() {
        loadLastGameFromFile();

        // TODO: - AFTER LOADING THE LAST GAME FROM FILE, WE NEED TO:
        //  1. DISPLAY THE GAME ONTO THE BOARD INSIDE A GRID LIKE BOARD PANEL
        //  2. PLAY OUT THE MOVES ONE BY ONE
    }

    /**
     * Loads last game from file and puts the
     * data respectively into local properties
     */
    private void loadLastGameFromFile() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(GAME_LAST_GAME_FILE));
            rows = Integer.parseInt(bufferedReader.readLine());
            cols = Integer.parseInt(bufferedReader.readLine());

            int i = 0;
            while (i < rows*cols) {
                cards.add(bufferedReader.readLine());
                i++;
            }

            while (bufferedReader.readLine() != null){
                moves.add(bufferedReader.readLine());
            }

            System.out.println(rows);
            System.out.println(cols);
            for (String card : cards) {
                System.out.println(card);
            }
            for (String move : moves) {
                System.out.println(move);
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

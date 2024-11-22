// Bar Wanunu 209422435

import Game.DirectHit;
import Game.GameFlow;
import Game.TheBossLevel;
import Game.WideEasy;
import GameAddsOn.AnimationRunner;
import Interfaces.LevelInformation;
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Ass6Game class - creates a game object by two options :
 * 1 - if the user didn't insert something in the command line the program
 * creates a list of the 3 levels of the game and run them.
 * 2 - if the user inserted the list contains all the valid level numbers
 * that were inserted and runs the game as the user requested.
 */
public class Ass6Game {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    /**
     * The main method creates the game and runs it.
     *
     * @param args - can be empty or contain the levels the user wants to play
     */
    public static void main(String[] args) {
        // creating a list of LevelInformation
        List<LevelInformation> levels = new ArrayList<>();
        // creating the gui for the game
        GUI gui = new GUI("Arkanoid", WIDTH, HEIGHT);
        // creating the GameFlow
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui),
                gui.getKeyboardSensor(), gui);

        for (String arg : args) {
            try {
                int number = Integer.parseInt(arg);
                // checking the args values
                if (number == 1) {
                    levels.add(new DirectHit());
                } else if (number == 2) {
                    levels.add(new WideEasy());
                } else if (number == 3) {
                    levels.add(new TheBossLevel());
                }
            } catch (NumberFormatException e) {
            }
        }
        // if the list is empty
        if (levels.isEmpty()) {
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new TheBossLevel());
        }
        // running the game flow with the levels in the list
        gameFlow.runLevels(levels);
    }
}

// Bar Wanunu 209422435

package Decorations;

import Game.GameLevel;
import Interfaces.LevelInformation;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class creates a level name object that displays the name of the level
 * on the screen.
 */
public class LevelName
        implements Sprite {
    private LevelInformation levelInformation;

    /**
     * Making a new level information.
     * @param levelInformation - level information
     */
    public LevelName(LevelInformation levelInformation) {
        this.levelInformation = levelInformation;
    }

    @Override public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        // displaying the level name
        d.drawText(500, 18,
                "Level Name: " + this.levelInformation.levelName(), 17);
    }

    @Override public void timePassed() {
    }
    /**
     * The method adds the sprite to the game.
     *
     * @param g - a game level
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

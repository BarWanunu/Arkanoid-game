// Bar Wanunu 209422435

package Decorations;

import Game.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class creates a sprite object that is the decorations for level 1 -
 * Direct Hit.
 */
public class DirectHitDeco
        implements Sprite {
    @Override public void drawOn(DrawSurface d) {
        d.setColor(Color.blue);
        // creating 3 circles around the block
        d.drawCircle(415, 215, 80);
        d.drawCircle(415, 215, 110);
        d.drawCircle(415, 215, 140);
        // creating 4 lines around the block
        d.drawLine(440, 215, 580, 215);
        d.drawLine(390, 215, 250, 215);
        d.drawLine(415, 190, 415, 50);
        d.drawLine(415, 240, 415, 380);
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

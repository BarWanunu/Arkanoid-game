// Bar Wanunu 209422435

package Decorations;

import Game.GameLevel;
import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The class creates a sprite object that is the decorations for level 2 -
 * Wide Easy.
 */
public class WideEasyDeco
        implements Sprite {
    @Override public void drawOn(DrawSurface d) {
        // creating the layers of the sun
        d.setColor(new Color(255, 255, 204));
        d.fillCircle(120, 120, 60);
        d.setColor(new Color(255, 255, 153));
        d.fillCircle(120, 120, 50);
        d.setColor(new Color(255, 204, 51));
        d.fillCircle(120, 120, 40);
        int xValue = 742;
        for (int i = 0; i < 72; i++) {
            // drawing the sun rays
            d.drawLine(120, 120, xValue, 263);
            xValue -= 10;
        }
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

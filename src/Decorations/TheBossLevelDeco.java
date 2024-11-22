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
public class TheBossLevelDeco
        implements Sprite {
    @Override public void drawOn(DrawSurface d) {
        // drawing the building
        d.setColor(Color.black);
        d.fillRectangle(50, 450, 80, 150);
        // drawing the poles
        d.setColor(new Color(51, 51, 51));
        d.fillRectangle(80, 400, 20, 50);
        d.setColor(new Color(102, 102, 102));
        d.fillRectangle(87, 280, 6, 120);
        // drawing the circles
        d.setColor(new Color(255, 204, 51));
        d.fillCircle(90, 260, 20);
        d.setColor(new Color(255, 102, 0));
        d.fillCircle(90, 260, 12);
        d.setColor(Color.white);
        d.fillCircle(90, 260, 5);
        d.setColor(Color.lightGray);
        // drawing the windows
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                d.fillRectangle(55 + 15 * i, 460 + 30 * j, 10, 20);
            }
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

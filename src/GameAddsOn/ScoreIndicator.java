// Bar Wanunu 209422435

package GameAddsOn;

import Game.GameLevel;
import Geometry.Counter;
import Interfaces.Sprite;
import biuoop.DrawSurface;

/**
 * ScoreIndicator class - implements Sprite and prints the score.
 */
public class ScoreIndicator
        implements Sprite {

    // Fields

    private Counter score;

    // Constructor

    /**
     * Making a new ScoreIndicator.
     *
     * @param score - score counter
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    // Methods

    @Override public void drawOn(DrawSurface d) {
        // displaying the score on the screen
        d.drawText(360, 18, "Score: " + this.score.getValue(), 17);
    }

    /**
     * The method get a game variable and adds the ScoreIndicator as a sprite.
     *
     * @param g - a GameLevel.GameLevel
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * The method removes the ScoreIndicator from the game.
     *
     * @param g - a game
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
    @Override public void timePassed() {

    }
}

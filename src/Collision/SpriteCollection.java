// Bar Wanunu 209422435

package Collision;

import Interfaces.Sprite;
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * Sprite Collection class - contains the Sprite Collection constructor and
 * methods.
 */
public class SpriteCollection {

    // Fields

    private List<Sprite> sprites;

    // Constructor

    /**
     * Making a new Interfaces.Sprite Collection with a given list.
     *
     * @param sprites - List of sprites
     */
    public SpriteCollection(List<Sprite> sprites) {
        this.sprites = sprites;
    }

    /**
     * Making a default empty sprite list.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    // Methods


    /**
     * The method returns the list of sprite collection.
     *
     * @return - List of sprite collection
     */
    public List<Sprite> getSprites() {
        return this.sprites;
    }

    /**
     * Adding an Interfaces.Sprite to the list.
     *
     * @param s - an Interfaces.Sprite object
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * The methods go over the list and notifies all sprite time the passed.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spriteList = new ArrayList<>(this.sprites);
        for (Sprite s : spriteList) {
            s.timePassed();
        }
    }

    /**
     * The method go over the list and draws the sprites on the surface.
     *
     * @param d - the DrawSurface
     */
    public void drawAllOn(DrawSurface d) {
        for (int i = 0; i < this.sprites.size(); i++) {
            this.sprites.get(i).drawOn(d);
        }
    }

    /**
     * The method returns the size of the sprites list.
     *
     * @return - amount of sprites
     */
    public int sizeOfSprites() {
        return this.sprites.size();
    }
}

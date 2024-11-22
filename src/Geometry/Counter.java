// Bar Wanunu 209422435

package Geometry;

/**
 * Counter class - keeps count on specific objects.
 */
public class Counter {

    // Fields

    private int count;

    // Constructor

    /**
     * Creates a new counter with a given number.
     *
     * @param num - the number we start the counter to
     */
    public Counter(int num) {
        this.count = num;
    }

    // Methods

    /**
     * Creates a new counter and initialize it to 0.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * The method adds a given number to the counter.
     *
     * @param number - the value we want to add
     */
    public void increase(int number) {
        this.count += number;
    }

    /**
     * The method reduces a given number from the counter.
     *
     * @param number - the value we want to reduce
     */
    public void decrease(int number) {
        this.count -= number;
    }

    /**
     * The method returns the value of the counter.
     *
     * @return - the counter number
     */
    public int getValue() {
        return this.count;
    }
}

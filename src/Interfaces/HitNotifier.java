// Bar Wanunu 209422435

package Interfaces;

/**
 * Methods for object we want to send notification when they've been hit.
 */
public interface HitNotifier {

    /**
     * The method adds hl as a listener to the events.
     *
     * @param hl - the HitListener we want to add
     */
    void addHitListener(HitListener hl);

    /**
     * The method removes hl from the list of listeners to the events.
     *
     * @param hl - the HitListener we want to remove
     */
    void removeHitListener(HitListener hl);
}

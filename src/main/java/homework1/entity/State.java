package homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Jadon
 */
@Data
@AllArgsConstructor
public class State {
    /**
     * the tile which was added.
     */
    Tile tile;
    /**
     * current floor.
     */
    int[][] floor;
    /**
     * c(n) current cost.
     */
    int c;
    /**
     * h(n) heuristic function.
     */
    int h;
    /**
     * f(n) = c(n)+h(n).
     */
    int f;
    /**
     * the parent state of current state,in order to find the sequence of tiles added in the end of the search.
     */
    State parent;

    @Override
    public String toString() {
//        return "State{" +
//                "tile=" + tile +
//                ", c(n)=" + c +
//                ", h(n)=" + h +
//                ", f(n)=c(n)+h(n)=" + f +
//                '}';
        return tile+"("+c+"+"+h+")\t";
    }
}

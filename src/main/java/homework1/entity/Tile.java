package homework1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * tile
 *
 * @author Jadon
 */
@Data
@AllArgsConstructor
public class Tile {
    int col;
    int row;

    /**
     * get the size of tile.
     *
     * @return tile size.
     */
    public int getTileSize() {
        return getRow() * getCol();
    }

    @Override
    public String toString() {
//        return "Tile{" +
//                col + "x" + row
//                +
//                '}';
        return "{" +
                col + "x" + row
                +
                '}';
    }
}

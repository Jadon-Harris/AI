package homework1.utils;

import java.util.List;

import homework1.entity.Tile;

/**
 * some utils used in A* search.
 *
 * @author HaoJiandong
 */
public interface Utils {
    /**
     * Check if the tile can be added to the specified location(the most bottom left corner location which is empty) of the floor.
     *
     * @param floor floor.
     * @param tile  tile.
     * @return If the tile can be added to the specified location(the most bottom left corner location which is empty).
     */
    boolean canBeAdded(int[][] floor, Tile tile);

    /**
     * add the tile to the floor.
     *
     * @param floor floor.
     * @param tile  tile.
     * @return the floor after adding the tile.
     */
    int[][] addTile(int[][] floor, Tile tile);

    /**
     * Check if the floor is full of tiles.
     *
     * @param floor floor.
     * @return If the floor is full of tiles.
     */
    boolean goalTest(int[][] floor);

    /**
     * deep copy floor.
     *
     * @param floor floor.
     * @return the copy of floor.
     */
    int[][] deepCopyFloor(int[][] floor);

    /**
     * get the number of empty part of the floor.
     *
     * @param floor floor.
     * @return the number of empty part of the floor.
     */
    int getEmptyNum(int[][] floor);

    /**
     * get the size of the biggest tile can be added.
     * @param floor current floor.
     * @param tiles tiles list.
     * @return the size of the biggest tile can be added.
     */
    int getSizeOfTheBiggestTileCanBeAdded(int[][] floor, List<Tile> tiles);
}

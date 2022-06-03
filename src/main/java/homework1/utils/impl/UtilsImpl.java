package homework1.utils.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import homework1.entity.Tile;
import homework1.utils.Utils;

/**
 * @author HaoJiandong
 */
public class UtilsImpl implements Utils {

    /**
     * Check if the tile can be added to the specified location(the most bottom left corner location which is empty) of the floor.
     *
     * @param floor floor.
     * @param tile  tile.
     * @return If the tile can be added to the specified location(the most bottom left corner location which is empty).
     */
    @Override
    public boolean canBeAdded(int[][] floor, Tile tile) {
        // find the most bottom left empty location's index.
        int[] emptyLocation = findFirstEmptyLocation(floor);
        int result = 0;
        if (emptyLocation != null) {
            int rowIndex = emptyLocation[0];
            int colIndex = emptyLocation[1];

            // check if the tile can be added.
            if (rowIndex - (tile.getRow() - 1) < 0 || colIndex + tile.getCol() > floor[0].length) {
                return false;
            }

            for (int i = 0; i < tile.getRow(); i++) {
                for (int j = 0; j < tile.getCol(); j++) {
                    result += floor[rowIndex - i][colIndex + j];
                }
            }
        }
        return result == 0;
    }

    /**
     * add the tile to the floor.
     *
     * @param floor floor.
     * @param tile  tile.
     * @return the floor after adding the tile.
     */
    @Override
    public int[][] addTile(int[][] floor, Tile tile) {
        int rowIndex = findFirstEmptyLocation(floor)[0];
        int colIndex = findFirstEmptyLocation(floor)[1];

        for (int i = 0; i < tile.getRow(); i++) {
            for (int j = 0; j < tile.getCol(); j++) {
                floor[rowIndex - i][colIndex + j] = 1;
            }
        }
        return floor;
    }

    /**
     * Check if the floor is full of tiles.
     *
     * @param floor floor.
     * @return If the floor is full of tiles.
     */
    @Override
    public boolean goalTest(int[][] floor) {
        return Arrays.stream(floor).mapToInt(a -> IntStream.of(a).sum()).sum() == floor.length * floor[0].length;
    }

    /**
     * deep copy floor.
     *
     * @param floor floor.
     * @return the copy of floor.
     */
    @Override
    public int[][] deepCopyFloor(int[][] floor) {
        int[][] temp = new int[floor.length][floor[0].length];
        for (int i = 0; i < floor.length; i++) {
            System.arraycopy(floor[i], 0, temp[i], 0, floor[0].length);
        }
        return temp;
    }

    /**
     * get the number of empty part of the floor.
     *
     * @param floor floor.
     * @return the number of empty part of the floor.
     */
    @Override
    public int getEmptyNum(int[][] floor) {
        return floor.length * floor[0].length - Arrays.stream(floor).mapToInt(a -> IntStream.of(a).sum()).sum();
    }

    /**
     * get the size of the biggest tile can be added.
     *
     * @param floor current floor.
     * @param tiles tiles list.
     * @return the size of the biggest tile can be added.
     */
    @Override
    public int getSizeOfTheBiggestTileCanBeAdded(int[][] floor, List<Tile> tiles) {
        int result = Integer.MIN_VALUE;
        for (Tile tile : tiles) {
            if (canBeAdded(floor, tile)) {
                result = Math.max(tile.getTileSize(), result);
            }
        }
        return result;
    }

    /**
     * find the most bottom left empty location.
     *
     * @return location(rowIndex, colIndex)
     */
    private int[] findFirstEmptyLocation(int[][] floor) {
        for (int row = floor.length - 1; row >= 0; row--) {
            for (int col = 0; col < floor[row].length; col++) {
                if (floor[row][col] == 0) {
                    return new int[]{row, col};
                }
            }
        }
        return null;
    }
}

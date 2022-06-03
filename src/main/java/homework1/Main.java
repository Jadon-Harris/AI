package homework1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import homework1.algorithm.AStarSearch;
import homework1.entity.State;
import homework1.entity.Tile;

/**
 * Main
 *
 * @author HaoJiandong
 * @date 2022-05-26
 */
public class Main {
    final static int TILES_SUM = 3;

    public static void main(String[] args) {
        // input the data provided for Question 3.
        final Scanner scanner = new Scanner(System.in);
        System.out.println("enter the col of the floor");
        int floorCol = scanner.nextInt();
        System.out.println("enter the row of the floor");
        int floorRow = scanner.nextInt();
        List<Tile> tiles = new ArrayList<>(TILES_SUM);
        for (int i = 1; i <= TILES_SUM; i++) {
            System.out.println("enter the col of the tile (" + i + "/5)");
            int tileCol = scanner.nextInt();
            System.out.println("enter the row of the tile (" + i + "/5)");
            int tileRow = scanner.nextInt();
            tiles.add(new Tile(tileCol, tileRow));
        }

        // sort the tiles supplied to make sure the biggest size one is at the first position of the list.
        tiles = tiles.stream().sorted(Comparator.comparing(Tile::getTileSize).reversed()).collect(Collectors.toList());

        // init the floor.
        int[][] floor = new int[floorRow][floorCol];

        // do A* search.
        final List<State> sequence = AStarSearch.search(floor, tiles);
        System.out.println();
        System.out.println("The cost is " + sequence.get(sequence.size() - 1).getC());
        System.out.println();
        System.out.println("The sequence of tiles: " + sequence);
    }
}

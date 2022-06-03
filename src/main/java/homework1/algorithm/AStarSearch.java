package homework1.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import homework1.entity.State;
import homework1.entity.Tile;
import homework1.utils.Utils;
import homework1.utils.impl.UtilsImpl;

/**
 * A* Search.
 *
 * @author HaoJiandong
 */
public class AStarSearch {
    public static List<State> search(int[][] floor, List<Tile> tiles) {
        List<State> sequence = new LinkedList<>();
        Utils utils = new UtilsImpl();
        List<State> open = new ArrayList<>();
        List<State> visited = new ArrayList<>();
        int floorSize = floor.length * floor[0].length;
        int iterationCount = 1;

        // init openList
        for (Tile tile : tiles) {
            int[][] temp = utils.deepCopyFloor(floor);
            if (utils.canBeAdded(floor, tile)) {
                // this h() is not admissible in order to improve the process speed.
                int h = (int) Math.ceil((double) (floorSize - tile.getTileSize()) / utils.getSizeOfTheBiggestTileCanBeAdded(floor, tiles));
                int c = 1;
                int f = h + c;
                open.add(new State(tile, utils.addTile(temp, tile), c, h, f, null));
            }
        }
        open = open.stream().sorted(Comparator.comparing(State::getF).thenComparing(State::getH)).collect(Collectors.toList());
        System.out.println("iteration " + iterationCount + ":\n");
        System.out.println("open list: " + open + "\n");
        System.out.println("visited list: " + visited);
        System.out.println("=====================================================================");
        iterationCount++;

        while (!open.isEmpty()) {
            // peek the first element in open list.
            State state = open.get(0);
            int biggest = utils.getSizeOfTheBiggestTileCanBeAdded(state.getFloor(), tiles);
            // check whether the goal is achieved
            if (utils.goalTest(state.getFloor())) {
                // if achieve the goal, break the loop.
                State temp = state;
                while (temp != null) {
                    sequence.add(temp);
                    temp = temp.getParent();
                }
                Collections.reverse(sequence);
                break;
            } else {
                // add to visited list
                visited.add(state);
                // expand and sort open list
                open.remove(0);
                for (Tile tile : tiles) {
                    if (utils.canBeAdded(state.getFloor(), tile)) {
                        int[][] temp = utils.deepCopyFloor(state.getFloor());
                        // this h() is not admissible in order to improve the process speed.
                        int h = (int) Math.ceil((double) (utils.getEmptyNum(state.getFloor()) - tile.getTileSize()) / biggest);
                        int c = state.getC() + 1;
                        int f = h + c;
                        open.add(new State(tile, utils.addTile(temp, tile), c, h, f, state));
                    }
                }
                open = open.stream().sorted(Comparator.comparing(State::getF).thenComparing(State::getH)).collect(Collectors.toList());

                // output open list and visited list
                System.out.println("iteration " + iterationCount + ":\n");
                System.out.println("open list: " + open + "\n");
                System.out.println("visited list: " + visited);
                System.out.println("=====================================================================");
                iterationCount++;
            }
        }
        return sequence;
    }
}

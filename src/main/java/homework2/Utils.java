package homework2;

import java.util.List;

public interface Utils {
    boolean isTerminalNode(Node node);
    int evaluationFunction(Node node);
    List<Node> findAllPositionsCanPlaced(Node node);
    int[][] deepCopyBoard(int[][] board);
}

package homework2.entity;

import lombok.Data;

/**
 * @author Jadon
 */
@Data
public class Node {
    int[][] board;
    int depth;
    NodeType nodeType;
    int evaluationValue;

    public Node(int[][] board, int depth, NodeType nodeType) {
        this.board = board;
        this.depth = depth;
        this.nodeType = nodeType;
        this.evaluationValue = ("MAX".equals(nodeType.name())?Integer.MIN_VALUE:Integer.MAX_VALUE);
    }
}

package homework2;

import java.util.List;

import lombok.Data;

@Data
public class Node {
    int[][] board;
    int row;
    int col;
    Node parent;
    List<Node> children;
    boolean isMax;

    public Node(int[][] board, int row, int col, Node parent, List<Node> children, boolean isMax) {
        this.board = board;
        this.row = row;
        this.col = col;
        this.parent = parent;
        this.children = children;
        this.isMax = isMax;
    }
}

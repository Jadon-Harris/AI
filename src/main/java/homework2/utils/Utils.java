package homework2.utils;

import java.util.List;

import homework2.entity.Node;


/**
 * @author Jadon
 */
public interface Utils {
    /**
     * check a node if a leaf node.
     *
     * @param node node.
     * @return whether a leaf node.
     */
    boolean isLeafNode(Node node);

    /**
     * check if a piece in "type" can be placed in (rowIndex, colIndex) of the node's board.
     *
     * @param node     the node.
     * @param rowIndex the piece's row index.
     * @param colIndex the piece's col index.
     * @param type     the piece's type(i.e. blue or red).
     * @return whether a piece in "type" can be placed in (rowIndex, colIndex) of the node's board.
     */
    boolean isValid(Node node, int rowIndex, int colIndex, String type);

    /**
     * calculate the evaluation value of a node.
     *
     * @param node node.
     * @return the evaluation value.
     */
    int calEvaluationValue(Node node);

    /**
     * prune the search tree.
     *
     * @param openList open list.
     * @return pruned open list.
     */
    List<Node> prune(List<Node> openList);
}

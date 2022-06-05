package homework2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Jadon
 */
public class AlphaBetaPruning {
    Node expand(Node node) {
        Utils util = new UtilsImpl();
        List<Node> open = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        while (open.size() < 400) {
            final List<Node> allPositionsCanPlaced = util.findAllPositionsCanPlaced(node);
            for (Node subNode : allPositionsCanPlaced) {
                if (open.size() < 400) {
                    open.add(subNode);
                    queue.offer(subNode);
                } else {
                    break;
                }
            }
            node = queue.poll();
        }
        return node;
    }


}

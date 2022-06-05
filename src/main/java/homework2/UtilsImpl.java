package homework2;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Jadon
 */
public class UtilsImpl implements Utils {
    @Override
    public boolean isTerminalNode(Node node) {
        return false;
    }

    @Override
    public int evaluationFunction(Node node) {
        return 0;
    }

    @Override
    public List<Node> findAllPositionsCanPlaced(Node node) {
        final int[][] board = node.getBoard();
        List<Node> res = new LinkedList<>();
        if (node.isMax()) {
            // agent
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 0) {
                        if (row == 0) {
                            if (col == 0) {
                                // 左上角
                                if (board[row + 1][col] != -1 && board[row][col + 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else if (col == board[0].length - 1) {
                                // 右上角
                                if (board[row + 1][col] != -1 && board[row][col - 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else {
                                // 上边
                                if (board[row + 1][col] != -1 && board[row][col - 1] != -1 && board[row][col + 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            }
                        } else if (row == board.length - 1) {
                            if (col != -1) {
                                // 左下角
                                if (board[row - 1][col] != -1 && board[row][col + 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else if (col == board[0].length - 1) {
                                // 右下角
                                if (board[row - 1][col] != -1 && board[row][col - 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else {
                                // 下边
                                if (board[row - 1][col] != -1 && board[row][col - 1] != -1 && board[row][col + 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            }
                        } else {
                            if (col == 0) {
                                // 左边
                                if (board[row - 1][col] != -1 && board[row + 1][col] != -1 && board[row][col + 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else if (col == board[0].length - 1) {
                                // 右边
                                if (board[row - 1][col] != -1 && board[row + 1][col] != -1 && board[row][col - 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else {
                                // 中间
                                if (board[row - 1][col] != -1 && board[row + 1][col] != -1 && board[row][col - 1] != -1 && board[row][col + 1] != -1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            }
                        }
                    }
                }
            }
        }else {
            // human
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 0) {
                        if (row == 0) {
                            if (col == 0) {
                                // 左上角
                                if (board[row + 1][col] != 1 && board[row][col + 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else if (col == board[0].length - 1) {
                                // 右上角
                                if (board[row + 1][col] != 1 && board[row][col - 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else {
                                // 上边
                                if (board[row + 1][col] != 1 && board[row][col - 1] != 1 && board[row][col + 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            }
                        } else if (row == board.length - 1) {
                            if (col != 1) {
                                // 左下角
                                if (board[row - 1][col] != 1 && board[row][col + 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else if (col == board[0].length - 1) {
                                // 右下角
                                if (board[row - 1][col] != 1 && board[row][col - 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else {
                                // 下边
                                if (board[row - 1][col] != 1 && board[row][col - 1] != 1 && board[row][col + 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            }
                        } else {
                            if (col == 0) {
                                // 左边
                                if (board[row - 1][col] != 1 && board[row + 1][col] != 1 && board[row][col + 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else if (col == board[0].length - 1) {
                                // 右边
                                if (board[row - 1][col] != 1 && board[row + 1][col] != 1 && board[row][col - 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            } else {
                                // 中间
                                if (board[row - 1][col] != 1 && board[row + 1][col] != 1 && board[row][col - 1] != 1 && board[row][col + 1] != 1) {
                                    int[][] temp = deepCopyBoard(board);
                                    temp[col][row] = 1;
                                    res.add(new Node(temp, row, col, node, new LinkedList<>(), false));
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    @Override
    public int[][] deepCopyBoard(int[][] board) {
        return new int[0][];
    }
}

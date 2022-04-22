package 回溯;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 对递归方法外层的遍历是枚举各种情况
 * 递归方法内层的遍历时针对特定情况的深度搜索
 */
public class 单词搜索 {
    public static void main(String[] args) {
        char[][] chars = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(chars, "ASA"));
    }

    public static boolean exist(char[][] board, String word) {
        int[][] record = new int[board.length][board[0].length];
        // 确定起点，遍历每一个点，当做单词的第一个字母
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean find = find(board, record, word, 0, j, i);
                if (find) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * dfs
     *
     * @param board  board
     * @param record 记录是否已走过，走过为 1
     * @param word   word
     * @param x      第几列 （已左上角为原点）
     * @param y      第几行
     * @param index  记录走到单词的哪个位置了
     */
    private static boolean find(char[][] board, int[][] record, String word, int index, int x, int y) {
        // 当越界时结束
        if (x < 0 || y < 0 || x >= board[0].length || y >= board.length) {
            return false;
        }

        if (word.charAt(index) != board[y][x]) {
            return false;
        } else {
            if (index == word.length() - 1) {
                return true;
            }
        }
        // 往下走一格
        if (y + 1 < board.length && record[y + 1][x] == 0) { // 往下走一格时没有越界，并且没有走过这个点，就可以dfs
            record[y][x] = 1;
            boolean find = find(board, record, word, index + 1, x, y + 1);
            if (find) { // 找到了完整的路径则可以直接结束
                return true;
            }
            // 当前路径没有找到，则需要回溯
            record[y][x] = 0;
        }
        // 往上走一格
        if (y - 1 >= 0 && record[y - 1][x] == 0) { // 往上走一格时没有越界，并且没有走过这个点，就可以dfs
            record[y][x] = 1;
            boolean find = find(board, record, word, index + 1, x, y - 1);
            if (find) {
                return true;
            }
            record[y][x] = 0;
        }
        // 往左走一格
        if (x - 1 >= 0 && record[y][x - 1] == 0) { // 往左走一格时没有越界，并且没有走过这个点，就可以dfs
            record[y][x] = 1;
            boolean find = find(board, record, word, index + 1, x - 1, y);
            if (find) {
                return true;
            }
            record[y][x] = 0;
        }
        // 往右走一格
        if (x + 1 < board[0].length && record[y][x + 1] == 0) { // 往右走一格时没有越界，并且没有走过这个点，就可以dfs
            record[y][x] = 1;
            boolean find = find(board, record, word, index + 1, x + 1, y);
            if (find) {
                return true;
            }
            record[y][x] = 0;
        }
        // 没有一条符合条件的路径，返回false
        return false;
    }
}

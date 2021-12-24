//
// 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连
//。 
//
// 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 
//
// 给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 
//isConnected[i][j] = 0 表示二者不直接相连。 
//
// 返回矩阵中 省份 的数量。 
//
// 
//
// 示例 1： 
//
// 
//输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 200 
// n == isConnected.length 
// n == isConnected[i].length 
// isConnected[i][j] 为 1 或 0 
// isConnected[i][i] == 1 
// isConnected[i][j] == isConnected[j][i] 
// 
// 
//
// 
//
// 注意：本题与主站 547 题相同： https://leetcode-cn.com/problems/number-of-provinces/ 
// Related Topics 深度优先搜索 广度优先搜索 并查集 图 👍 21 👎 0


package top.lighten.leetcode.editor.cn;

public class BLyHh0 {
    public static void main(String[] args) {
        Solution solution = new BLyHh0().new Solution();
        System.out.println(solution.findCircleNum(new int[][]{new int[]{1, 1, 0}, new int[]{1, 1, 0}, new int[]{0, 0, 1}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;
        boolean[] visited;
        int[][] map;

        public int findCircleNum(int[][] isConnected) {
            map = isConnected;
            visited = new boolean[isConnected.length];
            for (int i = 0; i < isConnected.length; i++) {
                if (visited[i]) {
                    continue;
                }
                count++;
                dfs(i);
            }
            return count;
        }

        private void dfs(int index) {
            visited[index] = true;
            int[] series = map[index];
            for (int i = 0; i < series.length; i++) {
                if (series[i] == 1 && !visited[i]) {
                    dfs(i);
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
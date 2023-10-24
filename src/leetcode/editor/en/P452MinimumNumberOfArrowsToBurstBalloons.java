//There are some spherical balloons taped onto a flat wall that represents the 
//XY-plane. The balloons are represented as a 2D integer array points where points[
//i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches 
//between xstart and xend. You do not know the exact y-coordinates of the balloons. 
//
// Arrows can be shot up directly vertically (in the positive y-direction) from 
//different points along the x-axis. A balloon with xstart and xend is burst by 
//an arrow shot at x if xstart <= x <= xend. There is no limit to the number of 
//arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any 
//balloons in its path. 
//
// Given the array points, return the minimum number of arrows that must be 
//shot to burst all balloons. 
//
// 
// Example 1: 
//
// 
//Input: points = [[10,16],[2,8],[1,6],[7,12]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
//- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
// 
//
// Example 2: 
//
// 
//Input: points = [[1,2],[3,4],[5,6],[7,8]]
//Output: 4
//Explanation: One arrow needs to be shot for each balloon for a total of 4 
//arrows.
// 
//
// Example 3: 
//
// 
//Input: points = [[1,2],[2,3],[3,4],[4,5]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
//- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 10⁵ 
// points[i].length == 2 
// -2³¹ <= xstart < xend <= 2³¹ - 1 
// 
//
// Related Topics Array Greedy Sorting 👍 6530 👎 186

package leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

class P452MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        Solution solution = new P452MinimumNumberOfArrowsToBurstBalloons().new Solution();
        int[][] points = new int[][]{
                {-2147483646, -2147483645}, {2147483646, 2147483647}
        };
        System.out.println(solution.findMinArrowShots(points));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) return 0;
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] < o2[0]) return -1;
                    else if (o1[0] > o2[0]) return 1;
                    else return 0;
                }
            });
            int cnt = 1;
            int[] overlapped = points[0];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= overlapped[1]) { // overlapped
                    overlapped[0] = Math.max(points[i][0], overlapped[0]);
                    overlapped[1] = Math.min(points[i][1], overlapped[1]);
                } else { // non-overlapped
                    cnt++;
                    overlapped = points[i];
                }
            }
            return cnt;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
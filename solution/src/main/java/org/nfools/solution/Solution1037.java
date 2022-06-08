package org.nfools.solution;

/**
 * @author caoxuan
 */
public class Solution1037 {
    public boolean isBoomerang(int[][] points) {
        int i = 0;
        float k0 = Float.NaN;
        while (i < points.length - 1) {
            int[] p1 = points[i + 1];
            int[] p0 = points[i];
            if (Float.isNaN(k0)) {
                k0 = (float)(p1[1] - p0[1]) / (p1[0] - p0[0]);
                i++;
                continue;
            }
            float k = (float)(p1[1] - p0[1]) / (p1[0] - p0[0]);
            if (Float.isNaN(k)) {
                i++;
                continue;
            }
            if ((k != k0) && !(Float.isInfinite(k0) && Float.isInfinite(k))) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{0,0},{0,2},{2,1}};
        System.out.println(new Solution1037().isBoomerang(points));
    }

}

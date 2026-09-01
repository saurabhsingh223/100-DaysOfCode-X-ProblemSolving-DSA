class Solution {
    public int minMoves(String[] classroom, int energy) {
        int rows = classroom.length, cols = classroom[0].length();
        int[][] litterIdx = new int[rows][cols];
        int sr = 0, sc = 0, cnt = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') { sr = i; sc = j; }
                else if (c == 'L') litterIdx[i][j] = cnt++;
            }
        }
        if (cnt == 0) return 0;

        boolean[][][][] visited = new boolean[rows][cols][energy + 1][1 << cnt];
        int fullMask = (1 << cnt) - 1;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc, energy, fullMask});
        visited[sr][sc][energy][fullMask] = true;

        int[] dirs = {-1, 0, 1, 0, -1};
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cur = queue.poll();
                int r = cur[0], c = cur[1], e = cur[2], mask = cur[3];

                if (mask == 0) return moves;
                if (e <= 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dirs[k], nc = c + dirs[k + 1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    char cell = classroom[nr].charAt(nc);
                    if (cell == 'X') continue;

                    int ne = (cell == 'R') ? energy : e - 1;
                    int nMask = mask;
                    if (cell == 'L') nMask &= ~(1 << litterIdx[nr][nc]);

                    if (!visited[nr][nc][ne][nMask]) {
                        visited[nr][nc][ne][nMask] = true;
                        queue.offer(new int[]{nr, nc, ne, nMask});
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
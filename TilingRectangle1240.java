class Solution {
    public int tilingRectangle(int n, int m) {
        // n => rows , m => cols 
        if(n==m) return 1;
        boolean[][] grid = new boolean[n][m];
        Map<String,Integer> mpp = new HashMap<>();
        return solve (grid,mpp);
    }
    public int solve(boolean[][] grid,Map<String,Integer> mpp){
        if(gridOccupied(grid)) return 0;
        String key = gridToString(grid);
        if(mpp.containsKey(key)) return mpp.get(key);
        int[] firstCell = firstCell(grid);
        int sRow = firstCell[0];
        int sCol = firstCell[1];
        int eRow = endRow(grid,sRow,sCol);
        int eCol = endCol(grid,sRow,sCol);
        int mini = Math.min(eRow-sRow+1,eCol-sCol+1);
        int ans = Integer.MAX_VALUE;
        for(int sq = mini ; sq>=1 ; sq--){
            fillGrid(grid,sRow,sCol,sq);
            int usedSquare = 1 + solve(grid,mpp);
            ans = Math.min(ans,usedSquare);
            unFillGrid(grid,sRow,sCol,sq);
        }
        mpp.put(key,ans);
        return ans;

    }
    public String gridToString(boolean[][] grid){
        StringBuilder str = new StringBuilder();
        for(boolean[] row : grid){
            for(boolean cell : row){
                char ch = (cell)?'1':'0';
                str.append(ch);
            }
        }
        return str.toString();
    }
    public void fillGrid(boolean[][] grid, int row, int col, int sq){
        for(int i=row;i<row+sq;i++){
            for(int j=col;j<col+sq;j++){
                grid[i][j] = true;
            }
        }
    }
    public void unFillGrid(boolean[][] grid, int row, int col, int sq){
        for(int i=row;i<row+sq;i++){
            for(int j=col;j<col+sq;j++){
                grid[i][j] = false;
            }
        }
    }
    public boolean gridOccupied(boolean[][] grid){
        for(boolean[] row : grid){
            for(boolean cell : row){
                if(!cell) return false;
            }
        }
        return true;
    }
    public int[] firstCell(boolean[][] grid){
        int[] ans = new int[2];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!grid[i][j]) return new int[]{i,j};
            }
        }
        return ans;
    }
    public int endRow(boolean[][] grid, int row, int col){
        while(row<grid.length){
            if(grid[row][col]) return row-1;
            row++;
        }
        return row-1;
    }
    public int endCol(boolean[][] grid, int row, int col){
        while(col<grid[0].length){
            if(grid[row][col]) return col-1;
            col++;
        }
        return col-1;
    }
}

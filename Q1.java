class Q1
{

	//TESTING - still working on using JUinit - will update as soon as I have used it successfully 
	public static void main(String[] args)
	{
		boolean[] row1 = new boolean[]{false, true, false, true};
		boolean[] row2 = new boolean[]{true, true, false, false};
		boolean[] row3 = new boolean[]{false, false, true, false};
		boolean[] row4 = new boolean[]{false, false, true, false};

		boolean[][] grid = new boolean[][]{row1, row2, row3, row4};

		System.out.println(countIslands(grid.length, grid[0].length, grid));
		
	}




	public static int countIslands(int rows, int columns, boolean[][] grid)
	{
		boolean[][] seen = new boolean[rows][columns];
		int count = 0;

		for(int i = 0; i < rows; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				if(grid[i][j] == true && seen[i][j] == false)
				{
					count = count + 1;
					findConnected(grid, seen, i, j);
				}
			}
		}
		return count;
	}


	private static void findConnected(boolean[][] grid, boolean[][] seen, int rowPos, int colPos)
	{
		int above = colPos - 1;
		int left = rowPos - 1;
		int right = rowPos + 1;
		int bellow = colPos + 1;


		if(left >= 0  &&  grid[left][colPos] == true && seen[left][colPos] == false)
		{
			seen[left][colPos] = true;
			findConnected(grid, seen, left, colPos);
		}

		if(right < grid.length  &&  grid[right][colPos] == true && seen[right][colPos] == false)
		{
			seen[right][colPos] = true;
			findConnected(grid, seen, right, colPos);
		}

		if(above >= 0  &&  grid[rowPos][above] == true && seen[rowPos][above] == false)
		{
			seen[rowPos][above] = true;
			findConnected(grid, seen, rowPos, above);
		}

		if(bellow < grid[0].length  &&  grid[rowPos][bellow] == true && seen[rowPos][bellow] == false)
		{
			seen[rowPos][bellow] = true;
			findConnected(grid, seen, rowPos, bellow);
		}
	}
}



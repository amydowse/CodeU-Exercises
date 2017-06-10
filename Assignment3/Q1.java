import java.util.*;

class Q1
{
	public static void main(String args[])
	{
		char[][] grid = new char[2][3];
		grid[0][0] = 'A';
		grid[0][1] = 'A';
		grid[0][2] = 'R';
		grid[1][0] = 'T';
		grid[1][1] = 'C';
		grid[1][2] = 'D';

		TreeSet<String> answer = findWords(2,3,grid,new Dictionary());

		Iterator it = answer.iterator();

		while(it.hasNext())
		{
			System.out.println(it.next());
		}
	}



	public static TreeSet<String> findWords (int rows, int columns, char[][] grid, Dictionary dictionary)
	{
		TreeSet<String> found = new TreeSet<String>();

		//going through to start at each different letter in the grid 
		for(int i=0; i<rows; i++)			
		{
			for(int j = 0; j<columns; j++)
			{
				//only considers the starting letter if it is a prefix - if it is not the start of any word in the dictionary, there is no point following it 
				if(dictionary.isPrefix(Character.toString(grid[i][j])))
				{
					checkAround(grid, i, j, dictionary, new boolean[rows][columns], Character.toString(grid[i][j]), found);
				}
			}
		}
		return found;
	}


	private static void checkAround(char[][] grid, int row, int column, Dictionary dictionary, boolean[][] visited, String word, TreeSet<String> found)
	{
		visited[row][column] = true;

		//if its a word, add it to the set 
		if(dictionary.isWord(word))
		{
			found.add(word);
		}

		//if a word or a prefix, you want to check neighbours 
		//only want to check the 8 cells around the one you are currently considering 
		for(int x = row -1; x <= row + 1; x++)
		{
			for(int y = column - 1; y <= row + 1; y++)
			{
				//want to make sure the cells are valid - you are not trying to access one that isn't acutally in the grid 
				if(valid(x, y, grid))
				{
					//want to make sure you havent visited that cell before 
					if(visited[x][y] == false)
					{
						//only want to follow that path if it is a prefix
						if(dictionary.isPrefix(word + grid[x][y]))
						{
							word = word + grid[x][y];

							checkAround(grid, x, y, dictionary, visited, word, found);
						}
					}
				}
			}
		}
	}

	//checking if the element is a valid one in the grid 
	private static boolean valid(int x, int y, char[][] grid)
	{
		if(x < grid.length && x > -1)
		{
			if(y < grid[0].length && y >-1)
			{
				return true;
			}
		}
		return false; 
	}
}














//-------------------------------------------------------------------------------------

class Dictionary
{
	String[] words = new String[4];

	public Dictionary()
	{
		words[0] = "CAR";
		words[1] = "CARD";
		words[2] = "CART";
		words[3] = "CAT";
	}

	public boolean isWord(String word)
	{

		for(int i=0; i<words.length; i++)
		{
			if(words[i].equals(word))
			{
				return true;
			}
		}
		return false;
	}


	public boolean isPrefix(String word)
	{
		for(int i=0; i<words.length; i++)
		{
			if(words[i].startsWith(word))
			{
				return true;
			}
		}
		return false;
	}
}
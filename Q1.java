import java.util.*;

class Q1
{
	public static void main(String[] args)
	{
		int[] start = new int[4];
		int[] end = new int[4];

		start[0] = 1;
		start[1] = 2;
		start[2] = 0;
		start[3] = 3;

		end[0] = 3;
		end[1] = 1;
		end[2] = 2;
		end[3] = 0;

		rearrange(start, end);
	}


	public static void rearrange(int[] start, int[] end)
	{
		HashMap<Integer, Integer> positions = calculateMap(start);

		for(int i=0; i<start.length; i++)
		{

			if(start[i] != end[i] || end[i] != 0)
			{
				move0(start, positions, i);

				int wantedCar = end[i];
				int positionOfCar = positions.get(wantedCar);

				//swapping places in array
				start[i] = wantedCar;
				start[positionOfCar] = 0;

				//altering the map
				positions.put(wantedCar, i);
				positions.put(0, positionOfCar);

				System.out.println("swap positions " + i + " and " + positionOfCar);
			}
		}
	}


	//Moves the space to the correct place with each iteration 
	private static void move0 (int[] start, HashMap<Integer, Integer> positions, int i)
	{
		int positionOf0 = positions.get(0);

		if(positionOf0 != i)
		{
			int carToMove = start[i];
			start[i] = 0;
			start[positionOf0] = carToMove;

			positions.put(carToMove, positionOf0);
			positions.put(0,i);

			System.out.println("swap positions " + positionOf0 + " and " + i);
		}
	}



	//HashMap of the positions of the cars
	//Key is the car
	//Value is the position 
	public static HashMap<Integer, Integer> calculateMap(int[] start)
	{
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<start.length; i++)
		{
			for(int j=0; j<start.length; j++)
			{
				if(start[j] == i)
				{
					map.put(start[j], j);
				}
			}
		}

		return map;
	}
}




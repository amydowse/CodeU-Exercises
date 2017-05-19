class Q2
{
	public static void main (String[] args)
	{
		Cell<Integer> C5 = new Cell(5, null);
		Cell<Integer> C4 = new Cell(4, C5);
		Cell<Integer> C3 = new Cell(3, C4);
		Cell<Integer> C2 = new Cell(2, C3);
		Cell<Integer> C1 = new Cell(1, C2);

		try
		{
			System.out.println(kth(C1, 4).first);
		}
		catch (ListTooSmallException e)
		{
			System.out.println("List is too small");
		}
	}

	public static <T> Cell<T> kth (Cell<T> list, int k) throws ListTooSmallException
	{
		int listSize = 0;

		for(Cell<T> ptr = list; ptr.next!=null; ptr=ptr.next)
		{
			listSize = listSize + 1;
		}

		if(listSize < k)
		{
			throw  new ListTooSmallException();
		}
		else
		{
			int goTo = listSize - k;
			int count = 0;
			Cell<T> ptr = list;
			for(; count < goTo; ptr=ptr.next)
			{
				count = count+1;
			}
			return ptr;
		}
	}	
}



class Cell <T>
{
	T first;
	Cell<T> next;

	Cell(T first, Cell<T> next)
	{
		this.first = first;
		this.next = next;
	}
}

class ListTooSmallException extends Exception
{
	ListTooSmallException()
	{
		super();
	}
}
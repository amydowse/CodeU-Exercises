class Q1
{
	public static void main (String[] args)
	{
		System.out.println(perm("Apple", "Pable"));
	}


	public static boolean perm(String str1, String str2)
	{
		if(str1.length() != str2.length())
		{
			return false;
		}
		else
		{
			str1 = str1.toLowerCase();
			str2 = str2.toLowerCase();

			Boolean[] found = new Boolean[str2.length()];

			String[] string1 = str1.split("");
			String[] string2 = str2.split("");

			for(int i=0; i<found.length; i++)
			{
				found[i] = false;
			}

			boolean flag;

			for(int i=0; i < string1.length; i++)
			{
				flag = false;

				for(int j=0; j<string2.length; j++)
				{
					System.out.println("1:	" + string1[i]);
					System.out.println("2:	" + string2[j]);

					if(string1[i].equals(string2[j]) && found[j]==false)
					{
						found[j] = true;
						flag = true;
						break;
					}
				}
				if(!flag)
				{
					return false;
				}
			}
			return true;
		}
	}
}
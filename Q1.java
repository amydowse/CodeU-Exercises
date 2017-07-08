import java.util.*;

class Q1
{
	public static void main(String[] args)
	{
		ArrayList<String> words = new ArrayList<String>();
		words.add("ART");
		words.add("RAT");
		words.add("CAT");
		words.add("CAR");

		printAlphabet(alphabet(words));

	}



	public static ArrayList<Character> alphabet (ArrayList<String> words)
	{
		Map letters = findLetters(words);
		ArrayList<Node> allNodes = createNodes(letters);

		links(words, allNodes);
		return getAlphabet(allNodes);
	}

		

	//getting all of the letters in the language 
	private static Map findLetters(ArrayList<String> words)
	{
		Map letters = new HashMap();

		for(int i=0; i<words.size(); i++)
		{
			for(int j=0; j<words.get(i).length(); j++)
			{
				if(!letters.containsKey(words.get(i).charAt(j)))
				{
					letters.put(words.get(i).charAt(j), false);
				}				
			}
		}
		return letters;
	}
		


	//creating all of the nodes 
	private static ArrayList<Node> createNodes (Map letters)
	{
		Set<Character> allLetters = letters.keySet();

		ArrayList<Node> allNodes = new ArrayList<Node>();

		Iterator<Character> it = allLetters.iterator();

		while(it.hasNext()) 
		{
			ArrayList<Node> successors = new ArrayList<Node>();

	        char letter = it.next();
	        Node letterNode = new Node(letter, successors);
	        allNodes.add(letterNode);
	    }
	    return allNodes;
	}


   	//setting relationships between the nodes 
	private static void links (ArrayList<String> words, ArrayList<Node> allNodes)
	{
		for(int i=0; i<words.size()-1; i++)
		{
			char first = words.get(i).charAt(0);
			char second = words.get(i+1).charAt(0);

			if(first != second)
			{
				Node firstNode = find(allNodes, first);
				Node secondNode = find(allNodes, second);

				firstNode.setSuccessor(secondNode);
				secondNode.addConnection();
			}
			else
			{
				lookDeeper(words.get(i), words.get(i+1), allNodes);
			}
		}
	}


	//dealing with letters other than the first letter of the word 
	private static void lookDeeper(String word1, String word2, ArrayList<Node> allNodes)
	{
		int count = 1;

		while (word1.charAt(count) == word2.charAt(count))
		{
			count++;
		}

		Node firstNode = find(allNodes, word1.charAt(count));
		Node secondNode = find(allNodes, word2.charAt(count));

		firstNode.setSuccessor(secondNode);
		secondNode.addConnection();

		return;
	}

	//getting the node that has the letter you want 
	private static Node find(ArrayList<Node> allNodes, char letter)
	{
		for(int i=0; i<allNodes.size(); i++)
		{
			if(allNodes.get(i).value == letter)
			{
				return allNodes.get(i);
			}
		}
		return null;
	}

]	//getting the alphabet from the graph of nodes you have created
	private static ArrayList<Character> getAlphabet(ArrayList<Node> allNodes)
	{
		ArrayList<Character> alphabet = new ArrayList<Character>();

		while(allNodes.size() !=0)
		{
			for(int i=0; i<allNodes.size(); i++)
			{
				if(allNodes.get(i).getConnections() == 0)
				{
					alphabet.add(allNodes.get(i).value);

					for(int j = 0; j<allNodes.get(i).successors.size(); j++)
					{
						allNodes.get(i).successors.get(j).removeConnection();
					}

					allNodes.remove(i);
				}
			}
		}
		return alphabet;
	}


	private static void printAlphabet(ArrayList<Character> alphabet)
	{
		for(int i=0; i<alphabet.size(); i++)
		{
			System.out.print(alphabet.get(i) + " ");
		}
	}
	
}

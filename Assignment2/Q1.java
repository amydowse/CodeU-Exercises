//The tree created is a binary tree to match the example given but the method does not make any use of binary tree features 

class Q1
{
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree(16);
		tree.add(9);
		tree.add(18);
		tree.add(19);
		tree.add(3);
		tree.add(14);
		tree.add(1);
		tree.add(5);

		System.out.println("OK");

		find(tree, 5);
	}

	public static void find(BinaryTree tree, int valueToFind)
	{
		if (tree.root.value == valueToFind)
		{
			System.out.println(valueToFind + " is the root - it has no ancestors");
		}
		else if(findHelp(tree.root, valueToFind) == 0)
		{
			System.out.println(valueToFind + " is not part of the tree");
		}
	}

	public static int findHelp(Node consider, int valueToFind)
	{
		if(consider == null)
		{
			return 0;
		}
		if(consider.value == valueToFind) //found the value
		{
			return 1;
		}	
		else if(consider.left == null & consider.right == null) //leaf 
		{
			return 0;
		}
		else if(consider.left == null ) //no left node to examine 
		{
			int x = findHelp(consider.right, valueToFind);
			if(x==1)
			{
				System.out.println(consider.value);
			}
			return x;
		}
		else if(consider.right == null) //no right node to examine 
		{
			int x = findHelp(consider.left, valueToFind);
			if (x==1)
			{
				System.out.println(consider.value);
			}
			return x;
		}
		else  //when there are 2 nodes to go 
		{
			int x = findHelp(consider.left, valueToFind);
			int y = findHelp(consider.right, valueToFind);

			if(x==1 || y==1)
			{
				System.out.println(consider.value);
				return 1;
			}
			return 0;
		}

	}//end of method

}//end of class





//BINARY TREE AND NODE CLASSES

class Node
{
	int value;
	Node left = null;
	Node right = null;

	public Node(int value)
	{
		this.value = value;
	}
}

//Implementation is a binary search tree but the method of finding the ancestors will work on just a standard binary tree 
class BinaryTree
{
    Node root = null;

    BinaryTree(int value)
    {
        root = new Node(value);
    }

   	public void add(int value)
    {
        if(root == null)
        {
          	root = new Node(value);
			return; 
		}		

        addHelp(value, root);
    }

	private void addHelp(int value, Node consider) 
	{
		int compare = value - consider.value;
        
        if(compare <= 0)
        {
            if(consider.left == null)
            {
                consider.left = new Node(value);
            }
			else 
			{
                addHelp(value, consider.left);
            }
		}
		else 
		{	
			if(consider.right == null)
			{
				consider.right = new Node(value);
			}
			else 
			{
                addHelp(value, consider.right);
            }
		} 
	}
}
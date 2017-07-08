class Q2
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

		Node x = lowest(tree.root, new Node(19), new Node(4));
		if(x != null)
		{
			System.out.println("COMMOM: " + x.getValue());
		}
		
	}

	//checks if both nodes are actually present in the tree 
	public static Node lowest(Node root, Node p, Node q)
	{
		if(findHelp(root, p.getValue()) != 0 && findHelp(root, q.getValue()) != 0)
		{
			return lowestCommonAncestor(root, p, q);
		}
		else
		{
			System.out.println("Both of the nodes do not exist");
			return null;
		}
	}

	//find the lowest common ancestor (recurviely) 
	public static Node lowestCommonAncestor(Node root, Node p, Node q) 
	{
		if(root==null)
		{
        	return null;
		}
 
    	if(root.getValue()==p.getValue() || root.getValue()==q.getValue())
    	{
        	return root;
        }
 
    	Node l = lowestCommonAncestor(root.left, p, q);
    	Node r = lowestCommonAncestor(root.right, p, q);
 
    	if(l != null && r != null)
    	{
        	return root;
    	}
    	else if(l == null && r == null)
    	{ 
        	return null;
    	}
    	else
    	{
        	return l==null?r:l;
    	}
	}


	//checks if the nodes are actually present 
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
			return findHelp(consider.right, valueToFind);
		}
		else if(consider.right == null) //no right node to examine 
		{
			return findHelp(consider.left, valueToFind);
		}
		else  //when there are 2 nodes to go 
		{
			int x = findHelp(consider.left, valueToFind);
			int y = findHelp(consider.right, valueToFind);

			if(x==1 || y==1)
			{
				return 1;
			}
			return 0;
		}

	}//end of method



	
}





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

	public int getValue()
	{
		return value;
	}
}


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
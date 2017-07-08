import java.util.*;

class Node
{
	char value; 
    List<Node> successors;
    int connections;

	public Node(char value, List<Node> successors)
	{
		this.value = value;
		this.successors = successors;
		connections = 0;
	}

	public void setSuccessor(Node second)
	{
		successors.add(second);
	}

	public void addConnection()
	{
		connections = connections+1;
	}

	public void removeConnection()
	{
		connections = connections-1;
	}

	public int getConnections()
	{
		return connections;
	}
}
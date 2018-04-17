import java.io.*;
import java.util.*;
import java.math.*;

class Node
{
	char ch;
	Node child[],fail;
	public Node()
	{
		ch = ' ';
		child = new Node[10];
	}
}

public class Test
{
	public static void main(String args[])
	{
		Node node = new Node();
		System.out.println(node.child[0]+"\t"+node.child[5]+"\t"+node.fail);
	}
}
import java.io.*;
import java.util.*;
import java.math.*;

class KTNode
{
	char label;
	boolean pattern;
	KTNode child[], fail, parent;

	KTNode()
	{
		label = 'R';
		pattern = false;
		child = new KTNode[10];	
	}

	KTNode(char ch)
	{
		label = ch;
		pattern = false;
		child = new KTNode[10];
	}
}

class KTree
{
	KTNode root;
	int nodeCount;
	KTree()
	{
		nodeCount = 0;
	}

	public void insertPattern(String str, String[] list)
	{
		if(root==null)
		{
			KTNode node = new KTNode();
			nodeCount++;
			root = node;
			root.fail = root;
		}

		KTNode node = root;
		int len = str.length();
		for(int i=0;i<len;i++)
		{
			char ch = str.charAt(i);
			int index = (int)ch - 48;
			if(node.child[index]==null)
			{
				KTNode new_node = new KTNode(ch);
				node.child[index] = new_node;
				new_node.parent = node;
				if(index==2 || index==4 || index==8)
					new_node.pattern=true;
				else if(index==6)
					for(int j=1;j<i;j++)
					{
						String sub = str.substring(j,i+1);
						int l = i+1-j;
						if(sub.equals(list[l]))
						{
							new_node.pattern=true;
							//if(l==3 && j>1)
							//	System.out.println("sub:"+str.substring(j-2,i+1));
						}
					}
				nodeCount++;
				node = new_node;
			}
			else
				node = node.child[index];				
		}
		node.pattern=true;
	}

	public void constructFailureLinks()
	{
		Queue<KTNode> queue = new LinkedList<KTNode>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			KTNode node = queue.remove();
			KTNode parent = node.parent;
			//if(node!=root)
			//	System.out.println("label:"+node.label+"\tparent:"+parent+"\t"+parent.label);
			if(parent!=null)
			{
				KTNode prnt_fail = parent.fail;
				int index = (int)node.label - 48;
				while(prnt_fail.child[index]==null && prnt_fail!=root)
					prnt_fail = prnt_fail.fail;

				if(prnt_fail.child[index]!=null)
					node.fail = prnt_fail.child[index];
				else
					node.fail = root;
			}

			for(int i=0;i<10;i++)
				if(node.child[i]!=null)
					queue.add(node.child[i]);
		}
	}
}

public class TwoTwoKT
{
	public static void main(String args[])
	{
		KTree ktr = new KTree();	
		BigInteger b1 = new BigInteger("2");
		String list[] = new String[242];
		for(int i=0;i<=800;i++)
		{
			BigInteger b2 = b1.pow(i);
			String str = ""+b2;
			int len = str.length();
			int index=(i-1)%4;
			if(index==3)
				list[len]=str;

			ktr.insertPattern(str, list);
		}
		System.out.println(ktr.nodeCount);
		ktr.constructFailureLinks();
		ktr.root.child[0]=ktr.root;

		Scanner sc = new Scanner(System.in);
		int not = sc.nextInt();
		String str = sc.nextLine();
		for(int tc=0;tc<not;tc++)		
		{
			str = sc.nextLine();
			int len = str.length();
			int count=0;
			KTNode node = ktr.root;
			for(int i=0;i<len;i++)
			{
				char ch = str.charAt(i);
				int index = (int)ch - 48;
				if(node.child[index]!=null)
				{
					node = node.child[index];
					System.out.println("ch:"+ch+"\tnode:"+node.label);
					if(node.pattern)
					{				
						count++;
					}
				}
				else
				{
					System.out.println("ch:"+ch+"\tnode:"+node.label+"\t"+node.child[6]+"\t"+node.parent.label+"\t"+node.parent.fail.label);
					node = node.fail;
					System.out.println("ch:"+ch+"\tnode:"+node.label);
					while(node.child[index]==null && node!=ktr.root)
						node = node.fail;

					//System.out.println("node:"+node.label);
					node = node.child[index];
					if(node.pattern)
					{
						//System.out.println("ch:"+ch+"\tnode:"+node);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}
/*This is my implementation of the B+ Tree. It works by giving the commands in the following manner :-

i x :- Insert an element x in the B+ Tree
p :- Prints the B+ Tree
l :- Prints all the Leaf Nodes of the B+ Tree
x :- Destroys the Tree and makes it an empty Tree
s x :- Searches the value x in the Tree
q :- Quits the program

The code uses External Merge Sort for sorting the data and generates the sorted data into a final file named output.txt. 
Upon inserting any value the values is writed in the file input.txt and it creates temporary files within the code and 
deletes them when the file output.txt gets created. */
import java.util.*;
import java.io.*;

public class BPlusTree 
{
	private static final int defaultOrder = 4;
	private static final int minOrder = 3;
	private static final int maxOrder = 10;
	private static Node queue = null;
	private static int order = defaultOrder;
	private static boolean verbose_output = false;
	
	public static void setOrder(int newOrder)
	{
		order = newOrder;
	}
	public static void enqueue(Node newNode)
	{	
		Node temp;
		if(queue == null)
		{
			queue = newNode;
			queue.next = null;
		}
		else
		{
			temp = queue;
			while(temp.next != null)
				temp = temp.next;
			temp.next = newNode;
			newNode.next = null;
		}
	}
	public static Node dequeue()
	{
		Node temp = queue;
		queue = queue.next;
		temp.next = null;
		return temp;
	}
	public static void printLeaves(Node root)
	{
		int i;
		Node temp = root;
		if(root == null)
		{
			System.out.println("Empty Tree");
			return;
		}
		while(!temp.isLeaf)
		{
			temp = (Node)temp.pointers[0];
		}
		while(true)
		{
			for(i = 0; i < temp.numberOfKeys; i++)
			{
				if(verbose_output == true)
					System.out.print(temp.pointers[i] + " ");
				System.out.print(temp.keys.get(i) + " ");
			}
			if(verbose_output == true)
			{
				System.out.print(temp.pointers[order - 1] + " ");
			}
			if(temp.pointers[order - 1] != null)
			{
				System.out.print(" | ");
				temp = (Node)temp.pointers[order - 1];
			}
			else
				break;
		}
		System.out.println();
	}
	public static int height(Node root)
	{
		int h = 0;
		Node temp = root;
		while(!temp.isLeaf)
		{
			temp = (Node)temp.pointers[0];
			h++;
		}
		return h;
	}
	public static int pathRoot(Node root, Node child)
	{
		int length = 0;
		Node temp = child;
		while(temp != root)
		{
			temp = temp.parent;
			length++;
		}
		return length;
	}
	public static void printTree(Node root)
	{
		Node ptr = null;
		int i = 0;
		int rank = 0;
		int nextRank = 0;
		if(root == null)
		{
			System.out.println("Empty Tree");
			return;
		}
		queue = null;
		enqueue(root);
		while(queue != null)
		{
			ptr = dequeue();
			if(ptr.parent != null && ptr == ptr.parent.pointers[0])
			{
				nextRank = pathRoot(root, ptr);
				if(nextRank != rank)
				{
					rank = nextRank;
					System.out.println();
				}
			}
			if(verbose_output == true)
			{
				System.out.print(ptr);
			}
			for(i = 0; i < ptr.numberOfKeys; i++)
			{
				if(verbose_output == true)
					System.out.print(ptr.pointers[0] + " ");
				System.out.print(ptr.keys.get(i) + " ");
			}
			if(!ptr.isLeaf)
			{
				for(i = 0; i <= ptr.numberOfKeys; i++)
					enqueue((Node)ptr.pointers[i]);
			}
			if(verbose_output == true)
			{
				if(ptr.isLeaf == true)
					System.out.print(ptr.pointers[order - 1] + " ");
				else
					System.out.print(ptr.pointers[ptr.numberOfKeys] + " ");
			}
			System.out.print("| ");
		}
		System.out.println();
	}
	public static void findPrint(Node root, int key, boolean verbose)
	{
		Record var = find(root, key, verbose);
		if(var == null)
			System.out.println("Key not found");
		else
			System.out.println("Key found");
	}
	public static Node findLeaf(Node root, int key, boolean verbose)
	{
		int i = 0;
		Node temp = root;
		if(temp == null)
		{
			if(verbose == true)
				System.out.println("Empty Tree");
			return temp;
		}
		while(!temp.isLeaf)
		{
			if(verbose == true)
			{
				System.out.print("[");
				for(i = 0; i < temp.numberOfKeys-1; i++)
					System.out.print(temp.keys.get(i) + " ");
				System.out.print(temp.keys.get(i) + "]");
			}
			i = 0;
			while(i < temp.numberOfKeys)
			{
				if(key >= temp.keys.get(i))
					i++;
				else
					break;
			}
			if(verbose == true)
				System.out.println(i + "->");
			temp = (Node)temp.pointers[i];
		}
		if(verbose == true)
		{
			System.out.print("Leaf [");
			for(i = 0; i < temp.numberOfKeys-1; i++)
				System.out.print(temp.keys.get(i) + " ");
			System.out.println(temp.keys.get(i) + "]");
		}
		return temp;
	}
	public static Record find(Node root, int key, boolean verbose)
	{
		int i = 0;
		Node temp = findLeaf(root, key, verbose);
		if(temp == null)
			return null;
		for(i = 0; i < temp.numberOfKeys; i++)
			if(temp.keys.get(i) == key)
				break;
		if(i == temp.numberOfKeys)
			return null;
		else
			return (Record)temp.pointers[i];
	}
	public static int cut(int length)
	{
		if(length % 2 == 0)
			return length/2;
		else
			return length/2 + 1;
	}
	public static Record makeRecord(int value)
	{
		Record newRecord = new Record();
		if(newRecord == null)
		{
			System.out.println("Record not created");
			System.exit(1);
		}	
		else
			newRecord.value = value;
		return newRecord;
	}
	public static Node makeNode()
	{
		Node newNode = new Node();
		if(newNode == null)
		{
			System.out.println("Node not created");
			System.exit(1);
		}
		newNode.keys = new ArrayList<Integer>(order - 1);
		if(newNode.keys == null)
		{
			System.out.println("Keys Array not created");
			System.exit(1);
		}
		newNode.pointers = new Object[order];
		if(newNode.pointers == null)
		{
			System.out.println("Pointers Array not created");
			System.exit(1);
		}
		newNode.isLeaf = false;
		newNode.next = null;
		newNode.numberOfKeys = 0;
		newNode.parent = null;
		return newNode;
	}
	public static Node makeLeaf()
	{
		Node leaf = makeNode();
		leaf.isLeaf = true;
		return leaf;
	}
	public static int getLeftIndex(Node parent, Node left)
	{
		int left_index = 0;
		while(left_index <= parent.numberOfKeys && parent.pointers[left_index] != left)
			left_index++;
		return left_index;
	}
	public static Node insertIntoLeaf(Node leaf, int key, Record pointer)
	{
		int i, point;
		point = 0;
		while(point < leaf.numberOfKeys && leaf.keys.get(point) < key)
			point++;
		for(i = leaf.numberOfKeys; i > point; i--)
		{
			leaf.keys.add(i, leaf.keys.get(i-1));
			leaf.pointers[i] = leaf.pointers[i-1];
		}
		leaf.keys.add(point, key);
		leaf.pointers[point] = pointer;
		leaf.numberOfKeys++;
		return leaf;	
	}
	public static Node insertIntoLeafSplitting(Node root, Node leaf, int key, Record pointer)
	{
		Node newLeaf;
		int[] tempKeys;
		Object[] tempPointers;
		int index, split, newKey, i, j;
		newLeaf = makeLeaf();
		tempKeys = new int[order];
		if(tempKeys == null)
		{
			System.out.println("Temp Keys Array not created");
			System.exit(1);
		}
		tempPointers = new Object[order];
		if(tempPointers == null)
		{
			System.out.println("Temp Pointers Array not created");
			System.exit(1);
		}
		index = 0;
		while(index < order-1 && leaf.keys.get(index) < key)
			index++;
		for(i = 0, j = 0; i < leaf.numberOfKeys; i++, j++)
		{
			if(j == index)
				j++;
			tempKeys[j] = leaf.keys.get(i);
			tempPointers[j] = leaf.pointers[i];
		}
		tempKeys[index] = key;
		tempPointers[index] = pointer;
		leaf.numberOfKeys = 0;
		split = cut(order - 1);
		for(i = 0; i < split; i++)
		{
			leaf.pointers[i] = tempPointers[i];
			leaf.keys.add(i, tempKeys[i]);
			leaf.numberOfKeys++;
		}
		for(i = split, j = 0; i < order; i++, j++)
		{
			newLeaf.pointers[j] = tempPointers[i];
			newLeaf.keys.add(j, tempKeys[i]);
			newLeaf.numberOfKeys++;
		}
		tempPointers = null;
		tempKeys = null;
		newLeaf.pointers[order-1] = leaf.pointers[order-1];
		leaf.pointers[order-1] = newLeaf;
		for(i = leaf.numberOfKeys; i < order-1; i++)
			leaf.pointers[i] = null;
		for(i = newLeaf.numberOfKeys; i < order-1; i++)
			newLeaf.pointers[i] = null;
		newLeaf.parent = leaf.parent;
		newKey = newLeaf.keys.get(0);
		return insertIntoParent(root, leaf, newKey, newLeaf);
	}
	public static Node insertIntoNode(Node root, Node n, int left_index, int key, Node right)
	{
		int i;
		for(i = n.numberOfKeys; i > left_index; i--)
		{
			n.pointers[i+1] = n.pointers[i];
			n.keys.add(i, n.keys.get(i-1));
		}
		n.pointers[left_index+1] = right;
		n.keys.add(left_index, key);
		n.numberOfKeys++;
		return root;
	}
	public static Node insertIntoNodeSplitting(Node root, Node oldNode, int leftIndex, int key, Node right)
	{
		int i,j,split, kPrime;
		Node newNode, child;
		int[] tempKeys;
		ArrayList<Node> tempPointers;
		tempPointers = new ArrayList<Node>(order+1);
		if(tempPointers == null)
		{
			System.out.println("Temporary Pointers Array not created");
			System.exit(1);
		}
		tempKeys = new int[order];
		if(tempKeys == null)
		{
			System.out.println("Temporary Keys Array not created");
			System.exit(1);
		}
		for(i = 0, j = 0; i < oldNode.numberOfKeys + 1; i++, j++)
		{
			if(j == leftIndex+1)
				j++;
			tempPointers.add(j, (Node)oldNode.pointers[i]);
		}
		for(i = 0, j = 0; i < oldNode.numberOfKeys; i++, j++)
		{
			if(j == leftIndex)
				j++;
			tempKeys[j] = oldNode.keys.get(i);
		}
		tempPointers.add(leftIndex+1, right);
		tempKeys[leftIndex] = key;
		split = cut(order);
		newNode = makeNode();
		oldNode.numberOfKeys = 0;
		for(i = 0; i < split-1; i++)
		{
			oldNode.pointers[i] = tempPointers.get(i);
			oldNode.keys.add(i, tempKeys[i]);
			oldNode.numberOfKeys++;
		}
		oldNode.pointers[i] = tempPointers.get(i);
		kPrime = tempKeys[split-1];
		for(++i, j = 0; i < order; i++, j++)
		{
			newNode.pointers[j] = tempPointers.get(i);
			newNode.keys.add(j, tempKeys[i]);
			newNode.numberOfKeys++;
		}
		newNode.pointers[j] = tempPointers.get(i);
		tempPointers = null;
		tempKeys = null;
		newNode.parent = oldNode.parent;
		for(i = 0; i <= newNode.numberOfKeys; i++)
		{
			child = (Node)newNode.pointers[i];
			child.parent = newNode;
		}
		return insertIntoParent(root, oldNode, kPrime, newNode);
	}
	public static void merge(int[] arr, int l, int m, int r)
	{
		int i,j,k;
		int n1 = m-l+1;
		int n2 = r-m;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(i = 0; i < n1; i++)
			L[i] = arr[l+i];
		for(j = 0; j < n2; j++)
			R[j] = arr[m+1+j];
		i = 0;
		j = 0;
		k = l;
		while(i < n1 && j < n2)
		{
			if(L[i] <= R[j])
				arr[k++] = L[i++];
			else
				arr[k++] = R[j++];
		}
		while(i < n1)
			arr[k++] = L[i++];
		while(j < n2)
			arr[k++] = R[j++];
	}
	public static void mergeSort(int[] arr, int l, int r)
	{
		if(l < r)
		{
			int m = (l + r) / 2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r-1);
			merge(arr, l, m, r);
		}
	}
	public static Node insertIntoParent(Node root, Node left, int key, Node right)
	{
		int leftIndex;
		Node parent;
		parent = left.parent;
		if(parent == null)
			return insertIntoNewRoot(left, key, right);
		leftIndex = getLeftIndex(parent, left);
		if(parent.numberOfKeys < order - 1)
		{
			return insertIntoNode(root, parent, leftIndex, key, right);
		}
		return insertIntoNodeSplitting(root, parent, leftIndex, key, right);
	}
	public static Node insertIntoNewRoot(Node left, int key, Node right)
	{
		Node root = makeNode();
		root.keys.add(0, key);
		root.pointers[0] = left;
		root.pointers[1] = right;
		root.numberOfKeys++;
		root.parent = null;
		left.parent = root;
		right.parent = root;
		return root;
	}
	public static Node startNewTree(int key, Record ptr)
	{
		Node root = makeLeaf();
		root.keys.add(0, key);
		root.pointers[0] = ptr;
		root.pointers[order-1] = null;
		root.parent = null;
		root.numberOfKeys++;
		return root;
	}
	public static Node insert(Node root, int key, int value)
	{
		Record ptr;
		Node leaf;
		if(find(root, key, false) != null)
			return root;
		ptr = makeRecord(value);
		if(root == null)
			return startNewTree(key, ptr);
		leaf = findLeaf(root, key, false);
		if(leaf.numberOfKeys < order - 1)
		{
			leaf = insertIntoLeaf(leaf, key, ptr);
			return root;
		}
		return insertIntoLeafSplitting(root, leaf, key, ptr);
	}
	public static void destroyTreeNodes(Node root)
	{
		int i;
		if(root.isLeaf == true)
			for(i = 0; i < root.numberOfKeys; i++)
				root.pointers[i] = null;
		else
			for(i = 0; i < root.numberOfKeys+1; i++)
				destroyTreeNodes((Node)root.pointers[i]);
		root.pointers = null;
		root.keys = null;
		root = null;
	}
	public static Node destroyTree(Node root)
	{
		destroyTreeNodes(root);
		return null;
	}
	public static long estimateBestSizeOfBlocks(File filetobesorted) 
	{
		long sizeoffile = filetobesorted.length();
		final int MAXTEMPFILES = 1024;
		long blocksize = sizeoffile / MAXTEMPFILES ;
		long freemem = Runtime.getRuntime().freeMemory();
		if( blocksize < freemem/2)
			blocksize = freemem/2;
		else 
		{
			if(blocksize >= freemem) 
				System.err.println("We expect to run out of memory. ");
		}
		return blocksize;
	}
	public static void printFunction(long startTime, long endTime)
	{
		long offset = 10;
		if(endTime - startTime <= 10)
			System.out.println("Time elapsed is " + (endTime-startTime) + "msec");
		else
		{
				long u = endTime-startTime;
				u = u % offset;
				System.out.println("Time elapsed is " + u + "msec");
		}
	}
	public static List<File> sortInBatch(File file, Comparator<String> cmp) throws IOException 
	{
		List<File> files = new ArrayList<File>();
		BufferedReader fbr = new BufferedReader(new FileReader(file));
		long blocksize = estimateBestSizeOfBlocks(file);
		try
		{
			List<String> tmplist = new ArrayList<String>();
			String line = "";
			try 
			{
				while(line != null) 
				{
					long currentblocksize = 0;
					while((currentblocksize < blocksize) && ((line = fbr.readLine()) != null))
					{ 
						tmplist.add(line);
						currentblocksize += line.length();
					}
					files.add(sortAndSave(tmplist,cmp));
					tmplist.clear();
				}
			} 
			catch(EOFException exception) 
			{
				if(tmplist.size() > 0) 
				{
					files.add(sortAndSave(tmplist,cmp));
					tmplist.clear();
				}
			}
		} 
		finally 
		{
			fbr.close();
		}
		return files;
	}
	public static File sortAndSave(List<String> tmplist, Comparator<String> cmp) throws IOException 
	{
		Collections.sort(tmplist,cmp);  
		File newtmpfile = File.createTempFile("sortInBatch", "flatfile");
		newtmpfile.deleteOnExit();
		BufferedWriter fbw = new BufferedWriter(new FileWriter(newtmpfile));
		try 
		{
			for(String r : tmplist) 
			{
				fbw.write(r);
				fbw.newLine();
			}
		}
		finally 
		{
			fbw.close();
		}
		return newtmpfile;
	} 
	public static int mergeSortedFiles(List<File> files, File outputfile, final Comparator<String> cmp) throws IOException 
	{
		PriorityQueue<BinaryFileBuffer> pq = new PriorityQueue<BinaryFileBuffer>(11, new Comparator<BinaryFileBuffer>() 
		{
			public int compare(BinaryFileBuffer i, BinaryFileBuffer j) 
			{
				return cmp.compare(i.peek(), j.peek());
			}
		});
		for (File f : files) 
		{
			BinaryFileBuffer bfb = new BinaryFileBuffer(f);
			pq.add(bfb);
		}
		BufferedWriter fbw = new BufferedWriter(new FileWriter(outputfile));
		int rowcounter = 0;
		try 
		{
			while(pq.size() > 0) 
			{
				BinaryFileBuffer bfb = pq.poll();
				String r = bfb.pop();
				fbw.write(r);
				fbw.newLine();
				++rowcounter;
				if(bfb.empty()) 
				{
					bfb.fbr.close();
					bfb.originalfile.delete();
				} 
				else 
				{
					pq.add(bfb); 
				}
			}
		} 
		finally 
		{ 
			fbw.close();
			for(BinaryFileBuffer bfb : pq ) 
				bfb.close();
		}
		return rowcounter;
	}
	public static void InputReader() throws FileNotFoundException, IOException
	{
		File f = new File("output.txt");
		boolean b = f.delete();
		Scanner s = new Scanner(new File("input.txt"));
		int[] buffer = new int[1000];
		int i = 0;
		while(s.hasNextInt())
			buffer[i++] = s.nextInt();
		mergeSort(buffer, 0, buffer.length-1);
		for(int itr = 0; itr < buffer.length; itr++)
			if(buffer[itr] != 0) 
				FileWrite(buffer[itr]);
		s.close();
	}
	public static void FileWrite(int value) throws IOException
	{
		FileWriter fwrite = new FileWriter("output.txt", true);
		BufferedWriter buff = new BufferedWriter(fwrite);
		buff.write(String.valueOf(value));
		buff.newLine();
		buff.close();
	}
	public static void InputWriter(int value) throws IOException
	{
		FileWriter fwrite = new FileWriter("input.txt", true);
		BufferedWriter buff = new BufferedWriter(fwrite);
		buff.write(String.valueOf(value));
		buff.newLine();
		buff.close();
	}
	public static void externalMergeSort(String inputFile, String outputFile, boolean flag) throws IOException
	{
		if(flag == false)
			externalMergeSortHelper(inputFile, outputFile);
		else
			InputReader();
	}
	public static void externalMergeSortHelper(String inputFile, String outputFile) throws IOException
	{
		Comparator<String> comparator = new Comparator<String>() 
		{
			public int compare(String s1, String s2)
			{
				return s1.compareTo(s2);
			}
		};
		List<File> list = sortInBatch(new File(inputFile), comparator);
		mergeSortedFiles(list, new File(outputFile), comparator);	
	}
	public static void main(String[] args) throws IOException
	{
		Scanner s = new Scanner(System.in);
		Node root = null;
		verbose_output = false;
		System.out.println("Enter the order of the B+ Tree");
		int Order = s.nextInt();
		if(Order < minOrder || Order > maxOrder)
		{
			System.out.println("Invalid Order");
			System.exit(1);
		}
		setOrder(Order);
		char input;
		boolean flag = true;
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		System.out.println("Enter the approach");
		int variable = s.nextInt();
		if(variable == 1)
		{
			while(true)
			{
				input = s.next().charAt(0);
				if(input == 'i')
				{
					long startTime = System.currentTimeMillis();
					int value = s.nextInt();
					InputWriter(value);
					externalMergeSort(inputFile, outputFile, true);
					root = insert(root, value, value);
					printTree(root);
					long endTime = System.currentTimeMillis();
					System.out.println("Time elapsed is " + (endTime-startTime) + "msec");
				}
				else if(input == 's')
				{
					long startTime = System.currentTimeMillis();
					int value = s.nextInt();
					findPrint(root, value, input == 'p');
					long endTime = System.currentTimeMillis();
					System.out.println("Time elapsed is " + (endTime-startTime) + "msec");
				}
				else if(input == 'p')
				{
					long startTime = System.currentTimeMillis();
					printTree(root);
					long endTime = System.currentTimeMillis();
					System.out.println("Time elapsed is " + (endTime-startTime) + "msec");
				}
				else if(input == 'x')
				{
					long startTime = System.currentTimeMillis();
					if(root != null)
					root = destroyTree(root);
					long endTime = System.currentTimeMillis();
					System.out.println("Time elapsed is " + (endTime-startTime) + "msec");
				}
				else if(input == 'l')
				{
					long startTime = System.currentTimeMillis();
					printLeaves(root);
					long endTime = System.currentTimeMillis();
					System.out.println("Time elapsed is " + (endTime-startTime) + "msec");
				}
				else if(input == 'q')
				{
					flag = false;
					break;	
				}
			}
			InputReader();
			if(flag == false)
				System.exit(1);
			s.close();
		}
		else if(variable == 2)
		{
			while(true)
			{
				input = s.next().charAt(0);
				if(input == 'i')
				{
					long startTime = System.currentTimeMillis();
					int value = s.nextInt();
					InputWriter(value);
					externalMergeSort(inputFile, outputFile, true);
					root = insert(root, value, value);
					long endTime = System.currentTimeMillis();
					printFunction(startTime, endTime);
				}
				else if(input == 's')
				{
					long startTime = System.currentTimeMillis();
					int value = s.nextInt();
					findPrint(root, value, input == 'p');
					long endTime = System.currentTimeMillis();
					printFunction(startTime, endTime);
				}
				else if(input == 'p')
				{
					long startTime = System.currentTimeMillis();
					printTree(root);
					long endTime = System.currentTimeMillis();
					printFunction(startTime, endTime);
				}
				else if(input == 'x')
				{
					long startTime = System.currentTimeMillis();
					if(root != null)
					root = destroyTree(root);
					long endTime = System.currentTimeMillis();
					printFunction(startTime, endTime);
				}
				else if(input == 'l')
				{
					long startTime = System.currentTimeMillis();
					printLeaves(root);
					long endTime = System.currentTimeMillis();
					printFunction(startTime, endTime);
				}
				else if(input == 'q')
				{
					flag = false;
					break;	
				}
			}
			InputReader();
			if(flag == false)
				System.exit(1);
			s.close();	
		}	
		else
		{
			System.out.println("Wrong value passed\n");
			System.exit(1);
		}
	}
}
class Node
{
	public ArrayList<Integer> keys;
	public Node parent;
	public boolean isLeaf;
	public int numberOfKeys;
	public Node next;
	public Object[] pointers;

	public Node(int order)
	{
		this.keys = new ArrayList<Integer>(order-1);
		this.parent = null;
		this.next = null;
		this.isLeaf = false;
		this.numberOfKeys = 0;
		this.pointers = new Object[order];
	}
	public Node()
	{
		
	}
}
class Record
{
	int value;
}
class BinaryFileBuffer  
{
	public static int BUFFERSIZE = 2048;
	public BufferedReader fbr;
	public File originalfile;
	private String cache;
	private boolean empty;

	public BinaryFileBuffer(File f) throws IOException 
	{
		originalfile = f;
		fbr = new BufferedReader(new FileReader(f), BUFFERSIZE);
		reload();
	}
	public boolean empty() 
	{
		return empty;
	}
	private void reload() throws IOException
	{
		try
		{
			if((this.cache = fbr.readLine()) == null)
			{
				empty = true;
				cache = null;
			}
			else
			{
				empty = false;
			}
		} 
		catch(EOFException oef) 
		{
			empty = true;
			cache = null;
		}
	}
	public void close() throws IOException
	{
		fbr.close();
	}
	public String peek() 
	{
		if(empty()) 
			return null;
		return cache.toString();
	}
	public String pop() throws IOException 
	{
		String answer = peek();
		reload();
		return answer;
	}
}
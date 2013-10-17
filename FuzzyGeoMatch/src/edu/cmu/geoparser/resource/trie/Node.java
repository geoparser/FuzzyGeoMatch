package edu.cmu.geoparser.resource.trie;

public class Node {

	private char c;
	public Node right, down;
	private long[] ids;// not an location ending, if id is empty.
	
	//sometimes we want to check the trie tree for authentication of the string(it's original form). 
	//for doing this, we store another original string field into the tree at each leaf node.
	//so we don't need to go to the index to look it up.
	
	private String[] OriginalString;//This is for storing original string for checking accent match.
	
	public Node(char c2) {
		// TODO Auto-generated constructor stub
		this.c = c2;
	}

	public boolean containsChild(char c2) {
		// TODO Auto-generated method stub

		if (this.down == null)
			return false;

		Node cur = this.down;
		while (cur != null) {
			if (cur.c == c2)
				return true;
			cur = cur.right;
		}
		return false;
	}

	public void addChildren(Node child) {
		// TODO Auto-generated method stub

		if (this.down == null)
			this.down = (Node) child;
		else {
			Node cur = this.down;
			if (cur.right == null)
				cur.right = (Node) child;
			else {
				Node temp = cur.right;
				cur.right = (Node) child;
				((Node) child).right = temp;
			}
		}
	}

	public Node getChild(char c2) {
		// TODO Auto-generated method stub
		if (this.down == null)
			return null;
		Node cur = this.down;
		while (cur != null) {
			if (cur.c == c2)
				return cur;
			cur = cur.right;
		}
		return null;
	}

	
	public void addValue( long id) {
		// TODO Auto-generated method stub
		if (this.ids == null) {
			this.ids = new long[1];
			this.ids[0] = id;
			//add string
		} else {
			int len = this.ids.length;
			long[] temp = new long[len + 1];
			for (int j = 0; j < len; j++)
				temp[j] = this.ids[j];
			temp[len] = id;
			this.ids = temp;
		}
	}
	
	//this is the id and string value version for add.
	public void addValue( long id, String s) {
		// TODO Auto-generated method stub
		if (this.ids == null) {
			this.ids = new long[1];
			this.ids[0] = id;
			//add string
			this.OriginalString=new String[1];
			this.OriginalString[0]=s;
		} else {
			int len = this.ids.length;
			long[] tempint = new long[len + 1];
			String[] tempstring=new String[len+1];
			for (int j = 0; j < len; j++)
			{	
				tempint[j] = this.ids[j];
				tempstring[j] = this.OriginalString[j];
			}
			tempint[len] = id;
			tempstring[len] =s;
			this.ids = tempint;
			this.OriginalString=tempstring;
		}
	}
	public boolean isChildrenEmpty() {
		// TODO Auto-generated method stub

		if (this.down == null)
			return true;
		else
			return false;
	}

	public boolean isLocation() {
		if (this.ids == null)
			return false;
		else
			return true;
	}

	public long[] getIDValue() {
		return this.ids;
	}
	
	public String[] getStringValue(){
		return this.OriginalString;
	}
	
	public static void main(String argv[]){
		
	}
}

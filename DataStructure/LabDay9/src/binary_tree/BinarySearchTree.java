package binary_tree;



public class BinarySearchTree {
	
	class BTNode
	{
		private int data;
		private BTNode lchild;
		private BTNode rchild;
		
		public BTNode(int data)
		{
			this.data = data; 
		}
	}
	
	private BTNode root;
	
	public void setRoot(int data) {
		this.root = new BTNode(data);
	}

	public BinarySearchTree() {
		root = null;
	}

	public void insert(int data)
	{
		BTNode curr = root;
		BTNode prev = null;
		
		while(curr!=null)
		{
			prev = curr;
			if(data>curr.data)
				curr = curr.rchild;
			else
				curr = curr.lchild;			
		}
		if (prev == null)
		{
			setRoot(data);
			return;
		}
		if (prev.data < data)
			prev.rchild = new BTNode(data);
		else
			prev.lchild = new BTNode(data);
		
	}
	
	private void inorder(BTNode node) {
		if (node == null) {
			return;
		}

		if (node.lchild != null) {
			inorder(node.lchild);
		}
		System.out.println(node.data);
		if (node.rchild != null) {
			inorder(node.rchild);
		}
	}
	public void inorder() {
		inorder(root);
	}
	
	public boolean find(int val )
	{
		return find(root , val);
	}
	
	public boolean find(BTNode node , int val )
	{
		if(node==null)
			return false;
		if(node.data == val)
			return true;
		if(val<node.data)
		{
			if(node.lchild!= null)
				return find(node.lchild , val);
			else return false;
		}
		if(node.rchild!= null)
			return find(node.rchild , val);
		else 
			return false;
		
	}
}


















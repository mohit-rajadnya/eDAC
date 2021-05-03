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
		System.out.print(node.data + " ");
		System.out.println();
		if (node.rchild != null) {
			inorder(node.rchild);
		}
	}
	public void inorder() {
		System.out.println("Inside inorder");
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
	
	public void delete(int val)
	{
		BTNode curr = root;
		BTNode prev = null;
		
		while(curr!=null && curr.data != val)
		{
			prev = curr;
			if(curr.data>val)
				curr = curr.lchild;
			else
				curr = curr.rchild;
		}
		
		if(curr == null)
			return;
		
		while(curr.lchild!=null || curr.rchild!=null)
		{
//			if(curr.lchild==null || curr.rchild==null)
//			{
//				if(curr.lchild!=null)
//				{
//					int temp = curr.data;
//					curr.data = curr.lchild.data;
//					curr.lchild.data = temp;
//				}
//				else
//				{
//					int temp = curr.data;
//					curr.data = curr.rchild.data;
//					curr.rchild.data = temp;
//				}	
//				prev = curr;
//				if(curr.lchild!=null)
//					curr=curr.lchild;				
//				else 
//					curr=curr.rchild;
//					
//			}
//			continue;
			if(curr.lchild==null || curr.rchild==null)
			{
				if(curr==root)
				{
					if(curr.lchild!=null)
					{
						root = root.lchild;
					}
					else
					{
						root = root.rchild;
					}
				}
				
				if(prev.lchild == curr)
				{
					if (curr.lchild != null) {
						prev.lchild = curr.lchild;
					} 
					else {
						prev.lchild = curr.rchild;
					}
				}
				else
				{
					if (curr.lchild != null) {
						prev.rchild = curr.lchild;
					} 
					else {
						prev.rchild = curr.rchild;
					}
				}
				return;
			}
		
			BTNode isNodeParent = curr;
			BTNode isNode = curr.rchild;
			while(isNode.lchild!=null)
			{
				isNodeParent = isNode;
				isNode = isNode.lchild;
			}
			int temp = curr.data;
			curr.data = isNode.data;
			isNode.data = temp;
			curr = isNode;
			prev = isNodeParent;
			continue;
		}
		
		if(curr == root)
			{
				root = null;
				return;
			}
		
		if(curr.lchild == null && curr.rchild==null)
		{
			if(curr == prev.lchild)
				prev.lchild = null;
			else 
				prev.rchild = null;
		}
		
	}
}


















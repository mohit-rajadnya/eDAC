package avl_tree;

public class AVLTree {

	class AVLNode
	{
		private int height;
		private int val;
		private AVLNode lchild;
		private AVLNode rchild;
		
		public AVLNode(int val)
		{
			this.val = val;
		}
		
		@Override
		public String toString()
		{
			return "Value = " + this.val;
		}
	} 
	
	private AVLNode root;
	
	public void insert(int val)
	{
		root = insert(root , val);
	}
	
	private AVLNode insert(AVLNode root , int val)
	{
		//System.out.println("Inside root insert");
		 if(root == null)
			 return new AVLNode(val);
		 
		 if(val<root.val)
			 root.lchild = insert(root.lchild, val);
		 else
			 root.rchild = insert(root.rchild, val);
		 
		 setHeight(root);		 
		 
		 return root = balance(root);
	}
	
	private AVLNode balance(AVLNode root)
	{
		 if(isLeftHeavy(root))
			 {
			 	System.out.println(root.val + " Tree is left heavy");
			 	if(balanceFactor(root.lchild)<0)
			 		root.lchild = leftRotate(root.lchild);
			 	return rightRotate(root);
			 }
		 else if(isRightHeavy(root))
		 {
			 System.out.println(root.val +" Tree is right heavy");
			 if(balanceFactor(root.rchild)>0)
				 root.rchild = rightRotate(root.rchild);
			 return leftRotate(root);
		 }
		return root;	 
	}
	
	private AVLNode leftRotate(AVLNode root)
	{
		AVLNode newRoot = root.rchild;
		
		root.rchild = newRoot.lchild;
		newRoot.lchild = root;
		
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
		
	}
	
	private AVLNode rightRotate(AVLNode root)
	{
		AVLNode newRoot = root.lchild;
		
		root.lchild = newRoot.rchild;
		newRoot.rchild = root;
		
		setHeight(root);
		setHeight(newRoot);
		
		return newRoot;
	}
	
	private void setHeight(AVLNode node)
	{
		node.height = Math.max(height(root.lchild), height(root.rchild))+1;
	}
	
	private boolean isLeftHeavy(AVLNode node)
	{
		return height(node.lchild) - height(node.rchild) > 1; 
	}
	
	private boolean isRightHeavy(AVLNode node)
	{
		return height(node.lchild) - height(node.rchild) < -1;
	}
	
	private int balanceFactor(AVLNode node)
	{
		return (node==null) ? 0 : height(node.lchild) - height(node.rchild);
	}
	
	private int height(AVLNode node)	
	{
		return (node==null) ? -1:node.height;
	}
	
	private void inorder(AVLNode node) {
		if (node == null) {
			return;
		}

		if (node.lchild != null) {
			inorder(node.lchild);
		}
		System.out.print(node.val + " ");
		System.out.println();
		if (node.rchild != null) {
			inorder(node.rchild);
		}
	}
	public void inorder() {
		//System.out.println("Inside inorder");
		inorder(root);
	}
}























package binary_tree;


public class BinaryTree {
	public class BTNode {
		int data;
		BTNode lChild;
		BTNode rChild;
	}

	private BTNode root;

	public BinaryTree() {
		root = null;
	}

	public void createTree() {
		root = new BTNode();
		root.data = 5;
		root.lChild = new BTNode();
		root.rChild = new BTNode();
		root.lChild.data = 3;
		root.rChild.data = 1;
		root.rChild.lChild = new BTNode();
		root.rChild.lChild.data = 9;
	}

	private void inorder(BTNode node) {
		if (node == null) {
			return;
		}

		if (node.lChild != null) {
			inorder(node.lChild);
		}
		System.out.println(node.data);
		if (node.rChild != null) {
			inorder(node.rChild);
		}
	}
	public void inorder() {
		inorder(root);
	}
	
	private void preorder(BTNode node) {
		if(node==null) {
			return;
		}
		
		System.out.println(node.data);
		if(node.lChild!=null)
		{
			preorder(node.lChild);
		}
		if(node.lChild!=null)
		{
			preorder(node.rChild);
		}
	}
	public void preorder() {
		preorder(root);
	}
	
	private void postorder(BTNode node) {
		if(node==null) {
			return;
		}		
		
		if(node.lChild!=null)
		{
			postorder(node.lChild);
		}
		if(node.lChild!=null)
		{
			postorder(node.rChild);
		}
		System.out.println(node.data);
	}
	public void postorder() {
		postorder(root);
	}
}















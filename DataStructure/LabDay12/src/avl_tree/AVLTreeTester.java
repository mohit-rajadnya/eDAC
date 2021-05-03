package avl_tree;

public class AVLTreeTester {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insert(30);
		tree.insert(10);
		tree.insert(20);
		tree.insert(18);
		tree.insert(8);
		
		tree.inorder();


	}

}

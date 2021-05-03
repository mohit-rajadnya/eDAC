package binary_tree_traversal;

public class BinaryTreeApp01 {
	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();

		//System.out.println(bt.find(20));
		bt.insert(20);
		//System.out.println(bt.find(20));
		//System.out.println(bt.find(30));
		bt.insert(21);
		bt.insert(18);
		bt.insert(6);
		//System.out.println(bt.find(25));
		bt.insert(50);
		bt.insert(28);
		bt.insert(19);
		//System.out.println(bt.find(18));
		System.out.println(bt.find(50));
		bt.inorder();
		
	}
}

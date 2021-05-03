package binary_tree;

public class BinaryTreeApp01 {
	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();

		System.out.println(bt.find(20));
		bt.insert(20);
		System.out.println(bt.find(20));
		System.out.println(bt.find(30));
		bt.insert(25);
		bt.insert(18);
		bt.insert(6);
		System.out.println(bt.find(25));
		bt.insert(50);
		System.out.println(bt.find(18));
		System.out.println(bt.find(50));
		bt.inorder();
		
	}
}

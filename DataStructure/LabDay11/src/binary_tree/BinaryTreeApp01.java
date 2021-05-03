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
		bt.insert(120);
		System.out.println("Height of tree" + bt.height());
		System.out.println(bt.find(18));
		System.out.println(bt.find(50));
		bt.inorder();
		bt.delete(18);
		bt.delete(50);
		bt.inorder();
		bt.delete(30);
		bt.delete(20);
		bt.inorder();
		bt.delete(6);
		bt.inorder();
		bt.delete(25);
		bt.inorder();
	}
}

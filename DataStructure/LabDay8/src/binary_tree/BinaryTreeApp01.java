package binary_tree;

public class BinaryTreeApp01 {
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();

		bt.createTree();
		bt.inorder();
		System.out.println();
		
		bt.preorder();
		System.out.println();
		
		bt.postorder();
	}
}

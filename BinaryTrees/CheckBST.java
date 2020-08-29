package bst;

import bst.BST.Node;

/** we can do this using two ways
 * Do In-Order Traversal of the given tree and store the result in a temp array.
 * Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
 * Bcoz inorder traversal gives sorted output  Time Complexity: O(n)
 *
 * iterative solution is some what difficult to understand.
 *
 */
public class CheckBST {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.insertdata(1);
		b1.insertdata(0);
		b1.insertdata(-1);
		b1.insertdata(-2);
		b1.insertdata(3);
		b1.insertdata(2);
		boolean flag = checkbst(b1.root);
		System.out.println(flag);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(usingcomparison(b.root));

	}

	public static boolean checkbst(Node root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.data < min || root.data > max)
			return false;

		return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
	}
	
	//using comparison
		private static boolean usingcomparison(Node node) {
		if (node == null) {
			return true;
		}
		boolean returnvalue = usingcomparison(node.left);
		if (!returnvalue) {
			return false;
		}

		if (prev != null && node.data < prev.data) {
			return false;
		}

		prev = node;

		return usingcomparison(node.right);

	}

}

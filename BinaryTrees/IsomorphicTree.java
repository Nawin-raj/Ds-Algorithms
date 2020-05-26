package bst;

import bst.BST.Node;

/**
 * Two trees are called isomorphic if one of them can be obtained from other by
 * a series of flips, i.e. by swapping left and right children of a number of
 * nodes. Any number of nodes at any level can have their children swapped. Two
 * empty trees are isomorphic.
 *
 */
public class IsomorphicTree {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.insertdata(5);
		b1.insertdata(2);
		b1.insertdata(7);

		BST b2 = new BST();
		b2.insertdata(5);
		b2.insertdata(2);
		b2.insertdata(7);
		System.out.print(isIsomorphic(b1.root, b2.root));

	}

	public static boolean isIsomorphic(Node n1, Node n2) {
		if (n1 == null && n2 == null) {
			return true;
		}
		if (n1 == null || n2 == null) {
			return false;
		}
		if (n1.data != n2.data) {
			return false;
		}
		return (isIsomorphic(n1.left, n2.left) && isIsomorphic(n1.right, n2.right))
				|| (isIsomorphic(n1.left, n2.right) && isIsomorphic(n1.right, n2.left));
	}

}

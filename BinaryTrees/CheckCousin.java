package bst;

import java.util.HashMap;

import bst.BST.Node;

/**
 * Refer this code one more time. In this im storing data in hashmap. We can
 * also solve by storing in another class
 * REFER:https://www.youtube.com/watch?v=XWe_FMfcrR8
 *
 */

public class CheckCousin {
	static int xDepth = 0;
	static int yDepth = 0;
	static int xParent = 0;
	static int yParent = 0;

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.right = new Node(6);
		System.out.print(chechcousin(b1.root, 4, 6));
		System.out.print(chechcousinlessspace(b1.root, 4, 6));

	}

	/**
	 * Copied from leetcode
	 */
	public static boolean chechcousinlessspace(Node root, int x, int y) {
		if (root == null)
			return true;
		getDepthAndParent(root, x, y, 0);
		return xDepth == yDepth && xParent != yParent;
	}

	public static void getDepthAndParent(Node root, int x, int y, int depth) {
		// using pre-order traversal, root, left, right
		if (root == null)
			return;
		if (root.left != null) {
			if (root.left.data == x)
				xParent = root.data;
			if (root.left.data == y)
				yParent = root.data;
		}
		if (root.right != null) {
			if (root.right.data == x)
				xParent = root.data;
			if (root.right.data == y)
				yParent = root.data;
		}

		if (root.data == x)
			xDepth = depth;
		if (root.data == y)
			yDepth = depth;
		getDepthAndParent(root.left, x, y, depth + 1);
		getDepthAndParent(root.right, x, y, depth + 1);
	}

	/**
	 * solved by own
	 */
	public static boolean chechcousin(Node root, int a, int b) {
		HashMap<Integer, Integer> map = new HashMap();
		getparentandlevel(root, a, root, 0, map);
		getparentandlevel(root, b, root, 0, map);
		if (map.size() == 1)
			return true;
		else
			return false;

	}

	public static void getparentandlevel(Node root, int val, Node parent, int level, HashMap<Integer, Integer> map) {
		if (root == null)
			return;
		if (root.data == val) {
			if (!map.containsKey(level) && !map.containsValue(parent.data)) {
				map.put(level, parent.data);
				return;
			}

			if (map.containsKey(level) && !map.containsKey(parent.data)) {
				map.put(level, parent.data);
			}
			if (map.containsKey(level) && map.containsKey(parent.data)) {
				map.put(level + 1, parent.data + 1);
			}
		}

		getparentandlevel(root.left, val, root, level + 1, map);
		getparentandlevel(root.right, val, root, level + 1, map);
	}

}

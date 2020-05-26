package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import bst.BST.Node;

/**
 * Print diagonal elements and also their sum Recursive solution in this we are
 * using treemap to store nodes along with distance. {0=[10, 2, 2], 1=[8, 6],
 * 2=[3]} horizontal distane for root is 0 for left is root distance+1 and right
 * is same as root
 *
 * In Iterative solution we are using queue Refer Vivekanand Khyade -
 * Algorithm_Every Day pending Refer GFG
 */
public class DiagonalTree {

	public static void main(String[] args) {
		BST b = new BST();
		b.root = new Node(10);
		b.root.left = new Node(8);
		b.root.right = new Node(2);
		b.root.left.left = new Node(3);
		b.root.left.right = new Node(6);
		b.root.right.right = new Node(2);
		Map<Integer, ArrayList<Integer>> map = new TreeMap();
		int hd = 0;
		for (int i = 0; i < map.size(); i++) {
			map.get(i).forEach(x -> System.out.print(x + " "));
		}
		// printdiagonaliterative(b.root);
		diagonalsum(b.root);
	}

	// not working fine please check
	public static void diagonalsum(Node root) {
		int sum = 0;
		if (root == null)
			return;
		Queue<Node> q = new LinkedList();
		q.offer(root);
		// add delimiter
		q.offer(null);
		while (!q.isEmpty()) {
			root = q.poll();

			// if current is delimiter then insert another
			// for next diagonal and cout nextline
			if (root == null) {
				System.out.print(sum + " ");

				if (q.isEmpty()) {
					return;
				}
				// add delimiter again
				q.add(null);
				root = q.poll();
			}
			sum = 0;

			while (root != null) {
				sum = sum + root.data;
				if (root.left != null)
					q.offer(root.left);
				root = root.right;
			}
		}
	}

	public static void printdiagonaliterative(Node root) {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList();
		q.offer(root);
		// add delimiter
		q.offer(null);
		while (!q.isEmpty()) {
			root = q.poll();

			// if current is delimiter then insert another
			// for next diagonal and cout nextline
			if (root == null) {

				if (q.isEmpty()) {
					return;
				}
				System.out.println();
				// add delimiter again
				q.add(null);
			}

			while (root != null) {
				if (root.left != null)
					q.offer(root.left);
				System.out.print(root.data + "	");
				root = root.right;

			}
		}

	}

	public static void printdiagonal(Node root, Map<Integer, ArrayList<Integer>> map, int hd) {
		if (root == null)
			return;
		ArrayList<Integer> list = map.get(hd);
		if (list == null) {
			list = new ArrayList();
			list.add(root.data);
		} else {
			int ele = list.get(0);
			list.remove(0);
			// here u are adding single number i.e u are doing addition
			list.add(ele + root.data);
		}
		map.put(hd, list);
		printdiagonal(root.left, map, hd + 1);
		printdiagonal(root.right, map, hd);

	}

}

package bst;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

import bst.BST.Node;
//refer once
public class VerticalOrderBst {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.right = new Node(6);
		int hd = 0;
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap();
		vertialorder(b1.root, hd, map);
		System.out.println(map);

		// Top view of binary tree code in this print only first elements of
		// list
		Collection<ArrayList<Integer>> a = map.values();
		for (ArrayList aa : a) {
			System.out.print(aa.get(0));
			// aa.size();
		}
		System.out.println();

//		Collection<ArrayList<Integer>> ab = map.values();
//		for (ArrayList aa : a) {
//			// System.out.println("Size"+aa.size()+"");
//			System.out.print(aa.get(aa.size() - 1));
//			// aa.size();
//		}

	}

	public static void vertialorder(Node root, int hd, TreeMap<Integer, ArrayList<Integer>> map) {
		if (root == null)
			return;

		if (map.get(hd) == null) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(root.data);
			map.put(hd, l);
		} else {
			ArrayList<Integer> l = map.get(hd);
			l.add(root.data);
			map.put(hd, l);
		}

		vertialorder(root.left, hd - 1, map);
		vertialorder(root.right, hd + 1, map);                                      
                                          
	}

}

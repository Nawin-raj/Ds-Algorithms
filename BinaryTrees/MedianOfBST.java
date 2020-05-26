package bst;

import java.util.ArrayList;

import bst.BST.Node;
//Refer GFG
public class MedianOfBST {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.insertdata(19);
		b1.insertdata(10);
		b1.insertdata(24);
		b1.insertdata(7);
		b1.insertdata(12);
		float median = 0;
		ArrayList<Integer> list = new ArrayList();
		findmedian(b1.root, list);
		System.out.print(list);
		int size = list.size();
		if (size % 2 != 0) {
			median = list.get(size / 2);
		}
		if (size % 2 == 0) {
			median = (list.get(size / 2) + list.get((size / 2)-1))/2;
		}
		System.out.print(median);

	}

	public static void findmedian(Node root, ArrayList<Integer> list) {
		if (root == null)
			return;
		findmedian(root.left, list);
		list.add(root.data);
		findmedian(root.right, list);
	}

}

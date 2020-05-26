package bst;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import bst.BST.Node;

//one approch done   //it is  better if we do second one
public class GetVerticalSum {

	public static void main(String[] args) {
		BST b = new BST();
		b.insertdata(5);
		b.insertdata(2);
		b.insertdata(7);
		b.insertdata(6);
		b.insertdata(8);
		b.insertdata(1);
		b.insertdata(3);
		Map<Integer, Integer> map = new TreeMap();
		int hd = 0;
		sum(b.root, map, hd);
		map.values().forEach(x -> System.out.print(x + " "));

	}

	private static void sum(Node root, Map<Integer, Integer> map, int hd) {
		if (root == null) {
			return;
		}
		if (map.get(hd) == null) {
			map.put(hd, root.data);
		} else {
			map.put(hd, (map.get(hd) + root.data));
		}
		sum(root.left, map, hd - 1);
		sum(root.right, map, hd + 1);
	}

}

package bst;

import bst.BST.Node;
import bst.Heightofbst;

//max number of nodes between any to leaf nodes
//debug this once
//not	perfect
public class DiameterOfBst {

	public static void main(String[] args) {
		BST b1 = new BST();
		b1.root = new Node(1);
		b1.root.left = new Node(2);
		b1.root.right = new Node(3);
		b1.root.left.left = new Node(4);
		b1.root.left.right = new Node(5);
		b1.root.right.right = new Node(6);
		int dia = diameter(b1.root);
		System.out.println(dia);
	}

	public static int diameter(Node root) {
		if (root == null)
			return 0;
		int lefth = Heightofbst.heightofbst(root.left);
		int righth = Heightofbst.heightofbst(root.right);
		int leftdia = diameter(root.left);
		int rightdia = diameter(root.right);
		return Math.max((lefth + righth + 1), Math.max(leftdia, rightdia));

	}

}

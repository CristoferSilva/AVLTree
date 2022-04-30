package classes.AVLTree;

import classes.BinarySearchTree.Node;

public class AVLNode<Key extends Comparable <Key>, Value> extends Node<Key, Value> {

	private int balanceFactor;
	
	public AVLNode(Key key, Value value, int size) {
		super(key, value, size);
	}

}


package classes.BinarySearchTree;

import interfaces.INode;

public class Node <Key extends Comparable <Key>, Value> implements INode<Key, Value>{
	
	private Key key;
	private int size;
	private Value value;
	private Node <Key, Value> left;
	private Node <Key, Value> right;
	
	
	public Node(Key key, Value value, int size) {
		this.key = key;
		this.value = value;
		this.size = size;
	}
	@Override
	public Key getKey() {
		return this.key;
	}
	@Override
	public void setKey(Key key) {
		this.key = key;
	}
	@Override
	public Value getValue() {
		return this.value;
	}
	@Override
	public void setValue(Value value) {
		this.value = value;
	}
	@Override
	public Node<Key, Value> getLeft() {
		return this.left;
	}
	@Override
	public void setLeft(INode<Key, Value> left) {
		this.left = (Node<Key, Value>)left;
	}
	@Override
	public Node<Key, Value> getRight() {
		return this.right;
	}
	@Override
	public void setRight(INode<Key, Value> right) {
		this.right = (Node<Key, Value>)right;
	}
	@Override
	public int getSize() {
		int leftSize = 0;
		int rightSize = 0;
		if(left == null && right != null) {
			leftSize = 0;
			rightSize = right.getSize();
		} else if(right == null && left != null) {
			leftSize = left.getSize();
			rightSize = 0;
		}
		this.size = leftSize + rightSize + 1;
		return this.size;
	}
	@Override
	public void setSize(int size) {
		this.size = size;
	}
	
}

package classes.BinarySearchTree;

import interfaces.INode;

public class Node <Key extends Comparable <Key>, Value> implements INode<Key, Value>{
	
	private Key key;
	private Value value;
	private Node <Key, Value> left;
	private Node <Key, Value> right;
	private int size;
	
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
		this.left = (Node)left;
	}
	@Override
	public Node<Key, Value> getRight() {
		return this.right;
	}
	@Override
	public void setRight(INode<Key, Value> right) {
		this.right = (Node)right;
	}
	@Override
	public int getSize() {
		return this.size;
	}
	@Override
	public void setSize(int size) {
		this.size = size;
	}
	
}

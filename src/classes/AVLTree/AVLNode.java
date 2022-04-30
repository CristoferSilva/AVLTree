package classes.AVLTree;

import interfaces.IAVLNode;
import interfaces.INode;

public class AVLNode<Key extends Comparable <Key>, Value> implements IAVLNode<Key, Value> {

	private Key key;
	private Value value;
	private int balanceFactor, size;
	private AVLNode <Key, Value> left, right;

	
	public AVLNode(Key key, Value value, int size) {
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
	public AVLNode<Key, Value> getLeft() {
		return this.left;
	}
	@Override
	public void setLeft(INode<Key, Value> left) {
		this.left = (AVLNode)left;
	}
	@Override
	public AVLNode<Key, Value> getRight() {
		return this.right;
	}
	@Override
	public void setRight(INode<Key, Value> right) {
		this.right = (AVLNode)right;
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

	@Override
	public int getBalanceFactor() {
		int nodeRightHeight = 0;
		int nodeLeftHeight = 0;
		if (left == null && right == null) {
			return 0;
		}
		else if(left == null && right != null) {
			nodeLeftHeight = 0;
			nodeRightHeight = right.getSize();
		} else if(right == null && left != null) {
			nodeLeftHeight = left.getSize();
			nodeRightHeight = 0;
		}
		this.balanceFactor = nodeRightHeight - nodeLeftHeight;
		return this.balanceFactor;
	}
	public AVLNode<Key, Value> getFather() {
		return null;
	}

}


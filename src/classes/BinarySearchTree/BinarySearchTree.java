package classes.BinarySearchTree;

import interfaces.IBinarySearchTree;

public class BinarySearchTree<Key extends Comparable <Key>, Value>  implements IBinarySearchTree<Key, Value>{
	
	private Node<Key, Value> root;
	@Override
	public Value get(Key key) {
		return this.get(this.root, key);
	}
	
	private Value get(Node<Key, Value> x, Key key){
		if (x == null) {
			return null;
		}
		int compareResult = key.compareTo(x.getKey());
		
		if (compareResult < 0) {
			return this.get(x.getLeft(), key);
		} else if (compareResult > 0) {
			return this.get(x.getRight(), key);
		} else {
			return x.getValue();
		}
	}
	@Override
	public int size() {
		return this.size(this.root);
	}
	
	private int size(Node <Key, Value> x) {
		if (x == null) {
			return 0;
		} else {
			return x.getSize();
		}
	}
	@Override
	public void put(Key key, Value value) {
		this.root = this.put(this.root, value, key);
	}
	
	private Node<Key, Value> put(Node<Key, Value> x, Value value, Key key){
		if (x == null) {
			return new Node<Key, Value>(key, value, 1);
		}
		int compareResult = key.compareTo(x.getKey());
		
		if (compareResult < 0) {
			Node<Key, Value> leftNode = this.put(x.getLeft(), value, key);
			x.setLeft(leftNode);
		} else if (compareResult > 0) {
			Node<Key, Value> rightNode = this.put(x.getRight(), value, key);
			x.setRight(rightNode);
		} else {
			x.setValue(value);
		}
		
		int newSize = this.size(x.getLeft()) + this.size(x.getRight()) + 1;
		x.setSize(newSize);
		return x;
	}
	@Override
	public void delete(Key key) {
		this.delete(this.root, key);
	}
	
	private Node<Key, Value> delete(Node<Key, Value> x, Key key) {
		if (x == null) {
			return null;
		}
		if(this.root.getKey().compareTo(key) == 0) {
			this.root.getRight().setLeft(this.root.getLeft());
			this.root = this.root.getRight();
			return null;
		}
		
		int minCompareResult = key.compareTo(min());
		int maxCompareResult = key.compareTo(max());
		
		if (minCompareResult == 0) {
			 deleteMin(x);
		} else if(maxCompareResult == 0) {
			 deleteMax(x);
		} else {
			int compareResult = key.compareTo(x.getKey());
			
			if (compareResult < 0) {
				Node<Key, Value> leftNode = this.delete(x.getLeft(), key);
				x.setLeft(leftNode);
			} else if (compareResult > 0) {
				Node<Key, Value> rightNode = this.delete(x.getRight(), key);
				x.setRight(rightNode);
			} else {
				Node<Key, Value> minNode = x.getRight().getLeft();
				minNode.setLeft(x.getLeft());
				x.getRight().setLeft(minNode.getRight());
				minNode.setRight(x.getRight());
				return minNode;
			}
		}
		
		int newSize = this.size(x.getLeft()) + this.size(x.getRight()) + 1;
		x.setSize(newSize);
		return x;
	}
	@Override
	public Key min() {
		return this.min(this.root);
	}
	
	private Key min(Node<Key, Value> x) {
		Key minSubTree = x.getKey();
		if (x.getLeft() != null) {
			minSubTree = this.min(x.getLeft());
		}
		return minSubTree;
	}
	@Override
	public Key max() {
		return this.max(this.root);
	}
	
	private Key max(Node<Key, Value> x) {
		Key maxSubTree = x.getKey();
		if (x.getRight() != null) {
			maxSubTree = this.max(x.getRight());
		}
		return maxSubTree;
	}
	
	private Node<Key, Value> deleteMin(Node<Key, Value> x){
		if (x.getLeft() == null) {
			return x.getRight();
		}
		Node<Key, Value> leftNode = deleteMin(x.getLeft());
		x.setLeft(leftNode);
		
		int newSize = this.size(x.getLeft()) + this.size(x.getRight()) + 1;
		x.setSize(newSize);
		return x;
	}
	
	private Node<Key, Value> deleteMax(Node<Key, Value> x){
		if (x.getRight() == null) {
			return x.getLeft();
		}
		Node<Key, Value> rightNode = deleteMax(x.getRight());
		x.setRight(rightNode);
		
		int newSize = this.size(x.getLeft()) + this.size(x.getRight()) + 1;
		x.setSize(newSize);
		return x;
	}
	@Override
	public Node<Key, Value> getRoot() {
		return this.root;
	}
	
}

package classes.AVLTree;

import interfaces.IAVlTree;

public class AVLTree<Key extends Comparable<Key>, Value> implements IAVlTree<Key, Value> {

	private AVLNode<Key, Value> root;

	@Override
	public int size() {
		return this.size(this.root);
	}

	private int size(AVLNode<Key, Value> x) {
		if (x == null) {
			return 0;
		} else {
			return x.getSize();
		}
	}

	@Override
	public void put(Key key, Value value) {
		this.root = this.put(this.root, value, key);
		ensureBalance(key);
	}

	private AVLNode<Key, Value> put(AVLNode<Key, Value> x, Value value, Key key) {
		if (x == null) {
			return new AVLNode<Key, Value>(key, value, 1);
		}
		int compareResult = key.compareTo(x.getKey());

		if (compareResult < 0) {
			AVLNode<Key, Value> leftNode = this.put(x.getLeft(), value, key);
			x.setLeft(leftNode);
		} else if (compareResult > 0) {
			AVLNode<Key, Value> rightNode = this.put(x.getRight(), value, key);
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

	private AVLNode<Key, Value> delete(AVLNode<Key, Value> x, Key key) {
		if (x == null) {
			return null;
		}
		if (this.root.getKey().compareTo(key) == 0) {
			this.root.getRight().setLeft(this.root.getLeft());
			this.root = this.root.getRight();
			return null;
		}

		int minCompareResult = key.compareTo(min());
		int maxCompareResult = key.compareTo(max());

		if (minCompareResult == 0) {
			ensureBalance(min()); // -1 indica esquerda
			deleteMin(x);
		} else if (maxCompareResult == 0) {
			ensureBalance(max()); // +1 indica direita
			deleteMax(x);
		} else {
			int compareResult = key.compareTo(x.getKey());

			if (compareResult < 0) {
				AVLNode<Key, Value> leftNode = this.delete(x.getLeft(), key);
				x.setLeft(leftNode);
			} else if (compareResult > 0) {
				AVLNode<Key, Value> rightNode = this.delete(x.getRight(), key);
				x.setRight(rightNode);
			} else {
				AVLNode<Key, Value> minNode = x.getRight().getLeft();
				minNode.setLeft(x.getLeft());
				x.getRight().setLeft(minNode.getRight());
				minNode.setRight(x.getRight());
				ensureBalance(minNode.getKey());
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

	private Key min(AVLNode<Key, Value> x) {
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

	private Key max(AVLNode<Key, Value> x) {
		Key maxSubTree = x.getKey();
		if (x.getRight() != null) {
			maxSubTree = this.max(x.getRight());
		}
		return maxSubTree;
	}

	private AVLNode<Key, Value> deleteMin(AVLNode<Key, Value> x) {
		if (x.getLeft() == null) {
			return x.getRight();
		}
		AVLNode<Key, Value> leftNode = deleteMin(x.getLeft());
		x.setLeft(leftNode);

		int newSize = this.size(x.getLeft()) + this.size(x.getRight()) + 1;
		x.setSize(newSize);
		return x;
	}

	private AVLNode<Key, Value> deleteMax(AVLNode<Key, Value> x) {
		if (x.getRight() == null) {
			return x.getLeft();
		}
		AVLNode<Key, Value> rightNode = deleteMax(x.getRight());
		x.setRight(rightNode);

		int newSize = this.size(x.getLeft()) + this.size(x.getRight()) + 1;
		x.setSize(newSize);
		return x;
	}

	@Override
	public AVLNode<Key, Value> getRoot() {
		return this.root;
	}

	// Métodos criados para AVL começa aqui

	private void ensureBalance(Key key) {
		AVLNode<Key, Value> unbalancedNode = getUnbalancedNode(key);
		int unbalancedNodeBalanceFactor;
		if (unbalancedNode == null)
			return;

		unbalancedNodeBalanceFactor = unbalancedNode.getBalanceFactor();
		if (unbalancedNodeBalanceFactor > 0 && unbalancedNode.getRight().getBalanceFactor() > 0) {
			rightRightRotation(unbalancedNode);
		} else if (unbalancedNodeBalanceFactor > 0 && unbalancedNode.getRight().getBalanceFactor() < 0) {
			rightLeftRotation(unbalancedNode);
		} else if (unbalancedNodeBalanceFactor < 0 && unbalancedNode.getLeft().getBalanceFactor() < 0) {
			leftLeftRotation(unbalancedNode);
		} else if (unbalancedNodeBalanceFactor < 0 && unbalancedNode.getLeft().getBalanceFactor() > 0) {
			leftRightRotation(unbalancedNode);
		}
	}

	@Override
	public AVLNode<Key, Value> get(Key key) {
		return this.get(this.root, key);
	}

	private AVLNode<Key, Value> get(AVLNode<Key, Value> x, Key key) {
		if (x == null) {
			return null;
		}
		int compareResult = key.compareTo(x.getKey());

		if (compareResult < 0) {
			return this.get(x.getLeft(), key);
		} else if (compareResult > 0) {
			return this.get(x.getRight(), key);
		} else {
			return x;
		}
	}

	public AVLNode<Key, Value> getUnbalancedNode(Key key) {
		return this.getUnbalancedNode(this.root, key, null);
	}

	private AVLNode<Key, Value> getUnbalancedNode(AVLNode<Key, Value> x, Key key,
			AVLNode<Key, Value> lastUnbalancedNODE) {
		if (x == null) {
			return null;
		}

		int compareResult = key.compareTo(x.getKey());
		int xBalanceFactor = x.getBalanceFactor();

		if (compareResult < 0) {
			if (xBalanceFactor < -1 || xBalanceFactor > 1) {
				return this.getUnbalancedNode(x.getLeft(), key, x);
			} else if (lastUnbalancedNODE != null) {
				return this.getUnbalancedNode(x.getLeft(), key, lastUnbalancedNODE);
			}
			return this.getUnbalancedNode(x.getLeft(), key, null);
		} else if (compareResult > 0) {
			if (xBalanceFactor < -1 || xBalanceFactor > 1) {
				return this.getUnbalancedNode(x.getRight(), key, x);
			} else if (lastUnbalancedNODE != null) {
				return this.getUnbalancedNode(x.getLeft(), key, lastUnbalancedNODE);
			}
			return this.getUnbalancedNode(x.getRight(), key, null);
		}

		if (xBalanceFactor < -1 || xBalanceFactor > 1)
			return x;

		return lastUnbalancedNODE;

	}

	public AVLNode<Key, Value> getFather(Key key) {
		return this.getfather(this.root, key);
	}

	private AVLNode<Key, Value> getfather(AVLNode<Key, Value> x, Key key) {
		if (x == null) {
			return null;
		}
		int compareResult = key.compareTo(x.getKey());

		if (compareResult < 0) {
			if (x.getLeft().getKey().equals(key)) {
				return x;
			}
			return this.get(x.getLeft(), key);
		} else if (compareResult > 0) {
			if (x.getRight().getKey().equals(key)) {
				return x;
			}
			return this.get(x.getRight(), key);
		}

		return null;

	}

	private void rightRightRotation(AVLNode<Key, Value> unbalancedNode) {

	}

	private void leftLeftRotation(AVLNode<Key, Value> unbalancedNode) {
		AVLNode<Key, Value> leftSon = unbalancedNode.getLeft();
		AVLNode<Key, Value> unbalancedNodeFather = getFather(unbalancedNode.getKey());
		AVLNode<Key, Value> leftSonRightSubTree = leftSon.getRight();

		unbalancedNode.setLeft(leftSonRightSubTree);
		leftSon.setRight(unbalancedNode);

		if (unbalancedNodeFather != null) {
			unbalancedNodeFather.setLeft(leftSon);
		}
		if (unbalancedNode.getKey().compareTo(this.getRoot().getKey()) == 0) {
			this.root = leftSon;
		}
	}

	private void rightLeftRotation(AVLNode<Key, Value> unbalancedNode) {

	}

	private void leftRightRotation(AVLNode<Key, Value> unbalancedNode) {

	}
}

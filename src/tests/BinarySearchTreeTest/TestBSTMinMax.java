package tests.BinarySearchTreeTest;

import org.junit.Assert;
import org.junit.Test;

import classes.BinarySearchTree.BinarySearchTree;

/**
 * The BinarySearchTree tests were implemented by Professor Diego Pinheiro in the ED1 Subject
 */

public class TestBSTMinMax {
	
	@Test
	public void testMinTree() {
		BinarySearchTree<Integer, String> myBinarySearchTree = getBST();

		int expected = 2;
		int actual = myBinarySearchTree.min();
		Assert.assertEquals(expected, actual);
	}

	
	
	@Test
	public void testMaxTree() {
		BinarySearchTree<Integer, String> myBinarySearchTree = getBST();

		int expected = 8;
		int actual = myBinarySearchTree.max();
		Assert.assertEquals(expected, actual);
	}
	
	private BinarySearchTree<Integer, String> getBST() {
		BinarySearchTree<Integer, String> myBinarySearchTree = new BinarySearchTree<>();
		int[] keys = {5,3,8,2,7};
		for(int key : keys) {
			myBinarySearchTree.put(key, String.valueOf(key));	
		}
		return myBinarySearchTree;
	}
}


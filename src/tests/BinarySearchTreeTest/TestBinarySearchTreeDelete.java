package tests.BinarySearchTreeTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import classes.BinarySearchTree.BinarySearchTree;
import classes.BinarySearchTree.BinaryTreeWalker;

/**
 * The BinarySearchTree tests were implemented by Professor Diego Pinheiro in the ED1 Subject
 */

public class TestBinarySearchTreeDelete {
	
	@Test
	public void deleteMin() {
		BinarySearchTree<String, Integer> bst = createBST();
		BinaryTreeWalker<String, Integer> walker = new BinaryTreeWalker<>(bst);
		bst.delete("A");
		
		List<String> actual = walker.inOrder();
		String[] expected = {"C","E","H","M","R","S","X"};
		Assert.assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void deleteMax() {
		BinarySearchTree<String, Integer> bst = createBST();
		BinaryTreeWalker<String, Integer> walker = new BinaryTreeWalker<>(bst);
		bst.delete("X");
		
		List<String> actual = walker.inOrder();
		String[] expected = {"A", "C","E","H","M","R","S"};
		Assert.assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void deleteRoot() {
		BinarySearchTree<String, Integer> bst = createBST();
		BinaryTreeWalker<String, Integer> walker = new BinaryTreeWalker<>(bst);
		bst.delete("S");
		
		List<String> actual = walker.inOrder();
		String[] expected = {"A", "C","E","H","M","R","X"};
		Assert.assertArrayEquals(expected, actual.toArray());
	}
	
	@Test
	public void deleteInternal() {
		BinarySearchTree<String, Integer> bst = createBST();
		BinaryTreeWalker<String, Integer> walker = new BinaryTreeWalker<>(bst);
		bst.delete("E");
		
		List<String> actual = walker.inOrder();
		String[] expected = {"A","C","H","M","R","S","X"};
		Assert.assertArrayEquals(expected, actual.toArray());
	}
	
	private BinarySearchTree<String, Integer> createBST() {
		BinarySearchTree<String, Integer> bst = new BinarySearchTree<String, Integer>();
		bst.put("S", 1);

		bst.put("X", 2);
		bst.put("E", 3);
		
		bst.put("A", 4);
		bst.put("R", 5);
		
		bst.put("C", 6);
		bst.put("H", 7);
		
		bst.put("M", 8);
		return bst;
	}
}


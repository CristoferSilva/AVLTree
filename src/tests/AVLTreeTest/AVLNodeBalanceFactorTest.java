package tests.AVLTreeTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import classes.AVLTree.AVLNode;
import interfaces.IAVLNode;


public class AVLNodeBalanceFactorTest {
    @Test
    public void testGetBalanceFactorJustANode() {
        IAVLNode<Integer, String> avlNode = new AVLNode<Integer, String>(5, "a", 0);
        assertEquals(0, avlNode.getBalanceFactor());
    }

    @Test
    public void testGetBalanceFactorJustTheRight() {
        IAVLNode<Integer, String> avlNode = new AVLNode<Integer, String>(5, "a", 0);
        IAVLNode<Integer, String> avlNode2 = new AVLNode<Integer, String>(6, "b", 0);
        IAVLNode<Integer, String> avlNode3 = new AVLNode<Integer, String>(7, "c", 0);
        IAVLNode<Integer, String> avlNode4 = new AVLNode<Integer, String>(8, "d", 0);
        IAVLNode<Integer, String> avlNode5 = new AVLNode<Integer, String>(9, "e", 0);

        avlNode.setRight(avlNode2);
        avlNode2.setRight(avlNode3);
        avlNode3.setRight(avlNode4);
        avlNode4.setRight(avlNode5);

        assertEquals(4, avlNode.getBalanceFactor());
    }

    @Test
    public void testGetBalanceFactorJustTheLeft() {
        IAVLNode<Integer, String> avlNode = new AVLNode<Integer, String>(5, "a", 0);
        IAVLNode<Integer, String> avlNode2 = new AVLNode<Integer, String>(6, "b", 0);
        IAVLNode<Integer, String> avlNode3 = new AVLNode<Integer, String>(7, "c", 0);
        IAVLNode<Integer, String> avlNode4 = new AVLNode<Integer, String>(8, "d", 0);
        IAVLNode<Integer, String> avlNode5 = new AVLNode<Integer, String>(9, "e", 0);

        avlNode.setLeft(avlNode2);
        avlNode2.setLeft(avlNode3);
        avlNode3.setLeft(avlNode4);
        avlNode4.setLeft(avlNode5);

        assertEquals(-4, avlNode.getBalanceFactor());
    }

    @Test
    public void testGetBalanceFactor() {
        IAVLNode<Integer, String> avlNode = new AVLNode<Integer, String>(5, "a", 0);
        IAVLNode<Integer, String> avlNode2 = new AVLNode<Integer, String>(6, "b", 0);
        IAVLNode<Integer, String> avlNode3 = new AVLNode<Integer, String>(2, "c", 0);
        IAVLNode<Integer, String> avlNode4 = new AVLNode<Integer, String>(7, "d", 0);
        IAVLNode<Integer, String> avlNode5 = new AVLNode<Integer, String>(1, "e", 0);

        avlNode.setRight(avlNode2);
        avlNode.setLeft(avlNode3);

        avlNode2.setRight(avlNode4);

        avlNode3.setLeft(avlNode5);

        assertEquals(0, avlNode.getBalanceFactor());
        assertEquals(1, avlNode2.getBalanceFactor());
        assertEquals(-1, avlNode3.getBalanceFactor());
        assertEquals(0, avlNode4.getBalanceFactor());
        assertEquals(0, avlNode5.getBalanceFactor());

    }
}

package tests.AVLTreeTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import classes.AVLTree.*;
import interfaces.IAVLNode;
import interfaces.IAVlTree;

public class RightRightRotationTest {

    @Test
    public void rootPutRotationTest(){
        IAVlTree<Integer, String> tree = new AVLTree<Integer, String>();
        
        tree.put(1, "a");
        tree.put(2, "b");
        tree.put(3, "c");

        IAVLNode<Integer, String> middleNode = tree.get(2);
        assertTrue(middleNode != null);
        IAVLNode<Integer, String> rightChildren = (AVLNode<Integer, String>) middleNode.getRight();
        IAVLNode<Integer, String> leftChildren = (AVLNode<Integer, String>) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 1);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 3);

        assertTrue((int)tree.getRoot().getKey() == 2);
    }

    @Test
    public void middlePutRotationTest(){
        IAVlTree<Integer, String> tree = new AVLTree();
        
        tree.put(50, "a");
        tree.put(10, "b");
        tree.put(60, "c");
        tree.put(20, "d");
        tree.put(5, "e");
        tree.put(70, "f");
        tree.put(40, "g");
        tree.put(80, "h");
        tree.put(90, "i");

        IAVLNode<Integer, String> middleNode = tree.get(70);
        assertTrue(middleNode != null);
        IAVLNode<Integer, String> rightChildren = (AVLNode<Integer, String>) middleNode.getRight();
        IAVLNode<Integer, String> leftChildren = (AVLNode<Integer, String>) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 60);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 80);
    }

    @Test
    public void deleteRotationTest(){
        IAVlTree<Integer, String> tree = new AVLTree<Integer, String>();
        
        tree.put(2, "a");
        tree.put(1, "b");
        tree.put(3, "c");
        tree.put(4, "d");
        tree.delete(1);

        IAVLNode<Integer, String> middleNode = tree.get(3);
        assertTrue(middleNode != null);
        IAVLNode<Integer, String> rightChildren = (AVLNode<Integer, String>) middleNode.getRight();
        IAVLNode<Integer, String> leftChildren = (AVLNode<Integer, String>) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 2);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 4);

        assertTrue((int)tree.getRoot().getKey() == 3);
    }

}

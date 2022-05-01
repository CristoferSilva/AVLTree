package tests.BinarySearchTreeTest.AVLTreeTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import classes.AVLTree.*;
import interfaces.IAVLNode;
import interfaces.IAVlTree;

public class AllRotationsTest {
    
    @Test
    public void allRotationsTest(){
        IAVlTree tree = new AVLTree();
        
        tree.put(40, "a");
        tree.put(35, "b");
        tree.put(45, "c");
        tree.put(33, "d");
        tree.put(32, "e");

        IAVLNode middleNode = tree.get(33);
        assertTrue(middleNode != null);
        IAVLNode rightChildren = (AVLNode) middleNode.getRight();
        IAVLNode leftChildren = (AVLNode) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 32);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 35);

        tree = new AVLTree();
        
        tree.put(39, "f");

        middleNode = tree.get(40);
        assertTrue(middleNode != null);
        rightChildren = (AVLNode) middleNode.getRight();
        leftChildren = (AVLNode) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 39);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 45);

        assertTrue((int)tree.getRoot().getKey() == 35);

        tree = new AVLTree();
        
        tree.put(60, "g");
        tree.put(70, "h");

        middleNode = tree.get(60);
        assertTrue(middleNode != null);
        rightChildren = (AVLNode) middleNode.getRight();
        leftChildren = (AVLNode) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 45);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 70);
        
        tree.put(50, "i");

        middleNode = tree.get(60);
        assertTrue(middleNode != null);
        rightChildren = (AVLNode) middleNode.getRight();
        leftChildren = (AVLNode) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 50);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 70);

    }


}

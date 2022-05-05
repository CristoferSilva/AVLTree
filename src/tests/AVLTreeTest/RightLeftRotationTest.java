package tests.AVLTreeTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import classes.AVLTree.*;
import interfaces.IAVLNode;
import interfaces.IAVlTree;

public class RightLeftRotationTest {
    
    @Test
    public void middlePutRotationTest(){
        IAVlTree<Integer, String> tree = new AVLTree<Integer, String>();
        
        tree.put(50, "a");
        tree.put(10, "b");
        tree.put(60, "c");
        tree.put(20, "d");
        tree.put(5, "e");
        tree.put(70, "f");
        tree.put(40, "g");
        tree.put(65, "h");
        tree.put(80, "i");

        IAVLNode<Integer, String> middleNode = tree.get(65);
        assertTrue(middleNode != null);
        IAVLNode<Integer, String> rightChildren = (AVLNode<Integer, String>) middleNode.getRight();
        IAVLNode<Integer, String> leftChildren = (AVLNode<Integer, String>) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 60);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 70);
    }

    @Test
    public void deleteRotationTest(){
        IAVlTree<Integer, String> tree = new AVLTree<Integer, String>();
        
        tree.put(50, "a");
        tree.put(10, "b");
        tree.put(70, "c");
        tree.put(60, "d");
        tree.delete(10);

        IAVLNode<Integer, String> middleNode = tree.get(60);
        assertTrue(middleNode != null);
        IAVLNode<Integer, String> rightChildren = (AVLNode<Integer, String>) middleNode.getRight();
        IAVLNode<Integer, String> leftChildren = (AVLNode<Integer, String>) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 50);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 70);
    }

}

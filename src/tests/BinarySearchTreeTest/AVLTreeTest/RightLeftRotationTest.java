package tests.BinarySearchTreeTest.AVLTreeTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import classes.AVLTree.*;
import interfaces.IAVLNode;
import interfaces.IAVlTree;

public class RightLeftRotationTest {
    
    @Test
    public void middleRotationTest(){
        IAVlTree tree = new AVLTree();
        
        tree.put(50, "a");
        tree.put(10, "b");
        tree.put(60, "c");
        tree.put(20, "d");
        tree.put(5, "e");
        tree.put(70, "f");
        tree.put(40, "g");
        tree.put(65, "h");
        tree.put(80, "i");

        IAVLNode middleNode = tree.get(65);
        assertTrue(middleNode != null);
        IAVLNode rightChildren = (AVLNode) middleNode.getRight();
        IAVLNode leftChildren = (AVLNode) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 60);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 70);
    }

}

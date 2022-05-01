package tests.AVLTreeTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import classes.AVLTree.*;
import interfaces.IAVLNode;
import interfaces.IAVlTree;

public class LeftRightRotationTest {

    @Test
    public void middleRotationTest(){
        IAVlTree tree = new AVLTree();
        
        tree.put(10, "a");
        tree.put(20, "b");
        tree.put(5, "c");
        tree.put(4, "d");
        tree.put(7, "e");
        tree.put(30, "f");
        tree.put(15, "g");
        tree.put(2, "h");
        tree.put(3, "i");

        IAVLNode middleNode = tree.get(3);
        assertTrue(middleNode != null);
        IAVLNode rightChildren = (AVLNode) middleNode.getRight();
        IAVLNode leftChildren = (AVLNode) middleNode.getLeft();

        assertTrue(leftChildren != null);
        assertTrue((int)leftChildren.getKey() == 2);
        assertTrue(rightChildren != null );
        assertTrue((int)rightChildren.getKey() == 4);
    }

}

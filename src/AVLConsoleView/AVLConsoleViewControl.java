package AVLConsoleView;

import classes.AVLTree.AVLTree;
import interfaces.IAVLNode;
import interfaces.IAVlTree;

public class AVLConsoleViewControl<Key extends Comparable <Key>, Value> implements IAVLConsoleViewControl<Key,Value> {

    private IAVlTree<Key, Value> tree;
    
    public AVLConsoleViewControl() {
        this.tree = new AVLTree<Key, Value>();
    }
   
    @Override
    public IAVLNode<Key, Value> get(Key key) {
        // Delegate
        return tree.get(key);
    }

    @Override
    public void put(Key key, Value value) {
           // Delegate
        tree.put(key, value);
        
    }

    @Override
    public void delete(Key key) {
           // Delegate
        tree.delete(key);
        
    }

    @Override
    public void menu() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
    
    public IAVlTree<Key, Value> getTree() {
        return tree;
    }
    
    
}

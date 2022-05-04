package AVLConsoleView;

import interfaces.IAVLNode;

public interface IAVLConsoleViewControl<Key extends Comparable <Key>, Value> {
    public IAVLNode<Key, Value> get(Key key);
    public void put(Key key, Value value);
	public void delete(Key key);
    public void menu();
    public void run();
}

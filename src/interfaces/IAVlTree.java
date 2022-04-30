package interfaces;


public interface IAVlTree<Key extends Comparable <Key>, Value> {
    public IAVLNode<Key, Value> get(Key key);
	public int size();
	public void put(Key key, Value value);
	public void delete(Key key);
	public Key min();
	public Key max() ;
	public IAVLNode<Key, Value> getRoot();
}

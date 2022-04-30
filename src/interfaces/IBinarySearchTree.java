package interfaces;

public interface IBinarySearchTree<Key extends Comparable <Key>, Value> {

	public Value get(Key key);
	public int size();
	public void put(Key key, Value value);
	public void delete(Key key);
	public Key min();
	public Key max() ;
	public INode<Key, Value> getRoot();
}

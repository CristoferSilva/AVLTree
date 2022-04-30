package interfaces;

public interface INode<Key extends Comparable <Key>, Value> {
    
	
	public Key getKey();
	public void setKey(Key key);
	public Value getValue();
	public void setValue(Value value);
	public INode<Key, Value> getLeft();
	public void setLeft(INode<Key, Value> left);
	public INode<Key, Value> getRight();
	public void setRight(INode<Key, Value> right);
	public int getSize();
	public void setSize(int size);
	
}

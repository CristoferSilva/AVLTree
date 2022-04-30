package interfaces;

public interface IAVLNode<Key extends Comparable <Key>, Value> extends INode<Key, Value> {
    public int getBalanceFactor();
}

//package hdt7;

/**
 *
 * @author Gerardo
 * @param <K>
 * @param <V>
 */
public class Association<K, V> 
{
    private K key;
    private V value;
    
    public Association(K k, V v)
    {
        key = k;
        value = v;
    }
    
    /**
     *
     * @return
     */
    public K getKey()
    {
        return key;
    }
    
    /**
     *
     * @param k
     */
    public void setKey(K k)
    {
        key = k;
    }
    
    /**
     *
     * @return
     */
    public V getValue()
    {
        return value;
    }
    
    /**
     *
     * @param v
     */
    public void setValue(V v)
    {
        value = v;
    }
}

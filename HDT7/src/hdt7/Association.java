/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdt7;

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
    
    public K getKey()
    {
        return key;
    }
    
    public void setKey(K k)
    {
        key = k;
    }
    
    public V getValue()
    {
        return value;
    }
    
    public void setValue(V v)
    {
        value = v;
    }
    
    public void display()
    {
        System.out.println("Key: " + String.valueOf(key));
        System.out.println("Value: " + String.valueOf(value));
        System.out.println("");
    }
}

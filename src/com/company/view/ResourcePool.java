package com.company.view;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 06.08.14
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
public interface ResourcePool<T extends PoolableResource> {
    public T getResource() throws RuntimeException;
    public void releaseResource(T resource);
    public void releaseAll();
    public void releaseBroken(T resource);
    public int getSize();
    public int getUsed();
}

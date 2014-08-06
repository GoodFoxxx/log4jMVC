package com.company.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 06.08.14
 * Time: 12:01
 * To change this template use File | Settings | File Templates.
 */
public class ViewPool<T extends PoolableResource> implements ResourcePool<T> {
    private List<T> pool = new ArrayList<T>();
    private List<T> used = new ArrayList<T>();
    private Class<T> classObj = null;
    private final int maxSize;

    public ViewPool(Class<T> classObj, int initialSize, int maxSize){
        this.classObj = classObj;
        this.maxSize = maxSize;
        boolean notInitialized = false;
        for (int i=0; i<initialSize; i++){
            T resource = this.produceResource();
            if (null != resource) {
                pool.add(resource);
            } else {
                notInitialized = true;
            }
        }
        if (notInitialized){
            //TODO logger
        }
    }

    @Override
    public T getResource() throws RuntimeException {
        T resource;
        if (!pool.isEmpty()) {
            resource = pool.remove(0);
            used.add(resource);
        } else {
            if (this.getSize() < maxSize){
                resource = this.produceResource();
                used.add(resource);
            } else {
                throw new RuntimeException(this.classObj.getCanonicalName()+" pool max size reached");
            }
        }
        return resource;
    }

    @Override
    public void releaseResource(T resource) {
        if (!used.isEmpty()) {
            used.remove(resource);
            resource.release();
            pool.add(resource);
        } else {
            //TODO logger
        }
    }

    @Override
    public void releaseAll() {
        for(Iterator<T> iterator = used.iterator(); iterator.hasNext(); ){
            T obj = iterator.next();
            iterator.remove();
            obj.release();
            pool.add(obj);
        }
    }

    @Override
    public void releaseBroken(T resource) {
        if (!used.isEmpty()) {
            used.remove(resource);
            resource = this.produceResource();
            pool.add(resource);
        } else {
            //TODO logger
        }
    }

    @Override
    public int getSize() {
        return pool.size()+used.size();
    }

    @Override
    public int getUsed() {
        return used.size();
    }

    private T produceResource(){
        T resource = null;
        try {
            resource = classObj.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();  //TODO logger
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //TODO logger
        }
        return resource;
    }

}

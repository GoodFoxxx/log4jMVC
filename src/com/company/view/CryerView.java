package com.company.view;

import com.company.model.Cryer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 05.08.14
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class CryerView implements Showable, PoolableResource {
    private Cryer cryer = null;


    public CryerView(){
        this.cryer = null;
    }

    public CryerView(Cryer cryer){
        this.cryer = cryer;
    }

    @Override
    public void show() {
        cryer.cry();
    }

    public CryerView load(Cryer cryer) {
        this.cryer = cryer;
        return this;
    }


    @Override
    public void release() {
        cryer = null;
    }

}

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
public class CryerView implements Showable, Poolable {
    private Cryer cryer = null;
    public CryerView(Cryer cryer){
        this.cryer = cryer;
    }

    @Override
    public void show() {
        cryer.cry();
    }


    @Override
    public void refresh() {
        cryer = null;
    }

    public void setup(Cryer cryer) {
        this.cryer = cryer;
    }

//    @Override
//    public void setup(Object obj) {
//        if (Arrays.asList(obj.getClass().getInterfaces()).contains(Cryer.class)){
//            this.cryer = (Cryer)obj;
//        }
//    }


}

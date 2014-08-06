package com.company.model;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 05.08.14
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
public class Frog implements Quarker {
    @Override
    public void quark() {
        System.out.println("quark");
        System.out.flush();
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

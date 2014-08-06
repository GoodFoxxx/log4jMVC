package com.company.model;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 05.08.14
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 */
public class Toad extends Frog implements Quarker {
    @Override
    public void quark() {
        System.out.println("QUAAARK");
        System.out.flush();
    }
}

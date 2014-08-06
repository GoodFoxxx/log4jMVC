package com.company.model;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 05.08.14
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class Child implements Cryer {
    private String name = null;

    public Child(){
        this.name = "No-name";
    }

    public Child(String name){
        this.name = name;
    }

    @Override
    public void cry() {
        System.out.println(name+" crying");
        System.out.flush();
    }

}

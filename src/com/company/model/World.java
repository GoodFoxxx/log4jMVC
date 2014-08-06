package com.company.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 05.08.14
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
public class World {
    private List<Object> scene = null;
    public World(){
        this.generate();


    }
    private void generate(){
        scene = new ArrayList<Object>();
        scene.add(new Child());
        scene.add(new Frog());
        scene.add(new Toad());
    }

    public void produceChild(String name){
        scene.add(new Child(name));
    }

    public List<Object> getScene() {
        return scene;
    }
}

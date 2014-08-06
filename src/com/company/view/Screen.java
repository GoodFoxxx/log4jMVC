package com.company.view;

import com.company.model.Cryer;
import com.company.model.Quarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Screen {
    private ViewPool<CryerView> betterPool = new ViewPool<CryerView>(CryerView.class, 2,4);

    public void show(List<Object> scene){
        System.out.println("---------------------------");
        System.out.flush();
        betterPool.releaseAll();
        List<Showable> sceneView = new ArrayList<Showable>();


        for (Object elem : scene){
            List<Class<?>> interfaces = Arrays.asList(elem.getClass().getInterfaces());
            if (interfaces.contains(Cryer.class)){
                sceneView.add(betterPool.getResource().load((Cryer)elem));
            } else if (interfaces.contains(Quarker.class)){
                sceneView.add(new QuarkerView((Quarker)elem));
            }
        }
        System.out.println(betterPool.getClass().getCanonicalName()+" used size: "+betterPool.getUsed()+"(of "+betterPool.getSize()+")");
        System.out.flush();
        for (Showable sceneObject : sceneView){
            sceneObject.show();
        }
    }
}

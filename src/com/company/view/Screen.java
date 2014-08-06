package com.company.view;

import com.company.model.Cryer;
import com.company.model.Quarker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Screen {
    private CryerPool cryerPool = new CryerPool(4);

    public void show(List<Object> scene){
        System.out.println("---------------------------");
        System.out.flush();
        cryerPool.refreshAll();
        List<Showable> sceneView = new ArrayList<Showable>();

        for (Object elem : scene){
            List<Class<?>> interfaces = Arrays.asList(elem.getClass().getInterfaces());
//            System.out.println(elem.getClass());
//            for (Class<?> c : interfaces){
//                System.out.println(c);
//                System.out.flush();
//            }
            if (interfaces.contains(Cryer.class)){
//                sceneView.add(new CryerView((Cryer)elem));
                sceneView.add(cryerPool.get((Cryer)elem));
            } else if (interfaces.contains(Quarker.class)){
                sceneView.add(new QuarkerView((Quarker)elem));
            }
        }
        for (Showable sceneObject : sceneView){
            sceneObject.show();
        }
    }
}

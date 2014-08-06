package com.company.view;

import com.company.model.Cryer;

import java.util.ArrayList;
import java.util.List;

public class CryerPool {
    private List<CryerView> pool = new ArrayList<CryerView>();
    private int size = 0;
    private int used = 0;
    public CryerPool(int size){
        this.size = size;
        for (int i=0; i<size; i++){
            pool.add(new CryerView(null));
        }
    }
    public CryerView get(Cryer cryer){
        if (used >= size) throw new RuntimeException("Not enough free elements in pool");
        CryerView poolElem = pool.get(used++);
        poolElem.setup(cryer);
        return poolElem;

    }
    public void refreshAll(){
        for (CryerView c : pool){
            c.refresh();
        }
        used = 0;
    }
}

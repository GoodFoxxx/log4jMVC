package com.company.view;

import com.company.model.Quarker;

/**
 * Created with IntelliJ IDEA.
 * User: pberstenyov
 * Date: 05.08.14
 * Time: 16:39
 * To change this template use File | Settings | File Templates.
 */
public class QuarkerView implements Showable {
    Quarker quarker = null;
    public QuarkerView(Quarker quarker){
        this.quarker = quarker;
    }

    @Override
    public void show() {
        quarker.quark();
    }
}

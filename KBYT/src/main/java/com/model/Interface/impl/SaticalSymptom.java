package com.model.Interface.impl;

import com.model.Interface.ISaticalSymptom;

public class SaticalSymptom implements ISaticalSymptom {
    private int count;
    private String listSymptom;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getListSymptom() {
        return listSymptom;
    }
}

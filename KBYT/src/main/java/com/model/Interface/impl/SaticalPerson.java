package com.model.Interface.impl;

import com.model.Interface.ISaticalPerson;

public class SaticalPerson implements ISaticalPerson {

    private int count;
    private String date;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public String getDate() {
        return date;
    }
}

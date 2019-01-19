package com.org.config;

import com.org.entity.Menu;

import java.util.Comparator;

public class MenuComparator implements Comparator<Menu> {

    @Override
    public int compare(Menu o1, Menu o2) {
        if(o1.getSort()>o2.getSort()){
            return -1;
        }else {
            return 0;
        }

    }
}

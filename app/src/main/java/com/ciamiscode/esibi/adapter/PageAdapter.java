package com.ciamiscode.esibi.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.ciamiscode.esibi.TabAngka;
import com.ciamiscode.esibi.TabHuruf;

public class PageAdapter extends FragmentStatePagerAdapter {

    int countTab;

    public PageAdapter(FragmentManager fm,int countTab) {
        super(fm);
        this.countTab = countTab;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                TabHuruf tabHuruf = new TabHuruf();
                return tabHuruf;
            case 1:
                TabAngka tabAngka = new TabAngka();
                return tabAngka;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return countTab;
    }
}

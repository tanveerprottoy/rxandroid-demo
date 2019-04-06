package com.tanveershafeeprottoy.rxandroiddemo;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ActivityUtils {
    private static FragmentTransaction fragmentTransaction;
    private static ActionBar actionBar;

    public static void addFragmentOnActivity(
        FragmentManager fragmentManager,
        Fragment fragment, int frameId
    ) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(frameId, fragment);
        fragmentTransaction.commit();
    }

    public static void replaceFragmentOnActivity(
        FragmentManager fragmentManager,
        Fragment fragment, int frameId,
        String name
    ) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameId, fragment);
        if(!name.equals("")) {
            fragmentTransaction.addToBackStack(name);
        }
        fragmentTransaction.commit();
    }
}

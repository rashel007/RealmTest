package com.example.estique.realmtest;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by estique on 12/16/17.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
    }
}

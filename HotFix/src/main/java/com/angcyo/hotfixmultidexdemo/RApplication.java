package com.angcyo.hotfixmultidexdemo;

import android.app.Application;
import android.content.Context;

import java.io.File;

import dodola.hotfixlib.HotFix;

/**
 * Created by angcyo on 15-11-18-018.
 */
public class RApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        File dexPath = new File(getDir("dex", Context.MODE_PRIVATE), "indertlib_dex.jar");
        HotFix.prepareDex(this.getApplicationContext(), dexPath, "indertlib_dex.jar");
        HotFix.patch(this, dexPath.getAbsolutePath(), "com.angcyo.insertlib.InsertClass");
        try {
            this.getClassLoader().loadClass("com.angcyo.insertlib.InsertClass");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

package shopsys.ingramy.com.mvptest;

import android.app.Application;

import shopsys.ingramy.com.mvptest.util.LogX;

/**
 * Created by ycw on 2016/3/25.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogX.d("ycw", "----------    -app   oncreate-    --------------");

    }

}

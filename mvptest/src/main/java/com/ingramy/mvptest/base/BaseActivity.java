package com.ingramy.mvptest.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ycw on 2016/3/25.
 */
public class BaseActivity extends Activity {

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    protected void showActivity(Class<?> clas){
        Intent intent = new Intent(mContext, clas);
        startActivity(intent);
    }

    protected void showActivity(Intent intent){
        startActivity(intent);
    }

    protected void showActivity(Class<?> clas, Bundle bundle){
        Intent intent = new Intent(mContext, clas);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}

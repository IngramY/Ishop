package shopsys.ingramy.com.ishop.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import shopsys.ingramy.com.ishop.App;
import shopsys.ingramy.com.ishop.R;
import shopsys.ingramy.com.ishop.util.LogX;
import shopsys.ingramy.com.ishop.widget.LoadDialog;

public class BaseFragment extends Fragment {
    protected View contentView;
    protected String TAG = getClass().getSimpleName();
    protected Context mContext;
    protected App app;
    protected Activity activity;
    protected LoadDialog loadDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        activity = (Activity) mContext;
        app = App.getInstantce();
        loadDialog = new LoadDialog();
    }

    /**
     * show to @param(cls)
     */
    public void showActivity(Intent it) {
        startActivity(it);
    }

    /**
     * show to @param(cls)
     */
    public void showActivity(Class<?> cls, Bundle extras) {
        Intent intent = new Intent(mContext, cls);
        intent.putExtras(extras);
        startActivity(intent);
    }

    /**
     * show to @param(cls)
     */
    public void showActivity(Class<?> cls) {
        Intent intent = new Intent(mContext, cls);
        startActivity(intent);
    }

    public void showLoading(){
        showLoading(getResources().getString(R.string.loading));
    }

    public void showLoading(String msg) {
        LogX.d("panmengze", "showLoading");
        if (loadDialog != null) {
            loadDialog.setMessage(msg);
            loadDialog.show(getFragmentManager(), "");
        }
    }

    public void dismissLoading() {
//        if (loadDialog != null && loadDialog.isVisible()) {
        if (loadDialog != null) {
            loadDialog.dismiss();
        }
    }
}

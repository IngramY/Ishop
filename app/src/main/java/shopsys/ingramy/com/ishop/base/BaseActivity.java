package shopsys.ingramy.com.ishop.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import retrofit2.Call;
import shopsys.ingramy.com.ishop.App;
import shopsys.ingramy.com.ishop.R;
import shopsys.ingramy.com.ishop.ui.activity.LoginActivity;
import shopsys.ingramy.com.ishop.util.Constant;
import shopsys.ingramy.com.ishop.util.LogX;
import shopsys.ingramy.com.ishop.util.PrefUtility;
import shopsys.ingramy.com.ishop.widget.CommonTopBar;
import shopsys.ingramy.com.ishop.widget.LoadDialog;

public class BaseActivity extends Activity {
    protected App app;

    @Bind(R.id.top_bar)
    protected CommonTopBar topBar;

    protected String TAG = getClass().getSimpleName();
    protected Context mContext;
    protected LoadDialog loadDialog;
    protected List<Call> callList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle bundle) {
        // TODO Auto-generated method stub
        super.onCreate(bundle);
        app = App.getInstantce();
        app.addActivity(this);
        mContext = this;
        loadDialog = new LoadDialog();
    }

    @Override
    protected void onDestroy() {
        for(Call call:callList){
            LogX.d("panmengze", "call.isExecuted = " + call.isExecuted() + "   call.isCanceled = " + call.isCanceled());
            if(!call.isCanceled()) {
                call.cancel();
            }
        }
        super.onDestroy();
    }

    protected void exit() {
        finish();
    }

    public void showLoading() {
        showLoading(getResources().getString(R.string.loading));
    }

    public void showLoading(String msg) {
        if (loadDialog != null) {
            loadDialog.setMessage(msg);
            loadDialog.show(getFragmentManager(), "");
        }
    }

    public void dismissLoading() {
//        if (loadDialog != null && loadDialog.isVisible())
        if (loadDialog != null)
            loadDialog.dismiss();
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

    /**
     * skip to @param(cls), and this finish() method
     */
    public void skipActivity(Class<?> cls) {
        showActivity(cls);
        finish();
    }

    /**
     * 返回
     *
     * @param view
     */
    public void back(View view) {
        finish();
    }

    /***
     * @Description 发送更新个人数据广播
     * @author Daniel
     */
    protected void sendRefreshBroadcast() {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager
                .getInstance(mContext);
        Intent intent = new Intent(Constant.ACTION_REFRESH_PERSON_INFO);
        localBroadcastManager.sendBroadcast(intent);
    }

    /***
     * @Description 发送广播
     * @author Daniel
     */
    protected void sendLocalBroadcast(String action) {
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager
                .getInstance(mContext);
        Intent intent = new Intent(action);
        localBroadcastManager.sendBroadcast(intent);
    }

    // 用户被迫下线或退出
    public void logout(String msg) {
        PrefUtility.del(Constant.PREF_HAS_LOGIN);
        PrefUtility.del(Constant.PREF_COURSES_STRING);
        PrefUtility.del(Constant.PREF_USER_INFO_PROFILE_STRING);
        PrefUtility.del(Constant.PREF_USER_INFO_USER_STRING);
        skipActivity(LoginActivity.class);
        app.backToTop();
    }
}

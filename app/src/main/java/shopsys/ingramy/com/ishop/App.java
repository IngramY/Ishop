package shopsys.ingramy.com.ishop;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

import shopsys.ingramy.com.ishop.util.AppUtility;

/**
 * Created by ycw on 2016/3/23.
 */
public class App extends Application {

    private static App app;
//    private UserInfo userInfo;
//    private List<Course> courses;
    private List<Activity> activityList = new LinkedList<>();
//    private List<TestItem> testItemList;
//    private int kpId;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        AppUtility.setContext(app);


    }


    public static App getInstantce() {
        return app;
    }


    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // 遍历所有Activity并finish
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    /***
     * 退出全部activity
     */
    public void backToTop() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

//    /**
//     * @description: 保存用户数据
//     * @author: Daniel
//     */
//    public void sendUserToPref(UserInfo userInfo) {
//        Gson gson = new Gson();
//        String userItemToString = gson.toJson(userInfo.getUser());
//        String userProfileToString = gson.toJson(userInfo.getProfile());
//        PrefUtility.put(Constant.PREF_USER_INFO_USER_STRING, userItemToString);
//        PrefUtility.put(Constant.PREF_USER_INFO_PROFILE_STRING, userProfileToString);
//    }

}

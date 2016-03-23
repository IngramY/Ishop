package shopsys.ingramy.com.ishop.callback;

import com.zbzhixue.app.model.result.ResultBase;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @ClassName: CallbackFilter.java
 * @Description: 接口回调函数筛选分发类
 * @author Daniel
 * @date 2016/2/27 14:21
 */
public abstract class CallbackFilter<T extends ResultBase> implements Callback<T> {
    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        onFinish();
        if (response.code() == 200) {
            //可以获取到body
            if (response.body().getCode().equals("0")) {
                onSuccess(response.body());
            } else {
                onFail(response.body());
            }
        } else {
            //其他errorcode，没有body
            onFailRequest("请求失败");
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        onFinish();
        onFailRequest(t.getMessage());
    }

    /**
     * @description: 请求完成，所有情况都会执行,可以执行某些统一操作
     * @author: Daniel
     */
    public abstract void onFinish();

    /**
     * @description: onResponse执行成功
     * @author: Daniel
     */
    public abstract void onSuccess(T body);

    /**
     * @description: onResponse执行失败
     * @author: Daniel
     */
    public abstract void onFail(T body);

    /**
     * @description: 请求失败
     * @author: Daniel
     */
    public abstract void onFailRequest(String msg);

}

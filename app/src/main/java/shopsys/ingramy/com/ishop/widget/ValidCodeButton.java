package shopsys.ingramy.com.ishop.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.widget.Button;

import com.zbzhixue.app.R;

/**
 * @ClassName: ValidCodeButton.java
 * @Description: 发送验证码自动倒计时按钮
 * @author Daniel
 * @date 2016/2/22 16:23
 */
public class ValidCodeButton extends Button {
    ValidCodeCountDownTimer timer;

    Context mContext;

    public ValidCodeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public ValidCodeButton(Context context) {
        super(context);
        mContext = context;
    }

    public ValidCodeButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public void startCountDownTimer() {
        timer = new ValidCodeCountDownTimer(60000, 1000);
        timer.start();
    }

    /* 定义一个倒计时的内部类 */
    class ValidCodeCountDownTimer extends CountDownTimer {
        public ValidCodeCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            setText(mContext.getString(R.string.get_code_again, ""));
            setClickable(true);
            setSelected(false);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            setText(mContext.getString(R.string.get_code_again, "(" + millisUntilFinished / 1000 + ")"));
            setClickable(false);
            setSelected(true);
        }
    }
}

package shopsys.ingramy.com.ishop.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.zbzhixue.app.callback.OnCheckChangedListener;

public class BottomLayoutTextView extends TextView {
    private OnCheckChangedListener mListener;

    // private boolean isChecked=false;
    public BottomLayoutTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stub
    }

    public BottomLayoutTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public BottomLayoutTextView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    @SuppressLint("NewApi")
    public BottomLayoutTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        // TODO Auto-generated constructor stub
    }

    public void setChecked(boolean flag) {
        setSelected(flag);
        if (flag)
            mListener.onCheckChanged(true, this);
        else
            mListener.onCheckChanged(false, this);

    }

    public void setOnCheckChangedListener(OnCheckChangedListener changed) {
        this.mListener = changed;
    }

}

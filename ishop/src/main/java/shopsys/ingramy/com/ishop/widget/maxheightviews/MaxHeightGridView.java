package shopsys.ingramy.com.ishop.widget.maxheightviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 
 * @ClassName: MaxHeightGridView.java
 * @Description: 最大化高度的gridview，防止嵌套异常
 * @author Daniel
 * @date 2015年12月2日上午9:39:59
 * 
 */
public class MaxHeightGridView extends GridView {
	public MaxHeightGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MaxHeightGridView(Context context) {
		super(context);
	}

	public MaxHeightGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}

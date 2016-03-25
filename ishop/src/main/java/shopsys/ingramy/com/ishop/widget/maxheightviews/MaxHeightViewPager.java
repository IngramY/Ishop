package shopsys.ingramy.com.ishop.widget.maxheightviews;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;

/***
 * 
 * @ClassName: MaxHeightViewPager.java
 * @Description: 最大化高度viewpager，防止嵌套异常
 * @author Daniel
 * @date 2015年12月2日上午10:22:14
 *
 */
public class MaxHeightViewPager extends ViewPager {
	public MaxHeightViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MaxHeightViewPager(Context context) {
		super(context);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int height = 0;
		for (int i = 0; i < getChildCount(); i++) {
			View child = getChildAt(i);
			child.measure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
			int h = child.getMeasuredHeight();
			if (h > height)
				height = h;
		}
		heightMeasureSpec = MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY);
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
}

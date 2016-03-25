package shopsys.ingramy.com.ishop.widget;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Method;

import shopsys.ingramy.com.ishop.R;
import shopsys.ingramy.com.ishop.callback.NoDoubleClicksListener;
import shopsys.ingramy.com.ishop.util.AppUtility;
import shopsys.ingramy.com.ishop.util.LogX;

/**
 * 2015年10月16日12:04:53
 * 
 * @author jery 自定义通用的topbar
 */
public class CommonTopBar extends RelativeLayout {
	// topbar左边容器
	private LinearLayout container_left;
	// topbar中间容器
	private LinearLayout container_center;
	// topbar右边容器
	private LinearLayout container_right;
	// 中间容器textview文字
	private String titleStr = "";
	// 中间容器textview文字大小
	private int titleTextSize = 18;
	// 中间容器textview文字颜色
	private ColorStateList titleTextColor = null;

	// private Context mcontext;
	// private LayoutInflater inflater;
	private ImageButton img_title_left;
	private ImageButton img_title_right;

	private TextView tv_title;
	private TextView tvRight;

	private ImageButton imgRightSecond;

	// 标题默认字体颜色
	private final int defaultTextColor = 0xffffffff;// 默认字体颜色
	// 默认背景颜色
	private final int defaultBackGroudColor = 0xEDB526;
	/**
	 * 容器的布局参数
	 */
	private LayoutParams layoutparmas_left;
	private LayoutParams layoutparmas_right;
	private LayoutParams layoutparmas_center;

	public CommonTopBar(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray typearrArray = context.obtainStyledAttributes(attrs,
				R.styleable.CommonTopBar, 0, 0);
		if (typearrArray != null) {
			titleStr = typearrArray
					.getString(R.styleable.CommonTopBar_title_text);
			titleTextColor = typearrArray
					.getColorStateList(R.styleable.CommonTopBar_title_text_color);
			titleTextSize = typearrArray.getDimensionPixelSize(
					R.styleable.CommonTopBar_title_text_size, titleTextSize);
			typearrArray.recycle();
		}
		if (TextUtils.isEmpty(titleStr))
			titleStr = context.getResources().getString(R.string.app_name);
		if (titleTextColor == null)
			titleTextColor = ColorStateList.valueOf(defaultTextColor);
		initView(context);
	}

	public CommonTopBar(Context context) {
		super(context);
		initView(context);
	}

	@SuppressLint("NewApi")
	private void initView(Context mContext) {

		initContainer();
		LinearLayout.LayoutParams rlp = new LinearLayout.LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		rlp.gravity = Gravity.CENTER_VERTICAL;

		tv_title = new TextView(getContext());
		tvRight = new TextView(mContext);
		tvRight.setTextColor(titleTextColor);
		tvRight.setPadding(10, 4, 10, 4);
		tv_title.setId(R.id.topbar_center_textview);
		tv_title.setTextSize(titleTextSize);
		tv_title.setText(titleStr);
		tv_title.setTextColor(titleTextColor);

		addViewToCenter(tv_title, rlp);

		img_title_left = new ImageButton(getContext());
		img_title_left.setImageResource(R.drawable.arrow_white_left);
		img_title_left.setBackground(null);
		img_title_right = new ImageButton(getContext());
		img_title_right.setBackground(null);
		img_title_right.setId(R.id.top_bar_btn_right);

		imgRightSecond = new ImageButton(getContext());
		imgRightSecond.setBackground(null);
		addViewToRight(img_title_right);
	}

	/**
	 * 初始化容器
	 */
	public void initContainer() {
		container_center = new LinearLayout(getContext());
		container_left = new LinearLayout(getContext());
		container_right = new LinearLayout(getContext());

		container_center.setOrientation(LinearLayout.HORIZONTAL);
		container_left.setOrientation(LinearLayout.HORIZONTAL);
		container_right.setOrientation(LinearLayout.HORIZONTAL);

		container_right.setGravity(Gravity.CENTER_VERTICAL);
		container_center.setGravity(Gravity.CENTER_VERTICAL);
		container_left.setGravity(Gravity.CENTER_VERTICAL);

		layoutparmas_center = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutparmas_left = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutparmas_right = new LayoutParams(
				LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

		layoutparmas_center.addRule(RelativeLayout.CENTER_IN_PARENT);
		layoutparmas_left.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		layoutparmas_right.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		layoutparmas_right.addRule(RelativeLayout.CENTER_VERTICAL);
		layoutparmas_left.addRule(RelativeLayout.CENTER_VERTICAL);

		layoutparmas_left.setMargins(16, 0, 0, 0);
		layoutparmas_right.setMargins(0, 0, 16, 0);

		addView(container_left, layoutparmas_left);
		addView(container_center, layoutparmas_center);
		addView(container_right, layoutparmas_right);
	}

	public void addViewToLeft(View view) {
		container_left.addView(view);
	}

	public void addViewToLeft(View view, LinearLayout.LayoutParams parmas) {
		container_left.addView(view, parmas);
	}

	public void addViewToCenter(View view) {
		container_center.addView(view);

	}

	public void addViewToCenter(View view, LinearLayout.LayoutParams params) {
		container_center.addView(view, params);
	}

	public void addViewToRight(View view) {
		container_right.addView(view);
	}

	public void addViewToRight(View view, LinearLayout.LayoutParams parmas) {
		container_right.addView(view, parmas);
	}

	public void onBackBtnClick(final Object base, final String method,
			final Object... parameters) {
		img_title_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int length = parameters.length;
				Class<?>[] paramsTypes = new Class<?>[length];
				for (int i = 0; i < length; i++) {
					paramsTypes[i] = parameters[i].getClass();
				}
				try {
					Method m = base.getClass().getMethod(method, paramsTypes);
					m.setAccessible(true);
					m.invoke(base, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void backBtnClick(final Object base, final String method,
			final Object... parameters) {
		img_title_left.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				int length = parameters.length;
				Class<?>[] paramsTypes = new Class<?>[length];
				for (int i = 0; i < length; i++) {
					paramsTypes[i] = parameters[i].getClass();
				}
				try {
					Method m = base.getClass().getSuperclass()
								.getDeclaredMethod(method, paramsTypes);
					m.setAccessible(true);
					m.invoke(base, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LinearLayout.LayoutParams getWrapLayoutParams() {
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				-2, -2);
		layoutParams.gravity = Gravity.CENTER_VERTICAL;
		return layoutParams;
	}

	/**
	 * 设置所有容器的距离上边距的padding
	 * 
	 * @param padding
	 */

	public void setCoantainerPadding(int padding) {
		container_right.setPadding(0, padding, 0, 0);
		container_center.setPadding(0, padding, 0, 0);
		container_left.setPadding(0, padding, 0, 0);
	}

	/**
	 * 设置标题的文字内容
	 * 
	 * @param text
	 */
	public void setTitleText(String text) {
		if (tv_title != null) {
			tv_title.setText(text);
		}
	}

	public void setTitleText(int resId) {

		setTitleText(getContext().getResources().getString(resId));
	}

	public void setTitleVisibily(boolean f) {
		if (tv_title != null) {
			if (f)
				tv_title.setVisibility(View.VISIBLE);
			else
				tv_title.setVisibility(View.GONE);
		}
	}

	/**
	 * 设置标题是否可用
	 * 
	 * @param flag
	 */
	public void setTitleEnalbe(boolean flag) {
		if (tv_title != null) {
			if (flag)
				addViewToCenter(tv_title);
			else
				container_center.removeView(tv_title);

		}
	}

	/***
	 * 
	 * @Description 获取标题文字
	 * @author Daniel
	 */
	public String getTitleText() {
		if (tv_title != null) {
			if (AppUtility.isNotEmpty(tv_title.getText().toString().trim())) {
				return tv_title.getText().toString().trim();
			}
		}
		return "";
	}

	public void setRightBtnResourse(int drawableID) {
		img_title_right.setImageResource(drawableID);
	}

	public void setRightBtnVisibilty(boolean f) {
		if (f)
			img_title_right.setVisibility(View.VISIBLE);
		else
			img_title_right.setVisibility(View.GONE);
	}

	public void setRightBtnListener(final Object base, final String methodName,
			final Object... parameters) {
		img_title_right.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int length = parameters.length;
				Class<?>[] paramsTypes = new Class<?>[length];
				for (int i = 0; i < length; i++) {
					paramsTypes[i] = parameters[i].getClass();
				}
				try {
					Method m = base.getClass().getDeclaredMethod(methodName,
							paramsTypes);
					if (m == null) {
						m = base.getClass().getMethod(methodName, paramsTypes);
					}
					m.setAccessible(true);
					m.invoke(base, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public void onRightImgClick(final Object base, final String methodName,
			final Object... parameters) {
		img_title_right.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int length = parameters.length;
				Class<?>[] paramsTypes = new Class<?>[length];
				for (int i = 0; i < length; i++) {
					paramsTypes[i] = parameters[i].getClass();
				}
				try {
					Method m = base.getClass().getMethod(methodName,
							paramsTypes);

					m.setAccessible(true);
					m.invoke(base, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	public void setRightTextClick(final Object base, final String methodName,
			final Object... parameters) {

		tvRight.setOnClickListener(new NoDoubleClicksListener() {

			@Override
			public void noDoubleClick(View v) {
				// TODO Auto-generated method stub
				int length = parameters.length;
				Class<?>[] paramsTypes = new Class<?>[length];
				for (int i = 0; i < length; i++) {
					paramsTypes[i] = parameters[i].getClass();
				}
				try {
					Method m = base.getClass().getDeclaredMethod(methodName,
							paramsTypes);
					m.setAccessible(true);
					m.invoke(base, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public void setRightTextBackgroundResource(int resId) {
		this.tvRight.setBackgroundResource(resId);
	}

	public void setRightTextEnable(boolean flag) {
		if (flag) {
			addViewToRight(tvRight);
		}
	}

	public void setRightTextVisibility(boolean flag){
		if (flag)
			tvRight.setVisibility(View.VISIBLE);
		else
			tvRight.setVisibility(View.GONE);
	}

	public void setRightText(String text) {
		this.tvRight.setText(text);
	}

	public void setRightSecondImageRes(int resId) {
		this.imgRightSecond.setImageResource(resId);
	}

	public void setRightSecondImageEnable() {
		LinearLayout.LayoutParams parmas = getWrapLayoutParams();

		parmas.setMargins(15, 0, 0, 0);
		addViewToRight(imgRightSecond, parmas);
	}
	
	public void setRightSecondImageClick(final Object base, final String methodName,
			final Object... parameters){
		imgRightSecond.setOnClickListener(new NoDoubleClicksListener() {
			
			@Override
			public void noDoubleClick(View v) {
				 LogX.d("panmengze", "onClickInTopbar");
				// TODO Auto-generated method stub
				int length = parameters.length;
				Class<?>[] paramsTypes = new Class<?>[length];
				for (int i = 0; i < length; i++) {
					paramsTypes[i] = parameters[i].getClass();
				}
				try {
					Method m = base.getClass().getDeclaredMethod(methodName,
							paramsTypes);
					m.setAccessible(true);
					m.invoke(base, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				
			}
			}
		});
	}

	public void onRightSecondImageClick(final Object base, final String methodName,
			final Object... parameters){
		imgRightSecond.setOnClickListener(new NoDoubleClicksListener() {
			
			@Override
			public void noDoubleClick(View v) {
				 LogX.d("panmengze", "onClickInTopbar");
				// TODO Auto-generated method stub
				int length = parameters.length;
				Class<?>[] paramsTypes = new Class<?>[length];
				for (int i = 0; i < length; i++) {
					paramsTypes[i] = parameters[i].getClass();
				}
				try {
					Method m = base.getClass().getSuperclass().getDeclaredMethod(methodName,
							paramsTypes);
					m.setAccessible(true);
					m.invoke(base, parameters);
				} catch (Exception e) {
					e.printStackTrace();
				
			}
			}
		});
	}
	
	
	/*
	 * 设置左侧返按钮是否可用
	 */
	public void setBackBtnEnable(boolean flag) {
		if (img_title_left != null) {
			if (flag)
				addViewToLeft(img_title_left);
			else
				removeView(img_title_left);

		}
	}
}

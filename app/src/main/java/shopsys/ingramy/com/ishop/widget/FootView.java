package shopsys.ingramy.com.ishop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import shopsys.ingramy.com.ishop.R;

public class FootView extends RelativeLayout {
	@Bind(R.id.footer_image_view)
	ImageView footerImageView;
	@Bind(R.id.footer_pb_view)
	ProgressBar footerProgressBar;
	// @Bind(R.id.head_container) RelativeLayout head_container;
	@Bind(R.id.footer_text_view)
	TextView footerTextView;

	public FootView(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.layout_footer, this);
		ButterKnife.bind(this);
		initView();
	}

	private void initView() {
		footerProgressBar.setVisibility(View.GONE);
		footerImageView.setVisibility(View.VISIBLE);
		footerImageView.setImageResource(R.drawable.icon_down_arrow);
		footerTextView.setText("上拉加载更多...");
	}

	public void updateView(boolean enable) {
		footerTextView.setText(enable ? "松开加载" : "上拉加载");
		footerImageView.setVisibility(View.VISIBLE);
		footerImageView.setRotation(enable ? 0 : 180);
	}
    
	public void showLoading(){
		footerTextView.setText("正在加载...");
		footerImageView.setVisibility(View.GONE);
		footerProgressBar.setVisibility(View.VISIBLE);
	}
	public void loadFinish() {
		footerImageView.setVisibility(View.VISIBLE);
		footerProgressBar.setVisibility(View.GONE);
	}
}

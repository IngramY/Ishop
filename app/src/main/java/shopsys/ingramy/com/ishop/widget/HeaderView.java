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

public class HeaderView extends RelativeLayout {
	@Bind(R.id.pb_view) ProgressBar progressBar;
	@Bind(R.id.text_view) TextView textView;
	@Bind(R.id.image_view) ImageView imageView;
	@Bind(R.id.head_container) RelativeLayout head_container;

	public HeaderView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		LayoutInflater.from(context).inflate(R.layout.layout_head, this);
		ButterKnife.bind(this);
		initView();
	}
    
	private void initView(){
		textView.setText("下拉刷新");
		imageView.setVisibility(View.VISIBLE);
		imageView.setImageResource(R.drawable.icon_down_arrow);
		progressBar.setVisibility(View.GONE);
	}
	
	public void updateView(boolean enable){
		textView.setText(enable ? "松开刷新" : "下拉刷新");
		imageView.setVisibility(View.VISIBLE);
		imageView.setRotation(enable ? 180 : 0);
	}
	
	public void showLoading(){
		textView.setText("正在刷新");
		imageView.setVisibility(View.GONE);
		progressBar.setVisibility(View.VISIBLE);
	}
	
	public void loadFinish(){
		progressBar.setVisibility(View.GONE);
	}
}

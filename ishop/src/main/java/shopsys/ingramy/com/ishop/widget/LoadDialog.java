package shopsys.ingramy.com.ishop.widget;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import shopsys.ingramy.com.ishop.R;

/**
 * @ClassName: LoadDialog
 * @Description: TODO(加载进度——Dialog )
 * @author suny
 * @date 2015年12月8日 上午10:22:17
 * 
 */
public class LoadDialog extends DialogFragment {
	@Bind(R.id.txtMsg)
	TextView txtMsg;
//	@Bind(R.id.image_loading)
//	ImageView image_loading;

	private View contentView;
	private Context mContext;
	String message = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//LogX.i("TAG", "onCreate");
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		//LogX.i("TAG", "onCreateDialog");
		return super.onCreateDialog(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//LogX.i("TAG", "onCreateView");
		contentView = inflater.inflate(R.layout.dialog_loading, container);

		getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);// 去掉标题
		getDialog().getWindow().setBackgroundDrawableResource(
				android.R.color.transparent);
		getDialog().setCanceledOnTouchOutside(false);

		ButterKnife.bind(this, contentView);
		return contentView;
	}
	
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		ButterKnife.unbind(contentView);
		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//LogX.i("TAG", "onActivityCreated");
		mContext = getActivity();
		// 此处设置 有效 在oncreateView 设置无效，报错
		getDialog().getWindow().setLayout(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);// 设置Dialog的宽高
		Animation animation = AnimationUtils.loadAnimation(mContext,
				R.anim.image_loading_anim);
		txtMsg.setText(message);
	}

	/*
	 * 显示消息
	 */
	public String setMessage(String strMessage) {
		message = strMessage;
		return message;
	}
}

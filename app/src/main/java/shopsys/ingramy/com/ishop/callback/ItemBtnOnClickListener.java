package shopsys.ingramy.com.ishop.callback;


import android.view.View;

import com.zbzhixue.app.model.TopicReplyInfo;

/**
 * 回复按钮点击事件
 * Created by ycw on 2016/3/5.
 */
public interface ItemBtnOnClickListener {

    /**
     * 回复接口
     * @param v
     * @param replyInfo
     */
    void onItemReplyBtnClick(View v, TopicReplyInfo replyInfo);


    /**
     * 举报接口
     * @param v
     * @param replyInfo
     */
    void onItemReportBtnClick(View v, TopicReplyInfo replyInfo);

}

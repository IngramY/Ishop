package shopsys.ingramy.com.ishop.callback;

import com.zbzhixue.app.model.TestItem;

/**
 * @ClassName: OnTestItemClickListener.java
 * @Description: 用于处理选项点击事件
 * @author Daniel
 * @date 2016/3/7 16:53
 */
public interface OnTestItemClickListener {
    void onTestItemClick(TestItem.ItemOption itemOption);
}
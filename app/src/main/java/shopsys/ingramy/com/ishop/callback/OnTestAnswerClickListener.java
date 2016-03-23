package shopsys.ingramy.com.ishop.callback;

import com.zbzhixue.app.model.TestItem;

import java.util.List;

/**
 * @ClassName: OnTestAnswerClickListener.java
 * @Description: 用于处理做题结果点击答案事件
 * @author Daniel
 * @date 2016/3/7 16:54
 */
public interface OnTestAnswerClickListener {

    // 点击用户已做过的答案
    void onTestAnswerClick(int position);

    // 点击提交按钮
    void onTestSubmitClick(List<TestItem> testItemList);
}
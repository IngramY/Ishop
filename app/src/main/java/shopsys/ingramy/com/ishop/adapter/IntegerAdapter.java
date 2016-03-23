package shopsys.ingramy.com.ishop.adapter;


import android.content.Context;

import java.util.List;

import shopsys.ingramy.com.ishop.base.CommonAdapter;
import shopsys.ingramy.com.ishop.util.CommonViewHolder;

/**
 * Created by ycw on 2016/3/23.
 */
public class IntegerAdapter extends CommonAdapter<Integer> {

    public IntegerAdapter(Context context, List<Integer> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(CommonViewHolder holder, Integer integer) {

    }


}

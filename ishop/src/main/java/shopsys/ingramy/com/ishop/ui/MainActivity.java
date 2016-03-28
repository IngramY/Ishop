package shopsys.ingramy.com.ishop.ui;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import shopsys.ingramy.com.ishop.R;
import shopsys.ingramy.com.ishop.callback.OnCheckChangedListener;
import shopsys.ingramy.com.ishop.ui.main.OneBlankFragment;
import shopsys.ingramy.com.ishop.ui.main.ThreeBlankFragment;
import shopsys.ingramy.com.ishop.ui.main.TwoBlankFragment;
import shopsys.ingramy.com.ishop.widget.BottomLayoutTextView;
import shopsys.ingramy.com.ishop.widget.CommonTopBar;

public class MainActivity extends AppCompatActivity implements OnCheckChangedListener {

    @Bind(R.id.top_bar)
    CommonTopBar topBar;

    @Bind({R.id.tv_bottom_1, R.id.tv_bottom_2, R.id.tv_bottom_3})
    List<BottomLayoutTextView> mBottomLayoutTextViews = new ArrayList<>();

    private int currentPageIndex = -1;
    private ArrayList<Fragment> fragments;

    private static final int FRAGMENT_1 = 0;
    private static final int FRAGMENT_2 = 1;
    private static final int FRAGMENT_3 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        fragments = new ArrayList<>();
        currentPageIndex = FRAGMENT_1;
        updateTitle();
        for (BottomLayoutTextView tv : mBottomLayoutTextViews) {
            tv.setOnCheckChangedListener(this);
        }
        mBottomLayoutTextViews.get(currentPageIndex).setSelected(true);
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        OneBlankFragment oneBlankFragment = new OneBlankFragment();
        TwoBlankFragment twoBlankFragment = new TwoBlankFragment();
        ThreeBlankFragment threeBlankFragment = new ThreeBlankFragment();

        ft.add(R.id.frame_container, threeBlankFragment);
        ft.add(R.id.frame_container, oneBlankFragment);
        ft.add(R.id.frame_container, twoBlankFragment);

        fragments.add(oneBlankFragment);
        fragments.add(twoBlankFragment);
        fragments.add(threeBlankFragment);

        hideAllFragments();
        ft.show(fragments.get(FRAGMENT_1));
        ft.commit();

    }

    private void hideAllFragments() {
        for (Fragment baseFragment : fragments) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.hide(baseFragment).commit();
        }
    }

    @OnClick({R.id.tv_bottom_1, R.id.tv_bottom_2, R.id.tv_bottom_3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_bottom_1:
                onTabClick(FRAGMENT_1);
                break;
            case R.id.tv_bottom_2:
                onTabClick(FRAGMENT_2);
                break;
            case R.id.tv_bottom_3:
                onTabClick(FRAGMENT_3);
                break;
        }
    }

    private void onTabClick(int index) {
        unChooseAll();
        currentPageIndex = index;
        mBottomLayoutTextViews.get(index).setChecked(true);
    }

    private void unChooseAll() {
        for (BottomLayoutTextView tv : mBottomLayoutTextViews) {
            tv.setChecked(false);
        }
    }

    @Override
    public void onCheckChanged(boolean checked, View view) {
        if (checked) {
            hideAllFragments();
            FragmentTransaction ft = getFragmentManager()
                    .beginTransaction();
            switch (view.getId()) {
                case R.id.tv_bottom_1:
                    ft.show(fragments.get(FRAGMENT_1)).commit();
                    break;

                case R.id.tv_bottom_2:
                    ft.show(fragments.get(FRAGMENT_2)).commit();
                    break;

                case R.id.tv_bottom_3:
                    ft.show(fragments.get(FRAGMENT_3)).commit();
                    break;
            }
        }
        updateTitle();
    }

    /**
     * @description: 更新标题
     * @author: Daniel
     */
    private void updateTitle() {
        switch (currentPageIndex) {
            case FRAGMENT_1:
                topBar.setTitleText(R.string.tab_home);
                break;
            case FRAGMENT_2:
                topBar.setTitleText(R.string.tab_car);
                break;
            case FRAGMENT_3:
                topBar.setTitleText(R.string.tab_personal);
                break;
        }
    }
}

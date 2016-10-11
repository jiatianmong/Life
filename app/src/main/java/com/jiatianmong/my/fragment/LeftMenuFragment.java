package com.jiatianmong.my.fragment;

import android.view.View;

import com.jiatianmong.activity.R;

/**
 * Created by jiatianmong on 2016-10-10 15:47
 */
public class LeftMenuFragment extends BaseFragment {

    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_left_menu, null);
        return view;
    }

    @Override
    public void initData() {

    }
}

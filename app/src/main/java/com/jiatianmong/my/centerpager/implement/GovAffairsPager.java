package com.jiatianmong.my.centerpager.implement;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.jiatianmong.my.centerpager.BasePager;

/**
 * 政务
 * Created by jiatianmong on 2016-10-10 20:25
 */
public class GovAffairsPager extends BasePager{

    public GovAffairsPager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        System.out.println("政务初始化啦...");

        // 要给帧布局填充布局对象
        TextView view = new TextView(mActivity);
        view.setText("政务");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        flContent.addView(view);

        // 修改页面标题
        tvTitle.setText("政务");

        //显示菜单按钮
        //btnMenu.setVisibility(View.VISIBLE);
    }
}

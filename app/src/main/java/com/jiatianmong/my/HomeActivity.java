package com.jiatianmong.my;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.jiatianmong.activity.R;
import com.jiatianmong.my.fragment.ContentFragment;
import com.jiatianmong.my.fragment.LeftMenuFragment;

/**
 * Created by jiatianmong on 2016-10-6 23:08
 */
public class HomeActivity extends SlidingFragmentActivity{
    private static final String TAG_CONTENT = "TAG_CONTENT";
    private static final String TAG_LEFT_MENU = "TAG_LEFT_MENU";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState);
        setContentView(R.layout.activity_home);

        setBehindContentView(R.layout.left_menu);
        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);//全屏触摸
        slidingMenu.setBehindOffset(200);//屏幕预留200像素宽度

        init_fragment();
    }

    /**
     * 初始化fragment
     */
    private void init_fragment() {

        FragmentManager sFM = getSupportFragmentManager();
        //开启事务
        FragmentTransaction fragmentTransaction = sFM.beginTransaction();

        // 用fragment替换帧布局;参1:帧布局容器的id;参2:是要替换的fragment;参3:标记
        fragmentTransaction.replace(R.id.fl_left_menu, new LeftMenuFragment(),TAG_LEFT_MENU);
        fragmentTransaction.replace(R.id.fl_main, new ContentFragment(), TAG_CONTENT);
        fragmentTransaction.commit();

    }


}

package com.jiatianmong.my.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jiatianmong.activity.R;
import com.jiatianmong.my.HomeActivity;
import com.jiatianmong.my.centerpager.BasePager;
import com.jiatianmong.my.centerpager.implement.GovAffairsPager;
import com.jiatianmong.my.centerpager.implement.HomePager;
import com.jiatianmong.my.centerpager.implement.NewsCenterPager;
import com.jiatianmong.my.centerpager.implement.SettingPager;
import com.jiatianmong.my.centerpager.implement.SmartServicePager;

import java.util.ArrayList;

/**
 * Created by jiatianmong on 2016-10-10 15:59
 */
public class ContentFragment extends BaseFragment{

    private ViewPager mViewPager;

    private ArrayList<BasePager> mBasePagers;
    private RadioGroup mRadioGroup;


    @Override
    public View initView() {
        View view = View.inflate(mActivity, R.layout.fragment_content, null);
        mViewPager = (ViewPager) view.findViewById(R.id.vp_content);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rb_group);
        return view;
    }

    @Override
    public void initData() {

        mBasePagers = new ArrayList<>();

        //添加五个标签页
        mBasePagers.add(new HomePager(mActivity));
        mBasePagers.add(new NewsCenterPager(mActivity));
        mBasePagers.add(new SmartServicePager(mActivity));
        mBasePagers.add(new GovAffairsPager(mActivity));
        mBasePagers.add(new SettingPager(mActivity));


        mViewPager.setAdapter(new ContentAdapter());
        //对底部的标签栏监听实现与页面匹配
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_home:
                        //首页
                        mViewPager.setCurrentItem(0,false);//参2：是否有滑动动画
                        break;
                    case R.id.rb_news:
                        //新闻中心
                        mViewPager.setCurrentItem(1,false);
                        break;
                    case R.id.rb_smart:
                        //智慧服务
                        mViewPager.setCurrentItem(2,false);
                        break;
                    case R.id.rb_gov:
                        //政务
                        mViewPager.setCurrentItem(3,false);
                        break;
                    case R.id.rb_setting:
                        //设置
                        mViewPager.setCurrentItem(4,false);
                        break;
                }
            }
        });

        mBasePagers.get(0).initData();
        setslidingMenuEnable(false);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                
            }

            @Override
            public void onPageSelected(int position) {
                mBasePagers.get(mViewPager.getCurrentItem()).initData();
                if (position == 0 || position == 4) {
                    setslidingMenuEnable(false);
                } else {
                    setslidingMenuEnable(true);
                }
                switch (position) {
                    case 0:
                        //
                        mRadioGroup.check(R.id.rb_home);
                        break;
                    case 1:
                        //
                        mRadioGroup.check(R.id.rb_news);
                        break;
                    case 2:
                        //
                        mRadioGroup.check(R.id.rb_smart);
                        break;
                    case 3:
                        //
                        mRadioGroup.check(R.id.rb_gov);
                        break;
                    case 4:
                        //
                        mRadioGroup.check(R.id.rb_setting);
                        break;
                }
                
            }




            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setslidingMenuEnable(boolean b) {
        HomeActivity activity = (HomeActivity) mActivity;
        SlidingMenu slidingMenu = activity.getSlidingMenu();
        if (b) {
            slidingMenu.setTouchModeAbove(slidingMenu.TOUCHMODE_MARGIN);
        } else {
            slidingMenu.setTouchModeAbove(slidingMenu.TOUCHMODE_NONE);
        }
    }
    class ContentAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mBasePagers.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager = mBasePagers.get(position);
            View view = pager.mRootView;
            //pager.initData();//初始化数据,ViewPager会默认加载下一个页面，为了节省资源和流量，不在此处初始化数据
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}

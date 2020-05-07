package com.bw.movie.fragment;

import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.R;
import com.bw.movie.base.BaseFragment;
import com.bw.movie.base.IBasePresenter;
import com.bw.movie.fragment.cinemafragment.NearbyFragment;
import com.bw.movie.fragment.cinemafragment.RecommendFragment;
import com.bw.movie.fragment.cinemafragment.RegionFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

public class CinemaFragment extends BaseFragment {
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.movie_dingwei)
    ImageView movieDingwei;
    @BindView(R.id.movie_sousuo)
    ImageView movieSousuo;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<Fragment> list = new ArrayList<>();
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initview() {
        //添加标题
        title = new ArrayList<>();
        title.add("推荐影院");
        title.add("附近影院");
        title.add("海淀区▼");
        //添加页面
        list = new ArrayList<>();
        list.add(new RecommendFragment());
        list.add(new NearbyFragment());
        list.add(new RegionFragment());
        pager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });
        tab.setupWithViewPager(pager);
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.cinemafragment_layout;
    }
}

package com.bw.movie;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.IBasePresenter;
import com.bw.movie.fragment.morefragment.BeingFragment;
import com.bw.movie.fragment.morefragment.ComingSoonFragment;
import com.bw.movie.fragment.morefragment.HotmoviesFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoreActivity extends BaseActivity {

    @BindView(R.id.fh)
    ImageView fh;
    @BindView(R.id.movie_sousuo)
    ImageView movieSousuo;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.pager)
    ViewPager pager;
    private ArrayList<String> title = new ArrayList<>();
    private ArrayList<Fragment> list = new ArrayList<>();

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //添加标题
        title = new ArrayList<>();
        title.add("正在热映");
        title.add("即将上映");
        title.add("热门电影");
        //添加页面
        list = new ArrayList<>();
        list.add(new BeingFragment());
        list.add(new ComingSoonFragment());
        list.add(new HotmoviesFragment());

        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        //绑定
        tab.setupWithViewPager(pager);
    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_more;
    }

    @OnClick({R.id.fh, R.id.movie_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fh:
                finish();
                break;
            case R.id.movie_sousuo:
                break;
        }
    }
}

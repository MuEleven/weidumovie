package com.bw.movie;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.IBasePresenter;
import com.bw.movie.fragment.moviehomepagedetailsfragment.CommentFragment;
import com.bw.movie.fragment.moviehomepagedetailsfragment.IntroduceFragment;
import com.bw.movie.fragment.moviehomepagedetailsfragment.NoticeFragment;
import com.bw.movie.fragment.moviehomepagedetailsfragment.StillsFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MovieDetailsActivity extends BaseActivity {


    @BindView(R.id.simpleDraweeView)
    SimpleDraweeView simpleDraweeView;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.score)
    TextView score;
    @BindView(R.id.commentNum)
    TextView commentNum;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.typeAndtimes)
    TextView typeAndtimes;
    @BindView(R.id.releaseTime)
    TextView releaseTime;
    @BindView(R.id.moveText)
    RelativeLayout moveText;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.pager)
    ViewPager pager;
    @BindView(R.id.comment)
    Button comment;
    @BindView(R.id.btu_buy)
    Button btuBuy;
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
        Intent intent = getIntent();
        int movieId = intent.getIntExtra("movieId", 0);

        //添加标题
        title = new ArrayList<>();
        title.add("介绍");
        title.add("预告");
        title.add("剧照");
        title.add("影评");
        //添加页面
        list = new ArrayList<>();
        list.add(new IntroduceFragment());
        list.add(new NoticeFragment());
        list.add( new StillsFragment());
        list.add(new CommentFragment());

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
        return R.layout.activity_movie_details;
    }

    @OnClick({R.id.back, R.id.comment, R.id.btu_buy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.comment:
                break;
            case R.id.btu_buy:

                break;
        }
    }
}

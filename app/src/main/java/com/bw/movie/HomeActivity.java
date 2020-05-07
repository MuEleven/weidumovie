package com.bw.movie;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.base.BaseActivity;
import com.bw.movie.base.IBasePresenter;
import com.bw.movie.fragment.CinemaFragment;
import com.bw.movie.fragment.MovieFragment;
import com.bw.movie.fragment.MyFragment;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.frame)
    FrameLayout frame;
    @BindView(R.id.tv_moview)
    TextView tvMoview;
    @BindView(R.id.lin_movie)
    LinearLayout linMovie;
    @BindView(R.id.movie_ima)
    ImageView movieIma;
    @BindView(R.id.relay_view1)
    RelativeLayout relayView1;
    @BindView(R.id.tv_cinema)
    TextView tvCinema;
    @BindView(R.id.lin_cinema)
    LinearLayout linCinema;
    @BindView(R.id.cinema_ima)
    ImageView cinemaIma;
    @BindView(R.id.relay_view2)
    RelativeLayout relayView2;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    @BindView(R.id.lin_mine)
    LinearLayout linMine;
    @BindView(R.id.mine_ima)
    ImageView mineIma;
    @BindView(R.id.relay_view3)
    RelativeLayout relayView3;
    private MovieFragment movieFragment;
    private CinemaFragment cinemaFragment;
    private MyFragment myFragment;
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //初始化fragment
        movieFragment = new MovieFragment();
        cinemaFragment = new CinemaFragment();
        myFragment = new MyFragment();
        // 显示隐藏
        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, movieFragment)
                .add(R.id.frame, cinemaFragment)
                .add(R.id.frame, myFragment)
                .show(movieFragment)
                .hide(cinemaFragment)
                .hide(myFragment)
                .commit();
        linMovie.setVisibility(View.VISIBLE);

    }

    @Override
    protected IBasePresenter initPresenter() {
        return null;
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_home;
    }

    @OnClick({R.id.relay_view1, R.id.relay_view2, R.id.relay_view3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relay_view1:
                getSupportFragmentManager()
                        .beginTransaction()
                        .show(movieFragment)
                        .hide(cinemaFragment)
                        .hide(myFragment)
                        .commit();
                linMovie.setVisibility(View.VISIBLE);
                linCinema.setVisibility(View.GONE);
                linMine.setVisibility(View.GONE);
                movieIma.setVisibility(View.GONE);
                cinemaIma.setVisibility(View.VISIBLE);
                mineIma.setVisibility(View.VISIBLE);
                break;
            case R.id.relay_view2:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(movieFragment)
                        .show(cinemaFragment)
                        .hide(myFragment)
                        .commit();
                linMovie.setVisibility(View.GONE);
                linCinema.setVisibility(View.VISIBLE);
                linMine.setVisibility(View.GONE);
                movieIma.setVisibility(View.VISIBLE);
                cinemaIma.setVisibility(View.GONE);
                mineIma.setVisibility(View.VISIBLE);
                break;
            case R.id.relay_view3:
                getSupportFragmentManager()
                        .beginTransaction()
                        .hide(movieFragment)
                        .hide(cinemaFragment)
                        .show(myFragment)
                        .commit();
                linMovie.setVisibility(View.GONE);
                linCinema.setVisibility(View.GONE);
                linMine.setVisibility(View.VISIBLE);
                movieIma.setVisibility(View.VISIBLE);
                cinemaIma.setVisibility(View.VISIBLE);
                mineIma.setVisibility(View.GONE);
                break;
        }
    }

    //两次返回关闭应用
    boolean isState = true;
    public void onBackPressed(){
        if (isState) {
            isState = false;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isState = true;
                }
            }, 2000);
        } else {
            finish();
        }
    }
}

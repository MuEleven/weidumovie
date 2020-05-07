package com.bw.movie.app;

import com.bw.movie.bean.BannerBean;
import com.bw.movie.bean.CinemaCommentBean;
import com.bw.movie.bean.CinemaDetailsBean;
import com.bw.movie.bean.CommentBean;
import com.bw.movie.bean.JjsyBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.MovieDetailsBean;
import com.bw.movie.bean.MovieSchedule;
import com.bw.movie.bean.PaiqiBean;
import com.bw.movie.bean.PositionBean;
import com.bw.movie.bean.RecommendBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.RmBean;
import com.bw.movie.bean.WeiXinBean;
import com.bw.movie.bean.XianDanBean;
import com.bw.movie.bean.ZhiFuBaoBean;
import com.bw.movie.bean.ZouWeiBean;
import com.bw.movie.bean.ZzsyBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {
    /**
     * 用户接口
     * @param email
     * @param pwd
     * @return
     */
    //登录
    @POST("user/v2/login")
    @FormUrlEncoded
    Observable<LoginBean> login(@Field("email") String email, @Field("pwd") String pwd);
    //注册
    @POST("user/v2/register")
    @FormUrlEncoded
    Observable<RegisterBean>register(@Field("nickName") String nickName, @Field("pwd") String pwd, @Field("email") String email, @Field("code") String code);
    //发送邮箱验证码
    @POST("user/v2/sendOutEmailCode")
    @FormUrlEncoded
    Observable<RegisterBean> sendOutEmailCode(@Field("email") String email);
    //Banner轮播图
    @GET("tool/v2/banner")
    Observable<BannerBean>banner();

    /**
     * 影院接口
     */
    //正在上映
    @GET("movie/v2/findReleaseMovieList")
    Observable<ZzsyBean> findReleaseMovieList(@Query("page") int page, @Query("count") int count);

    //即将上映
    @GET("movie/v2/findComingSoonMovieList")
    Observable<JjsyBean>findComingSoonMovieList(@Query("page") int page, @Query("count") int count);

    //热门电影
    @GET("movie/v2/findHotMovieList")
    Observable<RmBean>findHotMovieList(@Query("page") int page, @Query("count") int count);
   //查询电影详情
    @GET("movie/v2/findMoviesDetail")
    Observable<MovieDetailsBean>findMoviesDetail(@Query("movieId") int movieId);
    //电影评论
    @GET("movie/v2/findAllMovieComment")
    Observable<CommentBean>findAllMovieComment(@Query("movieId") int movieId, @Query("page") int page, @Query("count") int count);
    //模糊查询电影
    @GET("movie/v2/findMovieByKeyword")
    Observable<ZzsyBean> findMovieByKeyword(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);
    /**
     * 影院接口
     */
    //推荐影院
    @GET("cinema/v1/findRecommendCinemas")
    Observable<RecommendBean>findRecommendCinemas(@Query("page") int page, @Query("count") int count);
    //附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<RecommendBean>findNearbyCinemas(@Query("page") int page, @Query("count") int count);
    //影院详情
    @GET("cinema/v1/findCinemaInfo")
    Observable<CinemaDetailsBean>findCinemaInfo(@Query("cinemaId") int cinemaId);
    //影院评论
    @GET("cinema/v1/findAllCinemaComment")
    Observable<CinemaCommentBean>findAllCinemaComment(@Query("cinemaId") int cinemaId, @Query("page") int page, @Query("count") int count);
    //影院排期
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<PaiqiBean> findCinemaScheduleList(@Query("cinemaId") int cinemaId, @Query("page") int page, @Query("count") int count);
    //查询区域列表
    @GET("tool/v2/findRegionList")
    Observable<RegionBean>findRegionList();
    //根据区域查询影院
    @GET("cinema/v2/findCinemaByRegion")
    Observable<PositionBean>findCinemaByRegion(@Query("regionId") int regionId);
    //购票下单
    @FormUrlEncoded
    @POST("movie/v2/verify/buyMovieTickets")
    Observable<XianDanBean>buyMovieTickets(@Header("userId") String userId, @Header("sessionId") String sessionId, @Field("scheduleId") int scheduleId, @Field("seat") String seat, @Field("sign") String sign);
    //查询座位信息
    //http://172.17.8.100/movieApi/movie/v2/findSeatInfo
    @GET("movie/v2/findSeatInfo")
    Observable<ZouWeiBean> findSeatInfo(@Query("hallId") int hallId);
    //支付  支付宝
    @FormUrlEncoded
    @POST("movie/v2/verify/pay")
    Observable<ZhiFuBaoBean> pay2(@Header("userId") String userId, @Header("sessionId") String sessionId, @Field("payType") int payType, @Field("orderId") String orderId);
    //支付  微信
    @FormUrlEncoded
    @POST("movie/v2/verify/pay")
    Observable<WeiXinBean> pay(@Header("userId") String userId, @Header("sessionId") String sessionId, @Field("payType") int payType, @Field("orderId") String orderId);
    //根据电影ID和影院ID查询电影排期列表
    //http://172.17.8.100/movieApi/movie/v2/findMovieSchedule
    @GET("movie/v2/findMovieSchedule")
    Observable<MovieSchedule>findMovieSchedule1(@Query("movieId") int movieId, @Query("cinemaId") int cinemaId);

}

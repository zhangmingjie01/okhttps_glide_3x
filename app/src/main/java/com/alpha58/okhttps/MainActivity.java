package com.alpha58.okhttps;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class MainActivity extends AppCompatActivity {

    private ImageView mIv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIv_img = (ImageView) findViewById(R.id.iv_img);
    }

    public void getHttpsHtml(View view) {
//        Request request = new Request.Builder()
//                .url("https://kyfw.12306.cn/otn/regist/init")
//                .build();
//        HTTPSUtils httpsUtils = new HTTPSUtils(this);
//        httpsUtils.getInstance().newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                System.out.println("--------------onFailure--------------" + e.toString());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                System.out.println("--------------onResponse--------------" + response.body().string());
//            }
//        });
    }

    public void getHttpsImg(View view) {
        //自签名https图片链接 （如果链接失效，自行到12306网站找图片）
        String url = "https://ad.12306.cn/res/delivery/0003/2018/09/17/201809171655222864.jpg";
        Glide.with(this)
                .load(url)
                .asBitmap()
                .listener(new RequestListener<String, Bitmap>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        System.out.println("--------------Exception--------------" + e);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(mIv_img);
    }
}

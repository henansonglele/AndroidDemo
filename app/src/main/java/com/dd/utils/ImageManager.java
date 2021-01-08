package com.dd.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.dd.R;

public class ImageManager {
    //https://blog.csdn.net/augfun/article/details/105963476


    public static void loadImageFromNet(Context context,String url, ImageView imageView){
        Glide.with(context).load(url).into(imageView);

    }
    public static void loadImageFromNetWithHold(Context context,String url, ImageView imageView,int holdRes){
        Glide.with(context).load(url).placeholder(holdRes).into(imageView);
        //Glide.with(context).load(url).placeholder(R.drawable.loading).into(imageView);

    }

    public static void loadImage(Context context,String url, ImageView imageView) {
        // 加载本地图片
        //File file = new File(getExternalCacheDir() + "/image.jpg");
        //Glide.with(context).load(file).into(imageView);

        // 加载应用资源
        int resource = R.drawable.ic_dashboard_black_24dp;
        Glide.with(context).load(resource).into(imageView);

        // 加载二进制流
        //byte[] image = getImageBytes();
        //Glide.with(context).load(image).into(imageView);
        //
        //// 加载Uri对象
        //Uri imageUri = getImageUri();
        //Glide.with(context).load(imageUri).into(imageView);
    }
}

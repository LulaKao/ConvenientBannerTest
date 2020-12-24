package com.quarterlife.convenientbanner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;

// 網路圖片
public class NetworkImageHolderView implements Holder<String> {
    private ImageView imageView;
    @Override
    public View createView(Context context) {
        // 可以通過 layout 文件來創建，也可通過程式碼來創建，此處通過程式碼創建
        // 任何元件都可以進行翻頁，不一定要是 ImageView
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String url) {
        /*  載入 url 圖片，並設置預 error 時會顯示的預設圖片  */
        Glide.with(context).load(url).error(R.drawable.default_banner).into(imageView);
    }
}
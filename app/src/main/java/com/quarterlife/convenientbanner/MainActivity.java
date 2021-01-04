package com.quarterlife.convenientbanner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {
    private ConvenientBanner convenientBanner;

    // 網路圖片
    private List<String> bannerList;
    private String[] images = {"https://i.ibb.co/8bHW6cj/slide1.png",
            "https://i.ibb.co/DtMq5nY/slide2.png",
            "https://i.ibb.co/Y0fDk0W/slide3.jpg"};

//    // 本地圖片
//    private List<Integer> bannerList;
//    private Integer[] images = {R.drawable.banner1, R.drawable.default_banner, R.drawable.banner3,};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convenientBanner = findViewById(R.id.convenientBanner);

        // 網路載入圖片
        bannerList = Arrays.asList(images);

        /*  若要使用本地圖片就把下方出現的三個 NetworkImageHolderView 換成 LocalImageHolderView   */
        convenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        },bannerList)
                // 設定指示器是否可見
                .setPointViewVisible(true)
                // 設定自動切換（同時設定切換的時間間隔）
                .startTurning(2000)
                // 設定兩個點圖片作為翻頁指示器，不設定則沒有指示器，可以根據自己需求自行配合自己的指示器，不需要圓點指示器可不設
                .setPageIndicator(new int[]{R.drawable.indicator_circle_white_8, R.drawable.indicator_circle_blue_8})
                // 設定指示器的方向（左、中、右）
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                // 設定點選監聽事件
                .setOnItemClickListener(this)
                // 設定可否手動切換
                .setManualPageable(true);
    }

    // banner 的點擊事件
    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "position:" + position, Toast.LENGTH_SHORT).show();
    }
}
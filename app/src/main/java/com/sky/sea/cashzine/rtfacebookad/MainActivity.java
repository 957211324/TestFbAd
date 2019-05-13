package com.sky.sea.cashzine.rtfacebookad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private AdView adViewFacebook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll_ad_view = findViewById(R.id.ll_ad_view);
        adViewFacebook = new AdView(this,"1046912242158715_1047353668781239", AdSize.BANNER_HEIGHT_90);
        ll_ad_view.addView(adViewFacebook);
        adViewFacebook.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("onError",adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("onAdLoaded",ad.getPlacementId());
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("onAdClicked",ad.getPlacementId());
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("onLoggingImpression",ad.getPlacementId());
            }
        });
        adViewFacebook.loadAd();
    }
}

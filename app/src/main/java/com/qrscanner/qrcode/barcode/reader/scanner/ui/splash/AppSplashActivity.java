package com.qrscanner.qrcode.barcode.reader.scanner.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import qrcode.qrscanner.barcode.scanner.R;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.util.AdsHelper;
import com.qrscanner.qrcode.barcode.reader.scanner.ui.home.MyHomeActivity;

public class AppSplashActivity extends AppCompatActivity {

    private final int SPLASH_DELAY = 3500;
    private ImageView mImageViewLogo;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow().setBackgroundDrawable(null);

        initViews();
        animateAppLogo();

        startHomeActivity();
    }

    private void initViews() {
        mImageViewLogo = findViewById(R.id.image_view_logo);
    }

    private void startHomeActivity() {
            new Handler().postDelayed(() -> {
                if (AdsHelper.showAd){
                    prepareInterstitial();
                    mInterstitialAd.setAdListener(new AdListener() {
                        @Override
                        public void onAdLoaded() {
                            mInterstitialAd.show();
                        }

                        @Override
                        public void onAdFailedToLoad(int errorCode) {
                            startActivity(new Intent(AppSplashActivity.this, MyHomeActivity.class));
                            finish();
                        }
                        @Override
                        public void onAdClosed() {
                            startActivity(new Intent(AppSplashActivity.this, MyHomeActivity.class));
                            finish();
                        }
                    });
                } else {
                    startActivity(new Intent(AppSplashActivity.this, MyHomeActivity.class));
                    finish();
                }
            }, SPLASH_DELAY);
        }


    private void prepareInterstitial()
    {
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.admob_interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    private void animateAppLogo() {
        int animID = R.anim.fade_in_without_duration;
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, animID);
        fadeInAnimation.setDuration(SPLASH_DELAY);
        mImageViewLogo.startAnimation(fadeInAnimation);
    }
}

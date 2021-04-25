package com.qrscanner.qrcode.barcode.reader.scanner;

import android.content.Context;
import android.os.Handler;

import com.google.android.gms.ads.MobileAds;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.util.AdsHelper;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.util.SharedPrefUtils;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.util.database.DatabaseUtil;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import qrcode.qrscanner.barcode.scanner.R;

public class MyQRCobaApplication extends MultiDexApplication {

    private static MyQRCobaApplication sInstance;

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        SharedPrefUtils.init(getApplicationContext());
        DatabaseUtil.init(getApplicationContext());
        initAdsProviderHelper();
        initMobileAds();
    }

    public void initMobileAds()
    {
        new Handler().postDelayed(() -> {
            if(AdsHelper.showAd)
                MobileAds.initialize(this, getString(R.string.admob_app_id));
        }, 3500);
    }

    public void initAdsProviderHelper(){
        AdsHelper adsHelper = new AdsHelper();
        adsHelper.getShowAdValue();
    }
}

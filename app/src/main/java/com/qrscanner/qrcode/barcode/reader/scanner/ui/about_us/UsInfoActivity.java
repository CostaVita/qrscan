package com.qrscanner.qrcode.barcode.reader.scanner.ui.about_us;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import qrcode.qrscanner.barcode.scanner.R;
import qrcode.qrscanner.barcode.scanner.databinding.ActivityAboutUsBinding;

import android.os.Bundle;
import android.view.MenuItem;

public class UsInfoActivity extends AppCompatActivity {

    ActivityAboutUsBinding mActivityAboutUsBinding;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityAboutUsBinding = DataBindingUtil.setContentView(this, R.layout.activity_about_us);
        initializetoolbar();
    }

    private void initializetoolbar() {
        setSupportActionBar(mActivityAboutUsBinding.toolbar);

        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

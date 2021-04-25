package com.qrscanner.qrcode.barcode.reader.scanner.ui.pickedfromgallery;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.bumptech.glide.Glide;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.constant.IntentKey;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.model.Code;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import qrcode.qrscanner.barcode.scanner.R;
import qrcode.qrscanner.barcode.scanner.databinding.ActivityPickedFromGalleryBinding;

import com.qrscanner.qrcode.barcode.reader.scanner.ui.scanresult.ScannigResultActivity;
import com.qrscanner.qrcode.barcode.reader.scanner.ui.settings.AppOptionsSettingsActivity;

public class PickedQRFromGalleryActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityPickedFromGalleryBinding mBinding;
    private Code mCurrentCode;
    private Menu mToolbarMenu;

    public Menu getToolbarMenu() {
        return mToolbarMenu;
    }

    public void setToolbarMenu(Menu toolbarMenu) {
        mToolbarMenu = toolbarMenu;
    }

    public Code getCurrentCode() {
        return mCurrentCode;
    }

    public void setCurrentCode(Code currentCode) {
        mCurrentCode = currentCode;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_picked_from_gallery);

        initToolbar();
        loadQRCode();
        setListeners();
    }

    private void initToolbar() {
        setSupportActionBar(mBinding.toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }
    }

    private void loadQRCode() {
        Intent intent = getIntent();

        if (intent != null) {
            Bundle bundle = intent.getExtras();

            if (bundle != null && bundle.containsKey(IntentKey.MODEL)) {
                setCurrentCode(bundle.getParcelable(IntentKey.MODEL));
            }
        }

        if (getCurrentCode() != null) {
            if (!TextUtils.isEmpty(getCurrentCode().getCodeImagePath())) {
                Glide.with(this)
                        .asBitmap()
                        .load(getCurrentCode().getCodeImagePath())
                        .into(mBinding.imageViewScannedCode);
            }
        }
    }

    private void setListeners() {
        mBinding.textViewGetValue.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            case R.id.action_settings:
                startActivity(new Intent(this, AppOptionsSettingsActivity.class));
                return true;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_toolbar_menu, menu);
        setToolbarMenu(menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_view_get_value:
                if (getCurrentCode() != null) {
                    Intent intent = new Intent(this, ScannigResultActivity.class);
                    intent.putExtra(IntentKey.MODEL, getCurrentCode());
                    intent.putExtra(IntentKey.IS_PICKED_FROM_GALLERY, true);
                    startActivity(intent);
                }
                break;

            default:
                break;
        }
    }
}

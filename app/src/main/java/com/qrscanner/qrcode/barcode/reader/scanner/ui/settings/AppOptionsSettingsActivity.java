package com.qrscanner.qrcode.barcode.reader.scanner.ui.settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.qrscanner.qrcode.barcode.reader.scanner.helpers.constant.PreferenceKey;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.util.SharedPrefUtils;
import com.qrscanner.qrcode.barcode.reader.scanner.ui.privacy_policy.PrivacyPolicyAppActivity;

import qrcode.qrscanner.barcode.scanner.R;
import qrcode.qrscanner.barcode.scanner.databinding.ActivitySettingsBinding;

import com.qrscanner.qrcode.barcode.reader.scanner.ui.about_us.UsInfoActivity;

public class AppOptionsSettingsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private ActivitySettingsBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_settings);

        initializeToolbar();
        loadSettings();
        setListeners();
    }

    private void loadSettings() {
        mBinding.switchCompatPlaySound.setChecked(SharedPrefUtils.readBooleanDefaultTrue(PreferenceKey.PLAY_SOUND));
        mBinding.switchCompatVibrate.setChecked(SharedPrefUtils.readBooleanDefaultTrue(PreferenceKey.VIBRATE));
        mBinding.switchCompatSaveHistory.setChecked(SharedPrefUtils.readBooleanDefaultTrue(PreferenceKey.SAVE_HISTORY));
        mBinding.switchCompatCopyToClipboard.setChecked(SharedPrefUtils.readBooleanDefaultTrue(PreferenceKey.COPY_TO_CLIPBOARD));
    }

    private void setListeners() {
        mBinding.switchCompatPlaySound.setOnCheckedChangeListener(this);
        mBinding.switchCompatVibrate.setOnCheckedChangeListener(this);
        mBinding.switchCompatSaveHistory.setOnCheckedChangeListener(this);
        mBinding.switchCompatCopyToClipboard.setOnCheckedChangeListener(this);

        mBinding.textViewPlaySound.setOnClickListener(this);
        mBinding.textViewVibrate.setOnClickListener(this);
        mBinding.textViewSaveHistory.setOnClickListener(this);
        mBinding.textViewCopyToClipboard.setOnClickListener(this);
    }

    private void initializeToolbar() {
        setSupportActionBar(mBinding.toolbar);

        ActionBar actionBar = getSupportActionBar();
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

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switch_compat_play_sound:
                SharedPrefUtils.write(PreferenceKey.PLAY_SOUND, isChecked);
                break;
            case R.id.switch_compat_vibrate:
                SharedPrefUtils.write(PreferenceKey.VIBRATE, isChecked);
                break;
            case R.id.switch_compat_save_history:
                SharedPrefUtils.write(PreferenceKey.SAVE_HISTORY, isChecked);
                break;
            case R.id.switch_compat_copy_to_clipboard:
                SharedPrefUtils.write(PreferenceKey.COPY_TO_CLIPBOARD, isChecked);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_view_play_sound:
                mBinding.switchCompatPlaySound.setChecked(!mBinding.switchCompatPlaySound.isChecked());
                break;

            case R.id.text_view_vibrate:
                mBinding.switchCompatVibrate.setChecked(!mBinding.switchCompatVibrate.isChecked());
                break;

            case R.id.text_view_save_history:
                mBinding.switchCompatSaveHistory.setChecked(!mBinding.switchCompatSaveHistory.isChecked());
                break;

            case R.id.text_view_copy_to_clipboard:
                mBinding.switchCompatCopyToClipboard.setChecked(!mBinding.switchCompatCopyToClipboard.isChecked());
                break;

            default:
                break;
        }
    }

    public void startAboutUsActivity(View view) {

        startActivity(new Intent(this, UsInfoActivity.class));
    }

    public void startPrivacyPolicyActivity(View view) {
        startActivity(new Intent(this, PrivacyPolicyAppActivity.class));
    }
}

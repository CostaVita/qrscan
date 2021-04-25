package com.qrscanner.qrcode.barcode.reader.scanner.helpers.util;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;

import androidx.appcompat.app.AlertDialog;
import qrcode.qrscanner.barcode.scanner.databinding.ProgresssDialogLayoutBinding;

public class ProgressDialogUtils {

    private static ProgressDialogUtils sInstance;
    private AlertDialog mAlertDialog;

    private ProgressDialogUtils() {

    }

    public static ProgressDialogUtils on() {
        if (sInstance == null) {
            sInstance = new ProgressDialogUtils();
        }

        return sInstance;
    }

    public void showProgressDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        ProgresssDialogLayoutBinding binding =
                ProgresssDialogLayoutBinding.inflate(LayoutInflater.from(context),
                        null, false);

        binding.textViewMessage.setTypeface(null, Typeface.NORMAL);

        builder.setCancelable(false);
        builder.setView(binding.getRoot());

        mAlertDialog = builder.create();
        mAlertDialog.show();
    }

    public void checkAndHideProgressDialog() {
        if (mAlertDialog != null) {
            mAlertDialog.dismiss();
            mAlertDialog = null;
        }
    }
}

package com.qrscanner.qrcode.barcode.reader.scanner.helpers.util.image;

import android.net.Uri;

public class ImageInformation {
    private Uri mImageUri;
    private boolean mTakenByCamera;

    public ImageInformation() {
    }

    public ImageInformation(Uri imageUri, boolean takenByCamera) {
        mImageUri = imageUri;
        mTakenByCamera = takenByCamera;
    }

    public Uri getImageUri() {
        return mImageUri;
    }

    public void setImageUri(Uri imageUri) {
        mImageUri = imageUri;
    }

    public boolean isTakenByCamera() {
        return mTakenByCamera;
    }

    public void setTakenByCamera(boolean takenByCamera) {
        mTakenByCamera = takenByCamera;
    }
}

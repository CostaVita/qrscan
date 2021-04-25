package com.qrscanner.qrcode.barcode.reader.scanner.ui.base;

import android.view.View;

public interface ItemClickListener<T> {
    void onItemClick(View view, T item, int position);
}

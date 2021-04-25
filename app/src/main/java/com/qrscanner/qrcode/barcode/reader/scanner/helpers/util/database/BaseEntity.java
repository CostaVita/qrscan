package com.qrscanner.qrcode.barcode.reader.scanner.helpers.util.database;

import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.constant.ColumnNames;

public abstract class BaseEntity implements Parcelable {
    /**
     * Fields
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ColumnNames.ID)
    @NonNull
    public long mId;

    /**
     * Getter and setter methods of the model
     */
    public long getId() {
        return mId;
    }
}

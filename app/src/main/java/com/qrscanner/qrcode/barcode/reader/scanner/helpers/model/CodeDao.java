package com.qrscanner.qrcode.barcode.reader.scanner.helpers.model;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Query;

import com.qrscanner.qrcode.barcode.reader.scanner.helpers.constant.TableNames;
import com.qrscanner.qrcode.barcode.reader.scanner.helpers.util.database.BaseDao;

import io.reactivex.Flowable;

@Dao

public interface CodeDao extends BaseDao<Code> {
    @Query("SELECT * FROM " + TableNames.CODES)
    Flowable<List<Code>> getAllFlowableCodes();

}

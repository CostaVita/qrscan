package com.qrscanner.qrcode.barcode.reader.scanner.helpers.util;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdsHelper {
    DatabaseReference dbRef;
    public static boolean showAd;

    public AdsHelper(){
        dbRef = FirebaseDatabase.getInstance()
                .getReference().child("showAd");
    }

    public void getShowAdValue(){
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists() && snapshot.getValue(Boolean.class)) {
                    showAd = (Boolean) snapshot.getValue();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}

package com.ugb.urban_shop;

import androidx.annotation.NonNull;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.OnDisconnect;

public class FirebaseOffline extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        onDisconnect();
    }

    private void onDisconnect() {
        DatabaseReference presenceRef = FirebaseDatabase.getInstance().getReference("disconnectmessage");
        presenceRef.onDisconnect().setValue("I disconnected!");

        presenceRef.onDisconnect().removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError error, @NonNull DatabaseReference reference) {
                if (error != null) {
                    //Log.d(, "could not establish onDisconnect event:" + error.getMessage());
                }
            }
        });

        OnDisconnect onDisconnectRef = presenceRef.onDisconnect();
        onDisconnectRef.setValue("I disconnected");

        onDisconnectRef.cancel();

    }
}


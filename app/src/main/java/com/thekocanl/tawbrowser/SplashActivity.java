package com.thekocanl.tawbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.Manifest;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplashActivity extends Activity {

    /**
     * İzin İstek Kodu
     */
    private final static int REQUEST_CODE_ASK_PERMISSIONS = 1;

    /**
     * Son kullanıcıdan açıkça talep edilmesi gereken izinler
     */
    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[] {
        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        checkPermissions();
    }


    /**
     * Dinamik olarak kontrol edilen izinleri kontrol eder ve son kullanıcıdan eksik izinleri ister
     */
    protected void checkPermissions() {
        final List < String > missingPermissions = new ArrayList < String > ();
        // gerekli tüm dinamik izinleri kontrol edin
        for (final String permission: REQUIRED_SDK_PERMISSIONS) {
            final int result = ContextCompat.checkSelfPermission(this, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission);
            }
        }
        if (!missingPermissions.isEmpty()) {
            // tüm eksik izinleri iste
            final String[] permissions = missingPermissions.toArray(new String[missingPermissions.size()]);
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_ASK_PERMISSIONS);
        } else {
            final int[] grantResults = new int[REQUIRED_SDK_PERMISSIONS.length];
            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED);
            onRequestPermissionsResult(REQUEST_CODE_ASK_PERMISSIONS, REQUIRED_SDK_PERMISSIONS,
            grantResults);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                for (int index = permissions.length - 1; index >= 0; --index) {
                    if (grantResults[index] != PackageManager.PERMISSION_GRANTED) {
                        // bir izin verilmezse uygulamadan çıkın
                        Toast.makeText(this, "Gerekli izin '" + permissions[index] + "' verilmedi, çıkılıyor, lütfen uygulama ayarlarından gerekli izini etkinleştirin.", Toast.LENGTH_LONG)
                            .show();
                        finish();
                        return;
                    }
                }
                // tüm izinler verildi başlatılıyor
                initialize();
                break;
        }
    }

	private void initialize() {
		startActivity(new Intent(this, IntroActivity.class));
        finish();
	}
}

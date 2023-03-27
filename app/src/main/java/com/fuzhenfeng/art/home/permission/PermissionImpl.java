package com.fuzhenfeng.art.home.permission;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionImpl implements Permission {

    @Override
    public boolean check(Context context, String permission) {
        int code = ContextCompat.checkSelfPermission(context, permission);
        return code == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public boolean request(Activity activity, String permission) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, 1);
        return false;
    }
}

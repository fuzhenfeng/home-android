package com.fuzhenfeng.art.home.permission;

import android.app.Activity;
import android.content.Context;

public interface Permission {

    boolean check(Context context, String permission);
    boolean request(Activity activity, String permission);
}

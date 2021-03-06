/**
 * Copyright 2017 Sun Jian
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.crazysunj.crazydaily.moudle.permission;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.support.v7.app.AlertDialog;

import com.crazysunj.crazydaily.R;
import com.crazysunj.crazydaily.util.SnackbarUtil;

import permissions.dispatcher.PermissionRequest;

/**
 * author: sunjian
 * created on: 2018/7/5 上午10:03
 * description:https://github.com/crazysunj/CrazyDaily
 */
public class PermissionHelper {

    private PermissionHelper() {
    }

    public static void storageShowRationale(Activity activity, PermissionRequest request) {
        showRationale(activity, request, R.string.permission_storage_rationale);
    }

    public static void storagePermissionDenied(Activity activity) {
        permissionDenied(activity, R.string.permission_storage_denied);
    }

    public static void storageNeverAskAgain(Activity activity) {
        neverAskAgain(activity, R.string.permission_storage_neverask);
    }

    public static void cameraShowRationale(Activity activity, PermissionRequest request) {
        showRationale(activity, request, R.string.permission_camera_rationale);
    }

    public static void cameraPermissionDenied(Activity activity) {
        permissionDenied(activity, R.string.permission_camera_denied);
    }

    public static void cameraNeverAskAgain(Activity activity) {
        neverAskAgain(activity, R.string.permission_camera_neverask);
    }

    public static void showRationale(Activity activity, PermissionRequest request, @StringRes int message) {
        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton(R.string.button_allow, (dialog, button) -> request.proceed())
                .setNegativeButton(R.string.button_deny, (dialog, button) -> request.cancel())
                .show();
    }

    public static void permissionDenied(Activity activity, @StringRes int message) {
        SnackbarUtil.show(activity, message);
    }

    public static void neverAskAgain(Activity activity, @StringRes int message) {
        SnackbarUtil.show(activity, message);
    }
}

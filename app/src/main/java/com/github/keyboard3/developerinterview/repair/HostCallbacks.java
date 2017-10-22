package com.github.keyboard3.developerinterview.repair;

import android.content.Context;
import android.content.Intent;

import com.allenliu.versionchecklib.core.AllenChecker;
import com.github.keyboard3.developerinterview.ConfigConst;
import com.github.keyboard3.developerinterview.http.HttpClient;
import com.qihoo360.replugin.RePluginCallbacks;

/**
 * 360插件化的回调 如果插件不存在就去下载
 *
 * @author keyboard3
 * @date 2017/9/11
 */

public class HostCallbacks extends RePluginCallbacks {
    private static String TAG = "HostCallbacks";

    public HostCallbacks(Context context) {
        super(context);
    }

    @Override
    public boolean onPluginNotExistsForActivity(final Context context, String plugin, Intent intent, int process) {
        if (plugin.equals(ConfigConst.PACKAGE_SELFVIEW)) {
            AllenChecker.startVersionCheck(context, HttpClient.getInstance().mSelfBuilder.build());
        }
        return super.onPluginNotExistsForActivity(context, plugin, intent, process);
    }
}

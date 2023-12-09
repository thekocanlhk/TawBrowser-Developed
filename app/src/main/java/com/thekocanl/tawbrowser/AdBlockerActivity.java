package com.thekocanl.tawbrowser;

import com.thekocanl.tawbrowser.util.AdBlocker;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.HashMap;
import java.util.Map;

public class AdBlockerActivity {

    static Map < String, Boolean > loadedUrls = new HashMap < >();

    public static boolean blockAds(WebView view, String url) {
        boolean ad;
        if (!loadedUrls.containsKey(url))
		{
            ad = AdBlocker.isAd(url);
            loadedUrls.put(url, ad);
        }
        else
		{
            ad = loadedUrls.get(url);
        }
        return ad;
    }

    public static class init {
        Context mContext;

        public init(Context mContext)
		{
            AdBlocker.init(mContext);
            this.mContext = mContext;
        }
    }
}

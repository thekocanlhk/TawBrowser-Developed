package com.thekocanl.tawbrowser.util;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebResourceResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.HashSet;
import java.util.Set;

public class AdBlocker {
    private static final String AD_HOSTS_FILE = "hosts";
    private static final Set < String > AD_HOSTS = new HashSet < >();

    public static void init(final Context mContext) {
        new AsyncTask < Void, Void, Void >() {
            @Override
            protected Void doInBackground(Void...params)
			{
                try
				{
                    loadFromAssets(mContext);
                }
                catch (IOException e)
				{
                    //
                }
                return null;
            }
        }.execute();
    }

    private static void loadFromAssets(Context mContext) throws IOException {
        InputStream stream = mContext.getAssets().open(AD_HOSTS_FILE);
        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) AD_HOSTS.add(line);
        bufferedReader.close();
        inputStreamReader.close();
        stream.close();
    }

    public static boolean isAd(String url) {
        try
		{
            return isAdHost(UrlUtils.getHost(url));
        }
        catch (MalformedURLException e)
		{
            Log.d("", e.toString());
            return false;
        }

    }

    private static boolean isAdHost(String host) {
        if (TextUtils.isEmpty(host))
		{
            return false;
        }
        int index = host.indexOf(".");
        return index >= 0 && (AD_HOSTS.contains(host) || index + 1 < host.length() && isAdHost(host.substring(index + 1)));
    }

    public static WebResourceResponse createEmptyResource()
	{
        return new WebResourceResponse("text/plain", "utf-8", new ByteArrayInputStream("".getBytes()));
    }

}

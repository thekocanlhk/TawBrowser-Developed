package com.thekocanl.tawbrowser;

import com.thekocanl.tawbrowser.AdBlockerActivity;
import com.thekocanl.tawbrowser.util.AdBlocker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.widget.SwipeRefreshLayout;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.widget.*;
import android.graphics.*;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;
import android.view.ViewTreeObserver;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;

import android.print.PrintManager;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;

import android.view.View.*;
import java.lang.reflect.Method;

import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.os.Handler;
import android.os.Looper;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import android.webkit.GeolocationPermissions;

import android.webkit.WebResourceResponse;

import android.net.http.SslCertificate;
import java.util.Date;

import android.content.pm.ActivityInfo;

import android.speech.RecognizerIntent;
import android.content.ActivityNotFoundException;
import java.util.ArrayList;
import android.text.TextUtils;
import android.content.*;

public class WebActivity extends AppCompatActivity implements View.OnClickListener {

    private WebView webView;
    private ProgressBar progressBar;
    private EditText textUrl, findBox;
	private TextView homePageSearch, urltitle, urlfull;
    private ImageView webIcon, webCertificate, goBack, goForward, navSet, goHome, speakGo, btnStart, btnSearchEngine, textUrlClean, textUrlEdit, floatButton, homePageSpeakGo, imageLabeldownload, imageLabelhistory, imageLabelsavedpage, imageLabeladdpage, imageLabelshare, imageLabeldarktheme, imageLabeladblocker, imageLabelfindpage, imageLabeldesktopsite, imageLabeltextsize, imageLabelzoomin, imageLabelprint, imageLabelsecurity, imageLabelsettings, imageLabeltranslation, imageLabelotorotate, imageLabelfullscreen, imageLabelwidefullscreen, imageLabelswiperefresh, imageLabelnojavascript, imageLabelnopicture, imageLabelcleandata, imageLabelsafebrowser, imageLabelexitapp;
    private SwipeRefreshLayout swipeRefreshLayout;
    // Tam Ekran Kullanımı
    private LinearLayout toplinearLayout, sublinearLayout, layoutSearch, layoutSearchUrlInfo;
    
    // Search
    private ImageButton closeButton, nextButton, backButton;
    
    // Ayarlar
    private FrameLayout navsetLayout, homePageLayout;

    private long exitTime = 0;
    
    // Tam Ekran Kullanımı
    private int floatbutton = 0;
    
    // Main Menu Fullscreen
    private int floatbuttonhideshow = 0;
    
    // Main Menu Wide Fullscreen
    private int widefullscreen = 0;
    
    // Main Menu Wide Fullscreen On Off
    private int widefullscreen_on_off = 0;
    
	// Main Menu Dark Theme
	private int darktheme = 0;
    
	// Main Menu Swipe Refresh
	private int swiperefresh = 0;
	
	// Main Menu No Javascript
	private int nojavascript = 0;
	
	// Main Menu No Picture
	private int nopicture = 0;
	
	// Main Menu Desktop Site
	private int desktopsite = 0;
    
	// Main Menu Oto Rotate
	private int otorotate = 0;
	
    // Ayarlar
    private int navset = 0;
    
    // Ad Blocker
    private int adblocker = 0;
    
    // Ad Blocker On Off
    private int adblockeronoff = 0;
    
    // Search
    private int findpage = 0;
    
	// Clean Data
	private int gt = 1;
	private int agt = 1;
	private int wot = 0;
	private int uot = 0;
	private int fvt = 1;
	private int wct = 1;
	private boolean bol0 = true;
	private boolean bol1 = true;
	private boolean bol2 = false;
	private boolean bol3 = false;
	private boolean bol4 = true;
	private boolean bol5 = true;
	
	//Search Engine
	private boolean sebol0 = true;
	private boolean sebol1 = false;
	private boolean sebol2 = false;
	private boolean sebol3 = false;
	private boolean sebol4 = false;
	private boolean sebol5 = false;
	private boolean sebol6 = false;
	private boolean sebol7 = false;
	private String searchengineurlinput = "https://www.google.com/search?q=";
	
	// Arama Çubuğu Göster Gizle
	private float startY;
	private int autohidesearchbar = 0;
	
	private int homepagesearch = 0;
	
	private int homepagespeakgo = 0;

    private Context mContext;
    private InputMethodManager manager;

    private static final int RESULT_SPEECH = 1;

    private static final String HTTP = "http://";
    private static final String HTTPS = "https://";
    private static final int PRESS_BACK_EXIT_GAP = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Alt Düğmenin Yukarı Hareket Etmesini Engelle
        getWindow().setSoftInputMode
                (WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN |
                        WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        setContentView(R.layout.activity_web);

        mContext = WebActivity.this;
        manager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        // Ad Blocker
        new AdBlockerActivity.init(this);

        // Bağlama Kontrolleri
        initView();

        // Web Görünümünü Başlat
        initWeb();
        
        // Swipe Refresh
        swipeRefresh();
        
		// Arama Çubuğu Göster Gizle
		autohideSearchBar();
    }

    /**
     * Bağlama Kontrolleri
     */
    private void initView() {
        webView = findViewById(R.id.webView);
        progressBar = findViewById(R.id.progressBar);
        textUrl = findViewById(R.id.textUrl);
        webIcon = findViewById(R.id.webIcon);
        webCertificate = findViewById(R.id.webCertificate);
        btnStart = findViewById(R.id.btnStart);
        goBack = findViewById(R.id.goBack);
        goForward = findViewById(R.id.goForward);
        navSet = findViewById(R.id.navSet);
        goHome = findViewById(R.id.goHome);
        
        // Main Menu Bağlama Kontrolleri
        imageLabeldownload = findViewById(R.id.imageLabeldownload);
        imageLabelhistory = findViewById(R.id.imageLabelhistory);
        imageLabelsavedpage = findViewById(R.id.imageLabelsavedpage);
        imageLabeladdpage = findViewById(R.id.imageLabeladdpage);
        imageLabelshare = findViewById(R.id.imageLabelshare);
        imageLabeldarktheme = findViewById(R.id.imageLabeldarktheme);
        imageLabeladblocker = findViewById(R.id.imageLabeladblocker);
        imageLabelfindpage = findViewById(R.id.imageLabelfindpage);
        imageLabeldesktopsite = findViewById(R.id.imageLabeldesktopsite);
        imageLabeltextsize = findViewById(R.id.imageLabeltextsize);
        imageLabelzoomin = findViewById(R.id.imageLabelzoomin);
        imageLabelprint = findViewById(R.id.imageLabelprint);
        imageLabelsecurity = findViewById(R.id.imageLabelsecurity);
        imageLabelsettings = findViewById(R.id.imageLabelsettings);
        imageLabeltranslation = findViewById(R.id.imageLabeltranslation);
        imageLabelotorotate = findViewById(R.id.imageLabelotorotate);
        imageLabelfullscreen = findViewById(R.id.imageLabelfullscreen);
        imageLabelwidefullscreen = findViewById(R.id.imageLabelwidefullscreen);
        imageLabelswiperefresh = findViewById(R.id.imageLabelswiperefresh);
        imageLabelnojavascript = findViewById(R.id.imageLabelnojavascript);
        imageLabelnopicture = findViewById(R.id.imageLabelnopicture);
        imageLabelcleandata = findViewById(R.id.imageLabelcleandata);
        imageLabelsafebrowser = findViewById(R.id.imageLabelsafebrowser);
        imageLabelexitapp = findViewById(R.id.imageLabelexitapp);
        
        //Tam Ekran Kullanımı
        toplinearLayout = findViewById(R.id.toplinearLayout);
        sublinearLayout = findViewById(R.id.sublinearLayout);
        
        // Search
        findBox = findViewById(R.id.findBox);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backButton);
        closeButton = findViewById(R.id.closeButton);
        layoutSearch = findViewById(R.id.layoutSearch);
        
        // Layout Search Url Info
        layoutSearchUrlInfo = findViewById(R.id.layoutSearchUrlInfo);
        urltitle = findViewById(R.id.urltitle);
        urlfull = findViewById(R.id.urlfull);
        
        // Search Engine
        btnSearchEngine = findViewById(R.id.btnSearchEngine);
        
        // Speak Go
        speakGo  = findViewById(R.id.speakGo);
        
        // Ayarlar
        navsetLayout = findViewById(R.id.navsetLayout);
        
        // Anasayfa Layout
        homePageLayout = findViewById(R.id.homePageLayout);
		homePageSearch = findViewById(R.id.homePageSearch);
		homePageSpeakGo = findViewById(R.id.homePageSpeakGo);
        
        // Adresi Silme
        textUrlClean = findViewById(R.id.textUrlClean);
        
        // Adresi Düzenleme
        textUrlEdit = findViewById(R.id.textUrlEdit);
        
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);

        swipeRefreshLayout.setColorSchemeColors(Color.BLACK,Color.BLACK,Color.BLACK);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (swiperefresh == 1) {
                    webView.reload();
                    swipeRefreshLayout.setRefreshing(false);
                } 
                else if (swiperefresh == 0) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
        
        // Web Site Sertifika Bilgisi
        webCertificate.setOnClickListener(new View.OnClickListener() { 
		    @Override 
		    public void onClick(View v) {
		        String s = "URL: " + webView.getUrl() + "\n";
                s += "Başlık: " + webView.getTitle() + "\n\n";
                SslCertificate certificate = webView.getCertificate();
                s += certificate == null ? "Güvenli değil" : "Sertifika:  Güvenli\n" + certificateToStr(certificate);

                AlertDialog.Builder certificateDialog = new AlertDialog.Builder(WebActivity.this)
                        .setTitle("Sertifika bilgisi")
                        .setMessage(s)
                        .setPositiveButton("Kapat", new DialogInterface.OnClickListener() {
							@Override
						    public void onClick(DialogInterface dialog, int which)
						    {
								//
						    }
						});
                        certificateDialog.show();
			}
		});
		
		// SwipeRefreshLayout sayfa üstünde yenileme ayarı
		webView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
			@Override
			public void onScrollChanged() {
			    if (swiperefresh == 1) {
				    if (webView.getScrollY()==0) {
					    swipeRefreshLayout.setEnabled(true);
			        }else {
					    swipeRefreshLayout.setEnabled(false);
				    }
				}
			}
		});
		
		// Anasayfa Arama odaklanma
		homePageSearch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//
				if(homepagesearch == 0) {
					textUrl.requestFocus();
					//InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
					//inputMethodManager.showSoftInput(textUrl, InputMethodManager.SHOW_IMPLICIT);
					showKeyboard(textUrl);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					//
					// Gösterme Animasyonu
					toplinearLayout.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() {
						public void onAnimationEnd(Animator animation, View view) {
							super.onAnimationEnd(animation);
							view.setVisibility(View.VISIBLE);
						}
					});
					//
					// Gösterme Süresi
					Handler handler = new Handler(Looper.getMainLooper());
					handler.postDelayed(new Runnable() {
						public void run() {
							WebActivity.this.toplinearLayout.setVisibility(View.VISIBLE);
						}
					}, 1);
					//
				}
			}
		});
		
		// Anasayfa Speak Go
		homePageSpeakGo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//
				if(homepagespeakgo == 0) {
					speakGo();
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					//
					// Gösterme Animasyonu
					toplinearLayout.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() {
						public void onAnimationEnd(Animator animation, View view) {
							super.onAnimationEnd(animation);
							view.setVisibility(View.VISIBLE);
						}
					});
					//
					// Gösterme Süresi
					Handler handler = new Handler(Looper.getMainLooper());
					handler.postDelayed(new Runnable() {
						public void run() {
							WebActivity.this.toplinearLayout.setVisibility(View.VISIBLE);
						}
					}, 1);
					//
				}
			}
		});
        
        // Speak Go
        speakGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
				speakGo();
				//
            }
        });
        
        // Adresi Silme
        textUrlClean.setOnClickListener(new View.OnClickListener() { 
		    @Override 
		    public void onClick(View v) {
				textUrl.setText(webView.getUrl());
				textUrl.setSelection(textUrl.getText().length());
				textUrl.getText().clear();
			}
		});
		
        // Adresi Silme
        textUrlEdit.setOnClickListener(new View.OnClickListener() { 
		    @Override 
		    public void onClick(View v) {
				textUrl.setText(webView.getUrl());
				textUrl.setSelection(textUrl.getText().length());
			}
		});

        //Tam Ekran Kullanımı
        floatButton = findViewById(R.id.floatButton);

		// Tam Ekran Düğmesi Kullanımı
		floatButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v)
				{
					if (floatbutton == 0)
					{
					    initView();
						toplinearLayout.setVisibility(View.GONE);
						Toast.makeText(mContext, "Tam Ekran açıldı çıkmak için tekrar basın", Toast.LENGTH_SHORT).show();
						floatButton.setImageResource(R.drawable.icfullscreenexit24dp);
						sublinearLayout.setVisibility(View.GONE);
						autohidesearchbar = 1;
						floatbutton = 1;
						initView();
					}
					else if (floatbutton == 1)
					{
					    initView();
						toplinearLayout.setVisibility(View.VISIBLE);
						toplinearLayout.setAlpha(1.0f);
						Toast.makeText(mContext, "Tam Ekrandan çıkıldı açmak için tekrar basın", Toast.LENGTH_SHORT).show();
						floatButton.setImageResource(R.drawable.icfullscreen24dp);
						sublinearLayout.setVisibility(View.VISIBLE);
						autohidesearchbar = 0;
						floatbutton = 0;
						initView();
					}
					if (findpage == 1)
					{
						initView();
					    toplinearLayout.setVisibility(View.GONE);
					    layoutSearch.setVisibility(View.VISIBLE);
					    autohidesearchbar = 1;
						initView();
					}
				}
			});

        // Bağlama Düğmesi Tıklama Olayı
        btnStart.setOnClickListener(this);
        goBack.setOnClickListener(this);
        goForward.setOnClickListener(this);
        navSet.setOnClickListener(this);
        goHome.setOnClickListener(this);
        
        // Main Menu Bağlama Kontrolleri
        imageLabeldownload.setOnClickListener(this);
        imageLabelhistory.setOnClickListener(this);
        imageLabelsavedpage.setOnClickListener(this);
        imageLabeladdpage.setOnClickListener(this);
        imageLabelshare.setOnClickListener(this);
        imageLabeldarktheme.setOnClickListener(this);
        imageLabeladblocker.setOnClickListener(this);
        imageLabelfindpage.setOnClickListener(this);
        imageLabeldesktopsite.setOnClickListener(this);
        imageLabeltextsize.setOnClickListener(this);
        imageLabelzoomin.setOnClickListener(this);
        imageLabelprint.setOnClickListener(this);
        imageLabelsecurity.setOnClickListener(this);
        imageLabelsettings.setOnClickListener(this);
        imageLabeltranslation.setOnClickListener(this);
        imageLabelotorotate.setOnClickListener(this);
        imageLabelfullscreen.setOnClickListener(this);
        imageLabelwidefullscreen.setOnClickListener(this);
        imageLabelswiperefresh.setOnClickListener(this);
        imageLabelnojavascript.setOnClickListener(this);
        imageLabelnopicture.setOnClickListener(this);
        imageLabelcleandata.setOnClickListener(this);
        imageLabelsafebrowser.setOnClickListener(this);
        imageLabelexitapp.setOnClickListener(this);
        
        // Search
        nextButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        closeButton.setOnClickListener(this);
        
        //Search Engine
        btnSearchEngine.setOnClickListener(this);

        // Adresi Silme
        textUrlClean.setVisibility(View.GONE);
        
        // Adresi Düzenleme
        textUrlEdit.setVisibility(View.GONE);
        
        // Speak Go
        speakGo.setVisibility(View.GONE);
        
        // Adres Giriş Alanı Odağı Alır Ve Kaybeder
        textUrl.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    // Geçerli URL Bağlantısını Göster TODO:Arama Terimlerini Gösteren Arama Sayfası
                    textUrl.setText(webView.getUrl());
                    // Sonunda İmleç
                    textUrl.setSelection(textUrl.getText().length());
                    // Adresi Silme
                    textUrl.getText().clear();
                    // İnternet Simgesini Göster
                    webIcon.setImageResource(R.drawable.internet);
                    // Atlama düğmelerini göster
                    btnStart.setImageResource(R.drawable.go);
                    // Adresi Silme
                    textUrlClean.setVisibility(View.VISIBLE);
                    // Adresi Düzenleme
                    textUrlEdit.setVisibility(View.VISIBLE);
                    // Web Site Sertifika Bilgisi
                    webCertificate.setVisibility(View.GONE);
                    webIcon.setVisibility(View.VISIBLE);
                    // Speak Go
                    speakGo.setVisibility(View.VISIBLE);
                    // Layout Search Url Info
                    urltitle.setText(webView.getTitle());
                    urltitle.setEms(14);
                    urlfull.setText(webView.getUrl());
                    urlfull.setEms(18);
                    layoutSearchUrlInfo.setVisibility(View.VISIBLE);
                } 
                else {
                    // Web Sitesi Adını Göster
                    textUrl.setText(webView.getTitle());
                    // Favicon'u Göster
                    webIcon.setImageBitmap(webView.getFavicon());
                    // Yenile Düğmesini Göster
                    btnStart.setImageResource(R.drawable.refresh);
                    // Adresi Silme
                    textUrlClean.setVisibility(View.INVISIBLE);
                    // Adresi Düzenleme
                    textUrlEdit.setVisibility(View.INVISIBLE);
                    // Web Site S CUHideShowControl
                    cuhideshowControl();
                    // Speak Go
                    speakGo.setVisibility(View.GONE);
                    // Layout Search Url Info
                    layoutSearchUrlInfo.setVisibility(View.GONE);
                    // Görünümü Tekrar Başlat
                    initView();
                }
            }
        });
        
        // Search
		findBox.setOnKeyListener(new OnKeyListener()
			{
				public boolean onKey(View v, int keyCode, KeyEvent event)
				{
					if (((findpage == 1)) && ((event.getAction() == KeyEvent.ACTION_DOWN)) && ((keyCode == KeyEvent.KEYCODE_ENTER)))
					{
						webView.findAllAsync(findBox.getText().toString());

						try
						{
							for (Method m : WebView.class.getDeclaredMethods())
							{
								if (m.getName().equals("setFindIsUp"))
								{
									m.setAccessible(true);
									m.invoke(webView, true);
									break;
								}
							}
						}
						catch (Exception ignored)
						{
						}
						finally
						{
							InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
							View vv = getCurrentFocus();
							if (vv != null)
							{
								inputManager.hideSoftInputFromWindow(v.getWindowToken(),
																	 InputMethodManager.HIDE_NOT_ALWAYS);
							}
						}
					}
					return false;
				}
			});

        // Monitör Klavyesi Aramaya Gir
        textUrl.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    // Arama Yap
                    btnStart.callOnClick();
                    textUrl.clearFocus();
                }
                return false;
            }
        });
    }


    /**
     * Web'i Başlat
     */
    @SuppressLint("SetJavaScriptEnabled")
    private void initWeb() {
        // Yeniden Yazmak WebViewClient
        webView.setWebViewClient(new TawWebViewClient());
        // Yeniden Yazmak WebChromeClient
        webView.setWebChromeClient(new TawWebChromeClient());

        WebSettings settings = webView.getSettings();
        // JS İşlevini Etkinleştir
        settings.setJavaScriptEnabled(true);
        // Tarayıcıyı Kullanıcı Aracısı Olarak Ayarla
        settings.setUserAgentString(settings.getUserAgentString() + " TawBrowser/" + getVerName(mContext));

        // Resmi Web Görünümüne Sığdırmak İçin Yeniden Boyutlandırın
        settings.setUseWideViewPort(true);
        // Ekranın Boyutuna Yakınlaştırın
        settings.setLoadWithOverviewMode(true);

        // Ölçeklendirmeyi Destekler, Varsayılanlar true'dur.  Aşağıdakilerin Öncülüdür.
        settings.setSupportZoom(true);
        // Yerleşik Yakınlaştırma Kontrollerini Ayarlar.  false'yse, WebView Yakınlaştırılamaz
        settings.setBuiltInZoomControls(true);
        // Yerel Yakınlaştırma Denetimlerini Gizle
        settings.setDisplayZoomControls(false);
        
		// Çoklu Pencereleri Destekleme
		settings.setSupportMultipleWindows(true);

        // WebView Background Color
		webView.setBackgroundColor(Color.WHITE);

        // Önbellek
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // Dosya Erişimini Ayarla
        settings.setAllowFileAccess(true);
        // JS Aracılığıyla Yeni Pencerelerin Açılmasını Destekleyin
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        // Resimlerin Otomatik Yüklenmesini Destekleyin
        settings.setLoadsImagesAutomatically(true);
        // Varsayılan Kodlama Biçimini Ayarlayın
        settings.setDefaultTextEncodingName("utf-8");
        // Yerel Depolama
        settings.setDomStorageEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
		// Geolocation Path
		settings.setGeolocationEnabled(true);
		settings.setGeolocationDatabasePath(String.valueOf(mContext.getFilesDir().getAbsolutePath()) + "/location");
        // AppCache Path
        settings.setAppCacheEnabled(true);
        settings.setAppCachePath(String.valueOf(mContext.getFilesDir().getAbsolutePath()) + "/cache");
        // Database Path
        settings.setDatabaseEnabled(true);
        settings.setDatabasePath(String.valueOf(mContext.getFilesDir().getAbsolutePath()) + "/databases");
        // WebView Metin Boyutu
        settings.setTextZoom(100);

        // Kaynak Karışımı Modu
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        // Ana Sayfayı Yükle
        SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
        SharedPreferences.Editor spe = sp.edit();
        //
        if (sp.getInt("HOMEPAGEURLCHANGE", 0) == 1) {
            //
            webView.loadUrl(""+sp.getString("HOMEPAGEURL", ""));
        }
        else {
            //
            webView.loadUrl(getResources().getString(R.string.home_url));
        }
    }


    /**
     * Swipe Refresh
     */
    private void swipeRefresh() {
        swipeRefreshLayout.setEnabled(false);
    }


    /**
     * WebView Back Forward Control
     */
    private void goBackForwardControl() {
	    //
	    goBack.setColorFilter(Color.parseColor("#c8c8c8"));
		goForward.setColorFilter(Color.parseColor("#c8c8c8"));
		//
	    if(webView.canGoBack()) {
	        //
	        goBack.setColorFilter(Color.parseColor("#4d4d4d"));
	    }
	    //
	    if(webView.canGoForward()) {
	        //
	        goForward.setColorFilter(Color.parseColor("#4d4d4d"));
	    }
	    //
	}


    /**
     * WebView Share Url Control
     */
    private void webviewShareUrlControl() {
	    //
	    imageLabelshare.setColorFilter(Color.parseColor("#c8c8c8"));
	    imageLabelprint.setColorFilter(Color.parseColor("#c8c8c8"));
	    imageLabeltranslation.setColorFilter(Color.parseColor("#c8c8c8"));
		//
		String cuUrl = getResources().getString(R.string.home_url);
	    if(webView.getUrl() != null && !webView.getUrl().equals(cuUrl)) {
	        //
	        imageLabelshare.setColorFilter(Color.parseColor("#000000"));
	        imageLabelprint.setColorFilter(Color.parseColor("#000000"));
	        imageLabeltranslation.setColorFilter(Color.parseColor("#000000"));
	    }
	    //
	}
	
	
	/**
	 * Speak Go
	 */
	private void speakGo() {
		//
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		// Konuşmadan Niyet Kullanarak Değeri Alın
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "tr-TR");
		try {
			startActivityForResult(intent, RESULT_SPEECH);
			// Metni Boş Olarak Ayarla
			textUrl.setText("");
		}
		catch (ActivityNotFoundException a) {
			// Cihaz Desteklenmiyorsa Bir Tost Göster
			Toast.makeText(getApplicationContext(), "Üzgünüm cihazınız Speech to Text'i desteklemiyor", Toast.LENGTH_SHORT)
				.show();
		}
		//
	}
	
	
	/**
	 * Hide Keyboard
	 */
	private void hideKeyboard(View view) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
	}
	
	
	/**
	 * Show Keyboard
	 */
	private void showKeyboard(View view) {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT);
	}
	
	
	/**
	 * Anasayfa Kontrol - Show Hide
	 */
	private void homePageControl() {
		String cuUrl = getResources().getString(R.string.home_url);
		if (webView.getUrl() != null && !webView.getUrl().equals(cuUrl))
		{
			initView();
			// Gizleme Süresi
			Handler handler = new Handler(Looper.getMainLooper());
			handler.postDelayed(new Runnable() {
				public void run() {
					// Gizleme Animasyonu
					homePageLayout.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
						public void onAnimationEnd(Animator animation, View view) {
							super.onAnimationEnd(animation);
							view.setVisibility(View.GONE);
						}
					});
				}
			}, 500);
			//
			homepagesearch = 1;
			homepagespeakgo = 1;
			initView();
		}
		else
		{
			initView();
			// Gösterme Süresi
			Handler handler = new Handler(Looper.getMainLooper());
			handler.postDelayed(new Runnable() {
				public void run() {
					// Gösterme Animasyonu
					homePageLayout.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() {
						public void onAnimationEnd(Animator animation, View view) {
							super.onAnimationEnd(animation);
							view.setVisibility(View.VISIBLE);
						}
					});
					webView.setVisibility(View.GONE);
				}
			}, 1);
			//
			Handler handler2 = new Handler(Looper.getMainLooper());
			handler2.postDelayed(new Runnable() {
				public void run() {
					webView.setVisibility(View.VISIBLE);
				}
			}, 500);
			//
			homepagesearch = 0;
			homepagespeakgo = 0;
			initView();
		}
	}


	/**
	 * Arama Çubuğu Göster Gizle
	 */
	private void autohideSearchBar() {
		this.webView.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View view, MotionEvent event) {
				// NavSetLayout Touch Hide
				navsetLayout.setVisibility(View.GONE);
				navset = 0;
				// Hide Keyboard
				hideKeyboard(textUrl);
				//
			    // Açık = Kapalı
				if (WebActivity.this.autohidesearchbar == 1) {
					return false;
				}
				//
				// 1
				if (event.getAction() == 0) {
					WebActivity.this.startY = event.getY();
				}
				//
				// 2
				if (event.getAction() == 2 || Math.abs(WebActivity.this.startY - event.getY()) <= ((float) (new ViewConfiguration().getScaledTouchSlop() * 5))) {
					return false;
				}
				//
				// Göster
				if (WebActivity.this.startY < event.getY()) {
					// Gösterme Animasyonu
				    toplinearLayout.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() {
						public void onAnimationEnd(Animator animation, View view) {
							super.onAnimationEnd(animation);
							view.setVisibility(View.VISIBLE);
						}
					});
					//
					// Gösterme Süresi
					Handler handler = new Handler(Looper.getMainLooper());
				    handler.postDelayed(new Runnable() {
						public void run() {
							WebActivity.this.toplinearLayout.setVisibility(View.VISIBLE);
						}
					}, 1);
					//
					return false;
				}
				//
				// Gizle
				    // Gizleme Animasyonu
				    toplinearLayout.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
						public void onAnimationEnd(Animator animation, View view) {
							super.onAnimationEnd(animation);
							view.setVisibility(View.GONE);
						}
					});
					//
					// Gizleme Süresi
				    Handler handler = new Handler(Looper.getMainLooper());
				    handler.postDelayed(new Runnable() {
						public void run() {
							WebActivity.this.toplinearLayout.setVisibility(View.GONE);
						}
					}, 1);
					//
				    return false;
				//
			}
		});
    }


	/**
     * Search Engine
     */
    private void searchEngineChange() {
        //
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Arama motoru seçin");
        String[] items = {"Google", "Bing", "Yandex", "DuckDuckGo", "Startpage", "Yahoo", "Ask", "Wow"};
        boolean[] checkedItems = {sebol0, sebol1, sebol2, sebol3, sebol4, sebol5, sebol6, sebol7};
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {@Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                switch (which) {
                    //
                    case 0:
                        if (isChecked) {
                            //
                            initView();
                            btnSearchEngine.setImageResource(R.drawable.se_google);
                            sebol0 = true;
                            sebol1 = false;
                            sebol2 = false;
                            sebol3 = false;
                            sebol4 = false;
                            sebol5 = false;
                            sebol6 = false;
                            sebol7 = false;
                            searchengineurlinput = "https://www.google.com/search?q=";
                            dialog.cancel();
                            initView();
                        } else {
                            //
                            initView();
                            sebol0 = true;
                            dialog.cancel();
                            initView();
                        }
                        break;
                        //
                    case 1:
                        if (isChecked) {
                            //
                            initView();
                            btnSearchEngine.setImageResource(R.drawable.se_bing);
                            sebol0 = false;
                            sebol1 = true;
                            sebol2 = false;
                            sebol3 = false;
                            sebol4 = false;
                            sebol5 = false;
                            sebol6 = false;
                            sebol7 = false;
                            searchengineurlinput = "https://www.bing.com/search?q=";
                            dialog.cancel();
                            initView();
                        } else {
                            //
                            initView();
                            sebol1 = true;
                            dialog.cancel();
                            initView();
                        }
                        break;
                        //
                    case 2:
                        if (isChecked) {
                            //
                            initView();
                            btnSearchEngine.setImageResource(R.drawable.se_yandex);
                            sebol0 = false;
                            sebol1 = false;
                            sebol2 = true;
                            sebol3 = false;
                            sebol4 = false;
                            sebol5 = false;
                            sebol6 = false;
                            sebol7 = false;
                            searchengineurlinput = "https://yandex.com/search/touch/?text=";
                            dialog.cancel();
                            initView();
                        } else {
                            //
                            initView();
                            sebol2 = true;
                            dialog.cancel();
                            initView();
                        }
                        break;
                        //
                    case 3:
                        if (isChecked) {
                            //
                            initView();
                            btnSearchEngine.setImageResource(R.drawable.se_duckduckgo);
                            sebol0 = false;
                            sebol1 = false;
                            sebol2 = false;
                            sebol3 = true;
                            sebol4 = false;
                            sebol5 = false;
                            sebol6 = false;
                            sebol7 = false;
                            searchengineurlinput = "https://duckduckgo.com/?q=";
                            dialog.cancel();
                            initView();
                        } else {
                            //
                            initView();
                            sebol3 = true;
                            dialog.cancel();
                            initView();
                        }
                        break;
                        //
                    case 4:
                        if (isChecked) {
                            //
                            initView();
                            btnSearchEngine.setImageResource(R.drawable.se_startpage);
                            sebol0 = false;
                            sebol1 = false;
                            sebol2 = false;
                            sebol3 = false;
                            sebol4 = true;
                            sebol5 = false;
                            sebol6 = false;
                            sebol7 = false;
                            searchengineurlinput = "https://www.startpage.com/do/search?query=";
                            dialog.cancel();
                            initView();
                        } else {
                            //
                            initView();
                            sebol4 = true;
                            dialog.cancel();
                            initView();
                        }
                        break;
                        //
                    case 5:
                        if (isChecked) {
                            //
                            initView();
                            btnSearchEngine.setImageResource(R.drawable.se_yahoo);
                            sebol0 = false;
                            sebol1 = false;
                            sebol2 = false;
                            sebol3 = false;
                            sebol4 = false;
                            sebol5 = true;
                            sebol6 = false;
                            sebol7 = false;
                            searchengineurlinput = "https://search.yahoo.com/search?p=";
                            dialog.cancel();
                            initView();
                        } else {
                            //
                            initView();
                            sebol5 = true;
                            dialog.cancel();
                            initView();
                        }
                        break;
                        //
                    case 6:
                        if (isChecked) {
                            //
                            initView();
                            btnSearchEngine.setImageResource(R.drawable.se_ask);
                            sebol0 = false;
                            sebol1 = false;
                            sebol2 = false;
                            sebol3 = false;
                            sebol4 = false;
                            sebol5 = false;
                            sebol6 = true;
                            sebol7 = false;
                            searchengineurlinput = "https://www.ask.com/web?q=";
                            dialog.cancel();
                            initView();
                        } else {
                            //
                            initView();
                            sebol6 = true;
                            dialog.cancel();
                            initView();
                        }
                        break;
                    case 7:
                        if (isChecked) {
                            //
                            initView();
                            btnSearchEngine.setImageResource(R.drawable.se_wow);
                            sebol0 = false;
                            sebol1 = false;
                            sebol2 = false;
                            sebol3 = false;
                            sebol4 = false;
                            sebol5 = false;
                            sebol6 = false;
                            sebol7 = true;
                            searchengineurlinput = "https://www.wow.com/search?p=";
                            dialog.cancel();
                            initView();
                        } else {
                            //
                            initView();
                            sebol7 = true;
                            dialog.cancel();
                            initView();
                        }
                        break;
                }
            }
        });
        builder.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {@Override
            public void onClick(DialogInterface dialog, int which) {
                initView();
                btnSearchEngine.setImageResource(R.drawable.se_google);
                sebol0 = true;
                    sebol1 = false;
                sebol2 = false;
                sebol3 = false;
                sebol4 = false;
                sebol5 = false;
                sebol6 = false;
                sebol7 = false;
                Toast.makeText(WebActivity.this, "Varsayılan arama motoru seçildi", Toast.LENGTH_SHORT)
                    .show();
                initView();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    /**
     * Clean Data D
     */
    private void cleanAllData() {
	  //
      AlertDialog.Builder alertDialog = new AlertDialog.Builder(WebActivity.this);
      alertDialog.setTitle("");
      String[] items = {"Geçmişi temizle", "Arama geçmişini temizle", "Web önbelleğini temizle", "Uygulama önbelleğini temizle", "Form verilerini temizle ", "Web çerezlerini temizle"};
      boolean[] checkedItems = {bol0, bol1, bol2, bol3, bol4, bol5};
      alertDialog.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which, boolean isChecked) {
              switch (which) {
                  case 0:
                      if(isChecked) {
                          gt = 1;
                          bol0 = true;
                      }
                      else {
                          gt = 0;
                          bol0 = false;
                      }
                  break;
                  case 1:
                      if(isChecked) {
                          agt = 1;
                          bol1 = true;
                      }
                      else {
                          agt = 0;
                          bol1 = false;
                      }
                  break;
                  case 2:
                      if(isChecked) {
                          wot = 1;
                          bol2 = true;
                      }
                      else {
                          wot = 0;
                          bol2 = false;
                      }
                  break;
                  case 3:
                      if(isChecked) {
                          uot = 1;
                          bol3 = true;
                      }
                      else {
                          uot = 0;
                          bol3 =false;
                      }
                  break;
                  case 4:
                      if(isChecked) {
                          fvt = 1;
                          bol4 = true;
                      }
                      else {
                          fvt = 0;
                          bol4 = false;
                      }
                  break;
                  case 5:
                      if(isChecked) {
                          wct = 1;
                          bol5 = true;
                      }
                      else {
                          wct = 0;
                          bol5 = false;
                      }
                  break;
              }
          }
      });
	  alertDialog.setNeutralButton("Varsayılan", new DialogInterface.OnClickListener() {
		  @Override
		  public void onClick(DialogInterface dialog, int which)
		      {
		          initView();
				  cleanAllDataDefault();
				  Toast.makeText(WebActivity.this, "Varsayılan ayarlara sıfırlandı", Toast.LENGTH_SHORT).show();
				  cleanAllData();
				  initView();
			  }
	  });
	  alertDialog.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which)
              {
				  Toast.makeText(WebActivity.this, "İptal edildi", Toast.LENGTH_SHORT).show();
              }
      });
      alertDialog.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
          @Override
          public void onClick(DialogInterface dialog, int which)
              {
				  if(gt == 1 || agt == 1 || wot == 1 || uot == 1 || fvt == 1 || wct ==1) {
					  //
					  // Geçmişi temizle
                      if(gt == 1) {
					      //
						  webView.clearHistory();
				      }
				      else if(gt == 0) {
					      //
				      }
					  //
				      // Arama geçmişini temizle
				      if(agt == 1) {
					      //
						  webView.clearMatches();
				      }
				      else if(agt == 0) {
					      //
				      }
				      //
					  // Web önbelleğini temizle
				      if(wot == 1) {
					      //
				      }
				      else if (wot == 0) {
					      //
				      }
				      //
					  // Uygulama önbelleğini temizle
				      if(uot == 1) {
					      //
				      }
				      else if(uot == 0) {
					      //
				      }
				      //
					  // Form verilerini temizle
				      if(fvt == 1) {
					      //
						  webView.clearFormData();
				      }
				      else if(fvt == 0) {
					      //
				      }
				      //
					  // Web çerezlerini temizle
				      if(wct == 1) {
					      //
						  webView.clearHistory();
						  webView.clearFormData();
						  webView.clearCache(true);
				      }
				      else if(wct == 0) {
					      //
				      }
				      //
				      if (gt == 1 || agt == 1 || wot == 1 || uot == 1 || fvt == 1 || wct ==1) {
				          if (gt == 1 && agt == 1 && wot == 1 && uot == 1 && fvt == 1 && wct ==1) {
				              Toast.makeText(WebActivity.this, "Tümü temizleniyor...", Toast.LENGTH_SHORT).show();
				          }
				          else {
					          Toast.makeText(WebActivity.this, "Seçilenler temizleniyor...", Toast.LENGTH_SHORT).show();
				          }
				          Toast.makeText(WebActivity.this, "Temizlendi", Toast.LENGTH_SHORT).show();
				      }
				  }
				  else if(gt == 0 && agt == 0 && wot == 0 && uot == 0 && fvt == 0 && wct == 0) {
				      initView();
				      cleanAllData();
				      Toast.makeText(WebActivity.this, "Hıçbir öğe seçilmedi tekrar seçim yapın ve tamam tuşuna basın veya çıkmak için iptal tuşuna basınız", Toast.LENGTH_SHORT).show();
				      initView();
				  }
              }
      });
      AlertDialog alert = alertDialog.create();
      alert.setCanceledOnTouchOutside(false);
      alert.show();
	  //
   }


    /**
     * Clean Data D Reset Value
     */
    private void cleanAllDataReset() {
        gt = 0;
        agt = 0;
        wot = 0;
        uot = 0;
        fvt = 0;
        wct = 0;
		bol0 = false;
		bol1 = false;
		bol2 = false;
		bol3 = false;
		bol4 = false;
		bol5 = false;
    }


	/**
     * Clean Data D Default Value
     */
    private void cleanAllDataDefault() {
        gt = 1;
        agt = 1;
        wot = 0;
        uot = 0;
        fvt = 1;
        wct = 1;
		bol0 = true;
		bol1 = true;
		bol2 = false;
		bol3 = false;
		bol4 = true;
		bol5 = true;
    }


    /**
     * Exit App
     */
    private void confirmExitApp() {
        // uyarı iletişim kutusu
        AlertDialog.Builder builder = new AlertDialog.Builder(WebActivity.this);
        builder.setIcon(R.drawable.splash);
        builder.setTitle("TawBrowser'dan çıkış yapmak istediğinize emin misiniz?");
        //
        String[] items = {"Web önbelleğini temizle", "Geçmişi temizle", "Her seferinde bana sor"};
		boolean[] checkedItems = {false, false, true};
		builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                switch (which) {
                    //
                    case 0:
                        if(isChecked) {
                            //
				        }
                        else {
                            //
				        }
                    break;
                    //
                    case 1:
                        if(isChecked) {
					        //
					        webView.clearHistory();
				        }
				        else {
					        //
				        }
                    break;
                    //
                    case 2:
                        if(isChecked) {
					        //
				        }
				        else {
					        //
				        }
                    break;
                }
            }
        });
        // bazı eylemler yapmak için hayır düğmesini ayarlayın
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                initView();
            }
        });
        // bazı eylemler yapmak için evet düğmesini ayarlayın
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                initView();
				Intent intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_HOME);
				intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
            }
        });
        // uyarı iletişim kutusunu göster
        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.setCancelable(false);
        alertDialog.show();
    }


    /**
     * Web Site Sertifika Bilgisi
     */
    private void certificateControl() {
        SslCertificate certificate = webView.getCertificate();
        if (certificate == null) {
            //
			initView();
            webCertificate.setImageResource(R.drawable.unreliable_certificate);
			cuhideshowControl();
			initView();
        }
		else
		{
			//
			initView();
			webCertificate.setImageResource(R.drawable.reliable_certificate);
			cuhideshowControl();
			initView();
		}
    }


    /**
     * Web Site S CUHideShowControl
     */
    private void cuhideshowControl() {
		String cuUrl = getResources().getString(R.string.home_url);
		if (webView.getUrl() != null && !webView.getUrl().equals(cuUrl))
		{
			initView();
			webIcon.setVisibility(View.GONE);
			webCertificate.setVisibility(View.VISIBLE);
			initView();
        }
		else
		{
			initView();
			webCertificate.setVisibility(View.GONE);
			webIcon.setVisibility(View.VISIBLE);
			initView();
		}
    }


    /**
     * Light Theme
     */
    private void lightTheme() {
        //
        getWindow().setStatusBarColor(Color.parseColor("#cccccc"));
        getWindow().setNavigationBarColor(Color.parseColor("#cccccc"));
    }


    /**
     * Dark Theme
     */
    private void darkTheme() {
        //
        getWindow().setStatusBarColor(Color.parseColor("#0f0f0f"));
        getWindow().setNavigationBarColor(Color.parseColor("#0f0f0f"));
    }


    /**
     * Main Menu Printer
     */
	private void createWebPrintJob(WebView webView) {  
		PrintManager printManager = (PrintManager) this.getSystemService(Context.PRINT_SERVICE);  
		PrintDocumentAdapter printAdapter = webView.createPrintDocumentAdapter();  
		String jobName = getString(R.string.app_name) + " Print Test";  
		printManager.print(jobName, printAdapter, new PrintAttributes.Builder().build());  
	}


    /**
     * Yeniden Yazmak WebViewClient
     */
    private class TawWebViewClient extends WebViewClient {
        // Ad Blocker
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            if (adblockeronoff == 1) {
            return AdBlockerActivity.blockAds(view, url) ? AdBlocker.createEmptyResource() : super.shouldInterceptRequest(view, url);
            }
            return null;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // WebView'e Tıklayarak Açılan Yeni Web Sayfasını, Yeni Tarayıcıya Atlamadan Mevcut Arayüzde Görüntülenecek Şekilde Ayarlayın

            if (url == null) {
                // Kendiniz Halletmek İçin true, İşlememek İçin false Döndürün
                return true;
            }

            // Normal İçerik, Açık
            if (url.startsWith(HTTP) || url.startsWith(HTTPS)) {
                view.loadUrl(url);
                return true;
            }

            // Üçüncü Taraf Uygulamaları Arayın，Engel Olmak Crash (Telefonunuzda Yüklü Bir Cihaz Yoksa个scheme Başlangıç url的APP, 会导致crash)
            try {
                // TODO:Pop-up Kullanıcıya Sorar，İzin Aldıktan Sonra Ara
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            } catch (Exception e) {
                return true;
            }
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            // Bir İlerleme Çubuğu Gösteren Web Sayfası Yüklenmeye Başlar
            progressBar.setProgress(0);
            progressBar.setVisibility(View.VISIBLE);

            // Durum Metnini Güncelle
            textUrl.setText("Yükleniyor...");

            // Varsayılan Web Simgesini Aç/Kapat
            webIcon.setImageResource(R.drawable.internet);
            
            // Web Site Sertifika Bilgisi
            certificateControl();
            
            // WebView Refresh Stop
            // WebView Durdur Ikonu Goster
            btnStart.setImageResource(R.drawable.ic_stop_or_close);
            
            // WebView Back Forward Control
            goBackForwardControl();
            
            // WebView Share Url Control
            webviewShareUrlControl();
			
			// Anasayfa Kontrol - Show Hide
			homePageControl();
        }
        
        @Override
		public void onLoadResource(WebView view, String url)
		{
			super.onLoadResource(view, url);
			// Main Menu Desktop Site
			if (desktopsite == 1) {
		    webView.evaluateJavascript("javascript:document.querySelector('meta[name=\"viewport\"]').setAttribute('content', 'width=1080px, initial-scale=' + (document.documentElement.clientWidth / 1080));", null);
		    webView.zoomOut();
			}
		}

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            // Sayfa Yüklendi Ve İlerleme Çubuğu Gizlendi
            progressBar.setVisibility(View.INVISIBLE);

            // Başlığı Değiştir
            setTitle(webView.getTitle());
            // Sayfa Başlığını Göster
            textUrl.setText(webView.getTitle());
            
            // Web Site Sertifika Bilgisi
            certificateControl();
            
            // WebView Refresh Stop
            // WebView Yenile Ikonu Göster
            btnStart.setImageResource(R.drawable.refresh);
            
            // WebView Back Forward Control
            goBackForwardControl();
            
            // WebView Share Url Control
            webviewShareUrlControl();
			
			// Anasayfa Kontrol - Show Hide
			homePageControl();
        }

        // No Internet
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl)
		{
            Toast.makeText(getApplicationContext(), "İnternet Bağlantısı Yok", Toast.LENGTH_LONG).show();
            webView.loadUrl(getResources().getString(R.string.home_url));
        }

		@Override
		public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error)
		{
			final AlertDialog.Builder builder = new AlertDialog.Builder(WebActivity.this);
			String message = "SSL Sertifikası hatası.";
			switch (error.getPrimaryError())
			{
				case SslError.SSL_UNTRUSTED:
					message = "Sertifika yetkilisine güvenilmiyor.";
					break;
				case SslError.SSL_EXPIRED:
					message = "Sertifikanın süresi doldu.";
					break;
				case SslError.SSL_IDMISMATCH:
					message = "Sertifika Ana Bilgisayar adı uyuşmazlığı.";
					break;
				case SslError.SSL_NOTYETVALID:
					message = "Sertifika henüz geçerli değil.";
					break;
			}
			message += " Yine de devam etmek istiyor musun?";

			builder.setTitle("SSL Sertifikası Hatası");
			builder.setMessage(message);

			builder.setPositiveButton("devam et", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						handler.proceed();
					}
				});
			builder.setNegativeButton("iptal", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which)
					{
						handler.cancel();
					}
				});
			final AlertDialog dialog = builder.create();
			dialog.show();
		}
    }


    /**
     * Yeniden Yazmak WebChromeClient
     */
    private class TawWebChromeClient extends WebChromeClient {
        private final static int WEB_PROGRESS_MAX = 100;
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        protected FrameLayout mFullscreenContainer;
        private int mOriginalOrientation;
        private int mOriginalSystemUiVisibility;

        TawWebChromeClient() {}

        public Bitmap getDefaultVideoPoster()
        {
            if (mCustomView == null) {
                return null;
            }
            return BitmapFactory.decodeResource(getApplicationContext().getResources(), 2130837573);
        }

        public void onHideCustomView()
        {
            ((FrameLayout)getWindow().getDecorView()).removeView(this.mCustomView);
            this.mCustomView = null;
            getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
            setRequestedOrientation(this.mOriginalOrientation);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mCustomViewCallback = null;
        }

        public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
        {
            if (this.mCustomView != null)
            {
                onHideCustomView();
                return;
            }
            this.mCustomView = paramView;
            this.mOriginalSystemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
            this.mOriginalOrientation = getRequestedOrientation();
            this.mCustomViewCallback = paramCustomViewCallback;
            ((FrameLayout)getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
            getWindow().getDecorView().setSystemUiVisibility(3846 | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
															 | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
															 | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
															 | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

		// Coğrafi Konum İzni
		@Override
		public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
			callback.invoke(origin, true, false);
		}

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);

            // İlerleme Değişiklikleri Yükleniyor, İlerleme Çubuğunu Yenileyin
            progressBar.setProgress(newProgress);
            if (newProgress > 0) {
                if (newProgress == WEB_PROGRESS_MAX) {
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        }

        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);

            // Simgeyi Değiştir
            webIcon.setImageBitmap(icon);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);

            // Başlığı Değiştir
            setTitle(title);
            // Sayfa Başlığını Göster
            textUrl.setText(title);
        }
    }

    /**
     * Geri Düğmesi Kullanımı
     */
    @Override
    public void onBackPressed() {
        // Geri Dönebiliyorsanız, Önceki Sayfaya Dönün
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > PRESS_BACK_EXIT_GAP) {
                // Programdan Çıkmak İçin Çift Tıklayın
                Toast.makeText(mContext, "Programdan çıkmak için tekrar basın",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                // Exit App
                confirmExitApp();
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // Search Engine
            case R.id.btnSearchEngine:
                searchEngineChange();
                break;
            // Atla Veya Yenile
            case R.id.btnStart:
                if (textUrl.hasFocus()) {
                    // Yumuşak Klavyeyi Gizle
                    if (manager.isActive()) {
                        manager.hideSoftInputFromWindow(textUrl.getApplicationWindowToken(), 0);
                    }

                    // Adres Çubuğunun Odağı Var, Bu Bir Sıçrama
                    String input = textUrl.getText().toString();
                    if (!isHttpUrl(input)) {
                        // URL Değil, İşlenmek Üzere Arama Motoru Tarafından Yüklendi
                        try {
                            // URL Kodlama
                            input = URLEncoder.encode(input, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        input = searchengineurlinput + input + "&ie=UTF-8";
                    }
                    webView.loadUrl(input);

                    // Adres Çubuğunun Odağını İptal Et
                    textUrl.clearFocus();
                } else {
                    // Adres Çubuğunda Odak Yok, Yenileniyor Yada Durduruluyor
                    // WebView Refresh Stop
                    if(webView.getProgress() == 100) {
                        webView.reload();
                    }
                    else {
                        webView.stopLoading();
                    }
                }
                break;

            // Geri
            case R.id.goBack:
                webView.goBack();
                break;

            // İleri
            case R.id.goForward:
                webView.goForward();
                break;

            // Ayarlar
            case R.id.navSet:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                if (navset == 0)
					{
					    initView();
						navsetLayout.setVisibility(View.VISIBLE);
						navset = 1;
						initView();
					}
				else if (navset == 1)
					{
					    initView();
						navsetLayout.setVisibility(View.GONE);
						navset = 0;
						initView();
					}
                break;

            // Anasayfa
            case R.id.goHome:
                if (findpage == 0) 
                {
                    SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
					SharedPreferences.Editor spe = sp.edit();
					//
					if (sp.getInt("HOMEPAGEURLCHANGE", 0) == 1) {
						//
						webView.loadUrl(""+sp.getString("HOMEPAGEURL", ""));
					}
					else {
						//
						webView.loadUrl(getResources().getString(R.string.home_url));
					}
                
                    toplinearLayout.animate().alpha(1.0f).setListener(new AnimatorListenerAdapter() {
					    public void onAnimationEnd(Animator animation, View view) {
						    super.onAnimationEnd(animation);
						    view.setVisibility(View.VISIBLE);
					    }
				    });
				
				    Handler handler = new Handler(Looper.getMainLooper());
				    handler.postDelayed(new Runnable() {
				    	public void run() {
						    WebActivity.this.toplinearLayout.setVisibility(View.VISIBLE);
					    }
				    }, 1);
				}
				if (findpage == 1) 
				{
				    SharedPreferences sp = getSharedPreferences("PREFS", MODE_PRIVATE);
					SharedPreferences.Editor spe = sp.edit();
					//
					if (sp.getInt("HOMEPAGEURLCHANGE", 0) == 1) {
						//
						webView.loadUrl(""+sp.getString("HOMEPAGEURL", ""));
					}
					else {
						//
						webView.loadUrl(getResources().getString(R.string.home_url));
					}
                
                    toplinearLayout.animate().alpha(0.0f).setListener(new AnimatorListenerAdapter() {
					    public void onAnimationEnd(Animator animation, View view) {
						    super.onAnimationEnd(animation);
						    view.setVisibility(View.GONE);
					    }
				    });
				
				    Handler handler = new Handler(Looper.getMainLooper());
				    handler.postDelayed(new Runnable() {
				    	public void run() {
						    WebActivity.this.toplinearLayout.setVisibility(View.GONE);
					    }
				    }, 1);
				}
                break;
                
            // Search
            case R.id.closeButton:
				if (findpage == 1)
				{
					initView();
                    toplinearLayout.setVisibility(View.VISIBLE);
                    toplinearLayout.setAlpha(1.0f);
                    layoutSearch.setVisibility(View.GONE);
					InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
					webView.clearMatches();
                    findBox.getText().clear();
					webView.findFocus();
                    imageLabelfindpage.setColorFilter(Color.BLACK);
                    autohidesearchbar = 0;
					findpage = 0;
					initView();
				}
				if (floatbutton == 1)
				{
				    initView();
				    toplinearLayout.setVisibility(View.GONE);
				    sublinearLayout.setVisibility(View.GONE);
				    autohidesearchbar = 1;
					initView();
				}
                break;

            // Search Next
            case R.id.nextButton:
				if (findpage == 1)
				{
					initView();
					webView.findNext(true);
					initView();
				}
                break;
                
            // Search Back
            case R.id.backButton:
				if (findpage == 1)
				{
					initView();
					webView.findNext(false);
					initView();
				}
                break;
                
            // Main Menu Download
            case R.id.imageLabeldownload:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                startActivity(new Intent(this, DownloadActivity.class));
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu History
            case R.id.imageLabelhistory:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                startActivity(new Intent(this, HistoryActivity.class));
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu Saved Page
            case R.id.imageLabelsavedpage:
                Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu Add Page
            case R.id.imageLabeladdpage:
                Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu Share
            case R.id.imageLabelshare:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                //
                String cuUrl = getResources().getString(R.string.home_url);
                if(webView.getUrl() != null && !webView.getUrl().equals(cuUrl)) {
                    //
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
				    shareIntent.setType("text/plain");
				    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "TawBrowser");
				    String shareMessage = webView.getUrl();
				    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);  
				    startActivity(Intent.createChooser(shareIntent, "Paylaşım öğesi seç"));
                }
                //
                else {
                    //
                    initView();
                    navsetLayout.setVisibility(View.VISIBLE);
                    navset = 1;
                    initView();
				}
				//
				initView();
                break;
                
            // Main Menu Dark Theme
            case R.id.imageLabeldarktheme:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
				if (darktheme == 0)
				{
					initView();
					// Dark
					imageLabeldarktheme.setColorFilter(Color.BLUE);
					darkTheme();
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					darktheme = 1;
					initView();
				}
				else if (darktheme == 1)
				{
					initView();
					// Light
					imageLabeldarktheme.setColorFilter(Color.BLACK);
					lightTheme();
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					darktheme = 0;
					initView();
				}
                break;
                
            // Main Menu Ad Blocker
            case R.id.imageLabeladblocker:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                if (adblocker == 0)
                {
                    initView();
					imageLabeladblocker.setColorFilter(Color.BLUE);
					adblockeronoff = 1;
					webView.reload();
                    navsetLayout.setVisibility(View.GONE);
                    navset = 0;
                    adblocker = 1;
                    initView();
                }
                else if (adblocker == 1)
                {
                    initView();
					imageLabeladblocker.setColorFilter(Color.BLACK);
					adblockeronoff = 0;
					webView.reload();
                    navsetLayout.setVisibility(View.GONE);
                    navset = 0;
                    adblocker = 0;
                    initView();
                }
                break;
                
            // Main Menu Find Page
            case R.id.imageLabelfindpage:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
				if (findpage == 0)
				{
					initView();
                    toplinearLayout.setVisibility(View.GONE);
                    layoutSearch.setVisibility(View.VISIBLE);
                    findBox.requestFocus();
                    findBox.setFocusableInTouchMode(true);
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.showSoftInput(findBox, InputMethodManager.SHOW_IMPLICIT);
                    imageLabelfindpage.setColorFilter(Color.BLUE);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					autohidesearchbar = 1;
					findpage = 1;
					initView();
				}
				else if (findpage == 1)
				{
					initView();
                    toplinearLayout.setVisibility(View.VISIBLE);
                    layoutSearch.setVisibility(View.GONE);
					webView.clearMatches();
					findBox.getText().clear();
					webView.findFocus();
                    imageLabelfindpage.setColorFilter(Color.BLACK);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					autohidesearchbar = 0;
					findpage = 0;
					initView();
				}
                break;
                
            // Main Menu Desktop Site
            case R.id.imageLabeldesktopsite:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
				if (desktopsite == 0)
				{
                    initView();
                    webView.reload();
                    webView.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36" + " TawBrowser/" + getVerName(mContext));
					imageLabeldesktopsite.setColorFilter(Color.BLUE);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					desktopsite = 1;
                    initView();
				}
				else if (desktopsite == 1)
				{
					initView();
					webView.reload();
					webView.getSettings().setUserAgentString(webView.getSettings().getDefaultUserAgent(mContext) + " TawBrowser/" + getVerName(mContext));
					imageLabeldesktopsite.setColorFilter(Color.BLACK);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					desktopsite = 0;
					initView();
				}
                break;
                
            // Main Menu Text Size
            case R.id.imageLabeltextsize:
                Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu Zoom In
            case R.id.imageLabelzoomin:
                Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu Print
            case R.id.imageLabelprint:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                //
                String cuUrll = getResources().getString(R.string.home_url);
                if(webView.getUrl() != null && !webView.getUrl().equals(cuUrll)) {
                    //
                    createWebPrintJob(webView);
                }
                //
                else {
                    //
                    initView();
                    navsetLayout.setVisibility(View.VISIBLE);
                    navset = 1;
                    initView();
				}
				//
				initView();
                break;
                
            // Main Menu Security
            case R.id.imageLabelsecurity:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                startActivity(new Intent(this, PrivacyActivity.class));
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu Settings
            case R.id.imageLabelsettings:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                startActivity(new Intent(this, SettingsActivity.class));
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu Translation
            case R.id.imageLabeltranslation:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                //
                String cuUrlll = getResources().getString(R.string.home_url);
                if(webView.getUrl() != null && !webView.getUrl().equals(cuUrlll)) {
                    //
                    webView.loadUrl("https://translate.google.com/translate?sl=auto&tl=en&u="+webView.getOriginalUrl());
                }
                //
                else {
                    //
                    initView();
                    navsetLayout.setVisibility(View.VISIBLE);
                    navset = 1;
                    initView();
				}
				//
                initView();
                break;
                
            // Main Menu Oto Rotate
            case R.id.imageLabelotorotate:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                if (otorotate == 0)
				{
					initView();
					imageLabelotorotate.setColorFilter(Color.BLUE);
					imageLabelotorotate.setImageResource(R.drawable.icotorotateon);
					setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					otorotate = 1;
					initView();
				}
				else if (otorotate == 1)
				{
					initView();
					imageLabelotorotate.setColorFilter(Color.BLACK);
					imageLabelotorotate.setImageResource(R.drawable.icotorotate);
					setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					otorotate = 0;
					initView();
				}
                break;
                
            // Main Menu Fullscreen
            case R.id.imageLabelfullscreen:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                if (floatbuttonhideshow == 0)
				{
					initView();
					imageLabelfullscreen.setColorFilter(Color.BLUE);
					floatButton.setImageResource(R.drawable.icfullscreen24dp);
					floatButton.setVisibility(View.VISIBLE);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					floatbuttonhideshow = 1;
					initView();
				}
				else if (floatbuttonhideshow == 1)
				{
					initView();
					imageLabelfullscreen.setColorFilter(Color.BLACK);
					floatButton.setVisibility(View.GONE);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					floatbuttonhideshow = 0;
					initView();
				}
                break;
                
            // Main Menu Wide Fullscreen
            case R.id.imageLabelwidefullscreen:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                if (widefullscreen == 0)
				{
					initView();
					// Hide
					imageLabelwidefullscreen.setColorFilter(Color.BLUE);
					View decorView = getWindow().getDecorView();
					int uiOptions = View.STATUS_BAR_HIDDEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
					decorView.setSystemUiVisibility(uiOptions);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					widefullscreen = 1;
					initView();
				}
				else if (widefullscreen == 1)
				{
					initView();
					// Show
					imageLabelwidefullscreen.setColorFilter(Color.BLACK);
					View decorView = getWindow().getDecorView();
					decorView.setSystemUiVisibility(widefullscreen_on_off);
					navsetLayout.setVisibility(View.GONE);
					navset = 0;
					widefullscreen = 0;
					initView();
				}
                break;
                
            // Main Menu Swipe Refresh
            case R.id.imageLabelswiperefresh:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                if (swiperefresh == 0)
                {
                    initView();
					imageLabelswiperefresh.setColorFilter(Color.BLUE);
					swipeRefreshLayout.setEnabled(true);
                    navsetLayout.setVisibility(View.GONE);
                    navset = 0;
                    swiperefresh = 1;
                    initView();
                }
                else if (swiperefresh == 1)
                {
                    initView();
					imageLabelswiperefresh.setColorFilter(Color.BLACK);
					swipeRefreshLayout.setEnabled(false);
                    navsetLayout.setVisibility(View.GONE);
                    navset = 0;
                    swiperefresh = 0;
                    initView();
                }
                break;
                
            // Main Menu No Javascript
            case R.id.imageLabelnojavascript:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                if (nojavascript == 0)
                {
                    initView();
					imageLabelnojavascript.setColorFilter(Color.BLUE);
					webView.getSettings().setJavaScriptEnabled(false);
                    navsetLayout.setVisibility(View.GONE);
                    navset = 0;
                    nojavascript = 1;
                    initView();
                }
                else if (nojavascript == 1)
                {
                    initView();
					imageLabelnojavascript.setColorFilter(Color.BLACK);
					webView.getSettings().setJavaScriptEnabled(true);
                    navsetLayout.setVisibility(View.GONE);
                    navset = 0;
                    nojavascript = 0;
                    initView();
                }
                break;
                
            // Main Menu No Picture
            case R.id.imageLabelnopicture:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                if (nopicture == 0)
                {
                    initView();
					imageLabelnopicture.setColorFilter(Color.BLUE);
					webView.getSettings().setLoadsImagesAutomatically(false);
                    navsetLayout.setVisibility(View.GONE);
                    navset = 0;
                    nopicture = 1;
                    initView();
                }
                else if (nopicture == 1)
                {
                    initView();
					imageLabelnopicture.setColorFilter(Color.BLACK);
					webView.getSettings().setLoadsImagesAutomatically(true);
                    navsetLayout.setVisibility(View.GONE);
                    navset = 0;
                    nopicture = 0;
                    initView();
                }
                break;
                
            // Main Menu Clean Data
            case R.id.imageLabelcleandata:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                cleanAllData();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;
                
            // Main Menu Safe Browser
            case R.id.imageLabelsafebrowser:
                Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;

            // Main Menu Exit App
            case R.id.imageLabelexitapp:
                //Toast.makeText(mContext, "Bu sürüm geliştirme sürümüdür. desteklenmiyor", Toast.LENGTH_SHORT).show();
                initView();
                confirmExitApp();
                navsetLayout.setVisibility(View.GONE);
                navset = 0;
                initView();
                break;

            default:
        }
    }


    /**
     * OnActivityResult
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // ...
        switch (requestCode) {
            // Speak Go
            case RESULT_SPEECH:
                if (resultCode == RESULT_OK && null != data) {
                    //
                    final ArrayList < String > text = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textUrl.setText(text.get(0));
                    String speechValue = textUrl.getText().toString();
                    //
                    if (!TextUtils.isEmpty(speechValue)) {
                        //
                        final Intent speakGoIntent = new Intent(this, WebActivity.class);
                        speakGoIntent.putExtra("SpeechValue", speechValue);
                        startActivity(speakGoIntent);
                        //
                        // Yazının içerdiği sonuçlar bulunuyor @WebView
                        String speechValue2 = textUrl.getText().toString();
                        webView.loadUrl("https://www.google.com/search?q=" + speechValue2);
                        textUrl.clearFocus();
                        //
                    }
                }
                break;
        }
        //
    }


    @Override
    protected void onPause() {
        super.onPause();
        try {
            webView.getClass().getMethod("onPause").invoke(webView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            webView.getClass().getMethod("onResume").invoke(webView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Bir Dize Olup Olmadığını BelirleyinURL
     *
     * @param urls Eşlemek İçin Dize
     * @return true:EvetURL、false:HayırURL
     */
    public static boolean isHttpUrl(String urls) {
        boolean isUrl;
        // URL Olup Olmadığını Belirlemek İçin Normal İfade
        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";

        Pattern pat = Pattern.compile(regex.trim());
        Matcher mat = pat.matcher(urls.trim());
        isUrl = mat.matches();
        return isUrl;
    }

    /**
     * Web Site Sertifika Bilgisi
     */
    private static String certificateToStr(SslCertificate certificate) {
        if (certificate == null) {
            return null;
        }
        String s = "";
        SslCertificate.DName issuedTo = certificate.getIssuedTo();
        if (issuedTo != null) {
            s += "Verilen: " + issuedTo.getDName() + "\n";
        }
        SslCertificate.DName issuedBy = certificate.getIssuedBy();
        if (issuedBy != null) {
            s += "Veren: " + issuedBy.getDName() + "\n";
        }
        Date issueDate = certificate.getValidNotBeforeDate();
        if (issueDate != null) {
            s += String.format("Verildiği Tarih: %tF %tT %tz\n", issueDate, issueDate, issueDate);
        }
        Date expiryDate = certificate.getValidNotAfterDate();
        if (expiryDate != null) {
            s += String.format("Son Kullanma Tarihi: %tF %tT %tz\n", expiryDate, expiryDate, expiryDate);
        }
        return s;
    }

    /**
     * Sürüm Numarası Adını Al
     *
     * @param context Bağlam
     * @return Mevcut Sürüm Adı
     */
    private static String getVerName(Context context) {
        String verName = "unKnow";
        try {
            verName = context.getPackageManager().
                    getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }
}

package com.thekocanl.tawbrowser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;
import android.view.LayoutInflater;

public class IntroActivity extends Activity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        SharedPreferences sharedPreferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        if (sharedPreferences.getInt("INTRO", 0) == 1)
		{
            startActivity(new Intent(IntroActivity.this, WebActivity.class));
            finish();
        }
        viewPager = findViewById(R.id.view_pager);
        dotsLayout = findViewById(R.id.layoutDots);
        btnSkip = findViewById(R.id.btn_skip);
        btnNext = findViewById(R.id.btn_next);
        layouts = new int[] {
            R.xml.slide1,
            R.xml.slide2,
            R.xml.slide3
        };
        // Alt Noktaları Ekleme
        addBottomDots(0);
        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
    }


    public void btnSkipClick(View v) {
        launchHomeScreen();
    }
    public void btnNextClick(View v)
	{
        // Son Sayfa Kontrol Ediliyor
        // if - Eğer Son Sayfa Ana Ekranı Açılacaksa
        int current = getItem(1);
        if (current < layouts.length)
		{
            // Sonraki Ekrana Git
            viewPager.setCurrentItem(current);
        }
		else
		{
            launchHomeScreen();
        }
    }


    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position)
		{
            addBottomDots(position);
            // Sonraki Düğme Metnini Değiştirme'
            if (position == layouts.length - 1)
			{
                btnNext.setText(getString(R.string.start));
                btnSkip.setVisibility(View.GONE);
            }
			else
			{
                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
		{
        }
        @Override
        public void onPageScrollStateChanged(int arg0)
		{
        }
    };


    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];
        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++)
		{
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources()
								 .getColor(R.color.dot_inactive));
            dotsLayout.addView(dots[i]);
        }
        if (dots.length > 0) dots[currentPage].setTextColor(getResources()
															.getColor(R.color.dot_active));
    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    private void launchHomeScreen() {
        // Giriş Ekranını Paylaşılan Tercihle İlk Kez Kaydet
        SharedPreferences sharedPreferences = getSharedPreferences("PREFS", MODE_PRIVATE);
        SharedPreferences.Editor editor;
        editor = sharedPreferences.edit();
        editor.putInt("INTRO", 1);
        editor.apply();
        startActivity(new Intent(this, WebActivity.class));
        finish();
    }


    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
        public ViewPagerAdapter()
		{
        }
        @Override
        public Object instantiateItem(ViewGroup container, int position)
		{
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);
            return view;
        }
        @Override
        public int getCount()
		{
            return layouts.length;
        }
        @Override
        public boolean isViewFromObject(View view, Object obj)
		{
            return view == obj;
        }
        @Override
        public void destroyItem(ViewGroup container, int position, Object object)
		{
            View view = (View) object;
            container.removeView(view);
        }
    }
}

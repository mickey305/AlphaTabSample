package com.example.alphatabsample;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

public class AlphaTabActivity extends FragmentActivity implements ActionBar.TabListener {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_tab_activity);

        // アクションバーの取得
        final ActionBar actionBar = this.getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle("TabTestApp");

        int titleId = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        View titleView = findViewById(titleId);
        Spinner spinnerView = (Spinner) getLayoutInflater().inflate(R.layout.spinner_layout, null);
        ViewGroupUtils.replaceView(titleView, spinnerView);

        // タブに表示する文字の配列
        final String[] tabTitles = {"イングランド", "北アイルランド", "スコットランド", "ウェールズ"};
        // フラグメントクラスの配列
        final Class[] classes = {
                TabFirstFragment.class,
                TabSecondFragment.class,
                TabThirdFragment.class,
                TabFourthFragment.class
        };
        TabsPagerAdapter pagerAdapter = new TabsPagerAdapter(
                this, getSupportFragmentManager(), tabTitles, classes);
        viewPager = (ViewPager) findViewById(R.id.container_pager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(
                    int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            // アクションバーにタブを追加する
            actionBar.addTab(
                    actionBar.newTab().setText(pagerAdapter.getPageTitle(i)).setTabListener(this)
            );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.alpha_tab_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}

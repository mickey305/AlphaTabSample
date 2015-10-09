package com.example.alphatabsample;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AlphaTabActivity extends Activity {
    private AlphaTabSampleApplication app;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alpha_tab_activity);

        app = (AlphaTabSampleApplication) getApplication();

        // アクションバーの取得
        actionBar = this.getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle("TabTestApp");
        actionBar.setSubtitle("プロジェクト１");
        // タブに表示する文字の配列
        final String[] tabTitles = {"イングランド", "北アイルランド", "スコットランド", "ウェールズ"};
        // タブリスナーのリスト
        final TabConnector[] tabConnectors = new TabConnector[4];
        tabConnectors[0] = new TabConnector<TabFirstFragment>(this, "tag1", TabFirstFragment.class);
        tabConnectors[1] = new TabConnector<TabSecondFragment>(this, "tag2", TabSecondFragment.class);
        tabConnectors[2] = new TabConnector<TabThirdFragment>(this, "tag3", TabThirdFragment.class);
        tabConnectors[3] = new TabConnector<TabFourthFragment>(this, "tag4", TabFourthFragment.class);
        for (int position = 0; position < tabTitles.length; position++) {
            String tabTitle = tabTitles[position];
            TabConnector tabConnector = tabConnectors[position];
            // アクションバーにタブを追加する
            actionBar.addTab(actionBar.newTab().setText(tabTitle).setTabListener(tabConnector));
        }
        int tabPosition = app.getAlphaTabPosition();
        actionBar.selectTab(actionBar.getTabAt(tabPosition));
    }

    @Override
    public void onPause() {
        super.onPause();

        app.setAlphaTabPosition(actionBar.getSelectedTab().getPosition());
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
}

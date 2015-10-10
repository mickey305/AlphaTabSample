package com.example.alphatabsample;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    // タブタイトル文字の配列
    private String[] titles;

    // フラグメントクラスの配列
    private Class[] classes;

    // コンテキスト
    private Context context;

    /**
     *
     * @param context コンテキスト
     * @param fm フラグメントマネージャー
     * @param titles タブタイトル文字の配列
     * @param classes フラグメントクラスの配列
     */
    public TabsPagerAdapter(Context context, FragmentManager fm, String[] titles, Class[] classes) {
        super(fm);
        this.context = context;
        this.titles = titles;
        this.classes = classes;
    }

    @Override
    public Fragment getItem(int position) {
        // フラグメントインスタンス生成

        /*
         * （メモ）
         * アクティビティからフラグメントへオブジェクトを渡す場合には、このあたりにコールバック処理を記述する
         * 必要があると思う。受け渡しをするオブジェクトには、Serializableインターフェースを実装する必要があると
         * 書いてあった。
         * 参考：http://yusuke-hata.hatenablog.com/entry/2014/12/01/002040
         */
        return Fragment.instantiate(this.context, this.classes[position].getName());
    }

    @Override
    public int getCount() {
        return this.classes.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.titles[position];
    }
}

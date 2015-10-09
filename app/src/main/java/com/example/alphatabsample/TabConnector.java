package com.example.alphatabsample;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 *
 * @param <T> フラグメントクラスまたは、そのサブクラス
 */
public class TabConnector<T extends Fragment> implements ActionBar.TabListener {
    // 切り替えるフラグメント
    private Fragment fragment;

    // アクティビティ
    private final Activity activity;

    // タグ情報
    private final String tag;

    // クラス
    private final Class<T> clz;

    /**
     * コンストラクタ
     * @param activity フラグメント元のアクティビティ
     * @param tag フラグメントのタグ情報
     * @param clz フラグメントのクラス
     */
    public TabConnector(Activity activity, String tag, Class<T> clz) {
        this.activity = activity;
        this.tag = tag;
        this.clz = clz;
        fragment = this.activity.getFragmentManager().findFragmentByTag(this.tag);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        // タブが選択された時
        if (fragment == null) {
            fragment = Fragment.instantiate(activity, clz.getName());
            /*
             * メモ：この辺りでBundleを使ってアクティビティからフラグメントへオブジェクトを渡す処理を書かないとい
             * けないと思う。渡すオブジェクトには、Serializableを実装する必要がある。
             * 参考：http://yusuke-hata.hatenablog.com/entry/2014/12/01/002040
             */
            FragmentManager fm = activity.getFragmentManager();
            fm.beginTransaction().add(R.id.container, fragment, tag).commit();
        } else {
            if (fragment.isDetached()) {
                FragmentManager fm = activity.getFragmentManager();
                fm.beginTransaction().attach(fragment).commit();
            }
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // タブの選択が解除された時
        if (fragment != null) {
            FragmentManager fm = activity.getFragmentManager();
            fm.beginTransaction().detach(fragment).commit();
        }
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        // 同じタブが選択された時
    }
}

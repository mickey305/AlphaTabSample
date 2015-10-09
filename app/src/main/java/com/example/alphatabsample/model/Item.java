package com.example.alphatabsample.model;

public class Item {

    // タイトル
    private String title;

    // サブタイトル
    private String subTitle;

    /**
     * コンストラクタ
     * @param title タイトルの文字
     * @param subTitle サブタイトルの文字
     */
    public Item(String title, String subTitle) {
        setTitle(title);
        setSubTitle(subTitle);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
}

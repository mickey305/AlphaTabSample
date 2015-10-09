package com.example.alphatabsample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alphatabsample.model.Item;

import java.util.ArrayList;

public class TabFourthFragment extends Fragment{
    private AlphaAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        ArrayList<Item> items = new ArrayList<Item>();
        for(int i=0; i<15; i++) {
            items.add(new Item("タブ（ウェールズ）の タイトル "+i, "サブタイトル "+i));
        }
        adapter = new AlphaAdapter(getActivity(), R.layout.alpha_items, items);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.alpha_tab_fragment, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.sample_list);
        listView.setAdapter(adapter);

        return rootView;
    }

}

package com.androidunleashed.fragmentcodeapp;

import android.view.View;
import android.view.LayoutInflater;
import android.app.Fragment;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.content.Intent;
import android.app.FragmentManager;

public class Fragment1Activity extends Fragment{

    protected static final String FRAG2 = "2";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Context c = getActivity().getApplicationContext();
        View vw = inflater.inflate(R.layout.fragment1, container, false);

        final String[] fruits={"Apple", "Mango", "Orange", "Grapes", "Banana"};
        ListView fruitsList = (ListView) vw.findViewById(R.id.fruits_list);
        ArrayAdapter<String> arrayAdpt= new ArrayAdapter<String>(c, android.R.layout.simple_list_item_1, fruits);
        fruitsList.setAdapter(arrayAdpt);

        final FragmentManager fragmentManager = getFragmentManager();
        fruitsList.setOnItemClickListener(new OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if(fragmentManager.findFragmentByTag(FRAG2)!=null){
                    TextView selectedOpt = (TextView) getActivity().findViewById(R.id.selectedopt);
                    selectedOpt.setText("You have selected "+((TextView) v).getText().toString());
                } else {
                    Intent intent = new Intent(getActivity().getApplicationContext(),  ShowItemActivity.class);
                    intent.putExtra("item", ((TextView) v).getText().toString());
                    startActivity(intent);
                }
            }
        });
        return vw;
    }
}

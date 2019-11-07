package ro.sapi.simpletabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    private ListView listView;
    protected ArrayList<String> strings = new ArrayList<>();

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        listView = (ListView) view.findViewById(R.id.list1);
        setData();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, strings);
        listView.setAdapter(adapter);
        // Inflate the layout for this fragment
        return view;
    }

    protected void setData() {
        strings.add("Hallo 5");
        strings.add("Call of Duty 3");
        strings.add("CS GO");
        strings.add("FIFA 15");
        strings.add("Assassin Creed 3");
        strings.add("Angry Bird");
        strings.add("Dark Soul");
    }

}

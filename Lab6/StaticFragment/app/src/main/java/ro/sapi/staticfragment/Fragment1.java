package ro.sapi.staticfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("Status:", "Fragment1:onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("Status:", "Fragment1:onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("Status:", "Fragment1:onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("Status:", "Fragment1:onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("Status:", "Fragment1:onDestroy");
    }
}

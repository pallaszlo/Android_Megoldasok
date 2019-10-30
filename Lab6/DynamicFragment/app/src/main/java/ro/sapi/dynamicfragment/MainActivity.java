package ro.sapi.dynamicfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // get the display mode
        int displaymode = getResources().getConfiguration().orientation;
        if (displaymode == 1) { // it portrait mode
            Fragment1 f1 = new Fragment1();
            //fragmentTransaction.replace(android.R.id.content, f1);
            fragmentTransaction.replace(R.id.linLayout, f1);
        } else {// its landscape
            Fragment2 f2 = new Fragment2();
            //fragmentTransaction.replace(android.R.id.content, f2);
            fragmentTransaction.replace(R.id.linLayout, f2);
        }
        fragmentTransaction.commit();
    }
}

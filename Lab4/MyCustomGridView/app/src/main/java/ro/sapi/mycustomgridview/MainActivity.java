package ro.sapi.mycustomgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    GridView androidGridView;

    String[] gridViewString = {
            "Alarm", "Android", "Mobile", "User", "Settings", "Email"
    } ;
    int[] gridViewImageId = {
            R.drawable.alarm, R.drawable.android, R.drawable.mobile, R.drawable.user, R.drawable.settings, R.drawable.email
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAdapter adapterViewAndroid = new CustomAdapter(MainActivity.this, gridViewString, gridViewImageId);
        androidGridView = (GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(MainActivity.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });
    }
}

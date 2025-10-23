package com.example.implicitintents;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button callNumber;
    EditText phoneNumber;
    Button btnPhoto;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        callNumber = findViewById(R.id.btnCall);
        phoneNumber = findViewById(R.id.edtPhone);
        btnPhoto = findViewById(R.id.btnPhot);
        image = findViewById(R.id.imageView);
    }

    public void call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + phoneNumber.getText()));
        if (ContextCompat.checkSelfPermission(this, CALL_PHONE) ==
                PackageManager.PERMISSION_DENIED) {
            requestPermissions(new String[]{CALL_PHONE}, 1);
        }
        startActivity(callIntent);
    }

    public void capturePhoto(View view) {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        launchCamera.launch(pictureIntent);
        /*
        registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == MainActivity.RESULT_OK) {
                            Intent data = result.getData();
                            Bundle extras = data.getExtras();
                            Bitmap img = (Bitmap) extras.get("data");
                            image.setImageBitmap(img);
                        } else {
                            Toast.makeText(MainActivity.this, "Cancelled...", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).launch(pictureIntent);

         */
    }

    private ActivityResultLauncher<Intent> launchCamera =  registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == MainActivity.RESULT_OK) {
                Intent data = result.getData();
                Bundle extras = data.getExtras();
                Bitmap img = (Bitmap) extras.get("data");
                image.setImageBitmap(img);
            } else {
                Toast.makeText(MainActivity.this, "Cancelled...", Toast.LENGTH_SHORT).show();
            }
        }
    });
}













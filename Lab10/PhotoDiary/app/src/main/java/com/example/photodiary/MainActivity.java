package com.example.photodiary;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView textViewEmpty;
    private FloatingActionButton fabNewEntry;
    private EntryAdapter adapter;
    private DiaryManager diaryManager;
    private ActivityResultLauncher<Uri> takePictureLauncher;
    private Uri currentPhotoUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        diaryManager = new DiaryManager(this);
        recyclerView = findViewById(R.id.recyclerViewEntries);
        textViewEmpty = findViewById(R.id.textViewEmpty);
        fabNewEntry = findViewById(R.id.fabNewEntry);

        setupRecyclerView();
        loadEntries();

        takePictureLauncher = registerForActivityResult(
                new ActivityResultContracts.TakePicture(),
                success -> {
                    if (success && currentPhotoUri != null) {
                        //showAddEntryDialog(currentPhotoUri.getPath());
                    }
                }
        );

        fabNewEntry.setOnClickListener(v->takePicture());

    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EntryAdapter(
                entry -> {
                    Toast.makeText(this, entry.getTitle(),
                            Toast.LENGTH_SHORT).show();
                },
                entry -> shareEntry(entry)
        );
        recyclerView.setAdapter(adapter);
    }

    private void loadEntries() {
        List<DiaryEntry> entries = diaryManager.loadEntries();
        adapter.setEntries(entries);
        if (entries.isEmpty()) {
            textViewEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            textViewEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    private void shareEntry(DiaryEntry entry) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        String shareText = entry.getTitle() + "\n\n" +
                entry.getContent() + "\n\n" +
                entry.getFormattedDate();

        shareIntent.putExtra(Intent.EXTRA_SUBJECT, entry.getTitle());
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        startActivity(Intent.createChooser(shareIntent, "Bejegyzés megosztása"));
    }

    private void takePicture() {
        File photoFile = createImageFile();
        if (photoFile != null) {
            currentPhotoUri = Uri.fromFile(photoFile);
            takePictureLauncher.launch(currentPhotoUri);
        }
    }

    private File createImageFile() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
                .format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getCacheDir(); // Cache konyvtar
        try {
            return File.createTempFile(imageFileName, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void showAddEntryDialog(String photoPath) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Uj bejegyzes");
        // Layout a ket EditText-hez
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50, 40, 50, 10);
        final EditText editTitle = new EditText(this);
        editTitle.setHint("Cim");
        layout.addView(editTitle);
        final EditText editContent = new EditText(this);
        editContent.setHint("Szoveg");
        editContent.setMinLines(3);
        layout.addView(editContent);
        builder.setView(layout);
        builder.setPositiveButton("Mentes", (dialog, which) -> {
            String title = editTitle.getText().toString().trim();
            String content = editContent.getText().toString().trim();
            if (!title.isEmpty()) {
                DiaryEntry entry = new DiaryEntry(title, content);
                entry.setPhotoPath(photoPath);
                diaryManager.addEntry(entry);
                loadEntries();
            }
        });
        builder.setNegativeButton("Megse", null);
        builder.show();
    }

}
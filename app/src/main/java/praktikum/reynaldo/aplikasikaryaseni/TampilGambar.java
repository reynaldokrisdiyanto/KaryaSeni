package praktikum.reynaldo.aplikasikaryaseni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TampilGambar extends AppCompatActivity {

    ImageView gambar;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_gambar);

        gambar = findViewById(R.id.iv_gambar0);

        Bundle bun = getIntent().getExtras();
        Bitmap bmp = (Bitmap) bun.getParcelable("imagebitmap");

        gambar.setImageBitmap(bmp);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TampilGambar.this,Kamera.class));
                finish();
            }
        });
    }
}

package praktikum.reynaldo.aplikasikaryaseni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Kamera extends AppCompatActivity {
    //Variabel global untuk bisa dipanggil disemua method
    Button btnKamera, btnLogout;

    private static final int REQUEST_IMAGE_PICTURE = 1002;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);

        //Untuk menghubungkan class java dengan widget button
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(Kamera.this,Login.class));
                finish();
            }
        });

        btnKamera = findViewById(R.id.btnKamera);
        btnKamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                if(imageTakeIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(imageTakeIntent, REQUEST_IMAGE_PICTURE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_PICTURE && resultCode==RESULT_OK){
            Bundle bun = data.getExtras();
            Bitmap bitmap = (Bitmap) bun.get("data");

            Intent intent = new Intent(Kamera.this,TampilGambar.class);

            bun.putParcelable("imagebitmap", bitmap);
            intent.putExtras(bun);
            startActivity(intent);
        }
    }
}

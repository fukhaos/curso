package br.com.mobitouch.intencoes;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;


public class FotoActivity extends ActionBarActivity {

    private static final int CAMERA_REQUEST = 1111;
    private static final int GALERIA_REQUEST = 2222;

    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);

        foto = (ImageView) findViewById(R.id.foto);
    }

    public void callFoto(View view) {
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    public void callGaleria(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALERIA_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        //tirar foto
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            foto.setImageBitmap(photo);
        }

        //galeria
        if (requestCode == GALERIA_REQUEST && resultCode == RESULT_OK){
            final Uri imageUri = data.getData();
            foto.setImageURI(imageUri);
        }
    }

}

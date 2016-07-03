package jhw.imagepicker.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jhw.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 100;

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.image);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String imagePath = data.getStringExtra("image_path");
                Glide.with(this).load(imagePath).into(image);
            }
        }
    }

    public void startImagePicker(View view) {
        ImagePicker.startImagePicker(this, REQUEST_CODE);
    }
}

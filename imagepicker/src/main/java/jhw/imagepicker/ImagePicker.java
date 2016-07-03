package jhw.imagepicker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import jhw.imagepicker.picker.ImagePickerActivity;


/**
 * Created by jihongwen on 16/7/2.
 */

public final class ImagePicker {

    public static void startImagePicker(Context context) {
        context.startActivity(new Intent(context, ImagePickerActivity.class));
    }

    public static void startImagePicker(Activity context, int requestCode) {
        context.startActivityForResult(new Intent(context, ImagePickerActivity.class), requestCode);
    }
}

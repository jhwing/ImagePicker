package jhw.imagepicker.picker;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;

import jhw.imagepicker.bean.ImageItem;


/**
 * Created by jihongwen on 16/7/2.
 */

public class ImageCursorLoader extends CursorLoader {

    private final static String[] IMAGE_PROJECTION = {     //查询图片需要的数据列
            MediaStore.Images.Media.DISPLAY_NAME,   //图片的显示名称  aaa.jpg
            MediaStore.Images.Media.DATA,           //图片的真实路径  /storage/emulated/0/pp/downloader/wallpaper/aaa.jpg
            MediaStore.Images.Media.SIZE,           //图片的大小，long型  132492
            MediaStore.Images.Media.WIDTH,          //图片的宽度，int型  1920
            MediaStore.Images.Media.HEIGHT,         //图片的高度，int型  1080
            MediaStore.Images.Media.MIME_TYPE,      //图片的类型     image/jpeg
            MediaStore.Images.Thumbnails.DATA,
            MediaStore.Images.Media.BUCKET_ID,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME, // 文件夹名称
            MediaStore.Images.Media.DATE_ADDED};    //图片被添加的时间，long型  1450518608


    private static final Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    private static final String[] projection = IMAGE_PROJECTION;

    private static final String selection = null;

    private static final String[] selectionArgs = null;

    private static final String sortOrder = IMAGE_PROJECTION[6] + " DESC";

    public ImageCursorLoader(Context context) {
        this(context, uri, projection, selection, selectionArgs, sortOrder);
    }

    public ImageCursorLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
    }

    public ImageItem map(Cursor cursor) {

        String imageName = cursor.getString(cursor.getColumnIndexOrThrow(IMAGE_PROJECTION[0]));
        String imagePath = cursor.getString(cursor.getColumnIndexOrThrow(IMAGE_PROJECTION[6]));
        long imageSize = cursor.getLong(cursor.getColumnIndexOrThrow(IMAGE_PROJECTION[2]));
        int imageWidth = cursor.getInt(cursor.getColumnIndexOrThrow(IMAGE_PROJECTION[3]));
        int imageHeight = cursor.getInt(cursor.getColumnIndexOrThrow(IMAGE_PROJECTION[4]));
        String imageMimeType = cursor.getString(cursor.getColumnIndexOrThrow(IMAGE_PROJECTION[5]));
        long imageAddTime = cursor.getLong(cursor.getColumnIndexOrThrow(IMAGE_PROJECTION[6]));
        ImageItem imageItem = new ImageItem();
        imageItem.imageName = imageName;
        imageItem.imagePath = imagePath;
        imageItem.imageSize = imageSize;
        imageItem.imageWidth = imageWidth;
        imageItem.imageHeight = imageHeight;
        imageItem.imageMimeType = imageMimeType;
        imageItem.imageAddTime = imageAddTime;
        return imageItem;

    }
}

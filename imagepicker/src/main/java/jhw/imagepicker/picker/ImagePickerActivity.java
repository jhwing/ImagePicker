package jhw.imagepicker.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import jhw.imagepicker.R;
import jhw.imagepicker.bean.ImageItem;
import jhw.imagepicker.views.GridSpacingItemDecoration;

/**
 * Created by jihongwen on 16/7/2.
 */

public class ImagePickerActivity extends AppCompatActivity implements ImagePickerContract.ImagePickerIView, LoaderManager.LoaderCallbacks<Cursor> {

    private static final int LOADER_ID = 1;

    LoaderManager mLoaderManager;

    RecyclerView recyclerView;

    ImageItemAdapter mImageItemAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker);
        mLoaderManager = getSupportLoaderManager();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, 5, true));
        mImageItemAdapter = new ImageItemAdapter(this);
        recyclerView.setAdapter(mImageItemAdapter);
        mLoaderManager.initLoader(LOADER_ID, null, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mLoaderManager != null) {
            mLoaderManager.destroyLoader(LOADER_ID);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new ImageCursorLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        ImageCursorLoader imageCursorLoader = (ImageCursorLoader) loader;
        data.moveToFirst();
        List<ImageItem> itemList = new ArrayList<>();
        while (!data.isAfterLast()) {
            itemList.add(imageCursorLoader.map(data));
            data.moveToNext();
        }
        mImageItemAdapter.setItemList(itemList);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void selectedImage(ImageItem imageItem) {
        Intent intent = new Intent();
        intent.putExtra("image_path", imageItem.imagePath);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public Context getViewContext() {
        return this;
    }
}

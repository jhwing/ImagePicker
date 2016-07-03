package jhw.imagepicker.picker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import jhw.imagepicker.R;
import jhw.imagepicker.bean.ImageItem;

/**
 * Created by jihongwen on 16/7/2.
 */

public class ImageItemAdapter extends RecyclerView.Adapter<ImageItemAdapter.ImageViewHolder> {

    ImagePickerContract.ImagePickerIView mPickerIView;

    LayoutInflater factory;

    List<ImageItem> itemList;

    public ImageItemAdapter(ImagePickerContract.ImagePickerIView pickerIView) {
        mPickerIView = pickerIView;
        factory = LayoutInflater.from(mPickerIView.getViewContext());
    }


    public void setItemList(List<ImageItem> itemList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageViewHolder(factory.inflate(R.layout.grid_item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        //ImageLoader.getInstance().displayImage(itemList.get(position).imagePath, holder.imageView);
        ImageItem imageItem = itemList.get(position);
        Glide.with(mPickerIView.getViewContext()).load(imageItem.imagePath).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.itemImage);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mPickerIView.selectedImage(itemList.get(getLayoutPosition()));
                }
            });
        }
    }
}

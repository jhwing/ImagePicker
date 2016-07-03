package jhw.imagepicker.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jihongwen on 16/7/2.
 */

public class ImageItem implements Parcelable {

    /*图片名称*/
    public String imageName;
    /*图片路径*/
    public String imagePath;
    /*图片大小*/
    public long imageSize;
    public int imageWidth;
    public int imageHeight;
    public long imageAddTime;
    /*图片格式*/
    public String imageMimeType;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageName);
        dest.writeString(this.imagePath);
        dest.writeLong(this.imageSize);
        dest.writeInt(this.imageWidth);
        dest.writeInt(this.imageHeight);
        dest.writeLong(this.imageAddTime);
        dest.writeString(this.imageMimeType);
    }

    public ImageItem() {
    }

    protected ImageItem(Parcel in) {
        this.imageName = in.readString();
        this.imagePath = in.readString();
        this.imageSize = in.readLong();
        this.imageWidth = in.readInt();
        this.imageHeight = in.readInt();
        this.imageAddTime = in.readLong();
        this.imageMimeType = in.readString();
    }

    public static final Creator<ImageItem> CREATOR = new Creator<ImageItem>() {
        @Override
        public ImageItem createFromParcel(Parcel source) {
            return new ImageItem(source);
        }

        @Override
        public ImageItem[] newArray(int size) {
            return new ImageItem[size];
        }
    };
}

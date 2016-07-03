package jhw.imagepicker.picker;

import jhw.imagepicker.IView;
import jhw.imagepicker.bean.ImageItem;

/**
 * Created by jihongwen on 16/7/2.
 */

public interface ImagePickerContract {

    interface ImagePickerIView extends IView {

        void selectedImage(ImageItem imageItem);

    }

    interface Presenter {

    }
}

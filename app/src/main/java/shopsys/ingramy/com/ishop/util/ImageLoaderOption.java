package shopsys.ingramy.com.ishop.util;

import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.zbzhixue.app.R;

public class ImageLoaderOption {
    private static DisplayImageOptions options;

    public static DisplayImageOptions getInstance() {
        if (options == null) {
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.default_img)
                    .showImageOnFail(R.drawable.default_img)
                    .showImageForEmptyUri(R.drawable.default_img)
                    .cacheInMemory(true).cacheOnDisk(true)
                    .bitmapConfig(Bitmap.Config.RGB_565).build();
        }
        return options;
    }
}

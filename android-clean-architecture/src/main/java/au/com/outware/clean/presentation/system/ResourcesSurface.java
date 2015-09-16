package au.com.outware.clean.presentation.system;

import android.content.Context;
import android.support.annotation.StringRes;

public class ResourcesSurface {

    private Context mContext;

    public ResourcesSurface(Context context) {
        mContext = context;
    }

    public String getString(@StringRes int stringResourceId) {
        return mContext.getString(stringResourceId);
    }

}

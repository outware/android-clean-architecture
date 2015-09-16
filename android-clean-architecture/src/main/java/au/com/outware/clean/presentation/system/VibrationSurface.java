package au.com.outware.clean.presentation.system;

import android.content.Context;
import android.os.Vibrator;

public class VibrationSurface {

    private Context mContext;

    public VibrationSurface(Context context) {
        mContext = context;
    }

    public void vibrate(long duration) throws UnsupportedOperationException {
        Vibrator adapter = (Vibrator) mContext.getSystemService(Context.VIBRATOR_SERVICE);
        if (adapter != null) {
            adapter.vibrate(duration);
        } else {
            throw new UnsupportedOperationException("Device does not have vibrate capability!");
        }
    }

}

package au.com.outware.clean.presentation.presenters;

import android.os.Bundle;
import android.support.annotation.Nullable;

public class BasePresenter implements Presenter {

    @Override
    public void onCreate(@Nullable Bundle parameters) {}

    @Override
    public void onRestoreState(Bundle inState) {}

    @Override
    public void onViewReady() {}

    @Override
    public void onResume() {}

    @Override
    public void onPause() {}

    @Override
    public void onSaveState(Bundle outState) {}

    @Override
    public void onDestroy() {}

}

package au.com.outware.clean.presentation.presenters;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Defines the structure of a Presenter and how it interacts with its ViewSurface.
 *
 * @author Ryan Hodgman, kamalmohamed
 */
public interface Presenter {

    /**
     * Should be called only once on screen creation before any other method in the Presenter.
     * Useful to get all the Presenter parameters from the given Bundle.
     *
     * @param parameters
     *         contains all the Presenter parameters in a Bundle.
     */
    void onCreate(@Nullable Bundle parameters);

    /**
     * Should be called only once upon screen creation only if a saved state is available to allow
     * the Presenter to restore it.
     *
     * @param inState
     *         the Bundle containing the state saved in the onSaveState method.
     */
    void onRestoreState(Bundle inState);

    /**
     * Should be called only once on screen creation after the onCreate method and before the
     * onResume method.
     */
    void onViewReady();

    /**
     * Should be called every time the screen comes back to be visible (eg. from the background to
     * the foreground).
     */
    void onResume();

    /**
     * Should be called every time the screen is not visible anymore (eg. from foreground to
     * background).
     */
    void onPause();

    /**
     * Should be called only once when the screen is about to be destroyed to optionally save the
     * Presenter state.
     *
     * @param outState
     *         the Bundle to be populated with the Presenter state to be saved.
     */
    void onSaveState(Bundle outState);

    /**
     * Should be called only once when the screen is about to be destroyed.
     */
    void onDestroy();

}

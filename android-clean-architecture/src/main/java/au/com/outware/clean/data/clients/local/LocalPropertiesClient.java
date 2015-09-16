package au.com.outware.clean.data.clients.local;

import android.content.SharedPreferences;

public class LocalPropertiesClient {

    private static final String KEY_ACCESS_TOKEN = "KEY_ACCESS_TOKEN";
    private static final String KEY_USER_ID = "KEY_USER_ID";

    private final SharedPreferences mSharedPreferences;

    public LocalPropertiesClient(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public void storeAccessToken(String accessToken) {
        mSharedPreferences.edit().putString(KEY_ACCESS_TOKEN, accessToken).apply();
    }

    public String retrieveAccessToken() {
        return mSharedPreferences.getString(KEY_ACCESS_TOKEN, "");
    }

    public void storeCurrentUserId(int userId) {
        mSharedPreferences.edit().putInt(KEY_USER_ID, userId).apply();
    }

    public int retrieveCurrentUserId() {
        return mSharedPreferences.getInt(KEY_USER_ID, 0);
    }

}

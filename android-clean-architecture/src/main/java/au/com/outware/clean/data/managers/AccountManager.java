package au.com.outware.clean.data.managers;

import android.text.TextUtils;

import au.com.outware.clean.data.clients.database.DatabaseClient;
import au.com.outware.clean.data.clients.local.LocalPropertiesClient;
import au.com.outware.clean.domain.entities.Achievement;
import au.com.outware.clean.domain.repositories.AccountRepository;

public class AccountManager implements AccountRepository {

    private final LocalPropertiesClient mLocalPropertiesClient;
    private final DatabaseClient mDatabaseClient;

    public AccountManager(LocalPropertiesClient localPropertiesClient,
                          DatabaseClient databaseClient) {
        mLocalPropertiesClient = localPropertiesClient;
        mDatabaseClient = databaseClient;
    }

    @Override
    public boolean isUserSignedIn() {
        return TextUtils.isEmpty(mLocalPropertiesClient.retrieveAccessToken());
    }

    @Override
    public void grantAchievement(Achievement achievement) {
        mDatabaseClient.addAchievements(mLocalPropertiesClient.retrieveCurrentUserId());
    }
}

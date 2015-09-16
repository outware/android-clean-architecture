package au.com.outware.clean.domain.repositories;

import au.com.outware.clean.domain.entities.Achievement;

public interface AccountRepository {

    boolean isUserSignedIn();

    void grantAchievement(Achievement achievement);

}

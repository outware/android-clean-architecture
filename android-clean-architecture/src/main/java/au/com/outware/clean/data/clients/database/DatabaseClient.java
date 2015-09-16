package au.com.outware.clean.data.clients.database;

import java.util.Arrays;
import java.util.List;

import au.com.outware.clean.data.clients.database.tables.AchievementTable;
import au.com.outware.clean.domain.entities.Achievement;

public class DatabaseClient {

    // Interacts with a singleton database connection, not this dummy table
    private final AchievementTable mAchievementTable;

    public DatabaseClient() {
        mAchievementTable = new AchievementTable();
    }

    public void addAchievements(int userId, Achievement... achievements) {
        mAchievementTable.get(userId).addAll(Arrays.asList(achievements));
    }

    public List<Achievement> getAchievements(int userId) {
        return mAchievementTable.get(userId);
    }

}

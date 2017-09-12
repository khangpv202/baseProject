package prism.gem.com.newbasestructure.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import prism.gem.com.newbasestructure.db.dao.CompanyDAO;
import prism.gem.com.newbasestructure.db.entity.Company;

/**
 * Created by khangpv on 8/16/2017.
 */
@Database(entities = { Company.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase
{
    public abstract CompanyDAO getCompanyDAO();

}

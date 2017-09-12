package prism.gem.com.newbasestructure.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import io.reactivex.Flowable;
import prism.gem.com.newbasestructure.db.entity.Company;

import java.util.List;

/**
 * Created by binhtv on 8/29/2017.
 */
@Dao
public interface CompanyDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Company company);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(List<Company> company);

    @Query("select * from company where " + Company.MOOLA_USER_ID + "=:customerID")
    Flowable<List<Company>> getAssignedCompanyList(String customerID);

    @Query("select * from company where "+Company.MOOLA_USER_ID+"=:customerID")
    Flowable<List<Company>> getAssignedCompanyLisdfdft(String customerID);
}

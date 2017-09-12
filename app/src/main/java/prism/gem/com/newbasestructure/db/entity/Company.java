package prism.gem.com.newbasestructure.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by khangpv on 8/29/2017.
 */
@Entity(tableName = "company")
public class Company
{
    public static final String MOOLA_USER_ID ="moolaUserId";
    @PrimaryKey
    private String webId;

    String bigLogoId;
    boolean deleted;
    String email;
    String name;
    String smallLogoId;

    private String moolaUserId;

    public String getWebId()
    {
        return webId;
    }

    public void setWebId(String webId)
    {
        this.webId = webId;
    }

    public String getBigLogoId()
    {
        return bigLogoId;
    }

    public void setBigLogoId(String bigLogoId)
    {
        this.bigLogoId = bigLogoId;
    }

    public boolean isDeleted()
    {
        return deleted;
    }

    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSmallLogoId()
    {
        return smallLogoId;
    }

    public void setSmallLogoId(String smallLogoId)
    {
        this.smallLogoId = smallLogoId;
    }

    public String getMoolaUserId()
    {
        return moolaUserId;
    }

    public void setMoolaUserId(String moolaUserId)
    {
        this.moolaUserId = moolaUserId;
    }

}

package prism.gem.com.newbasestructure.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by binhtv on 8/23/2017.
 */

public class MoolaCustomerDTO
{
    private String firstName;
    private String lastName;
    private String company;
    private Date dateOfBirth;
    private String photoFileId;
    private String customFields;

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getCompany()
    {
        return company;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhotoFileId()
    {
        return photoFileId;
    }

    public void setPhotoFileId(String photoFileId)
    {
        this.photoFileId = photoFileId;
    }

    public String getCustomFields()
    {
        return customFields;
    }

    public void setCustomFields(String customFields)
    {
        this.customFields = customFields;
    }
}

package prism.gem.com.newbasestructure.dto;


import java.io.Serializable;

public class LoginInfoDTO implements Serializable
{

    private String email;

    private String password;

    private String imei;

    private String deviceName;

    private Boolean activatingNewAccount;

    private String enterpriseId;

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getImei()
    {
        return imei;
    }

    public void setImei(String imei)
    {
        this.imei = imei;
    }

    public Boolean getActivatingNewAccount()
    {
        return activatingNewAccount;
    }

    public void setActivatingNewAccount(Boolean activatingNewAccount)
    {
        this.activatingNewAccount = activatingNewAccount;
    }

    public String getEnterpriseId()
    {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId)
    {
        this.enterpriseId = enterpriseId;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public void setDeviceName(String deviceName)
    {
        this.deviceName = deviceName;
    }

}

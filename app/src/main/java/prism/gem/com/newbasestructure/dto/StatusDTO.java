package prism.gem.com.newbasestructure.dto;

import java.io.Serializable;

public class StatusDTO implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String messageKey;

    private Object additionalInfoDTO;

    private String additionalInfo;

    public String getAdditionalInfo()
    {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo)
    {
        this.additionalInfo = additionalInfo;
    }

    public String getMessageKey()
    {
        return messageKey;
    }

    public void setMessageKey(String messageKey)
    {
        this.messageKey = messageKey;
    }

    public Object getAdditionalInfoDTO()
    {
        return additionalInfoDTO;
    }

    public void setAdditionalInfoDTO(Object additionalInfoDTO)
    {
        this.additionalInfoDTO = additionalInfoDTO;
    }
}

package prism.gem.com.newbasestructure.dto;

/**
 * User: khangpv
 * Date: 12/09/2017
 */

public enum MessageKey
{
    SUCCESS("messageSuccess"),UNKNOWN_EXCEPTION("messageFail.unknownException"),
    //client exception
    NO_INTERNET_EXCEPTION("common.message.error.networkConnectionNotFound"),
    TIME_OUT_EXCEPTION("common.message.error.networkTimeOut");

    private String extension;

    MessageKey(String extension)
    {
        this.extension = extension;
    }
    public String getValue()
    {
        return extension;
    }
    }

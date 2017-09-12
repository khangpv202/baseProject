package prism.gem.com.newbasestructure.common;


import prism.gem.com.newbasestructure.dto.MessageKey;
import prism.gem.com.newbasestructure.dto.ResponseDTO;

/**
 * MoolaUser : thinhdd
 * Date : 6/25/14.
 */
public class DTOUtils
{
    public static boolean isSuccess(ResponseDTO responseDTO)
    {
        return null != responseDTO && null != responseDTO.getStatusDTO() &&
                responseDTO.getStatusDTO().getMessageKey().equalsIgnoreCase(MessageKey.SUCCESS.getValue());
    }
}

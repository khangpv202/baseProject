package prism.gem.com.newbasestructure.dto;


import java.io.Serializable;

public class ResponseDTO<DTO> implements Serializable
{

    private static final long serialVersionUID = 1L;
    private DTO result;
    private StatusDTO statusDTO;

    public ResponseDTO()
    {
        this.statusDTO = new StatusDTO();
        statusDTO.setMessageKey(MessageKey.SUCCESS.getValue());
    }

    public static <DTO> ResponseDTO success(DTO result)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResult(result);
        return responseDTO;
    }

    public static ResponseDTO fail(MessageKey messageKey)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessageKey(messageKey);
        return responseDTO;
    }

    public static ResponseDTO fail(String messageKey)
    {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessageKey(messageKey);
        return responseDTO;
    }

    public static ResponseDTO failUnknownException()
    {
        return fail(MessageKey.UNKNOWN_EXCEPTION);
    }

    public DTO getResult()
    {
        return result;
    }

    public void setResult(DTO result)
    {
        this.result = result;
    }

    public StatusDTO getStatusDTO()
    {
        return statusDTO;
    }

    public void setStatusDTO(StatusDTO statusDTO)
    {
        this.statusDTO = statusDTO;
    }

    public void setMessageKey(MessageKey messageKey)
    {
        statusDTO.setMessageKey(messageKey.getValue());
    }

    public void setMessageKey(String messageKey)
    {
        statusDTO.setMessageKey(messageKey);
    }

    public void setStatusFailUnknownException()
    {
        statusDTO.setMessageKey(MessageKey.UNKNOWN_EXCEPTION.getValue());
    }
}

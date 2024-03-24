package com.exmple.common.convention.excetion;


import com.exmple.common.convention.errorcode.IErrorCode;

import static com.exmple.common.convention.errorcode.BaseErrorCode.CLIENT_ERROR;

/**
 * @Author 70ash
 * @Date 2024/1/24 23:06
 * @Description:
 */
public class ClientException extends AbstractException{
    public ClientException(String message) {
        super(message, null, CLIENT_ERROR);
    }

    public ClientException(IErrorCode errorCode) {
        super(null, null, errorCode);
    }

    public ClientException(String message, IErrorCode errorCode) {
        super(message, null, errorCode);
    }

    public ClientException(String message, Throwable cause, IErrorCode errorCode) {
        super(message, cause, errorCode);
    }

}

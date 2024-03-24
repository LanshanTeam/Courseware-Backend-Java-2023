package com.exmple.common.convention.excetion;


import com.exmple.common.convention.errorcode.IErrorCode;

import static com.exmple.common.convention.errorcode.BaseErrorCode.SERVICE_ERROR;

/**
 * @Author 70ash
 * @Date 2024/1/24 23:08
 * @Description:
 */
public class ServiceException extends AbstractException{

    public ServiceException(String message) {
        super(message, null ,SERVICE_ERROR);
    }

    public ServiceException(IErrorCode errorCode) {
        super(null, null ,errorCode);
    }

    public ServiceException(String message, IErrorCode errorCode) {
        super(message, null ,errorCode);
    }

    public ServiceException(String message, Throwable cause, IErrorCode errorCode) {
        super(message, cause, errorCode);
    }
}

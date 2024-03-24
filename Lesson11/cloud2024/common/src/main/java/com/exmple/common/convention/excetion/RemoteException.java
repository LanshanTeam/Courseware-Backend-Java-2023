package com.exmple.common.convention.excetion;


import com.exmple.common.convention.errorcode.IErrorCode;

import static com.exmple.common.convention.errorcode.BaseErrorCode.REMOTE_ERROR;

/**
 * @Author 70ash
 * @Date 2024/1/24 23:07
 * @Description:
 */
public class RemoteException extends AbstractException{

    public RemoteException(String message) {
        super(message, null ,REMOTE_ERROR);
    }

    public RemoteException(IErrorCode errorCode) {
        super(null, null ,errorCode);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        super(message, null ,errorCode);
    }
    public RemoteException(String message, Throwable cause, IErrorCode errorCode) {
        super(message, cause, errorCode);
    }
}

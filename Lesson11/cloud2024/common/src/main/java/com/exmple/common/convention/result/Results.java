package com.exmple.common.convention.result;


import com.exmple.common.convention.excetion.AbstractException;


import static com.exmple.common.convention.errorcode.BaseErrorCode.SERVICE_ERROR;

/**
 * @Author 70ash
 * @Date 2024/1/24 22:54
 * @Description:
 */
public class Results {
    public static <T> Result<T> success(T data) {
        return new Result<T>()
                .setData(data)
                .setCode(Result.SUCCESS_CODE)
                .setTimeStamp(System.currentTimeMillis());
    }

    public static Result<Void> success() {
        return new Result<Void>()
                .setCode(Result.SUCCESS_CODE)
                .setTimeStamp(System.currentTimeMillis());
    }

    public static Result<Void> fail(AbstractException ex) {
        return new Result<Void>()
                .setCode(ex.getErrorCode())
                .setMessage(ex.getErrorMessage());
    }

    public static Result<Void> fail() {
        return new Result<Void>()
                .setCode(SERVICE_ERROR.code())
                .setMessage(SERVICE_ERROR.message());
    }

    public static Result<Void> fail(String errorCode, String errorMessage) {
        return new Result<Void>()
                .setCode(errorCode)
                .setMessage(errorMessage);
    }
}

package com.exmple.common.convention.excetion;


import com.exmple.common.convention.errorcode.IErrorCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @Author 70ash
 * @Date 2024/1/24 23:03
 * @Description:
 */
@Getter
public class AbstractException extends RuntimeException{

    private String errorCode;

    private String errorMessage;

    public AbstractException(String message, Throwable cause, IErrorCode errorCode) {
        super(message, cause);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}

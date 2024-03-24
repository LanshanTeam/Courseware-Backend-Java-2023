package com.exmple.common.convention.result;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;

/**
 * @Author 70ash
 * @Date 2024/1/24 22:51
 * @Description:
 */
@Data
@Accessors(chain = true)
public class Result<T> {
    @Serial
    private static final long serialVersionUID = 5679018624309023727L;

    public static final String SUCCESS_CODE = "0";

    private String code;

    private String message;

    private Long timeStamp;

    private T data;

    public boolean isSuccess() {
        return SUCCESS_CODE.equals(code);
    }
}

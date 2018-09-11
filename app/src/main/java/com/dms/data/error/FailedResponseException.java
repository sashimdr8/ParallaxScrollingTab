package com.dms.data.error;

import com.dms.data.model.BaseResponse;

import java.io.IOException;

public class FailedResponseException extends IOException {
//    public final int status;
    public BaseResponse baseResponse;

    public FailedResponseException(BaseResponse baseResponse) {
//        super(baseResponse.getStatus());
        this.baseResponse = baseResponse;
//        this.status = baseResponse.getStatus();
    }

}

package com.dms.data.model;

import com.dms.data.error.FailedResponseException;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class BaseResponseConverter extends Converter.Factory {

    @Override
    @SuppressWarnings("unchecked")
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        Type baseResponseType = TypeToken.getParameterized(BaseResponse.class, type).getType();
        final Converter<ResponseBody, BaseResponse<?>> delegate =
                retrofit.nextResponseBodyConverter(this, baseResponseType, annotations);
        return new BaseResponseBodyConverter(delegate);
    }


    private static class BaseResponseBodyConverter<T> implements Converter<ResponseBody, T> {
        final Converter<ResponseBody, BaseResponse<T>> delegate;

        BaseResponseBodyConverter(Converter<ResponseBody, BaseResponse<T>> delegate) {
            this.delegate = delegate;
        }

        @Override
        public T convert(ResponseBody value) throws IOException {
            BaseResponse<T> response = delegate.convert(value);
            if (response == null)
                throw new IOException("BaseResponse == null");
            else if (response.getStatus().equalsIgnoreCase("ok")) {
                return response.getArticles();
            } else
                throw new FailedResponseException(response);
        }
    }
}

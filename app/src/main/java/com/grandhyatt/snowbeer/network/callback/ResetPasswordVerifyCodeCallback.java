package com.grandhyatt.snowbeer.network.callback;

import com.google.gson.Gson;
import com.grandhyatt.snowbeer.network.result.ResetPasswordVerifyPhoneResult;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * 获取短信验证码的回调
 *
 * @author
 * @email
 * @mobile
 * @create 2018-07-02 22:34
 */
public abstract class ResetPasswordVerifyCodeCallback extends Callback<ResetPasswordVerifyPhoneResult> {

    @Override
    public ResetPasswordVerifyPhoneResult parseNetworkResponse(Response response, int id) throws Exception {

        String strData = response.body().string();
        ResetPasswordVerifyPhoneResult result = new Gson().fromJson(strData, ResetPasswordVerifyPhoneResult.class);

        return result;
    }
}
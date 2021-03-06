package com.grandhyatt.snowbeer.network.callback;

import com.google.gson.Gson;
import com.grandhyatt.snowbeer.network.result.GetSecondChkListResult;
import com.grandhyatt.snowbeer.network.result.GetStoreHouseListResult;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * 组织机构网络请求回调
 *
 * @author 吴立富
 * @email 18602438878@qq.com
 * @mobile 18602438878
 * @create 2018/6/1 11:19
 */
public abstract class GetSecondChkListCallBack extends Callback<GetSecondChkListResult> {

    @Override
    public GetSecondChkListResult parseNetworkResponse(Response response, int id) throws Exception {

        String strData = response.body().string();
        GetSecondChkListResult result = new Gson().fromJson(strData, GetSecondChkListResult.class);
        
        return result;
    }

}

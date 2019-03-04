package cn.zhangyong.samplemodule.bean;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * description:
 * autour: zhangyong
 * date: 2019/1/30 17:45
 * update: 2019/1/30
 * version:
 */
@Route(path = "/sample/json")
public class JsonServiceImpl implements SerializationService {
    @Override
    public <T> T json2Object(String text, Class<T> clazz) {
        return new Gson().fromJson(text, clazz);
    }

    @Override
    public String object2Json(Object instance) {
        return new Gson().toJson(instance);
    }

    @Override
    public <T> T parseObject(String input, Type clazz) {
        return new Gson().fromJson(input, clazz);
    }

    @Override
    public void init(Context context) {

    }
}

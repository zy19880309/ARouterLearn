package cn.zhangyong.samplemodule.service;

import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * description:
 * autour: zhangyong
 * date: 2019/2/1 11:10
 * update: 2019/2/1
 * version:
 */
@Route(path = "/sample/hello", name = "测试服务hello")
public class HelloImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }

    @Override
    public void init(Context context) {

    }
}

package cn.zhangyong.samplemodule.service;

import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * description:
 * autour: zhangyong
 * date: 2019/2/1 11:09
 * update: 2019/2/1
 * version:
 */
public interface HelloService extends IProvider {
    String sayHello(String name);
}

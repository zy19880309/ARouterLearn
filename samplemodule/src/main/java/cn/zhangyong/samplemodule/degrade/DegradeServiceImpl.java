package cn.zhangyong.samplemodule.degrade;

import android.content.Context;
import android.util.Log;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * description:
 * autour: zhangyong
 * date: 2019/1/31 17:58
 * update: 2019/1/31
 * version:
 */
// 实现DegradeService接口，并加上一个Path内容任意的注解即可
@Route(path = "/sample/degrade")
public class DegradeServiceImpl implements DegradeService {
    @Override
    public void onLost(Context context, Postcard postcard) {
        Log.d("debuga", postcard.getPath() + "未找到");
    }

    @Override
    public void init(Context context) {

    }
}

package cn.zhangyong.samplemodule.interceptor;

import android.content.Context;
import android.util.Log;
import cn.zhangyong.samplemodule.util.Config;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * description:
 * autour: zhangyong
 * date: 2019/1/31 17:16
 * update: 2019/1/31
 * version:
 */
// 比较经典的应用就是在跳转过程中处理登陆事件，这样就不需要在目标页重复做登陆检查
// 拦截器会在跳转之间执行，多个拦截器会按优先级顺序依次执行
@Interceptor(priority = 8, name = "简单拦截器")
public class SimpleInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
//        callback.onContinue(postcard);  // 处理完成，交还控制权
        // callback.onInterrupt(new RuntimeException("我觉得有点异常"));      // 觉得有问题，中断路由流程

        // 以上两种至少需要调用其中一种，否则不会继续路由
        int extra = postcard.getExtra();
        switch (extra) {
            case Config.NEED_LOGIN:
                callback.onInterrupt(new Exception("请先登录"));
                break;
            case Config.TEST_INTERCEPTOR:
                Log.d("debuga", "测试简单拦截器");
            default:
                callback.onContinue(postcard);
        }
        if ("/sample/interceptorActivity".equals(postcard.getPath())) {
            callback.onInterrupt(new RuntimeException("触发了简单拦截器"));
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        System.out.println("简单拦截器初始化");
    }
}

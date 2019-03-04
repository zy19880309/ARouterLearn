package cn.zhangyong.samplemodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import cn.zhangyong.samplemodule.util.Config;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/sample/interceptorActivity", extras = Config.NEED_LOGIN)
public class InterceptorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interceptor);
    }
}

package cn.zhangyong.samplemodule;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import cn.zhangyong.samplemodule.util.Config;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/sample/simpleActivity", extras = Config.TEST_INTERCEPTOR)
public class SimpleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                intent.putExtra("back", "返回的结果");
                setResult(913, intent);
                finish();
            }
        }, 3000);
    }
}

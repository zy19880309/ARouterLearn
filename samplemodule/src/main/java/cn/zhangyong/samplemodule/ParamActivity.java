package cn.zhangyong.samplemodule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/sample/paramActivity")
public class ParamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param);
        Intent intent = getIntent();
        long key1 = intent.getLongExtra("key1", 0);
        String key3 = intent.getStringExtra("key3");
        TextView tv = findViewById(R.id.tv_params);
        tv.setText(key1 + "\n" + key3);
    }
}

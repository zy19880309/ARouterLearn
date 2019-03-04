package cn.zhangyong.samplemodule;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * description:
 * autour: zhangyong
 * date: 2019/1/30 15:52
 * update: 2019/1/30
 * version:
 */
@Route(path = "/sample/uriActivity")
public class UriActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri);
        Uri uri = getIntent().getData();
        Log.d("debuga", "onCreate: " + uri);//这个有很大问题之后再说
//        ARouter.getInstance().build(uri).navigation();
//        finish();
    }
}

package cn.zhangyong.samplemodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import cn.zhangyong.samplemodule.bean.Family;
import cn.zhangyong.samplemodule.service.HelloService;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/sample/paramAutoActivity")
public class ParamAutoActivity extends AppCompatActivity {
    @Autowired
    public String name;
    @Autowired
    int age;
    @Autowired(name = "girl") // 通过name来映射URL中的不同参数
            boolean boy;
    @Autowired
    Family obj;
    @Autowired
    HelloService helloService;
    @Autowired
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_param_auto);
        ARouter.getInstance().inject(this);
        String str = "name:" + name + ";age:" + age + ";boy:" + boy + ";obj:" + obj + ";service:" + helloService.sayHello("小魔仙");
        Log.d("debuga", "这是测试内容" + str);
        TextView tv = (TextView) findViewById(R.id.tv_params);
        tv.setText(str + "\n" + url);
    }
}

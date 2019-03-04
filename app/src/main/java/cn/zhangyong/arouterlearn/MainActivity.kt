package cn.zhangyong.arouterlearn

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import cn.zhangyong.samplemodule.service.HelloService
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_simple.setOnClickListener {
            ARouter.getInstance().build("/sample/simpleActivity").navigation()//简单跳转
        }
        btn_param.setOnClickListener {
            ARouter.getInstance().build("/sample/paramActivity")
                .withLong("key1", 666L)
                .withString("key3", "888")
                .navigation()
        }
        btn_uri.setOnClickListener {
            var intent = Intent()
            intent.data
            ARouter.getInstance().build("/sample/uriActivity")
                .setUri(Uri.parse("arouter://m.aliyun.com/"))
                .navigation()//简单跳转
        }
        btn_param_auto.setOnClickListener {
            //?name=呵呵&age=18
            /*var family = Family()
            family.husband = "jack"
            family.wife = "rose"
            ARouter.getInstance().build("/sample/paramAutoActivity")
                .withString("name", "girl")
                .withInt("age", 18)
                .withBoolean("girl", true)
                .withObject("obj", family)
                .navigation()*/
            var uri =
                Uri.parse(
                    "arouter://m.aliyun.com/sample/paramAutoActivity?" +
                            "name=啥爱好&age=25&girl=true&obj={\"husband\":\"jack\",\"wife\":\"rose\"}"
                )
            ARouter.getInstance().build(uri).navigation()
        }

        btn_interceptor.setOnClickListener {
            ARouter.getInstance().build("/sample/interceptorActivity")
                .navigation(this, object : NavCallback() {
                    override fun onArrival(postcard: Postcard?) {

                    }

                    override fun onInterrupt(postcard: Postcard?) {
                        runOnUiThread {
                            Toast.makeText(applicationContext, "请先登录", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
        }

        btn_degrade.setOnClickListener {
            ARouter.getInstance().build("/hahahah/heheheh").navigation()
        }

        btn_hello.setOnClickListener {
            var service = ARouter.getInstance().build("/sample/hello").navigation() as HelloService
            Toast.makeText(this, service.sayHello("潘金莲"), Toast.LENGTH_SHORT).show()
        }
        btn_result.setOnClickListener {
            ARouter.getInstance().build("/sample/simpleActivity").navigation(this, 3)//简单跳转
//            startActivityForResult(Intent(this, SimpleActivity::class.java), 3)
        }
        btn_fragment.setOnClickListener {
            var fragment = ARouter.getInstance().build("/sample/simpleFragment").navigation() as Fragment
            Log.d("debuga", fragment.toString());
        }

        btn_wv.setOnClickListener {
            //有问题一会儿再搞
            ARouter.getInstance().build("/sample/wvActivity")
                .withString("url", "file:///android_asset/schame-test.html")
                .navigation()
        }

        btn_kotlin.setOnClickListener {
            ARouter.getInstance().build("/kotlin/test")
                .withString("name", "小刚")
                .withInt("age", 89)
                .navigation()
        }

        btn_oldanim.setOnClickListener {
            ARouter.getInstance()
                .build("/sample/simpleActivity")
                .withTransition(R.anim.slide_in_bottom, R.anim.slide_out_bottom)
                .navigation(this)
        }

        btn_newanim.setOnClickListener {
            if (Build.VERSION.SDK_INT >= 16) {
                val compat = ActivityOptionsCompat.makeScaleUpAnimation(it, it.getWidth() / 2, it.getHeight() / 2, 0, 0)

                ARouter.getInstance()
                    .build("/sample/simpleActivity")
                    .withOptionsCompat(compat)
                    .navigation()
            } else {
                Toast.makeText(this, "API < 16,不支持新版本动画", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 3) {
            var str = data?.getStringExtra("back")
            Log.d("debuga", str + resultCode);
        }
    }
}

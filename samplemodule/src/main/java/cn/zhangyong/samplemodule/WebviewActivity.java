package cn.zhangyong.samplemodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/sample/wvActivity")
public class WebviewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        webView = (WebView) findViewById(R.id.wv);
        webView.loadUrl(getIntent().getStringExtra("url"));
    }
}

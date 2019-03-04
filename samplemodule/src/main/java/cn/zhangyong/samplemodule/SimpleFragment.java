package cn.zhangyong.samplemodule;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * description:
 * autour: zhangyong
 * date: 2019/2/14 17:58
 * update: 2019/2/14
 * version:
 */
@Route(path = "/sample/simpleFragment")
public class SimpleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText("简单fragment");
        return textView;
    }
}

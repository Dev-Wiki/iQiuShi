package net.devwiki.iqiushi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import net.devwiki.iqiushi.R;

/**
 * Created by zyz on 2016/3/3.
 */
public class FunctionView extends LinearLayout {

    private View rootView;

    public FunctionView(Context context) {
        super(context);
    }

    public FunctionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public FunctionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        rootView = LayoutInflater.from(context).inflate(R.layout.function_view, this, true);
    }
}

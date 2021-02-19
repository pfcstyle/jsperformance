package com.pfcstyle.js.performance.loading;

import android.content.Context;

import com.pfcstyle.js.performance.Executor;
import com.pfcstyle.js.performance.IoUtils;


abstract class BaseLoader implements Executor {

    private static final String JS_FILEPATH = "js/MockData.json";

    private String mJs;

    public BaseLoader(Context context) {
        mJs = loadJs(context);
    }

    String loadJs(Context context) {
        return "var list = " + IoUtils.getJsFromPath(context, JS_FILEPATH);
    }

    protected String getJs() {
        return mJs;
    }
}

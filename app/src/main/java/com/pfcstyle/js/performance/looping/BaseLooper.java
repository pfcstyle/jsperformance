package com.pfcstyle.js.performance.looping;

import android.content.Context;

import com.pfcstyle.js.performance.Executor;
import com.pfcstyle.js.performance.IoUtils;

abstract class BaseLooper implements Executor {

    private static final String JS_LOOP_FILEPATH = "js/SimpleLoop.js";

    String getLoopJs(Context context) {
        return IoUtils.getJsFromPath(context, JS_LOOP_FILEPATH);
    }
}

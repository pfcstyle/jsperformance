package com.pfcstyle.js.performance.looping;

import android.content.Context;

import androidx.annotation.Nullable;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

import rx.functions.Action1;

class JsEvalLooper extends BaseLooper {

    private final JsEvaluator mJsEvaluator;
    private final String mJs;

    JsEvalLooper(Context context) {
        mJsEvaluator = new JsEvaluator(context);
        mJsEvaluator.getWebViewWrapper();
        mJs = getLoopJs(context);
    }

    @Override
    public void execute(@Nullable final Action1<Long> listener) {
        final long startTime = System.nanoTime();
        mJsEvaluator.evaluate(mJs + "; getMax()", new JsCallback() {
                    @Override
                    public void onResult(String result) {
                        final long endTime = System.nanoTime();
                        if (listener != null) {
                            listener.call(endTime - startTime);
                        }
                    }

                    @Override
                    public void onError(String s) {
                        System.out.println("error:" + s);
                        final long endTime = System.nanoTime();
                        if (listener != null) {
                            listener.call(endTime - startTime);
                        }
                    }
                });
    }
}

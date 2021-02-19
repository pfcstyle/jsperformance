package com.pfcstyle.js.performance.loading;

import android.content.Context;

import androidx.annotation.Nullable;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

import rx.functions.Action1;

class JsEvalLoader extends BaseLoader {

    private final JsEvaluator mJsEvaluator;

    JsEvalLoader(Context context) {
        super(context);
        mJsEvaluator = new JsEvaluator(context);
    }

    @Override
    public void execute(@Nullable final Action1<Long> listener) {
        final long startTime = System.nanoTime();
        mJsEvaluator.evaluate(getJs(), new JsCallback() {
                    @Override
                    public void onResult(String result) {
                        final long endTime = System.nanoTime();
                        if (listener != null) {
                            listener.call(endTime - startTime);
                        }
                    }

                    @Override
                    public void onError(String s) {

                    }
                });
    }
}

package com.pfcstyle.js.performance.initialization;

import android.content.Context;

import androidx.annotation.Nullable;

import com.evgenii.jsevaluator.JsEvaluator;
import com.pfcstyle.js.performance.Executor;

import rx.functions.Action1;

class JsEvalInitializer implements Executor {

    final Context mContext;

    public JsEvalInitializer(Context context) {
        mContext = context;
    }

    @Override
    public void execute(final @Nullable Action1<Long> listener) {
        final long startTime = System.nanoTime();
        JsEvaluator evaluator = new JsEvaluator(mContext);
        evaluator.getWebViewWrapper();
        final long endTime = System.nanoTime();
        try {
            evaluator.destroy();
        }catch (Exception e){

        }


        if (listener != null) {
            listener.call(endTime - startTime);
        }
    }
}

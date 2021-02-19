package com.pfcstyle.js.performance.modeling;

import android.content.Context;

import androidx.annotation.Nullable;

import com.evgenii.jsevaluator.JsEvaluator;
import com.evgenii.jsevaluator.interfaces.JsCallback;

import rx.functions.Action1;

class JsEvalGrader extends BaseGrader {

    private final JsEvaluator mJsEvaluator;

    JsEvalGrader(Context context) {
        super(context);
        mJsEvaluator = new JsEvaluator(context);
        mJsEvaluator.getWebViewWrapper();
    }

    @Override
    public void execute(@Nullable final Action1<Long> listener) {
        // JS Evaluator executes every command in a separate context
        // so we have to load the full script on each iteration
        String js = getBaseJs()
                + "; var grader = LearnModeGraderFactory.create(); "
                + getExecutionJs();

        final long startTime = System.nanoTime();
        mJsEvaluator.evaluate(js, new JsCallback() {
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

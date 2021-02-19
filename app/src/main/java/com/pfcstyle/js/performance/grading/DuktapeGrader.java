package com.pfcstyle.js.performance.grading;

import android.content.Context;

import androidx.annotation.Nullable;

import com.pfcstyle.js.performance.JsExecutionScheduler;
import com.squareup.duktape.Duktape;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

class DuktapeGrader extends BaseGrader {

    private Duktape mDuktape;

    DuktapeGrader(final Context context) {
        super(context);
        mDuktape = init();
    }

    Duktape init() {
        Duktape duktape = Duktape.create();
        duktape.evaluate(getBaseJs());
        duktape.evaluate("var grader = LearnModeGraderFactory.create();");
        return duktape;
    }

    @Override
    public void execute(@Nullable final Action1<Long> listener) {
        Observable.defer(
                () -> {
                    final long startTime = System.nanoTime();
                    mDuktape.evaluate(JS);
                    final long endTime = System.nanoTime();
                    return Observable.just(endTime - startTime);
                }
        )
                .subscribeOn(JsExecutionScheduler.get())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(durationNs -> {
                    if (listener != null) {
                        listener.call(durationNs);
                    }
                });
    }
}

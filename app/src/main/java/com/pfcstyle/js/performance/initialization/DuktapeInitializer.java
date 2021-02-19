package com.pfcstyle.js.performance.initialization;

import androidx.annotation.Nullable;

import com.pfcstyle.js.performance.Executor;
import com.pfcstyle.js.performance.JsExecutionScheduler;
import com.squareup.duktape.Duktape;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class DuktapeInitializer implements Executor {

    @Override
    public void execute(@Nullable Action1<Long> listener) {
        Observable.defer(
                () -> {
                    final long startTime = System.nanoTime();
                    Duktape duktape = Duktape.create();
                    final long endTime = System.nanoTime();
                    duktape.close();
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

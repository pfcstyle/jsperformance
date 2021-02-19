package com.pfcstyle.js.performance;


import androidx.annotation.Nullable;

import rx.functions.Action1;

public interface Executor {

    void execute(@Nullable Action1<Long> listener);
}

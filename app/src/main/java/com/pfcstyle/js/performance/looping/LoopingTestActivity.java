package com.pfcstyle.js.performance.looping;

import android.os.Bundle;

import com.pfcstyle.js.performance.BaseTestActivity;
import com.pfcstyle.js.performance.Executor;

public class LoopingTestActivity extends BaseTestActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Looping");
    }

    @Override
    protected Executor getExecutor() {
        switch (getEngine()) {
            case JSEVALUATOR:
                return new JsEvalLooper(this);
            case J2V8:
                return new V8Looper(this);
            case DUKTAPE:
                return new DuktapeLooper(this);
        }
        throw new IllegalStateException("Pick a Javascript engine");
    }
}

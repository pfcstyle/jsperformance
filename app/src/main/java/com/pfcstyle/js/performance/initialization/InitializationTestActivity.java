package com.pfcstyle.js.performance.initialization;

import android.os.Bundle;

import com.pfcstyle.js.performance.BaseTestActivity;
import com.pfcstyle.js.performance.Executor;


public class InitializationTestActivity extends BaseTestActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Initialization");
    }

    @Override
    protected Executor getExecutor() {
        switch (getEngine()) {
            case JSEVALUATOR:
                return new JsEvalInitializer(this);
            case J2V8:
                return new V8Initializer();
            case DUKTAPE:
                return new DuktapeInitializer();
        }
        throw new IllegalStateException("Pick a Javascript engine");
    }
}

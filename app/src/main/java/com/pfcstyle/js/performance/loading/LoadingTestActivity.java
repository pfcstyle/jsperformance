package com.pfcstyle.js.performance.loading;

import android.os.Bundle;

import com.pfcstyle.js.performance.BaseTestActivity;
import com.pfcstyle.js.performance.Executor;

public class LoadingTestActivity extends BaseTestActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Loading");
    }

    @Override
    protected Executor getExecutor() {
        switch (getEngine()) {
            case JSEVALUATOR:
                return new JsEvalLoader(this);
            case J2V8:
                return new V8Loader(this);
            case DUKTAPE:
                return new DuktapeLoader(this);
        }
        throw new IllegalStateException("Pick a Javascript engine");
    }
}

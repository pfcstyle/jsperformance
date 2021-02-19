package com.pfcstyle.js.performance.modeling;

import android.os.Bundle;

import com.pfcstyle.js.performance.BaseTestActivity;
import com.pfcstyle.js.performance.Executor;


public class GradingActivity extends BaseTestActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Modeling");
    }

    @Override
    protected Executor getExecutor() {
        switch (getEngine()) {
            case JSEVALUATOR:
                return new JsEvalGrader(this);
            case J2V8:
                return new V8Grader(this);
            case DUKTAPE:
                return new DuktapeGrader(this);
        }
        throw new IllegalStateException("Pick a Javascript engine");
    }
}

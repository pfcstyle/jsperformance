package com.pfcstyle.js.performance;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.pfcstyle.js.performance.modeling.GradingActivity;
import com.pfcstyle.js.performance.initialization.InitializationTestActivity;
import com.pfcstyle.js.performance.loading.LoadingTestActivity;
import com.pfcstyle.js.performance.looping.LoopingTestActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.test_initialization)
    void onInitializationTestClicked() {
        startActivity(new Intent(this, InitializationTestActivity.class));
    }

    @OnClick(R.id.test_execution_loop)
    void onLoopingTestClicked() {
        startActivity(new Intent(this, LoopingTestActivity.class));
    }

    @OnClick(R.id.test_execution_load)
    void onLoadingTestClicked() {
        startActivity(new Intent(this, LoadingTestActivity.class));
    }

    @OnClick(R.id.test_grader)
    void onGradingTestClicked() {
        startActivity(new Intent(this, GradingActivity.class));
    }
}

package com.hejunlin.superindicator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by hejunlin on 2016/9/5.
 */
public class TestMainActivity extends AppCompatActivity {

    private Button mCommonViewButton;
    private Button mScrollViewButton;
    private Button mNetButton;

    private ImageView mProfileImg;
    private Animator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);

        initPager();

        initAnim();
    }

    private void initAnim() {
        mProfileImg = (ImageView) findViewById(R.id.profile_image);
        mAnimator = AnimatorInflater.loadAnimator(this, R.animator.scale_with_alpha);
        findViewById(R.id.bt_test_anim).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endAnim();
                mAnimator.setInterpolator(new Interpolator() {
                    @Override
                    public float getInterpolation(float input) {
                        return input;
                    }
                });
                mAnimator.setTarget(mProfileImg);
                mAnimator.start();
            }
        });
        findViewById(R.id.bt_test_anim_interpolator).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endAnim();
                mAnimator.setInterpolator(new Interpolator() {
                    @Override
                    public float getInterpolation(float input) {
                        return Math.abs(1 - input);
                    }
                });
                mAnimator.setTarget(mProfileImg);
                mAnimator.start();
            }
        });
    }

    private void endAnim() {
        if (mAnimator.isRunning()) {
            mAnimator.cancel();
            mAnimator.end();
        }
    }

    private void initPager() {
        mCommonViewButton = (Button) findViewById(R.id.bt_common);
        mScrollViewButton = (Button) findViewById(R.id.bt_scroll);
        mNetButton = (Button) findViewById(R.id.bt_net);
        mScrollViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMainActivity.this, TestScrollViewActivity.class);
                startActivity(intent);
            }
        });
        mCommonViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMainActivity.this, TestCommonViewActivity.class);
                startActivity(intent);
            }
        });
        mNetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMainActivity.this, TestCommonViewActivity.class);
                startActivity(intent);
            }
        });

    }

}

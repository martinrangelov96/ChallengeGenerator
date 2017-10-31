package com.example.martoraneca.challengegenerator.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.martoraneca.challengegenerator.R;

public class DetailActivity extends AppCompatActivity {

    private static final String EXTRA_COLOR = "EXTRA_COLOR";
    private static final String EXTRA_TIME = "EXTRA_TIME";
    private static final String EXTRA_CHALLENGE = "EXTRA_CHALLENGE";

    View mView;
    TextView mTime, mChallenge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent i = getIntent();

        int drawableExtra = i.getIntExtra(EXTRA_COLOR, 0);
        String timeExtra = i.getStringExtra(EXTRA_TIME);
        String challengeExtra = i.getStringExtra(EXTRA_CHALLENGE);

        mView = findViewById(R.id.detail_color);
        mView.setBackgroundResource(drawableExtra);

        mTime = (TextView) findViewById(R.id.detail_time);
        mTime.setText(timeExtra);

        mChallenge = (TextView) findViewById(R.id.detail_challenge);
        mChallenge.setText(challengeExtra);

    }
}

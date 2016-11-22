package com.shizhefei.view.hvscrollview.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private View moreLayerScrollViewButton;
    private View guideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moreLayerScrollViewButton = findViewById(R.id.main_moreLayerScrollView_button);
        guideButton = findViewById(R.id.main_guide_button);

        guideButton.setOnClickListener(onClickListener);
        moreLayerScrollViewButton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == guideButton) {
                startActivity(new Intent(getApplicationContext(), GuideActivity.class));
            } else if (v == moreLayerScrollViewButton) {
                startActivity(new Intent(getApplicationContext(), MoreLayerScrollViewActivity.class));
            }
        }
    };
}

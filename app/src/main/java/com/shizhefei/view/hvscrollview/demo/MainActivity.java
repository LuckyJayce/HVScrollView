package com.shizhefei.view.hvscrollview.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;


public class MainActivity extends FragmentActivity {

    private View moreLayerScrollViewButton;
    private View guideButton;
    private View compareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        moreLayerScrollViewButton = findViewById(R.id.main_moreLayerScrollView_button);
        guideButton = findViewById(R.id.main_guide_button);
        compareButton = findViewById(R.id.main_compare_button);

        guideButton.setOnClickListener(onClickListener);
        moreLayerScrollViewButton.setOnClickListener(onClickListener);
        compareButton.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == guideButton) {
                startActivity(new Intent(getApplicationContext(), GuideActivity.class));
            } else if (v == moreLayerScrollViewButton) {
                startActivity(new Intent(getApplicationContext(), MoreLayerScrollViewActivity.class));
            } else if (v == compareButton) {
                startActivity(new Intent(getApplicationContext(), CompareActivity.class));
            }
        }
    };
}

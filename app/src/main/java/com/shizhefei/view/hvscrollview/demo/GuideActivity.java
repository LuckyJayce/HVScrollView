package com.shizhefei.view.hvscrollview.demo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.shizhefei.view.hvscrollview.HVScrollView;


public class GuideActivity extends FragmentActivity {

    private View addButton;
    private LinearLayout layout;
    private View deleteButton;
    private ToggleButton canScrollHToggleButton;
    private ToggleButton canScrollVToggleButton;
    private ToggleButton fillViewportHToggleButton;
    private ToggleButton fillViewportVToggleButton;
    private ToggleButton childLayoutCanterToggleButton;
    private HVScrollView hvScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        layout = (LinearLayout) findViewById(R.id.guide_layout);
        addButton = findViewById(R.id.guide_addButton);
        deleteButton = findViewById(R.id.guide_deleteButton);
        canScrollHToggleButton = (ToggleButton) findViewById(R.id.guide_canScrollH_toggleButton);
        canScrollVToggleButton = (ToggleButton) findViewById(R.id.guide_canScrollV_toggleButton);
        fillViewportHToggleButton = (ToggleButton) findViewById(R.id.guide_fillViewportH_toggleButton);
        fillViewportVToggleButton = (ToggleButton) findViewById(R.id.guide_fillViewportV_toggleButton);
        childLayoutCanterToggleButton = (ToggleButton) findViewById(R.id.guide_childLayoutCanter_toggleButton);
        hvScrollView = (HVScrollView) findViewById(R.id.guide_hvScrollView);

        addButton.setOnClickListener(onClickListener);
        deleteButton.setOnClickListener(onClickListener);

        canScrollHToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        canScrollVToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        fillViewportHToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        fillViewportVToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        childLayoutCanterToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);

//        setContentView(R.layout.layout2);

//        NestedScrollView
    }

    private int index = 1;
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == addButton) {
                View l = getLayoutInflater().inflate(R.layout.item, layout, false);
                EditText editText = (EditText) l.findViewById(R.id.item_editText);
                editText.setText(String.format("%02d", index) + ":Hello World");
                layout.addView(l, layout.getChildCount() - 1);
                index++;
            } else if (v == deleteButton) {
                if (layout.getChildCount() > 1) {
                    layout.removeViewAt(layout.getChildCount() - 2);
                }
            }
        }
    };

    private ToggleButton.OnCheckedChangeListener onCheckedChangeListener = new ToggleButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (compoundButton == canScrollHToggleButton) {//是否可以水平滚动，默认可以滚动
                hvScrollView.setCanScrollHorizontally(!compoundButton.isChecked());

            } else if (compoundButton == canScrollVToggleButton) {//是否可以垂直滚动，默认可以滚动
                hvScrollView.setCanScrollVertically(!compoundButton.isChecked());

            } else if (compoundButton == fillViewportHToggleButton) {  //水平内容宽度是否充满，默认false自适应
                hvScrollView.setFillViewportH(compoundButton.isChecked());

            } else if (compoundButton == fillViewportVToggleButton) {//垂直内容高度是否充满，默认false自适应
                hvScrollView.setFillViewportV(compoundButton.isChecked());

            } else if (compoundButton == childLayoutCanterToggleButton) {//内容是否居中显示，默认右上角对齐
                hvScrollView.setChildLayoutCenter(compoundButton.isChecked());
            }
        }
    };
}

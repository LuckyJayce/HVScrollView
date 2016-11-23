package com.shizhefei.view.hvscrollview.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.shizhefei.view.hvscrollview.HVScrollView;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;


public class GuideActivity extends FragmentActivity {

    private View addButton;
    private LinearLayout layout;
    private View deleteButton;
    private ToggleButton fillViewportHToggleButton;
    private ToggleButton fillViewportVToggleButton;
    private ToggleButton childLayoutCanterToggleButton;
    private HVScrollView hvScrollView;
    private Indicator scrollOrientationIndicatorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        layout = (LinearLayout) findViewById(R.id.guide_layout);
        addButton = findViewById(R.id.guide_addButton);
        deleteButton = findViewById(R.id.guide_deleteButton);
        fillViewportHToggleButton = (ToggleButton) findViewById(R.id.guide_fillViewportH_toggleButton);
        fillViewportVToggleButton = (ToggleButton) findViewById(R.id.guide_fillViewportV_toggleButton);
        childLayoutCanterToggleButton = (ToggleButton) findViewById(R.id.guide_childLayoutCanter_toggleButton);
        hvScrollView = (HVScrollView) findViewById(R.id.guide_hvScrollView);
        scrollOrientationIndicatorView = (Indicator) findViewById(R.id.guide_scrollOrientation_indicatorView);

        addButton.setOnClickListener(onClickListener);
        deleteButton.setOnClickListener(onClickListener);

        fillViewportHToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        fillViewportVToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);
        childLayoutCanterToggleButton.setOnCheckedChangeListener(onCheckedChangeListener);

        scrollOrientationIndicatorView.setAdapter(indicatorAdapter);
        scrollOrientationIndicatorView.setScrollBar(new ColorBar(this, Color.WHITE, 8));
        scrollOrientationIndicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.WHITE, Color.parseColor("#cccccc")));
        scrollOrientationIndicatorView.setCurrentItem(3);
        scrollOrientationIndicatorView.setOnItemSelectListener(onItemSelectListener);
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
            if (compoundButton == fillViewportHToggleButton) {  //水平内容宽度是否充满，默认false自适应
                hvScrollView.setFillViewportH(compoundButton.isChecked());

            } else if (compoundButton == fillViewportVToggleButton) {//垂直内容高度是否充满，默认false自适应
                hvScrollView.setFillViewportV(compoundButton.isChecked());

            } else if (compoundButton == childLayoutCanterToggleButton) {//内容是否居中显示，默认右上角对齐
                hvScrollView.setChildLayoutCenter(compoundButton.isChecked());
            }
        }
    };

    private Indicator.IndicatorAdapter indicatorAdapter = new Indicator.IndicatorAdapter() {
        private String[] titles = {"不能滚动", "只能水平滚动", "只能垂直滚动", "双向滚动"};

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_toptab, parent, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(titles[position]);
            return convertView;
        }
    };

    private Indicator.OnItemSelectedListener onItemSelectListener = new Indicator.OnItemSelectedListener() {

        @Override
        public void onItemSelected(View selectItemView, int select, int preSelect) {
//          public static final int SCROLL_ORIENTATION_NONE = 0;
//          public static final int SCROLL_ORIENTATION_HORIZONTAL = 1;
//          public static final int SCROLL_ORIENTATION_VERTICAL = 2;
//          public static final int SCROLL_ORIENTATION_BOTH = 3;
            hvScrollView.setScrollOrientation(select);
        }
    };


}

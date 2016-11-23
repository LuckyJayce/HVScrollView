package com.shizhefei.view.hvscrollview.demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.ScrollIndicatorView;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

public class CompareActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);
        ScrollIndicatorView indicatorView = (ScrollIndicatorView) findViewById(R.id.compare_indicatorView);
        ViewPager viewPager = (ViewPager) findViewById(R.id.compare_viewPager);

        indicatorView.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.BLACK, Color.GRAY));
        indicatorView.setScrollBar(new ColorBar(this, Color.parseColor("#ff0000"), 4));
        IndicatorViewPager indicatorViewPager = new IndicatorViewPager(indicatorView, viewPager);
        indicatorViewPager.setAdapter(new PagerAdapters());

    }

    private class PagerAdapters extends IndicatorViewPager.IndicatorViewPagerAdapter {
        private int[] layouts = {R.layout.scroll_1, R.layout.scroll_2, R.layout.scroll_3, R.layout.empty};
        private String[] titles = {"普通ScrollView", "V4的NestedScrollView", "HVScrollView", "空界面"};

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            convertView = getLayoutInflater().inflate(R.layout.item_toptab, container, false);
            TextView textView = (TextView) convertView;
            textView.setText(titles[position]);
            return convertView;
        }

        @Override
        public View getViewForPage(int position, View convertView, ViewGroup container) {
            return getLayoutInflater().inflate(layouts[position], container, false);
        }
    }


}

package com.example.meetingactivity;

import android.content.Context;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import com.example.meetingactivity.Fragment.BoardFragment;
import com.example.meetingactivity.Fragment.CalendarFragment;
import com.example.meetingactivity.Fragment.InforFragment;
import com.example.meetingactivity.Fragment.PhotoFragment;
import com.example.meetingactivity.adapter.ContentsPagerAdapter;

public class MainActivity extends AppCompatActivity
        implements InforFragment.OnFragmentInteractionListener,
        BoardFragment.OnFragmentInteractionListener, CalendarFragment.OnFragmentInteractionListener, PhotoFragment.OnFragmentInteractionListener {

    private Context mContext;
    private TabLayout mTabLayout;

    private ViewPager mViewPager;
    private ContentsPagerAdapter mContentsPagerAdapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = getApplicationContext();
        mTabLayout = (TabLayout) findViewById(R.id.layout_tab);

        mTabLayout.addTab(mTabLayout.newTab().setText("홈"));
        mTabLayout.addTab(mTabLayout.newTab().setText("게시판"));
        mTabLayout.addTab(mTabLayout.newTab().setText("사진첩"));
       mTabLayout.addTab(mTabLayout.newTab().setText("일정"));

        mViewPager = (ViewPager) findViewById(R.id.pager_content);

        mContentsPagerAdapter = new ContentsPagerAdapter(
                getSupportFragmentManager(), mTabLayout.getTabCount());

        mViewPager.setAdapter(mContentsPagerAdapter);


        mViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override

            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }




            @Override

            public void onTabUnselected(TabLayout.Tab tab) {




            }




            @Override

            public void onTabReselected(TabLayout.Tab tab) {




            }

        });

    }
    private View createTabView(String tabName) {

        View tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);

        TextView txt_name = (TextView) tabView.findViewById(R.id.txt_name);

        txt_name.setText(tabName);

        return tabView;

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);

        return  super.onCreateOptionsMenu(menu);
    }
}



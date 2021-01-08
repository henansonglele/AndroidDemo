package com.dd;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.dd.ui.dashboard.DashboardFragment;
import com.dd.ui.home.HomeFragment;
import com.dd.ui.my.MyFragment;
import com.dd.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    };

    BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mViewPager.setCurrentItem(0);
                    Toast.makeText( MainActivity.this,"1",Toast.LENGTH_SHORT);
                    return true;
                case R.id.navigation_dashboard:
                    mViewPager.setCurrentItem(1);
                    Toast.makeText( MainActivity.this,"2",Toast.LENGTH_SHORT);
                    return true;
                case R.id.navigation_notifications:
                    mViewPager.setCurrentItem(2);
                    Toast.makeText( MainActivity.this,"3",Toast.LENGTH_SHORT);
                    return true;
                case R.id.navigation_my:
                    mViewPager.setCurrentItem(3);
                    Toast.makeText( MainActivity.this,"4",Toast.LENGTH_SHORT);
                    return true;
            }
            return false;
        }
    };


   void  initView(){
       mViewPager=(ViewPager) findViewById(R.id.mViewPager);
       navigationView=(BottomNavigationView) findViewById(R.id.navigation);
       navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
       mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
               navigationView.getMenu().getItem(position).setChecked(true);

           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
       initViewPager();
    }

   void  initViewPager(){
       final ArrayList<Fragment> fgLists=new ArrayList<>(4);
       fgLists.add(new HomeFragment());
       fgLists.add(new NotificationsFragment());
       fgLists.add(new DashboardFragment());
       fgLists.add(new MyFragment());
       FragmentPagerAdapter mPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
           @Override
           public Fragment getItem(int position) {
               return fgLists.get(position);
           }

           @Override
           public int getCount() {
               return fgLists.size();
           }
       };
       mViewPager.setAdapter(mPagerAdapter);
       mViewPager.setOffscreenPageLimit(3);
    }


}

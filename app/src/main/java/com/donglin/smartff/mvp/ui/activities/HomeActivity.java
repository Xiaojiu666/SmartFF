package com.donglin.smartff.mvp.ui.activities;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

import com.donglin.smartff.BottomNavigationViewHelper;
import com.donglin.smartff.R;
import com.donglin.smartff.mvp.base.BaseAppComPatActivity;
import com.donglin.smartff.mvp.ui.adapter.MyFragmentPagerAdapter;
import com.donglin.smartff.mvp.ui.fragments.AlarmFargment;
import com.donglin.smartff.mvp.ui.fragments.IotFragment;
import com.donglin.smartff.mvp.ui.fragments.SystemPartInfoFragment;
import com.donglin.smartff.widget.NoScollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeActivity extends BaseAppComPatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @BindView(R.id.home_vp_contant)
    NoScollViewPager mHomeVpContant;
    @BindView(R.id.navigation)
    BottomNavigationView mHomeNavigation;
    /**
     * Fragment集合
     */
    private List<Fragment> mFragment=new ArrayList<Fragment>();


    private enum TabFragment {
        home(R.id.navigation_home, IotFragment.class),
        alarm(R.id.navigation_alarm, IotFragment.class),
        iot(R.id.navigation_system, IotFragment.class),
        person(R.id.navigation_preson, IotFragment.class);

        private final int menuId;
        private final Class<? extends Fragment> clazz;
        private Fragment fragment;

        TabFragment(@IdRes int menuId, Class<? extends Fragment> clazz) {
            this.menuId = menuId;
            this.clazz = clazz;
        }

        @NonNull
        public Fragment fragment() {
            if (fragment == null) {
                try {
                    fragment = clazz.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                    fragment = new Fragment();
                }
            }
            return fragment;
        }


        public static TabFragment id4Fg(int itemId) {
            for (TabFragment fragment : values()) {
                if (fragment.menuId == itemId) {
                    return fragment;
                }
            }
            return home;
        }

        public static void onDestroy() {
            for (TabFragment fragment : values()) {
                fragment.fragment = null;
            }
        }
    }

    @Override
    protected void initOnClick() {
        mHomeNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    protected void initData() {
        mFragment.add(new IotFragment());
        mFragment.add(new AlarmFargment());
        mFragment.add(new SystemPartInfoFragment());
        mFragment.add(new IotFragment());
    }

    @Override
    protected void initView() {
        BottomNavigationViewHelper.disableShiftMode(mHomeNavigation);
        mHomeVpContant.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), mFragment));
        mHomeVpContant.setOffscreenPageLimit(4);
    }

    @Override
    public int getResLayout() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mHomeVpContant.setCurrentItem(TabFragment.id4Fg(item.getItemId()).ordinal(), false);
        return true;
    }
}

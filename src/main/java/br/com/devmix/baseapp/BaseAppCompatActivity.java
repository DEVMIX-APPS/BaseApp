package br.com.devmix.baseapp;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import br.com.devmix.baseapp.listener.OnCanSetLayoutParamsListener;
import br.com.devmix.baseapp.listener.SwitchFragment;

/**
 * Created by orasystems on 24/07/15.
 */
public class BaseAppCompatActivity {

    public void setupNavigationView(Toolbar toolbar, ActionBarDrawerToggle mDrawerToggle, final DrawerLayout mDrawerLayout, NavigationView navigationView, final SwitchFragment switchFragmentCallback) {
        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switchFragmentCallback.onswitchFragment(menuItem.getItemId());
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    public void setupFloatingActionButton(final FloatingActionButton mFloatingActionButton) {
        Utils.setFabLayoutParams(mFloatingActionButton, new OnCanSetLayoutParamsListener() {
            @Override
            public void onCanSetLayoutParams() {
                // setMargins to fix floating action button's layout bug
                CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mFloatingActionButton
                        .getLayoutParams();
                params.setMargins(0, 0, 0, 0);
                mFloatingActionButton.setLayoutParams(params);
            }
        });
    }

    public Snackbar onMakeSnackbarBaseApp(CharSequence text, int duration, CoordinatorLayout mCoordinatorLayout) {
        return Snackbar.make(mCoordinatorLayout, text, duration);
    }

}

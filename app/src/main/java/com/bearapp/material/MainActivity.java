package com.bearapp.material;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    public static final String HOME_FRAGMENT_TAG = "HOME_FRAGMENT";
    public static final String FAVORITE_FRAGMENT_TAG = "FAVORITE_FRAGMENT";
    public static final String BOOKMARK_FRAGMENT_TAG = "BOOKMARK_FRAGMENT";

    private static final String EXTRA_CURRENT_FRAGMENT = "EXTRA_CURRENT_FRAGMENT";

    private String CURRENT_FRAGMENT = HOME_FRAGMENT_TAG;

    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate>>>>>>" + CURRENT_FRAGMENT);

        // Navigation drawer
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);


        // Set behavior of Navigation drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.d(TAG, "item: " + item.getTitle());
                String tag = null;
                switch (item.getItemId()) {
                    case R.id.nav_home_fragment:
                        tag = HOME_FRAGMENT_TAG;
                        break;
                    case R.id.nav_favorite_fragment:
                        tag = FAVORITE_FRAGMENT_TAG;
                        break;
                    default:


                }
                if (tag != null && !tag.equals(CURRENT_FRAGMENT)) {
                    showFragment(tag);
                    item.setChecked(true);
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        if (savedInstanceState == null) {
            Log.d(TAG, "savedInstanceState == null>>>");
            showFragment(HOME_FRAGMENT_TAG);
            navigationView.setCheckedItem(R.id.nav_home_fragment);
        } else {
            Log.d(TAG, "savedInstanceState != null>>>");
            CURRENT_FRAGMENT = savedInstanceState.getString(EXTRA_CURRENT_FRAGMENT);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }


    public void setupToolBar(String title) {
        // Adding menu icon to toolbar
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator = VectorDrawableCompat.create(getResources(), R.drawable.ic_menu_black_24dp, getTheme());
            indicator.setTint(ResourcesCompat.getColor(getResources(), R.color.white, getTheme()));
            supportActionBar.setHomeAsUpIndicator(indicator);
            supportActionBar.setDisplayHomeAsUpEnabled(true);
            if (title != null) {
                supportActionBar.setTitle(title);
            }
        }
    }


    private void showFragment(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment current = fragmentManager.findFragmentByTag(CURRENT_FRAGMENT);
        if (current != null) {
            fragmentManager.beginTransaction().hide(current).commit();
        }
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager.beginTransaction().show(fragment).commit();
        } else {
            fragment = newFragment(tag);
            if (fragment != null) {
                fragmentManager.beginTransaction().add(R.id.main_content, fragment, tag).commit();
            }
        }
        CURRENT_FRAGMENT = tag;
    }

    private Fragment newFragment(String tag) {
        if (HOME_FRAGMENT_TAG.equals(tag)) {
            return new HomeFragment();
        } else if (FAVORITE_FRAGMENT_TAG.equals(tag)) {
            return new FavoriteFragment();
        }
        return null;
    }

    public String CURRENT_FRAGMENT() {
        return CURRENT_FRAGMENT;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState>>>");
        outState.putString(EXTRA_CURRENT_FRAGMENT, CURRENT_FRAGMENT);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy>>>>>");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart>>>>");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop>>>>>>");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume>>>>>>");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause>>>>>>");
    }
}

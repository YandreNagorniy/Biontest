package com.example.yandre.biontest.ui.main;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import com.example.yandre.biontest.R;
import com.example.yandre.biontest.adapters.MenuAdapter;
import com.example.yandre.biontest.ui.calculator.CalculatorFragment;
import com.example.yandre.biontest.ui.calculator.CalculatorFragment2;
import com.example.yandre.biontest.ui.settings.SettingsFragment;

import java.util.ArrayList;
import java.util.Arrays;

import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout;
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView;
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity implements DuoMenuView.OnMenuClickListener {
    private MenuAdapter mMenuAdapter;
    private ViewHolder mViewHolder;

    private ArrayList<String> mTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitles = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.menuOptions)));


        // Initialize the views
        mViewHolder = new ViewHolder();

        //показывать со старта открытым mDuoDrawerLayout
        mViewHolder.mDuoDrawerLayout.openDrawer(GravityCompat.START);

        handleToolbar();
        handleMenu();
        handleDrawer();

        // Show main fragment in container
        goToFragment(new CalculatorFragment(), false);
        mMenuAdapter.setViewSelected(0, true);
        setTitle(mTitles.get(0));

    }

    private void handleToolbar() {
        // setSupportActionBar(mViewHolder.mToolbar);
    }

    private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this,
                mViewHolder.mDuoDrawerLayout,
                mViewHolder.mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mViewHolder.mDuoDrawerLayout.setDrawerListener(duoDrawerToggle);
        duoDrawerToggle.syncState();
    }

    private void handleMenu() {
        mMenuAdapter = new MenuAdapter(mTitles);
        mViewHolder.mDuoMenuView.setOnMenuClickListener(this);
        mViewHolder.mDuoMenuView.setAdapter(mMenuAdapter);
    }


    @Override
    public void onFooterClicked() {
        Toast.makeText(this, "onFooterClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onHeaderClicked() {
        Toast.makeText(this, "onHeaderClicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOptionClicked(int position, Object objectClicked) {
        // Set the toolbar title
        setTitle(mTitles.get(position));
        // Set the right options selected
        mMenuAdapter.setViewSelected(position, true);
        switch (position) {
            case 0:
                goToFragment(new CalculatorFragment2(), false);
                break;
            case 1:
                goToFragment(new SettingsFragment(), false);
                break;
            case 2:
                //  goToFragment(new MainFragment(), false);
                break;
        }
        // Close the drawer
//        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    private void goToFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        //  transaction.add(R.id.container, fragment).commit();
        transaction.replace(R.id.container, fragment).commit();
        mViewHolder.mDuoDrawerLayout.closeDrawer();

    }

    private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private DuoMenuView mDuoMenuView;
        private Toolbar mToolbar;

        ViewHolder() {
            mDuoDrawerLayout = findViewById(R.id.drawer);
            mDuoMenuView = (DuoMenuView) mDuoDrawerLayout.getMenuView();
            //  mToolbar = findViewById(R.id.toolbar);
        }
    }
}

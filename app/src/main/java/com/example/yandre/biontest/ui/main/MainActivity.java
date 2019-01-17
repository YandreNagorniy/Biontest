package com.example.yandre.biontest.ui.main;

import android.annotation.SuppressLint;
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
import com.example.yandre.biontest.ui.about.AboutUsFragment;
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
    CalculatorFragment calculatorFragment;
    SettingsFragment settingsFragment;
    AboutUsFragment aboutUsFragment;

    private ArrayList<String> mTitles = new ArrayList<>();

    @SuppressLint("CommitTransaction")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitles = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.menuOptions)));

        calculatorFragment = new CalculatorFragment();
        settingsFragment = new SettingsFragment();
        aboutUsFragment = new AboutUsFragment();

        // Initialize the views
        mViewHolder = new ViewHolder();

        //показывать со старта открытым mDuoDrawerLayout
        mViewHolder.mDuoDrawerLayout.openDrawer(GravityCompat.START);

        handleToolbar();
        handleMenu();
        handleDrawer();

        //  showCalculatorFragment();

        addFragment();
        showCalculatorFragment();
        mMenuAdapter.setViewSelected(0, true);
        setTitle(mTitles.get(0));
    }

    private void handleToolbar() {
        // setSupportActionBar(mViewHolder.mToolbar);
    }

    private void handleDrawer() {
        DuoDrawerToggle duoDrawerToggle = new DuoDrawerToggle(this,
                mViewHolder.mDuoDrawerLayout,
//                mViewHolder.mToolbar,
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
//                goToFragment(new CalculatorFragment(), false);
                showCalculatorFragment();
                break;
            case 1:
//                goToFragment(new SettingsFragment(), false);
                showSettingsFragment();
                break;

            case 2:
//                goToFragment(new AboutUsFragment(), false);
                showAboutUsFragment();
                break;
        }
        // Close the drawer
//        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }


    private void showCalculatorFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (calculatorFragment.isAdded()) { // if the fragment is already in container
            transaction.show(calculatorFragment);
        }
        if (settingsFragment.isAdded()) {
            transaction.hide(settingsFragment);
        }
        if (aboutUsFragment.isAdded()) {
            transaction.hide(aboutUsFragment);
        }
        transaction.commit();

        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    private void showSettingsFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (settingsFragment.isAdded()) { // if the fragment is already in container
            transaction.show(settingsFragment);
        }
        if (calculatorFragment.isAdded()) {
            transaction.hide(calculatorFragment);
        }
        if (aboutUsFragment.isAdded()) {
            transaction.hide(aboutUsFragment);
        }
        transaction.commit();

        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    private void showAboutUsFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if (aboutUsFragment.isAdded()) { // if the fragment is already in container
            transaction.show(aboutUsFragment);
        }
//        else { // fragment needs to be added to frame container
//            transaction.add(R.id.container, aboutUsFragment);
//        }
        if (calculatorFragment.isAdded()) {
            transaction.hide(calculatorFragment);
        }
        if (settingsFragment.isAdded()) {
            transaction.hide(settingsFragment);
        }
        transaction.commit();

        mViewHolder.mDuoDrawerLayout.closeDrawer();
    }

    private void addFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, aboutUsFragment);
        transaction.add(R.id.container, settingsFragment);
//        transaction.hide(aboutUsFragment);
//        transaction.hide(settingsFragment);

        transaction.add(R.id.container, calculatorFragment);
        transaction.commit();
    }
        private class ViewHolder {
        private DuoDrawerLayout mDuoDrawerLayout;
        private DuoMenuView mDuoMenuView;
//        private Toolbar mToolbar;

        ViewHolder() {
            mDuoDrawerLayout = findViewById(R.id.drawer);
            mDuoMenuView = (DuoMenuView) mDuoDrawerLayout.getMenuView();
            //  mToolbar = findViewById(R.id.toolbar);
        }
    }
}

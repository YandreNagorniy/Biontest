package com.example.yandre.biontest.ui.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.adapters.SettingsAdapter;
import com.example.yandre.biontest.databinding.FragmentSettingsBinding;
import com.example.yandre.biontest.pojo.SoilFactorsModel;

import java.util.List;

public class SettingsFragment extends Fragment implements SettingsView {
    FragmentSettingsBinding binding;
    SettingsPresenter settingsPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_settings, container, false);
        settingsPresenter = new SettingsPresenterImpl(this);
        binding.rvSoilFactors.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        settingsPresenter.loadSoilFactors();

        return binding.getRoot();
    }

    @Override
    public void displayData(List<SoilFactorsModel> soilList) {
        if (soilList.size() == 0) {
            settingsPresenter.addStartSoilFactors();
        }
        RecyclerView.Adapter adapter = new SettingsAdapter(getActivity(), soilList);
        binding.rvSoilFactors.setAdapter(adapter);
    }
}
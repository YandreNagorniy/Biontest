package com.example.yandre.biontest.presentation.ui.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.databinding.FragmentSettingsBinding;
import com.example.yandre.biontest.data.database.model.SoilFactorsModel;

import java.util.List;

public class SettingsFragment extends Fragment implements SettingsView {
    FragmentSettingsBinding binding;
    SettingsModel settingsModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_settings, container, false);
        settingsModel = new SettingsModelImpl(this);

        binding.rvSoilFactors.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        settingsModel.loadSoilFactors();

        return binding.getRoot();
    }

    @Override
    public void displayData(List<SoilFactorsModel> soilList) {
        if (soilList.size() == 0) {
//            нету данных по почве
        }
//        RecyclerView.Adapter adapter = new TSoilFactorsAdapter(getActivity(), soilList);
//        binding.rvSoilFactors.setAdapter(adapter);
    }
}
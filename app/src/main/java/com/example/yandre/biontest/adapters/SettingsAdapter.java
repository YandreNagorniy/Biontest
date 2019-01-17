package com.example.yandre.biontest.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.databinding.CardSettingsBinding;
import com.example.yandre.biontest.pojo.SoilFactorsModel;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder> {
    private List<SoilFactorsModel> soilFactorsModelList;
    private Context context;

    public SettingsAdapter( Context context, List<SoilFactorsModel> soilFactorsModelList) {
        this.soilFactorsModelList = soilFactorsModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public SettingsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        CardSettingsBinding binding = DataBindingUtil.inflate(inflater, R.layout.card_settings, viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsAdapter.ViewHolder holder, int position) {
        holder.binding.setFactor(soilFactorsModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardSettingsBinding binding;

        public ViewHolder(CardSettingsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}


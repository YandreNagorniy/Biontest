package com.example.yandre.biontest.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.yandre.biontest.R;
import com.example.yandre.biontest.database.model.SoilFactorsModel;
import com.example.yandre.biontest.databinding.CardSettingsBinding;

import java.util.List;

public class TSoilFactorsAdapter extends RecyclerView.Adapter<TSoilFactorsAdapter.ViewHolder> {
    private List<SoilFactorsModel> soilFactorsModelList;
    private Context context;

    public TSoilFactorsAdapter(Context context, List<SoilFactorsModel> soilFactorsModelList) {
        this.soilFactorsModelList = soilFactorsModelList;

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        CardSettingsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.card_settings, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.binding.setSoilFactor(soilFactorsModelList.get(position));
        holder.bind(soilFactorsModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return soilFactorsModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardSettingsBinding binding;

        ViewHolder(CardSettingsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(SoilFactorsModel soilFactorsModel) {
            binding.setSoilFactor(soilFactorsModel);
            binding.executePendingBindings();
        }
    }
}

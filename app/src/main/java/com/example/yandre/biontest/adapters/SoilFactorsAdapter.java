package com.example.yandre.biontest.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yandre.biontest.R;

import com.example.yandre.biontest.database.model.SoilFactorsModel;
import com.example.yandre.biontest.databinding.CardSettingsBinding;

import java.util.List;

public class SoilFactorsAdapter extends RecyclerView.Adapter<SoilFactorsAdapter.ViewHolder> {
    private List<SoilFactorsModel> soilFactorsModelList;
    private Context context;

    public SoilFactorsAdapter(Context context, List<SoilFactorsModel> soilFactorsModelList) {
        this.soilFactorsModelList = soilFactorsModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public SoilFactorsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        CardSettingsBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.card_settings, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SoilFactorsAdapter.ViewHolder holder, int position) {
//        switch (soilFactorsModelList.get(position).getSubTitle()) {
//            case "K2O": {
//            }
//            break;
//            case "P2O5": {
//            }
//            break;
//            default:
        holder.binding.setSoilFactor(soilFactorsModelList.get(position));
        //        }
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
    }
}


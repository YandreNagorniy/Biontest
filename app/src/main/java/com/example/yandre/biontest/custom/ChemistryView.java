package com.example.yandre.biontest.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.yandre.biontest.R;

public class ChemistryView extends FrameLayout {
    public ChemistryView(Context context) {
        this(context, null);
    }

    public ChemistryView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChemistryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context,R.layout.chemistry_layout,this);

        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.ChemistryView);
        String title = array.getString(R.styleable.ChemistryView_title);
        String subTitle = array.getString(R.styleable.ChemistryView_sub_title);
        int value = array.getInt(R.styleable.ChemistryView_value, 0);

       TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvSubTitle = findViewById(R.id.tvSubtitle);
        EditText edValue = findViewById(R.id.etValue);

        tvTitle.setText(title);
        tvSubTitle.setText(subTitle);
        edValue.setText(String.valueOf(value));
        array.recycle();
    }
}

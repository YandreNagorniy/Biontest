package com.example.yandre.biontest.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.yandre.biontest.R;

public class ChemistryView extends FrameLayout {
    private TextView tvTitle;
    private TextView tvSubTitle;
    private EditText edValue;
    private int value;

    public ChemistryView(Context context) {
        this(context, null);
    }

    public ChemistryView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChemistryView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflate(context, R.layout.chemistry_layout, this);

        TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.ChemistryView);
        String title = array.getString(R.styleable.ChemistryView_title);
        String subTitle = array.getString(R.styleable.ChemistryView_sub_title);
        value = array.getInt(R.styleable.ChemistryView_value, 0);

        tvTitle = findViewById(R.id.tvTitle);
        tvSubTitle = findViewById(R.id.tvSubtitle);
        edValue = findViewById(R.id.etValue);

        tvTitle.setText(title);
        tvSubTitle.setText(subTitle);
        edValue.setText(String.valueOf(value));
        array.recycle();
    }

    public void setValueElement(String element) {
        edValue.setText(element);
    }

    public String getSubtitleText() {
        return String.valueOf(tvSubTitle.getText());
    }

    public void setSubtitleText(String text) {
        tvSubTitle.setText(text);
    }

    public void setSubtitleText(Spannable text) {
        tvSubTitle.setText(text, TextView.BufferType.SPANNABLE);
    }
}

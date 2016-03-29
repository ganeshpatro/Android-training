package com.example.gani.androidtraining.CustomComponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.Image;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gani.androidtraining.R;

/**
 * Created by ganeshpatro on 29/03/16.
 */
public class ColorOptionsView extends LinearLayout {
    private View mView;
    private ImageView mImageView;

    public ColorOptionsView(Context context, AttributeSet attrs) {
        super(context,attrs);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.Options);
        String titile = array.getString(R.styleable.Options_titleText);

        int valueColor = array.getColor(R.styleable.Options_valueColor,android.R.color.holo_blue_light);
        array.recycle();

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.view_color_options,this,true);


        TextView textView = (TextView) view.findViewById(R.id.textViewCustomComponent);
        textView.setText(titile);

        //Set background color
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewRightArrow);
       imageView.setBackgroundColor(valueColor);

    }

    public ColorOptionsView(Context context) {
        super(context,null);
    }

    public void setValueColor(int color) {
        mView.setBackgroundColor(color);
    }

    public void setImageVisible(boolean visible) {
        mImageView.setVisibility(visible ? View.VISIBLE : View.GONE);
    }


}

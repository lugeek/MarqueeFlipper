package com.lugeek.marqueeflipper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lujiaming on 16/8/20.
 */

public class MarqueeFlipperView extends ViewFlipper implements View.OnClickListener{
    private static final int DEFAULT_INTERVAL = 3000;
    private Context mContext;
    private List<String> mData = new ArrayList<>();
    private OnFlipperClickListener mListener;

    public interface OnFlipperClickListener {
        void onClick(String title, int position);
    }

    public MarqueeFlipperView(Context context) {
        super(context);
        init(context);
    }

    public MarqueeFlipperView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        setFlipInterval(DEFAULT_INTERVAL);
        setInAnimation(mContext, R.anim.marquee_in);
        setOutAnimation(mContext, R.anim.marquee_out);
        setOnClickListener(this);
    }

    public void setData(List<String> data) {
        if (data == null || data.isEmpty()) return;
        mData.clear();
        mData.addAll(data);
        removeAllViews();
        for (String str : mData) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_marquee, null, false);
            ((TextView)view.findViewById(R.id.tv_title)).setText(str);
            addView(view);
        }
        if (!isFlipping()) {
            startFlipping();
        }
    }

    public void setOnFlipperClickListener(OnFlipperClickListener listener) {
        this.mListener = listener;
    }

    @Override
    public void onClick(View v) {
        int position = getDisplayedChild();
        mListener.onClick(mData.get(position), position);
    }

}

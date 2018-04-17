package com.donglin.smartff.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.donglin.smartff.R;


import java.util.List;

/**
 * Created by Administrator on 2018/1/15 0015.
 */

public class AutoVerticalViewView extends ViewFlipper {

    private Context mContext;
    private boolean isSetAnimDuration = false;
    private int interval = 3000;
    private int animDuration = 500;
    private AutoVerticalViewView.OnItemClickListener onItemClickListener;

    public AutoVerticalViewView(Context context) {
        super(context);
        this.init(context, (AttributeSet) null, 0);
    }

    public AutoVerticalViewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init(context, attrs, 0);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.mContext = context;
        this.setFlipInterval(this.interval);
        Animation animIn = AnimationUtils.loadAnimation(this.mContext, R.anim.anim_marquee_in);
        if (this.isSetAnimDuration) {
            animIn.setDuration((long) this.animDuration);
        }

        this.setInAnimation(animIn);
        Animation animOut = AnimationUtils.loadAnimation(this.mContext, R.anim.anim_marquee_out);
        if (this.isSetAnimDuration) {
            animOut.setDuration((long) this.animDuration);
        }

        this.setOutAnimation(animOut);
    }

    public void setViews(List<AutoVerticalViewDataData> datas) {
        if (datas != null && datas.size() != 0) {
            this.removeAllViews();
            int size = datas.size();

            for (int i = 0; i < size; i += 2) {
                final int j = i;
                LinearLayout item = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.item_auto_vitercal_view, (ViewGroup) null);
                item.findViewById(R.id.rl).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (AutoVerticalViewView.this.onItemClickListener != null) {
                            AutoVerticalViewView.this.onItemClickListener.onItemClick(j);
                        }

                    }
                });
                ((TextView) item.findViewById(R.id.tv1)).setText(((AutoVerticalViewDataData) datas.get(i)).getValue());
                ((TextView) item.findViewById(R.id.title_tv1)).setText(((AutoVerticalViewDataData) datas.get(i)).getTitle());
                if (i + 1 < size) {
                    item.findViewById(R.id.rl2).setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (AutoVerticalViewView.this.onItemClickListener != null) {
                                AutoVerticalViewView.this.onItemClickListener.onItemClick(j + 1);
                            }

                        }
                    });
                    ((TextView) item.findViewById(R.id.tv2)).setText(((AutoVerticalViewDataData) datas.get(i + 1)).getValue());
                    ((TextView) item.findViewById(R.id.title_tv2)).setText(((AutoVerticalViewDataData) datas.get(i + 1)).getTitle());
                } else {
                    item.findViewById(R.id.rl2).setVisibility(View.GONE);
                }

                this.addView(item);
            }

            this.startFlipping();
        }
    }

    public void setOnItemClickListener(AutoVerticalViewView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int var1);
    }
}

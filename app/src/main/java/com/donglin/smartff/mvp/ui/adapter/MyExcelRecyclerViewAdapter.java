package com.donglin.smartff.mvp.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.donglin.smartff.R;
import com.donglin.smartff.mvp.model.entity.AlarmInfo4OneDay;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/3/27 0027.
 */
public class MyExcelRecyclerViewAdapter extends RecyclerView.Adapter {
    protected Context mContext;
    protected List<AlarmInfo4OneDay> mLists;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public MyExcelRecyclerViewAdapter(Context context) {
        this.mContext = context;
        //this.mLists = list;
    }

    public void setmLists(@NonNull List list) {
        this.mLists = list;
        notifyDataSetChanged();
    }

    public void removeData(int position) {
        mLists.remove(position);
        notifyDataSetChanged();
        // notifyItemRemoved(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_home_org, parent, false);
        return new DebounceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final DebounceViewHolder debounceViewHolder = (DebounceViewHolder) holder;
        debounceViewHolder.itemHomeOrgName.setText(mLists.get(position).getOrgName());
        debounceViewHolder.itemHomeOrgColor.setBackgroundColor(Color.parseColor(mLists.get(position).getOrgColor()));
        if (mOnItemClickListener != null) {
            debounceViewHolder.itemHomeOrgColor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = debounceViewHolder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(debounceViewHolder.itemView, position); // 2
                }
            });
        }

        if (mOnItemLongClickListener != null) {
            debounceViewHolder.itemHomeOrgColor.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = debounceViewHolder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(debounceViewHolder.itemView, position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (mLists == null) {
            return 0;
        }
        return mLists.size();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    static class DebounceViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.home_org_color)
        View itemHomeOrgColor;
        @BindView(R.id.home_org_name)
        TextView itemHomeOrgName;

        public DebounceViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}


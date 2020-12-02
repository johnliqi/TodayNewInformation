package com.candymobi.todaynewinformation.main.Shanghai.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.candymobi.todaynewinformation.R;
import com.candymobi.todaynewinformation.main.Shanghai.dao.ShanghaiBean;
import com.candymobi.todaynewinformation.main.Shanghai.view.ShangHaiDetailActivity;

import java.util.ArrayList;
;

public class ShangHaiAdapter extends RecyclerView.Adapter {
    private final Activity mContext;
    private final boolean mIsHor;
    private ArrayList<ShanghaiBean> mDatas;
    private RecyclerView.RecycledViewPool recycledViewPool;
    public ShangHaiAdapter(Activity context, ArrayList<ShanghaiBean> mData, boolean isHor) {
        recycledViewPool = new RecyclerView.RecycledViewPool();
        mDatas = mData;
        mContext = context;
        mIsHor = isHor;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {

        if (viewtype == ShanghaiBean.IShangHaiItemType.VERTICAL) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shanghai_fragment, parent, false);
            ShanghaiViewHolder viewHolder = new ShanghaiViewHolder(inflate);
            return viewHolder;
        } else if (viewtype == ShanghaiBean.IShangHaiItemType.HORIZONTAL) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_shanghai_rv, null);
            ShanghaiViewHolderRv viewHolder = new ShanghaiViewHolderRv(inflate);

            return viewHolder;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        ShanghaiBean bean = mDatas.get(position);
        Log.e("onCreateViewHolder", "" + bean.getmDec() + "isdesc" + bean.isShowImg());
        if (viewHolder instanceof ShanghaiViewHolder) {
            ((ShanghaiViewHolder) viewHolder).mTv.setText(bean.getmDec());
            ((ShanghaiViewHolder) viewHolder).mIv.setVisibility(bean.isShowImg() ? View.VISIBLE : View.GONE);
            ((ShanghaiViewHolder) viewHolder).itemView.setTag(position);
        } else if (viewHolder instanceof ShanghaiViewHolderRv) {

            ((ShanghaiViewHolderRv) viewHolder).mRecyclerView.setAdapter(new ShangHaiAdapter(mContext, bean.getData(), true));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mDatas.get(position).getmItemType();
    }

    public class ShanghaiViewHolder extends RecyclerView.ViewHolder {
        public TextView mTv;
        public ImageView mIv;

        public ShanghaiViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv = itemView.findViewById(R.id.item_shanghai_tv);
            mIv = itemView.findViewById(R.id.item_shanghai_iv);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int tag = (int) v.getTag();
                    ShangHaiDetailActivity.start_5_0(mContext,mIv);
                }
            });
        }


    }

    public class ShanghaiViewHolderRv extends RecyclerView.ViewHolder {

        RecyclerView mRecyclerView;

        public ShanghaiViewHolderRv(@NonNull View itemView) {
            super(itemView);
            mRecyclerView = itemView.findViewById(R.id.item_shanghai_rv);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
           layoutManager.setRecycleChildrenOnDetach(true);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setRecycledViewPool(recycledViewPool);
        }
    }
}
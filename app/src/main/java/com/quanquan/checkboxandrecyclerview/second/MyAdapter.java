package com.quanquan.checkboxandrecyclerview.second;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quanquan.checkboxandrecyclerview.R;

import java.util.ArrayList;

/**
 * @DateTime: 2016-07-26 14:31
 * @Author: duke
 * @Deacription:
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.VH> {
    private Context mContext;
    private ArrayList<UserBean> mLists = new ArrayList<>();
    private OnDKClickListener listener;

    //记录上次的位置和容器
    private LinearLayout oldContainer;
    private int oldPosition;

    public void setOnDKClickListener(OnDKClickListener listener) {
        this.listener = listener;
    }

    public MyAdapter(Context context, ArrayList<UserBean> list) {
        this.mContext = context;
        setList(list);
    }

    /**
     * 刷新数据，并更新界面
     *
     * @param list
     */
    public void updateList(ArrayList<UserBean> list) {
        setList(list);
        notifyDataSetChanged();
    }

    private void setList(ArrayList<UserBean> list) {
        if (list == null || list.size() <= 0) {
            this.mLists.clear();
        } else {
            this.mLists = list;
        }
    }

    @Override
    public int getItemCount() {
        return this.mLists.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        VH vh = new VH(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(VH holder, final int position) {
        //强制关闭复用
        //holder.setIsRecyclable(false);
        final UserBean user = this.mLists.get(position);
        holder.word.setText(user.userName);
        if (user.isSelected) {
            //选中的样式
            holder.container.setBackgroundResource(R.drawable.item_bg_press);
        } else {
            //未选中的样式
            holder.container.setBackgroundResource(R.drawable.item_bg);
        }
        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onDKClick(view, mLists.get(position), position);
                //复原old位置
                if (oldContainer != null) {
                    oldContainer.setBackgroundResource(R.drawable.item_bg);
                    if (oldPosition >= 0 && oldPosition < MyAdapter.this.mLists.size())
                        MyAdapter.this.mLists.get(oldPosition).isSelected = false;
                }
                //设置新的位置样式
                oldContainer = (LinearLayout) view;
                oldPosition = position;

                oldContainer.setBackgroundResource(R.drawable.item_bg_press);
                MyAdapter.this.mLists.get(oldPosition).isSelected = true;
            }
        });
    }

    public static class VH extends RecyclerView.ViewHolder {
        private LinearLayout container;
        private TextView word;

        public VH(View root) {
            super(root);
            container = (LinearLayout) root.findViewById(R.id.container);
            word = (TextView) root.findViewById(R.id.word);
        }
    }

    public interface OnDKClickListener {
        void onDKClick(View view, UserBean user, int position);
    }
}

package com.yiwo.fuzhoudian.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yiwo.fuzhoudian.R;

import java.util.List;

/**
 * Created by ljc on 2020/3/25.
 */

public class HomeGuanZhuDianPuShangPinAdapter extends RecyclerView.Adapter<HomeGuanZhuDianPuShangPinAdapter.ViewHolder>{
    private Context context;
    private List<String> data;
//    private SpImp spImp;
    public HomeGuanZhuDianPuShangPinAdapter(List<String> data){
        this.data = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();
//        spImp = new SpImp(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_home_guanzhu_dianpu_shangpin_item, parent, false);
        HomeGuanZhuDianPuShangPinAdapter.ViewHolder holder = new HomeGuanZhuDianPuShangPinAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return data !=null ? data.size(): 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_head;
        TextView tv_shop_name,tv_level,tv_shop_tel,tv_address,tv_juli;
        ImageView iv_level;
        RecyclerView rv;
        public ViewHolder(View itemView) {
            super(itemView);

            tv_shop_name = itemView.findViewById(R.id.tv_shop_name);
            tv_level = itemView.findViewById(R.id.tv_level);
            iv_head = itemView.findViewById(R.id.iv_head);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_shop_tel = itemView.findViewById(R.id.tv_shop_tel);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_juli = itemView.findViewById(R.id.tv_juli);
            iv_level = itemView.findViewById(R.id.iv_level);
            rv = itemView.findViewById(R.id.rv);
        }
    }
}

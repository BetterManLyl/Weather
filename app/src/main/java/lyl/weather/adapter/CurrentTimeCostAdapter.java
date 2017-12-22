package lyl.weather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lyl.weather.R;
import lyl.weather.model.CurrentCostDatas;

/**
 * Created by lyl on 2017/5/23.
 * <p>
 * 实时费用适配器
 */

public class CurrentTimeCostAdapter extends RecyclerView.Adapter<CurrentTimeCostAdapter.MyViewHolder> {
    private List<CurrentCostDatas.DataBean> currentCostDatases;
    private Context context;
    // 存储勾选框状态的map集合
    private Map<Integer, Boolean> map = new HashMap<>();

    public CurrentTimeCostAdapter(Context context, List<CurrentCostDatas.DataBean> currentCostDatases) {
        this.currentCostDatases = currentCostDatases;
        this.context = context;
        initMap();
    }

    //初始化map集合,默认为不选中
    public void initMap() {
        //每次进来先清空map集合
        map.clear();
        for (int i = 0; i < currentCostDatases.size(); i++) {
            map.put(i, false);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_current_cost, parent, false);
        MyViewHolder viewHolder = new CurrentTimeCostAdapter.MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_message.setVisibility(View.GONE);
        holder.tv_current_money_num.setText(currentCostDatases.get(position).getDeductionAmount());
        holder.tv_current_flow.setText(currentCostDatases.get(position).getUseFlow());

        if (currentCostDatases.get(position).getName().length() > 10) {
            holder.tv_title.setText(currentCostDatases.get(position).getName().substring(0, 10) + "...");
        } else {
            holder.tv_title.setText(currentCostDatases.get(position).getName());
        }
        holder.tv_left_money.setText(currentCostDatases.get(position).getActualBalance() + "");
        holder.tv_current_month_flow.setText(currentCostDatases.get(position).getHouseNum());
        holder.tv_left_money_states.setText(currentCostDatases.get(position).getBalanceStatus());
        holder.tv_message.setText(currentCostDatases.get(position).getAlermInfo());

        if (!TextUtils.isEmpty(currentCostDatases.get(position).getAlermInfo())) {
            holder.img_message.setVisibility(View.VISIBLE);
        } else {
            holder.img_message.setVisibility(View.GONE);
        }

        if (map.get(position) == null) {
            map.put(position, false);
        }
        if (!map.get(position)) {
            holder.tv_message.setVisibility(View.GONE);
        } else {
            holder.tv_message.setVisibility(View.VISIBLE);
        }

        //消息图标点击事件
        holder.ll_image_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.tv_message.getVisibility() == View.VISIBLE) {
                    holder.tv_message.setVisibility(View.GONE);
                } else {
                    initMap();
                    //显示的时候 给集合put true
                    map.put(position, true);
                    notifyDataSetChanged();
                }
            }
        });

        holder.ll_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initMap();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return currentCostDatases.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_current_money_num;//当次金额
        private TextView tv_current_flow;//当次流量
        private TextView tv_title;//商户名
        private TextView tv_left_money;//余额
        private TextView tv_current_month_flow;//当次金额
        private TextView tv_left_money_states;//余额状态
        private ImageView img_message;
        private TextView tv_message;
        private LinearLayout ll_content;
        private LinearLayout ll_image_icon;


        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_current_money_num = (TextView) itemView.findViewById(R.id.tv_current_money_num);
            tv_current_flow = (TextView) itemView.findViewById(R.id.tv_current_flow_num);
            tv_left_money = (TextView) itemView.findViewById(R.id.tv_left_money);
            tv_current_month_flow = (TextView) itemView.findViewById(R.id.tv_current_month_flow);
            tv_left_money_states = (TextView) itemView.findViewById(R.id.tv_left_money_states);
            img_message = (ImageView) itemView.findViewById(R.id.img_message);
            tv_message = (TextView) itemView.findViewById(R.id.tv_image_message);
            ll_content = (LinearLayout) itemView.findViewById(R.id.content);
            ll_image_icon = (LinearLayout) itemView.findViewById(R.id.ll_img_message);
        }
    }

}

package lyl.weather.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import lyl.weather.R;
import lyl.weather.event.SearchEvent;
import lyl.weather.model.Customers;

/**
 * Created by lyl on 2017/5/23.
 * <p>
 * 选择商户适配器
 */

public class ChooseMerchantsAdapter extends BaseQuickAdapter<Customers.DataBean, BaseViewHolder> {

    private Context context;
    public ChooseMerchantsAdapter(List<Customers.DataBean> dataBeen, Context context) {
        super(R.layout.item_choose_commercial, dataBeen);
        this.context=context;
    }

    @Override
    protected void convert(final BaseViewHolder holder, final Customers.DataBean list) {
        holder.setText(R.id.tv_name, list.getName());
        holder.setText(R.id.tv_left_money, list.getActualBalance());
        if (list.getActualBalance().contains("-")) {
            holder.setText(R.id.tv_left_money, list.getActualBalance());
            holder.setTextColor(R.id.tv_left_money, Color.parseColor("#f76262"));
        } else {
            holder.setTextColor(R.id.tv_left_money, Color.parseColor("#12db62"));
            if (list.getActualBalance().equals("0.00")) {
                holder.setText(R.id.tv_left_money, list.getActualBalance());
            } else {
                holder.setText(R.id.tv_left_money, "+" + list.getActualBalance());
            }
        }
        holder.addOnClickListener(R.id.ll_content);
        holder.getView(R.id.ll_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new SearchEvent(list.getName(),
                        list.getActualBalance(), list.getUniqueId()));
                if (context!=null){
                    Activity activity= (Activity) context;
                    activity.finish();
                }
                holder.setImageResource(R.id.img_select, R.drawable.item_commercial_selected);
            }
        });
    }
}

package com.example.android.amaliayovadiani_1202154301_studycase5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 25/03/2018.
 */

public class adapter extends RecyclerView.Adapter<adapter.holder> {
    private Context mcontex;
    private List<dataKegiatan> list;
    int color;

    public adapter(Context cntx, List<dataKegiatan> list, int color){
        this.mcontex=cntx;
        this.list=list;
        this.color=color;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) { //menentukan viewholder untuk recycler view
        View view = LayoutInflater.from(mcontex).inflate(R.layout.cardview, parent, false);
        holder hldr = new holder(view);
        return hldr;
    }

    @Override
    public void onBindViewHolder(holder holder, int position) {
        dataKegiatan data = list.get(position);
        holder.ToDo.setText(data.getTodo());
        holder.Desc.setText(data.getDesc());
        holder.Priority.setText(data.getPrior());
        holder.card_view.setCardBackgroundColor(mcontex.getResources().getColor(this.color));
    }

    @Override
    public int getItemCount() { //mendapatkan jumlah list
        return list.size();
    }

    public dataKegiatan getData(int position){ //mendapatkan list dari adapter
        return list.get(position);
    }

    public void deleteData(int i){ //menghapus list
        list.remove(i); //hapus item yang terpilih
        notifyItemRemoved(i); //notifikasi
        notifyItemRangeChanged(i, list.size());
    }

    class holder extends RecyclerView.ViewHolder{
        public TextView ToDo, Desc, Priority;
        public CardView card_view;
        public holder(View itemView){
            super(itemView);

            //view dan cardview pada layout
            ToDo = itemView.findViewById(R.id.todo);
            Desc = itemView.findViewById(R.id.description);
            Priority = itemView.findViewById(R.id.number);
            card_view = itemView.findViewById(R.id.cardview);
        }
    }
}



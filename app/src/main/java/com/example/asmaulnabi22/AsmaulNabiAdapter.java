package com.example.asmaulnabi22;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class AsmaulNabiAdapter extends
        RecyclerView.Adapter<AsmaulNabiAdapter.AsmaulNabiViewHolder> {
    public interface ItemClickListener {
        void onClick(View view, int position);
    }
    int gambar[] = {R.drawable.an1, R.drawable.kitab,
            R.drawable.an3,
            R.drawable.an4,
            R.drawable.an5,R.drawable.an6,R.drawable.an7,R.drawable.an8,

            R.drawable.an9,R.drawable.an10,R.drawable.an11} ;
    private ArrayList<AsmaulNabi> dataList;
    public AsmaulNabiAdapter(ArrayList<AsmaulNabi>
                                     dataList) {
        this.dataList = dataList;
    }
    private ItemClickListener clickListener;
    @Override
    public AsmaulNabiViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());
        View view =
                layoutInflater.inflate(R.layout.list_item, parent, false);
        return new AsmaulNabiViewHolder(view);
    }
    @Override
    public void onBindViewHolder(AsmaulNabiViewHolder
                                         holder, int position) {

        holder.txtNama.setText(dataList.get(position).getNama());
        holder.icon.setImageResource(gambar[position]);
    }
    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }
    public void setClickListener(ItemClickListener
                                         clickListener) {
        this.clickListener = clickListener;
    }
    public class AsmaulNabiViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtNama;
        private ImageView icon;
        public AsmaulNabiViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView)
                    itemView.findViewById(R.id.txt_nama);
            icon=(ImageView)
                    itemView.findViewById(R.id.img_card);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            txtNama.setOnClickListener(this);
            icon.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            if(clickListener != null)
                clickListener.onClick(view,
                        getAdapterPosition());
        }
    }
}

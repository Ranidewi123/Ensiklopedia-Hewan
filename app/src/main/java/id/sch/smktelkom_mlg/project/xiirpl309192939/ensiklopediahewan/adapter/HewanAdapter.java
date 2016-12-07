package id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.R;
import id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.model.Hewan;

/**
 * Created by Rani's on 11/26/2016.
 */

public class HewanAdapter extends RecyclerView.Adapter<HewanAdapter.ViewHolder> {
    ArrayList<Hewan> hewanList;
    IHewanAdapter mIHewanAdapter;

    public HewanAdapter(Context context, ArrayList<Hewan> hewanList) {
        this.hewanList = hewanList;
        mIHewanAdapter = (IHewanAdapter) context;
    }

    @Override
    public HewanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(HewanAdapter.ViewHolder holder, int position) {
        Hewan hewan = hewanList.get(position);
        holder.tvJudul.setText(hewan.judul);
        holder.ivFoto.setImageURI(Uri.parse(hewan.foto));
    }

    @Override
    public int getItemCount() {
        if (hewanList != null)
            return hewanList.size();
        return 0;
    }

    public interface IHewanAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHewanAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}

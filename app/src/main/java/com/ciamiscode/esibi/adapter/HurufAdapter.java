package com.ciamiscode.esibi.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ciamiscode.esibi.R;
import com.ciamiscode.esibi.model.GambarModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class HurufAdapter extends RecyclerView.Adapter<HurufAdapter.GridViewHolder> {

    Context ctx;
    List<GambarModel> mList;

    public HurufAdapter(Context ctx, List<GambarModel> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public HurufAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_huruf,parent, false);
        GridViewHolder holder = new GridViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HurufAdapter.GridViewHolder holder, int position) {
        final GambarModel gm = mList.get(position);
        String img_url = "http://esibi.ergnologi.com/asset/huruf/"+gm.getGambar();
        Glide.with(holder.itemView.getContext())
                .load(img_url)
                .into(holder.imgHuruf);
        holder.txtHuruf.setText(gm.getNama());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView imgHuruf;
        TextView txtHuruf;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            imgHuruf = itemView.findViewById(R.id.imgHuruf);
            txtHuruf = itemView.findViewById(R.id.txtHuruf);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    @SuppressLint("InflateParams") View modelBottomSheet = LayoutInflater.from(ctx).inflate(R.layout.dialog_huruf, null);

                    TextView dialogNama = modelBottomSheet.findViewById(R.id.dialog_text_huruf);
                    ImageView dialogFoto = modelBottomSheet.findViewById(R.id.dialog_foto_huruf);

                    dialogNama.setText(mList.get(getAdapterPosition()).getNama());

                    String img_url = "http://esibi.ergnologi.com/asset/huruf/"+mList.get(getAdapterPosition()).getGambar();
                    Glide.with(ctx)
                            .load(img_url)
                            .into(dialogFoto);

                    BottomSheetDialog dialog = new BottomSheetDialog(ctx, R.style.AppBottomSheetDialogTheme);
                    dialog.setContentView(modelBottomSheet);
                    dialog.show();

                }
            });

        }
    }
}

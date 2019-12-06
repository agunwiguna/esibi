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

public class AngkaAdapter extends RecyclerView.Adapter<AngkaAdapter.GridViewHolder> {

    Context ctx;
    List<GambarModel> mList;

    public AngkaAdapter(Context ctx, List<GambarModel> mList) {
        this.ctx = ctx;
        this.mList = mList;
    }

    @NonNull
    @Override
    public AngkaAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_angka,parent, false);
        GridViewHolder holder = new GridViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AngkaAdapter.GridViewHolder holder, int position) {
        final GambarModel gm = mList.get(position);
        String img_url = "http://esibi.ergnologi.com/asset/angka/"+gm.getGambar();
        Glide.with(holder.itemView.getContext())
                .load(img_url)
                .into(holder.imgAngka);
        holder.txtAngka.setText(gm.getNama());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        ImageView imgAngka;
        TextView txtAngka;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAngka = itemView.findViewById(R.id.imgAngka);
            txtAngka = itemView.findViewById(R.id.txtAngka);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    @SuppressLint("InflateParams") View modelBottomSheet = LayoutInflater.from(ctx).inflate(R.layout.dialog_angka, null);

                    TextView dialogNama = modelBottomSheet.findViewById(R.id.dialog_text_angka);
                    ImageView dialogFoto = modelBottomSheet.findViewById(R.id.dialog_foto_angka);

                    dialogNama.setText(mList.get(getAdapterPosition()).getNama());

                    String img_url = "http://esibi.ergnologi.com/asset/angka/"+mList.get(getAdapterPosition()).getGambar();
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

package com.ciamiscode.esibi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ciamiscode.esibi.adapter.HurufAdapter;
import com.ciamiscode.esibi.api.ApiEndpoint;
import com.ciamiscode.esibi.api.ApiService;
import com.ciamiscode.esibi.model.GambarModel;
import com.ciamiscode.esibi.model.ResponseModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabHuruf extends Fragment {

    private HurufAdapter viewAdapter;
    private List<GambarModel> mItems = new ArrayList<>();
    RecyclerView recyclerView;
    //ProgressBar progressBar;

    //declare the layout
    private ShimmerFrameLayout shimmer_view_container;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tabmenu_huruf,null);

        recyclerView = view.findViewById(R.id.recyclerHuruf);
        //progressBar = view.findViewById(R.id.progress_bar);

        shimmer_view_container = view.findViewById(R.id.shimmer_view_container);

        viewAdapter = new HurufAdapter(getContext(), mItems);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);

        loadDataHuruf();

        return view;
    }

    private void loadDataHuruf() {

        ApiService api = ApiEndpoint.getClient().create(ApiService.class);
        Call<ResponseModel> call = api.getHuruf();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String statusCode = response.body().getStatusCode();
                //progressBar.setVisibility(View.GONE);
                shimmer_view_container.stopShimmer();
                shimmer_view_container.setVisibility(View.GONE);

                if (statusCode.equals("200")) {
                    mItems = response.body().getResult_huruf();
                    viewAdapter = new HurufAdapter(getContext(), mItems);
                    recyclerView.setAdapter(viewAdapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                Toast.makeText(getContext(), "Oops, Tidak Ada Koneksi Internet!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}

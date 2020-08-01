package com.example.themarvelplace.comic;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themarvelplace.GetDataService;
import com.example.themarvelplace.R;
import com.example.themarvelplace.RetrofitInstance;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComicsFragment extends Fragment {

    RecyclerView recyclerView;
    ComicsAdapter comicsAdapter;
    LinearLayoutManager linearLayoutManager;
    boolean sizeNotChanged;
    int itemCount;

    Long tsLong;
    String ts;
    String apikey;
    String md5_hash;
    GetDataService service;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comics_fragment, container, false);

        service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        tsLong = System.currentTimeMillis()/1000;
        ts = tsLong.toString();
        apikey = "85ed30f839ab5f8acd5fca97a234c23e";
        md5_hash = ts+"4e544d67be08f24f195b797b34d3fcc1befd445a"+apikey;
        md5_hash = getMd5Hash(md5_hash);

        Call<ComicsList> call = service.getComicData(ts, apikey, md5_hash);
        call.enqueue(new Callback<ComicsList>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onResponse(Call<ComicsList> call, Response<ComicsList> response) {
                try {
                    generateComicsList(response.body(), container);
                }
                catch (Exception e) {
                    Log.e("Response error: ", e.toString());
                }
            }

            @Override
            public void onFailure(Call<ComicsList> call, Throwable t) {
                Log.i("URL call error:", "Something went wrong!");
                Log.i("URL call error:", t.toString());
            }
        });

        return view;
    }

    public static String getMd5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String md5 = number.toString(16);
            while (md5.length() < 32)
                md5 = "0" + md5;
            return md5;
        } catch (NoSuchAlgorithmException e) {
            Log.e("MD5", e.getLocalizedMessage());
            return null;
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void generateComicsList(ComicsList comicsList, @Nullable final ViewGroup container) {
        recyclerView = container.findViewById(R.id.comics_recview);
        linearLayoutManager = new LinearLayoutManager(container.getContext());
        comicsAdapter = new ComicsAdapter(comicsList, container.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(comicsAdapter);
        recyclerView.setHasFixedSize(true);
        addToComicsList();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void addToComicsList() {
        itemCount = 1;
        sizeNotChanged = true;
        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                final int counter = comicsAdapter.getItemCount()/20;
                linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
                Log.i("Last item: ", "" + linearLayoutManager.findLastVisibleItemPosition());
                if(counter!=itemCount) {
                    sizeNotChanged = true;
                    itemCount = counter;
                }
                if(linearLayoutManager.findLastVisibleItemPosition()==comicsAdapter.getItemCount()-1 && sizeNotChanged) {
                    sizeNotChanged = false;
                    Call<ComicsList> call = service.getComicData2(ts, apikey, md5_hash, comicsAdapter.getItemCount());
                    Log.wtf("URL Called", call.request().url() + "");
                    call.enqueue(new Callback<ComicsList>() {
                        @Override
                        public void onResponse(Call<ComicsList> call, Response<ComicsList> response) {
                            try {
                                comicsAdapter.addToList(response.body().getComicsData().getComics());
                                //comicsAdapter.notifyDataSetChanged();
                                comicsAdapter.notifyItemInserted(comicsAdapter.getItemCount()-1);
                                Log.i("New List Size: ", String.valueOf(comicsAdapter.getItemCount()));
                            } catch (Exception e) {
                                Log.e("Response error: ", e.toString());
                            }
                        }
                        @Override
                        public void onFailure(Call<ComicsList> call, Throwable t) {
                            Log.i("URL call error:", "Something went wrong!");
                            Log.i("URL call error:", t.toString());
                        }
                    });
                }
            }
        });
    }
}

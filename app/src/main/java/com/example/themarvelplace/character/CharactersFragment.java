package com.example.themarvelplace.character;

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

public class CharactersFragment extends Fragment {

    RecyclerView recyclerView;
    CharactersAdapter charactersAdapter;
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
        View view = inflater.inflate(R.layout.characters_fragment, container, false);

        service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        tsLong = System.currentTimeMillis()/1000;
        ts = tsLong.toString();
        apikey = "85ed30f839ab5f8acd5fca97a234c23e";
        md5_hash = ts+"4e544d67be08f24f195b797b34d3fcc1befd445a"+apikey;
        md5_hash = getMd5Hash(md5_hash);


        Call<CharactersList> call = service.getCharacterData(ts, apikey, md5_hash);
        Log.wtf("URL Called", call.request().url() + "");
        call.enqueue(new Callback<CharactersList>() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onResponse(Call<CharactersList> call, Response<CharactersList> response) {
                try {
                    generateCharactersList(response.body(), container);
                }
                catch (Exception e) {
                    Log.e("Response error: ", e.toString());
                }
            }

            @Override
            public void onFailure(Call<CharactersList> call, Throwable t) {
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
    public void generateCharactersList(CharactersList charactersList, @Nullable final ViewGroup container) {
        recyclerView = container.findViewById(R.id.char_recview);
        linearLayoutManager = new LinearLayoutManager(container.getContext());
        charactersAdapter = new CharactersAdapter(charactersList, container.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(charactersAdapter);
        recyclerView.setHasFixedSize(true);
        addToCharactersList();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void addToCharactersList() {
        itemCount = 1;
        sizeNotChanged = true;
        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                final int counter = charactersAdapter.getItemCount()/20;
                linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
                Log.i("Last item: ", "" + linearLayoutManager.findLastVisibleItemPosition());
                if(counter!=itemCount) {
                    sizeNotChanged = true;
                    itemCount = counter;
                }
                if(linearLayoutManager.findLastVisibleItemPosition()==charactersAdapter.getItemCount()-1 && sizeNotChanged) {
                    sizeNotChanged = false;
                    Call<CharactersList> call = service.getCharacterData2(ts, apikey, md5_hash, charactersAdapter.getItemCount());
                    Log.wtf("URL Called", call.request().url() + "");
                    call.enqueue(new Callback<CharactersList>() {
                        @Override
                        public void onResponse(Call<CharactersList> call, Response<CharactersList> response) {
                            try {
                                charactersAdapter.addToList(response.body().getCharactersData().getCharacters());
                                charactersAdapter.notifyItemInserted(charactersAdapter.getItemCount()-1);
                                Log.i("New List Size: ", String.valueOf(charactersAdapter.getItemCount()));
                                //charactersAdapter.notifyDataSetChanged();
                            } catch (Exception e) {
                                Log.e("Response error: ", e.toString());
                            }
                        }

                        @Override
                        public void onFailure(Call<CharactersList> call, Throwable t) {
                            Log.i("URL call error:", "Something went wrong!");
                            Log.i("URL call error:", t.toString());
                        }
                    });
                }
            }
        });
    }
}

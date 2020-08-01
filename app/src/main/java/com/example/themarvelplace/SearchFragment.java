package com.example.themarvelplace;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.themarvelplace.character.CharactersAdapter;
import com.example.themarvelplace.character.CharactersList;
import com.example.themarvelplace.comic.ComicsAdapter;
import com.example.themarvelplace.comic.ComicsList;
import com.example.themarvelplace.creator.CreatorsAdapter;
import com.example.themarvelplace.creator.CreatorsList;
import com.example.themarvelplace.event.Event;
import com.example.themarvelplace.event.EventsAdapter;
import com.example.themarvelplace.event.EventsList;
import com.example.themarvelplace.series.SeriesAdapter;
import com.example.themarvelplace.series.SeriesList;
import com.google.android.material.button.MaterialButton;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFragment extends Fragment {

    EditText searchText;
    int tag;
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    MaterialButton submit;
    RecyclerView recyclerView;

    Long tsLong;
    String ts;
    String apikey;
    String md5_hash;
    GetDataService service;

    CharactersList charactersList;
    ComicsList comicsList;
    CreatorsList creatorsList;
    SeriesList seriesList;
    EventsList eventsList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_fragment, container, false);

        assert container != null;
        submit = container.findViewById(R.id.submit_button);
        Log.i("Submit button", submit.getText().toString());
        searchText = container.findViewById(R.id.search_text);

        tag = 0;
        assert container != null;
        radioGroup1 = container.findViewById(R.id.radio_group1);
        radioGroup2 = container.findViewById(R.id.radio_group2);

        service = RetrofitInstance.getRetrofitInstance().create(GetDataService.class);

        tsLong = System.currentTimeMillis()/1000;
        ts = tsLong.toString();
        apikey = "85ed30f839ab5f8acd5fca97a234c23e";
        md5_hash = ts+"4e544d67be08f24f195b797b34d3fcc1befd445a"+apikey;
        md5_hash = getMd5Hash(md5_hash);

        RadioButton button1 = container.findViewById(R.id.button_character);
        if(button1!=null)
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = 1;
                radioGroup2.clearCheck();
            }
        });

        RadioButton button2 = container.findViewById(R.id.button_comic);
        if(button2!=null)
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = 2;
                radioGroup2.clearCheck();
            }
        });

        RadioButton button3 = container.findViewById(R.id.button_series);
        if(button3!=null)
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = 3;
                radioGroup2.clearCheck();
            }
        });

        RadioButton button4 = container.findViewById(R.id.button_event);
        if(button4!=null)
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = 4;
                radioGroup1.clearCheck();
            }
        });

        RadioButton button5 = container.findViewById(R.id.button_creator);
        if(button5!=null)
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = 5;
                radioGroup1.clearCheck();
            }
        });

        if(submit!=null)
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Submit button", submit.getText().toString());
                recyclerView = container.findViewById(R.id.search_recycler_view);

                switch (tag) {
                    case 1:
                        Call<CharactersList> call1 = service.getCharacterData3(ts, apikey, md5_hash, searchText.getText().toString());
                        Log.wtf("URL Called", call1.request().url() + "");
                        call1.enqueue(new Callback<CharactersList>() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onResponse(Call<CharactersList> call, Response<CharactersList> response) {
                                try {
                                    charactersList = response.body();
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
                        CharactersAdapter charactersAdapter = new CharactersAdapter(charactersList, container.getContext());
                        recyclerView.setAdapter(charactersAdapter);
                        break;

                    case 2:
                        Call<ComicsList> call2 = service.getComicData3(ts, apikey, md5_hash,searchText.getText().toString());
                        Log.wtf("URL Called", call2.request().url() + "");
                        call2.enqueue(new Callback<ComicsList>() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onResponse(Call<ComicsList> call, Response<ComicsList> response) {
                                try {
                                    comicsList = response.body();
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
                        ComicsAdapter comicsAdapter = new ComicsAdapter(comicsList, container.getContext());
                        recyclerView.setAdapter(comicsAdapter);
                        break;

                    case 3:
                        Call<SeriesList> call3 = service.getSeriesData(ts, apikey, md5_hash, searchText.getText().toString());
                        Log.wtf("URL Called", call3.request().url() + "");
                        call3.enqueue(new Callback<SeriesList>() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onResponse(Call<SeriesList> call, Response<SeriesList> response) {
                                try {
                                    seriesList = response.body();
                                }
                                catch (Exception e) {
                                    Log.e("Response error: ", e.toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<SeriesList> call, Throwable t) {
                                Log.i("URL call error:", "Something went wrong!");
                                Log.i("URL call error:", t.toString());
                            }
                        });
                        SeriesAdapter seriesAdapter = new SeriesAdapter(seriesList, container.getContext());
                        recyclerView.setAdapter(seriesAdapter);
                        break;

                    case 4:
                        Call<EventsList> call4 = service.getEventData(ts, apikey, md5_hash,searchText.getText().toString());
                        Log.wtf("URL Called", call4.request().url() + "");
                        call4.enqueue(new Callback<EventsList>() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onResponse(Call<EventsList> call, Response<EventsList> response) {
                                try {
                                    eventsList = response.body();
                                }
                                catch (Exception e) {
                                    Log.e("Response error: ", e.toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<EventsList> call, Throwable t) {
                                Log.i("URL call error:", "Something went wrong!");
                                Log.i("URL call error:", t.toString());
                            }
                        });
                        EventsAdapter eventsAdapter = new EventsAdapter(eventsList, container.getContext());
                        recyclerView.setAdapter(eventsAdapter);
                        break;

                    case 5:
                        Call<CreatorsList> call5 = service.getCreatorData(ts, apikey, md5_hash, searchText.getText().toString());
                        Log.wtf("URL Called", call5.request().url() + "");
                        call5.enqueue(new Callback<CreatorsList>() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            @Override
                            public void onResponse(Call<CreatorsList> call, Response<CreatorsList> response) {
                                try {
                                    creatorsList = response.body();
                                }
                                catch (Exception e) {
                                    Log.e("Response error: ", e.toString());
                                }
                            }

                            @Override
                            public void onFailure(Call<CreatorsList> call, Throwable t) {
                                Log.i("URL call error:", "Something went wrong!");
                                Log.i("URL call error:", t.toString());
                            }
                        });
                        CreatorsAdapter creatorsAdapter = new CreatorsAdapter(creatorsList, container.getContext());
                        recyclerView.setAdapter(creatorsAdapter);
                        break;
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
                recyclerView.setHasFixedSize(true);
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

}

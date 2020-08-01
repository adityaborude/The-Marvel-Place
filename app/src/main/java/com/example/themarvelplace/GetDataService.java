package com.example.themarvelplace;

import com.example.themarvelplace.character.CharactersList;
import com.example.themarvelplace.comic.ComicsList;
import com.example.themarvelplace.creator.CreatorsList;
import com.example.themarvelplace.event.EventsList;
import com.example.themarvelplace.series.SeriesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetDataService
{
    @GET("/v1/public/characters")
    Call<CharactersList> getCharacterData(@Query("ts") String ts,
                                          @Query("apikey") String apikey,
                                          @Query("hash") String hash);

    @GET("/v1/public/characters")
    Call<CharactersList> getCharacterData2(@Query("ts") String ts,
                                          @Query("apikey") String apikey,
                                          @Query("hash") String hash,
                                           @Query("offset") int offset);
    @GET("/v1/public/characters")
    Call<CharactersList> getCharacterData3(@Query("ts") String ts,
                                          @Query("apikey") String apikey,
                                          @Query("hash") String hash,
                                           @Query("nameStartsWith") String name);

    @GET("/v1/public/comics")
    Call<ComicsList> getComicData(@Query("ts") String ts,
                                  @Query("apikey") String apikey,
                                  @Query("hash") String hash);

    @GET("/v1/public/comics")
    Call<ComicsList> getComicData2(@Query("ts") String ts,
                                   @Query("apikey") String apikey,
                                   @Query("hash") String hash,
                                   @Query("offset") int offset);

    @GET("/v1/public/comics")
    Call<ComicsList> getComicData3(@Query("ts") String ts,
                                   @Query("apikey") String apikey,
                                   @Query("hash") String hash,
                                   @Query("titleStartsWith") String title);

    @GET("/v1/public/creators")
    Call<CreatorsList> getCreatorData(@Query("ts") String ts,
                                      @Query("apikey") String apikey,
                                      @Query("hash") String hash,
                                      @Query("nameStartsWith") String name);

    @GET("/v1/public/series")
    Call<SeriesList> getSeriesData(@Query("ts") String ts,
                                   @Query("apikey") String apikey,
                                   @Query("hash") String hash,
                                   @Query("titleeStartsWith") String name);

    @GET("/v1/public/events")
    Call<EventsList> getEventData(@Query("ts") String ts,
                                  @Query("apikey") String apikey,
                                  @Query("hash") String hash,
                                  @Query("nameStartsWith") String name);

}

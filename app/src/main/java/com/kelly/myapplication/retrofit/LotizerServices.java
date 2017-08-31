package com.kelly.myapplication.retrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

/** Created by Paolo on 3/14/2016.*/

public interface LotizerServices {
    /**Login methods*/
    @POST(Urls.CREATE_USER)
    void createUser(@Header("Authorization") String authorization, @Body JsonObject request, Callback<JsonObject> lotizerCallback);

    @POST(Urls.AUTHENTICATE_USER)
    void authenticateUser(@Header("Authorization") String authorization, @Body JsonObject request, Callback<JsonObject> lotizerCallback);

    @POST(Urls.REFRESH_TOKEN)
    void refreshToken(@Header("Authorization") String authorization, @Body JsonObject request, Callback<JsonObject> lotizerCallback);

    @POST(Urls.USER_GALLERY)
    void userSolutionsGallery(@Header("Authorization") String authorization, @Body int userId, Callback<JsonArray> lotizerCallback);

    @POST(Urls.FULL_ALGORITHM_CALL)
    void fullAlgorithm(@Header("Authorization") String authorization, @Body JsonObject algorithmConfiguration, Callback<JsonObject> lotizerCallback);

    @POST(Urls.SOLUTION_CALL)
    void currentSolutionsCall(@Header("Authorization") String authorization, @Body JsonObject responseQueryView, Callback<JsonArray> lotizerCallback);

    @GET(Urls.SOLUTION_CALL_DETAIL)
    void currentSolutionsMap(@Header("Authorization") String authorization, @Query("solutionmapid") long solutionId, @Query("querymapid") long querymapid, Callback<JsonObject> lotizerCallback);

    @DELETE(Urls.SOLUTION_DELETE)
    void deleteSolution(@Header("Authorization") String authorization, @Query("solutionMapId") long solutionId, Callback<JsonObject> lotizerCallback);

    @GET(Urls.USER_FAVORITES)
    void userSolutionsFavorites(@Header("Authorization") String authorization, @Query("userId") long userId, LotizerCallback<JsonArray> lotizerCallback);

    @POST(Urls.SOLUTION_IS_FAVORITE)
    void isFavoriteSolution(@Header("Authorization") String authorization, @Body JsonObject solutionIsFavorite, Callback<JsonObject> lotizerCallback);

    @POST(Urls.UPDATE_URL)
    void updateSolutionMapImageLocation(@Header("Authorization") String authorization, @Body JsonObject request, LotizerCallback<JsonObject> lotizerCallback);
}
package com.kelly.myapplication.retrofit;

/** Created by Paolo on 3/14/2016*/
interface Urls {
    String CREATE_USER = "/user/create";
    String AUTHENTICATE_USER = "/user/authenticate";
    String REFRESH_TOKEN = "/user/refreshToken";

    String USER_GALLERY = "/user/gallery";
    String USER_FAVORITES = "/user/favorites";
    String SOLUTION_CALL = "/user/currentSolutions";
    String SOLUTION_CALL_DETAIL = "/user/currentSolutionMap";
    String SOLUTION_IS_FAVORITE = "/user/solution/favorite";
    String SOLUTION_DELETE = "/user/deleteSolution";
    String FULL_ALGORITHM_CALL = "/fullAlgorithm";
    String UPDATE_URL = "/user/solutionMap/mapUrl";

    /*Tester strings do not remove*/
    //String ALGORITHM_CONFIGURABLE_TEST = "/clusterAlgorithm/configurable";


}
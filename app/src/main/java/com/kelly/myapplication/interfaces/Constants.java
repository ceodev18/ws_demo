package com.kelly.myapplication.interfaces;

/** Created by paolo on 2/13/17.*/
public interface Constants {
    //for direction
    int WEST = 0;
    int SOUTH = 1;
    int EAST = 2;
    int NORTH = 3;

    String BUNDLE_X_DISTANCE = "bundle_x_distance";
    String BUNDLE_Y_DISTANCE = "bundle_y_distance";
    String BUNDLE_COORDINATES = "bundle_coordinates_vertices";
    String BUNDLE_ENTRY = "bundle_coordinates_entry";
    String BUNDLE_LIMITS = "bundle_coordinates_limits";
    String RESULT_TYPE = "result_type";
    String FROM_MAIN = "bundle_from_notification";
    String BUNDLE_XSIZE = "bundle_xSize";
    String BUNDLE_YSIZE = "bundle_ySize";
    String BUNDLE_RESULT_STRING = "bundle_ResultString";
    String BUNDLE_ROUTES = "bundle_routes";

    String BUNDLE_ENTRY_COORDS = "bundle_entry_coords";
    String  BUNDLE_VERTEX_COORDS = "bundle_vertex_coords";
    String BUNDLE_ORIGIN_COORDS = "bundle_origin_coords";
    String BUNDLE_MAP_SIZE_X = "bundle_map_size_x";
    String BUNDLE_MAP_SIZE_Y = "bundle_map_size_x";
    String BUNDLE_MAP_SIZE_LOT_SIDE_SIZE = "bundle_map_size_lot_side_size";
    String BUNDLE_MAP_SIZE_LOT_DEPTH_SIZE = "bundle_map_size_lot_depth_size";
    String BUNDLE_SOLUTION_TYPE = "bundle_solution_type";
    String BUNDLE_VERTEX_COORDINATES_PIXEL = "bundle_coordinates_vertices_pixel";
    String BUNDLE_ENTRANCE_COORDINATES_PIXEL = "bundle_coordinates_entrance_pixel";
    String BUNDLE_LOT_CONFIGURATION = "bundle_lot_configuration";
    String BUNDLE_CONFIGURATION_ID = "bundle_configuration_id";
    String BUNDLE_BEARING = "bundle_bearing";
    String BUNDLE_IMAGE_LOCATION = "bundle_image_location";
    String BUNDLE_FIRST_USE = "bundle_first_use";

    int MATRIX = 1;
    int RADIAL = 2;
    int CLUSTER = 3;
    int SPINE = 4;

    String MATRIX_NAME = "matrix";
    String RADIAL_NAME = "radial";
    String CLUSTER_NAME = "cluster";
    String SPINE_NAME = "spine";

    int ON_WAIT = 1;
    int TO_CHOOSE = 2;
    int CHOOSEN = 3;

    int REQUEST_SERVER_ERROR_CODE = 514;
    int REQUEST_NETWORK_CONNECTION_ERROR_CODE = 513;
    int REQUEST_RETROFIT_ERROR_CODE = 512;
    int REQUEST_LANGUAGE_CHANGE = 522;
    int MAX_MARKERS = 10;
}
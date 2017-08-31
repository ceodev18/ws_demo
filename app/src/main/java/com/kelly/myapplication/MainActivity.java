package com.kelly.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.kelly.myapplication.retrofit.LotizerCallback;
import com.kelly.myapplication.retrofit.RestClient;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import retrofit.client.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit.RetrofitError;

public class MainActivity extends AppCompatActivity {
    private Button b_signup;
    private EditText et_password;
    private EditText et_name;
    private EditText et_email;
    private Activity self;
    private ImageView iv_toolbar_back;
    private String newUserLocation = null;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       setElements();
        setActions();



    }
    private void setElements() {
        self = this;
        b_signup = (Button) findViewById(R.id.b_signup);
        et_password = (EditText) findViewById(R.id.et_password);
        et_name = (EditText) findViewById(R.id.et_name);
        et_email = (EditText) findViewById(R.id.et_email);


    }
    private void setActions() {
        b_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                final String password = et_password.getText().toString();
                final String email = et_email.getText().toString();


                final RestClient restClient = new RestClient(self);




                restClient.getWebservices().createUser("",toJson(), new LotizerCallback<JsonObject>(self) {
                    @Override
                    public void success(JsonObject jsonObject, Response response) {
                        super.success(jsonObject, response);
                        if (jsonObject == null) {
                            //Toast.makeText(self, R.string.s_username_already_taken_choose_different_username, Toast.LENGTH_SHORT).show();
                            //progressDialog.dismiss();
                            Toast.makeText(self, "usado", Toast.LENGTH_SHORT).show();
                        } else {
                            //progressDialog.dismiss();
                            //jsonObject.addProperty("username","usuario");
                            //jsonObject.addProperty("password", lotUser.getPassword());
                            //jsonObject.addProperty("fcmToken", FirebaseInstanceId.getInstance().getToken());


                            restClient.getWebservices().authenticateUser("", jsonObject, new LotizerCallback<JsonObject>(self) {
                                @Override
                                public void success(JsonObject jsonObject, Response response) {
                                    super.success(jsonObject, response);
                                    if (jsonObject != null) {
                                        login(jsonObject);
                                    } else {
                                       // Toast.makeText(self, R.string.s_authentication_error_username_and_password, Toast.LENGTH_LONG).show();
                                    }
                                    //progressDialog.dismiss();
                                }

                                @Override
                                public void failure(RetrofitError error) {
                                    super.failure(error);
                                    //progressDialog.dismiss();
                                }
                            });

                        }
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        super.failure(error);
                        //progressDialog.dismiss();
                    }
                });
            }
        });


    }

    private void login(JsonObject jsonObject) {
        Gson gson = new Gson();
      //  SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.getInstance(self);
       // sharedPreferencesManager.saveUser(gson.toJson(jsonObject));

        Intent intent = new Intent(self, MainActivity.class);
       // intent.putExtra(Constants.BUNDLE_FIRST_USE, true);
        startActivity(intent);
        self.finish();
    }

    public JsonObject toJson(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username","usario");
        jsonObject.addProperty("password","clave");
        jsonObject.addProperty("deviceid","");
        jsonObject.addProperty("fcmToken","");
        jsonObject.addProperty("creationgeocoords", "");

        jsonObject.addProperty("creationdate", "");
        jsonObject.addProperty("lastlogin", "");
        jsonObject.addProperty("email", "");

        return jsonObject;
    }

}

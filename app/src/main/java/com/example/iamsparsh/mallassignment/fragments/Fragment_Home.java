package com.example.iamsparsh.mallassignment.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.iamsparsh.mallassignment.R;
import com.example.iamsparsh.mallassignment.models.Restaurant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by iamsparsh on 4/7/16.
 */
public class Fragment_Home extends Fragment {

    private List<Restaurant> restaurantsList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        getData();

        return view;
    }

    private void getData() {

        String url = "http://stage.phonethics.in/inorbitapp/api-1/place_api/search?place_id=1&category_id=2&page=1&count=-1";

        StringRequest stringRequest= new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {

                            String temp = response;
                            JSONObject jsonObject = new JSONObject(temp);
                            JSONArray jsonArray = jsonObject.getJSONArray("record");

                            for(int i = 0;i < jsonArray.length();i++){

                                Restaurant restaurant = new Restaurant();
                                restaurant.setId(jsonArray.getJSONObject(i).getString("id"));
                                restaurant.setPlace_parent(jsonArray.getJSONObject(i).getString("place_parent"));
                                restaurant.setName(jsonArray.getJSONObject(i).getString("name"));
                                restaurant.setDescription(jsonArray.getJSONObject(i).getString("description"));
                                restaurant.setBuilding(jsonArray.getJSONObject(i).getString("building"));
                                restaurant.setStreet(jsonArray.getJSONObject(i).getString("street"));
                                restaurant.setLandmark(jsonArray.getJSONObject(i).getString("landmark"));
                                restaurant.setMall_id(jsonArray.getJSONObject(i).getString("mall_id"));
                                restaurant.setArea(jsonArray.getJSONObject(i).getString("area"));
                                restaurant.setCity(jsonArray.getJSONObject(i).getString("city"));
                                restaurant.setTel_no1(jsonArray.getJSONObject(i).getString("tel_no1"));
                                restaurant.setTel_no2(jsonArray.getJSONObject(i).getString("tel_no2"));
                                restaurant.setTel_no3(jsonArray.getJSONObject(i).getString("tel_no3"));
                                restaurant.setMob_no1(jsonArray.getJSONObject(i).getString("mob_no1"));
                                restaurant.setMob_no2(jsonArray.getJSONObject(i).getString("mob_no2"));
                                restaurant.setMob_no3(jsonArray.getJSONObject(i).getString("mob_no3"));
                                restaurant.setFax_no1(jsonArray.getJSONObject(i).getString("fax_no1"));
                                restaurant.setFax_no2(jsonArray.getJSONObject(i).getString("fax_no2"));
                                restaurant.setToll_free_no1(jsonArray.getJSONObject(i).getString("toll_free_no1"));
                                restaurant.setToll_free_no2(jsonArray.getJSONObject(i).getString("toll_free_no2"));
                                restaurant.setImage_url(jsonArray.getJSONObject(i).getString("image_url"));
                                restaurant.setEmail(jsonArray.getJSONObject(i).getString("email"));
                                restaurant.setWebsite(jsonArray.getJSONObject(i).getString("website"));
                                restaurant.setTotal_like(jsonArray.getJSONObject(i).getString("total_like"));
                                restaurant.setHas_offer(jsonArray.getJSONObject(i).getString("has_offer"));
                                restaurant.setTitle(jsonArray.getJSONObject(i).getString("title"));
                                restaurant.setCategory(jsonArray.getJSONObject(i).getString("category"));
                                restaurant.setCategory_id(jsonArray.getJSONObject(i).getString("category_id"));

                                restaurantsList.add(restaurant);
                            }

                            int x = restaurantsList.size();
                            int p =x;

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        String s = error.toString();
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("X-API-KEY", "d41d8cd98f00b204e9800998ecf8427e");
                return params;
            };
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(stringRequest);
    }
}

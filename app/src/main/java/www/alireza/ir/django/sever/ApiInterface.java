package www.alireza.ir.django.sever;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Alireza on 8/8/2018.
 */

public interface ApiInterface {

    @POST("register/")
    @FormUrlEncoded
    Call<model> GetHome_call(@Field("action") String action,
                             @Field("id") String id,
                             @Field("name") String name,
                             @Field("inviter") String inviter,
                             @Field("digits") String digits,
                             @Field("contact_id") String contact_id);




}


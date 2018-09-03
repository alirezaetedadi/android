package www.alireza.ir.django.sever;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alireza on 8/8/2018.
 */

public class ApiClinet {
    public static final String URL = "http://etedadi.pythonanywhere.com/";
    public static Retrofit retrofit = null;

    public static Retrofit GetClinet(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

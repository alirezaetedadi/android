package www.alireza.ir.django.sever;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Alireza on 8/24/2018.
 */

public class model {

    @SerializedName("result")
    private String result;

    public model(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

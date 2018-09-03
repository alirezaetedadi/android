package www.alireza.ir.django;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import www.alireza.ir.django.sever.ApiClinet;
import www.alireza.ir.django.sever.ApiInterface;
import www.alireza.ir.django.sever.model;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    EditText id,name,inviter,dig,cont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView2);
        button = (Button) findViewById(R.id.button);
        id = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        inviter = (EditText) findViewById(R.id.inviter);
        dig = (EditText) findViewById(R.id.digits);
        cont = (EditText) findViewById(R.id.contact_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = id.getText().toString();
                String Name = name.getText().toString();
                String I = inviter.getText().toString();
                String D = dig.getText().toString();
                String C = cont.getText().toString();

                ApiInterface apiInterface = ApiClinet.GetClinet().create(ApiInterface.class);
                Call<model> call = apiInterface.GetHome_call("create_customer",ID,Name,I,D,C);
                call.enqueue(new Callback<model>() {
                    @Override
                    public void onResponse(Call<model> call, Response<model> response) {
                        if (response.isSuccessful()){
                            textView.setText(response.body().getResult().toString());
                            Toast.makeText(MainActivity.this, "recived", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<model> call, Throwable t) {
                        textView.setText("error");
                        Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });




       }
}

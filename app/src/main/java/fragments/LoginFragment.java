package fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothingshoppingapp.DashboardActivity;
import com.example.onlineclothingshoppingapp.R;


public class LoginFragment extends Fragment implements View.OnClickListener{
    private EditText etusername;
    private EditText etpassword;
    private Button btnlogin;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etusername = view.findViewById(R.id.login_email);
        etpassword = view.findViewById(R.id.login_password);
        btnlogin = view.findViewById(R.id.btn_login);

        btnlogin.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        verifyLogin();
    }

    public void verifyLogin() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("register", Context.MODE_PRIVATE);
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");
        if (email.equals(etusername.getText().toString()) && password.equals(etpassword.getText().toString())) {
            Toast.makeText(getContext(), "Successful", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getContext(), DashboardActivity.class);
            intent.putExtra("myMessage","Welcome to the DashBoard");
            startActivity(intent);
        }
        else {
            Toast.makeText(getContext(), "Emal or Password is incorrect", Toast.LENGTH_SHORT).show();
        }
    }

}

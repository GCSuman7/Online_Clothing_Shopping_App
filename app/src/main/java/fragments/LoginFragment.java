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

import com.example.onlineclothingshoppingapp.AddItemActivity;
import com.example.onlineclothingshoppingapp.DashboardActivity;
import com.example.onlineclothingshoppingapp.R;
import com.example.onlineclothingshoppingapp.ViewPagerActivity;

import java.io.PrintStream;


public class LoginFragment extends Fragment implements View.OnClickListener{
    private EditText login_email;
    private EditText login_password;
    private Button btn_login;


    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        login_email = view.findViewById(R.id.login_email);
        login_password = view.findViewById(R.id.login_password);
        btn_login = view.findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);

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
        if (email.equals(login_email.getText().toString()) && password.equals(login_password.getText().toString())) {
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

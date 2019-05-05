package fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothingshoppingapp.R;

public class RegisterFragment extends Fragment implements View.OnClickListener{
    private EditText register_name;
    private EditText register_email;
    private EditText register_password;
    private Button btn_register;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        register_name = view.findViewById(R.id.register_name);
        register_email = view.findViewById(R.id.register_email);
        register_password = view.findViewById(R.id.register_password);
        btn_register = view.findViewById(R.id.btn_register);

        btn_register.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        Register();
    }

    public void Register() {
        SharedPreferences sharedPreferences=getContext().getSharedPreferences("register", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name",register_name.getText().toString());
        editor.putString("email",register_email.getText().toString());
        editor.putString("password",register_password.getText().toString());
        editor.commit();
        Toast.makeText(getContext(),"Registration Successful",Toast.LENGTH_LONG).show();
    }


}

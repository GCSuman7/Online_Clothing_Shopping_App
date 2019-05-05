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
    private EditText etname;
    private EditText etusername;
    private EditText etpassword;
    private Button btnregister;

    public RegisterFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        etname = view.findViewById(R.id.register_name);
        etusername = view.findViewById(R.id.register_email);
        etpassword = view.findViewById(R.id.register_password);
        btnregister = view.findViewById(R.id.btn_register);

        btnregister.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        Register();
    }

    public void Register() {
        SharedPreferences sharedPreferences=getContext().getSharedPreferences("register", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name", etname.getText().toString());
        editor.putString("email", etusername.getText().toString());
        editor.putString("password", etpassword.getText().toString());
        editor.commit();
        Toast.makeText(getContext(),"Registration Successful",Toast.LENGTH_LONG).show();
    }


}

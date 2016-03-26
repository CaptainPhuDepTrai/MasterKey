package com.phucute.masterkey;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;



public class LoginActivity extends AppCompatActivity {

    EditText IDDangNhap, PassDangNhap;
    Button BtnDangNhap, BtnDangKy;
    ma check;
    MaHoa maHoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        IDDangNhap = (AutoCompleteTextView) findViewById(R.id.email);


        PassDangNhap = (EditText) findViewById(R.id.password);
        BtnDangNhap = (Button) findViewById(R.id.email_sign_in_button);
        BtnDangKy = (Button) findViewById(R.id.dangki);
        check.hs.put("damducduy",maHoa.encryptMD5("18101995"));
        BtnDangKy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                changed();
            }
        });

        BtnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder tb = new AlertDialog.Builder(LoginActivity.this);

                String idLogin = IDDangNhap.getText().toString();
                String passLogin = PassDangNhap.getText().toString();
                if(check.hs.containsKey(idLogin)){
                    if(check.hs.get(idLogin).equals(maHoa.encryptMD5(passLogin))){
                        tb.setTitle("Chào Mừng!").create();
                        tb.setMessage("Đăng Nhập Thành Công");
                        tb.show();
                        PassDangNhap.setText("");
                        routeToMainMenu();
                    }
                    else{
                        tb.setTitle("Thông Báo!").create();
                        tb.setMessage("Pass Sai");
                        tb.show();
                        PassDangNhap.setText("");
                    }
                }
                else{
                    tb.setTitle("Thông Báo!").create();
                    tb.setMessage("ID Không Tồn Tại");
                    tb.show();
                    IDDangNhap.setText("");
                    PassDangNhap.setText("");
                }
            }
        });

    }

    public void  routeToMainMenu(){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
    public void  changed(){
        Intent intent = new Intent(this, DangKy.class);
        startActivity(intent);
    }
    public ma  check(){
        return check;
    }
}

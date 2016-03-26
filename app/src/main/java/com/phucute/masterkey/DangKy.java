package com.phucute.masterkey;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by morok on 25/03/2016.
 */
public class DangKy extends Activity {





    EditText Id,Pass, Pass2;
    Button dK;
    final Context context = this;
    ma check = new ma();
    MaHoa maHoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);




        Id = (EditText) findViewById(R.id.id);
        Pass = (EditText) findViewById(R.id.pass);
        Pass2 = (EditText) findViewById(R.id.pass2);
        dK = (Button) findViewById(R.id.dk);

        dK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder wrong = new AlertDialog.Builder(DangKy.this);

                String iD = Id.getText().toString();
                String pass11 = Pass.getText().toString();
                String pass12 = Pass2.getText().toString();
                if (check.hs.containsKey(iD)) {
                    wrong.setTitle("Thông Báo!").create();
                    wrong.setMessage("ID Đã Bị Trùng");
                    wrong.show();
                    Id.setText("");
                    Pass.setText("");
                    Pass2.setText("");
                } else {
                    if (iD.length() >= 6) {
                        if (pass11.length() >= 8) {
                            if (pass11.equals(pass12)) {
                                check.hs.put(iD, maHoa.encryptMD5(pass11));
                                wrong.setTitle("Chúc Mừng").create();
                                wrong.setMessage("Đăng Ký Thành Công!!");
                                wrong.show();
                                changed();
                            } else {
                                wrong.setTitle("Thông Báo!").create();
                                wrong.setMessage("Nhập Lại Password Không Giống!");
                                wrong.show();
                                Pass.setText("");
                                Pass2.setText("");
                            }
                        } else {
                            wrong.setTitle("Thông Báo!").create();
                            wrong.setMessage("Password Quá Ngắn Xin Nhập Lại!");
                            wrong.show();
                            Pass.setText("");
                            Pass2.setText("");
                        }


                    } else {
                        wrong.setTitle("Thông Báo!").create();
                        wrong.setMessage("ID Quá Ngắn Xin Nhập Lại.");
                        wrong.show();
                        Pass.setText("");
                        Pass2.setText("");
                    }
                }
            }
        });

    }

    public void  changed(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
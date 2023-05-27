package com.example.instant_messaging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        Button confirmRegisterButton = findViewById(R.id.confirmRegisterButton);

        confirmRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "请填写所有字段", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(RegisterActivity.this, "密码不匹配", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 执行注册逻辑，例如保存用户名和密码
                if (isValidRegistration(username, password)) {
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    // 在这里执行注册成功后的操作，例如跳转到登录界面
                } else {
                    Toast.makeText(RegisterActivity.this, "注册失败，请检查用户名和密码", Toast.LENGTH_SHORT).show();
                }

                // TODO: 执行注册逻辑，将用户信息保存到数据库或服务器端

                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//                finish();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean isValidRegistration(String username, String password) {
        // 这里可以编写验证注册信息的逻辑，例如检查用户名是否已存在
        // 在此示例中，简单地假设所有的注册都是有效的
        return true;

    }

}


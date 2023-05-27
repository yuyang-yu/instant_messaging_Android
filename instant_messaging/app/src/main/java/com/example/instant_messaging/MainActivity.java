package com.example.instant_messaging;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                // 执行登录逻辑，例如验证用户名和密码
                if (isValidLogin(username, password)) {
                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    //登录成功后页面跳转
                    Intent intent = new Intent(MainActivity.this, FriendsActivity.class);
                    startActivity(intent);
                    finish(); // 可选，结束当前登录页面

                    // 在这里执行登录成功后的操作，例如跳转到另一个活动
                } else {
                    Toast.makeText(MainActivity.this, "登录失败，请检查用户名和密码", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String username = usernameEditText.getText().toString();
//                String password = passwordEditText.getText().toString();
//                // 执行注册逻辑，例如保存用户名和密码
//                if (isValidRegistration(username, password)) {
//                    Toast.makeText(MainActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//                    // 在这里执行注册成功后的操作，例如跳转到登录界面
//                } else {
//                    Toast.makeText(MainActivity.this, "注册失败，请检查用户名和密码", Toast.LENGTH_SHORT).show();
//                }

                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean isValidLogin(String username, String password) {
        // 这里可以编写验证用户名和密码的逻辑，例如从数据库或服务器进行验证
        // 在此示例中，假设用户名为 "admin"，密码为 "password"

//        return username.equals("admin") && password.equals("password");
        return true;
    }

    private boolean isValidRegistration(String username, String password) {
        // 这里可以编写验证注册信息的逻辑，例如检查用户名是否已存在
        // 在此示例中，简单地假设所有的注册都是有效的
        return true;
    }
}

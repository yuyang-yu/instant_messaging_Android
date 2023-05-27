package com.example.instant_messaging;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    private EditText newFriendEditText;
    private ArrayAdapter<String> friendsAdapter;
    private ArrayList<String> friendsList;
    private EditText groupNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        ListView friendsListView = findViewById(R.id.friendsListView);
        newFriendEditText = findViewById(R.id.newFriendEditText);
        Button addFriendButton = findViewById(R.id.addFriendButton);
        Button createGroupButton = findViewById(R.id.createGroupButton);

        friendsList = new ArrayList<>();
        friendsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, friendsList);
        friendsListView.setAdapter(friendsAdapter);

        loadFriends();

        //添加
        addFriendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newFriend = newFriendEditText.getText().toString();
                friendsList.add(newFriend);
                friendsAdapter.notifyDataSetChanged();
                newFriendEditText.setText("");
            }
        });

        //创建群组

        createGroupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String groupName = groupNameEditText.getText().toString();

                if (groupName.isEmpty()) {
                    Toast.makeText(FriendsActivity.this, "请输入群组名称", Toast.LENGTH_SHORT).show();
                    return;
                }


                // TODO: 将 groupName 和 selectedMembers 发送到服务器创建群组的请求
                // 在服务器端处理创建群组的逻辑，包括创建群组实例、保存到数据库等

                Toast.makeText(FriendsActivity.this, "群组创建成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        //删除
        friendsListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                friendsList.remove(position);
                friendsAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    private void loadFriends() {
        // 在这里编写加载好友数据的逻辑
        // 例如，从数据库或网络获取好友列表数据

        // 假设你有一个名为 friendsList 的 ArrayList 存储好友数据
        // 这里只是一个示例，你需要根据实际情况自行获取好友数据

        friendsList = getFriendListFromDatabase(); // 从数据库获取好友列表
        friendsAdapter.clear(); // 清空适配器中的数据
        friendsAdapter.addAll(friendsList); // 添加所有好友到适配器
        friendsAdapter.notifyDataSetChanged(); // 通知适配器数据已更改
    }


    private ArrayList<String> getFriendListFromDatabase() {
        ArrayList<String> list = new ArrayList<>();
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        list.add("test");
        return list;
    }


}


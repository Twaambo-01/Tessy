package com.example.my_cute_hotel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SelectRoomActivity extends AppCompatActivity {

    String selectedRoom = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_room);

        Button btnStandard = findViewById(R.id.btnStandard);
        Button btnDeluxe = findViewById(R.id.btnDeluxe);
        Button btnExecutive = findViewById(R.id.btnExecutive);
        Button btnPresidential = findViewById(R.id.btnPresidential);
        Button btnFamily = findViewById(R.id.btnFamily);
        Button btnHoneymoon = findViewById(R.id.btnHoneymoon);
        Button btnBusiness = findViewById(R.id.btnBusiness);
        Button btnTwin = findViewById(R.id.btnTwin);
        Button btnContinue = findViewById(R.id.btnContinue);

        View.OnClickListener roomClickListener = view -> {
            Button clicked = (Button) view;
            selectedRoom = clicked.getText().toString();
            Toast.makeText(this, "Selected: " + selectedRoom, Toast.LENGTH_SHORT).show();
        };

        btnStandard.setOnClickListener(roomClickListener);
        btnDeluxe.setOnClickListener(roomClickListener);
        btnExecutive.setOnClickListener(roomClickListener);
        btnPresidential.setOnClickListener(roomClickListener);
        btnFamily.setOnClickListener(roomClickListener);
        btnHoneymoon.setOnClickListener(roomClickListener);
        btnBusiness.setOnClickListener(roomClickListener);
        btnTwin.setOnClickListener(roomClickListener);

        btnContinue.setOnClickListener(v -> {
            if (selectedRoom.isEmpty()) {
                Toast.makeText(this, "Please select a room first!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, bookingDetailsActivity.class);
                intent.putExtra("selectedRoom", selectedRoom);
                startActivity(intent);
            }
        });
    }
}

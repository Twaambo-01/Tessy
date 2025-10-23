package com.example.my_cute_hotel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class bookingDetailsActivity extends AppCompatActivity {

    EditText etCheckIn, etCheckOut, etGuests;
    Button btnConfirm;
    String selectedRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        etCheckIn = findViewById(R.id.etCheckIn);
        etCheckOut = findViewById(R.id.etCheckOut);
        etGuests = findViewById(R.id.etGuests);
        btnConfirm = findViewById(R.id.btnConfirm);

        selectedRoom = getIntent().getStringExtra("selectedRoom");

        btnConfirm.setOnClickListener(v -> {
            String checkIn = etCheckIn.getText().toString();
            String checkOut = etCheckOut.getText().toString();
            String guests = etGuests.getText().toString();

            if (checkIn.isEmpty() || checkOut.isEmpty() || guests.isEmpty()) {
                Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, PaymentMethodActivity.class);
                intent.putExtra("selectedRoom", selectedRoom);
                intent.putExtra("checkIn", checkIn);
                intent.putExtra("checkOut", checkOut);
                intent.putExtra("guests", guests);
                startActivity(intent);
            }
        });
    }
}

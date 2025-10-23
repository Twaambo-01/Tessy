package com.example.my_cute_hotel;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentMethodActivity extends AppCompatActivity {

    RadioGroup paymentGroup;
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        paymentGroup = findViewById(R.id.paymentGroup);
        btnPay = findViewById(R.id.btnPay);

        String selectedRoom = getIntent().getStringExtra("selectedRoom");
        String checkIn = getIntent().getStringExtra("checkIn");
        String checkOut = getIntent().getStringExtra("checkOut");
        String guests = getIntent().getStringExtra("guests");

        btnPay.setOnClickListener(v -> {
            int selectedId = paymentGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(this, "Please select a payment method", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedMethod = findViewById(selectedId);
                String paymentMethod = selectedMethod.getText().toString();

                Toast.makeText(
                        this,
                        "✅ Booking Confirmed!\nRoom: " + selectedRoom +
                                "\nCheck-in: " + checkIn +
                                "\nCheck-out: " + checkOut +
                                "\nGuests: " + guests +
                                "\nPayment: " + paymentMethod,
                        Toast.LENGTH_LONG
                ).show();
            }
        });
    }
}

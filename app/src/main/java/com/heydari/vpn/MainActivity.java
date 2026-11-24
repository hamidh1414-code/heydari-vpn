package com.heydari.vpn;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(32, 32, 32, 32);
        layout.setBackgroundColor(Color.WHITE);

        TextView title = new TextView(this);
        title.setText("Heydari VPN");
        title.setTextSize(28);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);

        Button connect = new Button(this);
        connect.setText("اتصال");
        connect.setTextSize(20);

        TextView status = new TextView(this);
        status.setText("وضعیت: آماده");
        status.setTextSize(18);
        status.setGravity(Gravity.CENTER);

        layout.addView(title);
        layout.addView(connect);
        layout.addView(status);

        setContentView(layout);
    }
}

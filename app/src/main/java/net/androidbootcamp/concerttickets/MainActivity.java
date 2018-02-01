package net.androidbootcamp.concerttickets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    double costPerTicket = 79.99;
    int numberOfTickets;
    double totalCost;
    String groupChoice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText tickets = (EditText) findViewById(R.id.numOfTickets);
        final Spinner group = (Spinner) findViewById(R.id.txtGroup);
        final Button cost = (Button) findViewById(R.id.btnCost);

        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = (TextView) findViewById(R.id.result);
            @Override
            public void onClick(View v) {
                numberOfTickets = Integer.parseInt(tickets.getText().toString());
                totalCost = costPerTicket * numberOfTickets;
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Cost for " + groupChoice + " is " + currency.format(totalCost));
            }
        });

    }
}

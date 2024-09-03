package com.example.placementanalyzer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText CGPA, IQ, Profile_Score;
    AppCompatImageButton Predict, PdfButton;
    String url = "https://web-production-c960.up.railway.app/predict";
    String pdfUrl = "https://drive.google.com/file/d/1nm8LW8a0RQRVp3aKqv9Yst1xTmasdTJ6/view?usp=sharing"; // Replace with your actual PDF link

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CGPA = findViewById(R.id.CGPA);
        IQ = findViewById(R.id.IQ);
        Profile_Score = findViewById(R.id.Profile_Score);
        Predict = findViewById(R.id.imageButton);
        PdfButton = findViewById(R.id.pdfButton); // Make sure this ID matches your layout XML

        Predict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePredictionRequest();
            }
        });

        PdfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPdf();
            }
        });
    }

    private void makePredictionRequest() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String result = jsonObject.getString("Placement");

                            // Create an intent to start ResultActivity
                            Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);
                            if (result.equals("1")) {
                                resultIntent.putExtra("result", "Congrats");
                            } else {
                                resultIntent.putExtra("result", "Failed");
                            }
                            startActivity(resultIntent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(MainActivity.this, "Error parsing response", Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Server error: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("cgpa", CGPA.getText().toString());
                params.put("iq", IQ.getText().toString());
                params.put("profile_score", Profile_Score.getText().toString());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }

    private void openPdf() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl));
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }
}

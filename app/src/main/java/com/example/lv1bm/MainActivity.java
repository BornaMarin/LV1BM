package com.example.lv1bm;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    private String[] descriptions;
    private Button buttonInspiration;
    private ImageView imageViewOne;
    private ImageView imageViewTwo;
    private ImageView imageViewThree;
    private EditText editTextDescription;
    private Button buttonEditDescription;
    private RadioGroup radioGroupPersons;
    private TextView textViewDescriptionOne;
    private TextView textViewDescriptionTwo;
    private TextView textViewDescriptionThree;


    private String[] facts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupData();
        setupUi();
    }

    private void setupUi() {
        buttonInspiration = findViewById(R.id.buttonInspiration);
        imageViewOne = findViewById(R.id.imageViewOne);
        imageViewTwo = findViewById(R.id.imageViewTwo);
        imageViewThree = findViewById(R.id.imageViewThree);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonEditDescription = findViewById(R.id.buttonEditDescription);
        radioGroupPersons = findViewById(R.id.radioGroupPersons);
        textViewDescriptionOne = findViewById(R.id.textViewDescriptionOne);
        textViewDescriptionTwo = findViewById(R.id.textViewDescriptionTwo);
        textViewDescriptionThree = findViewById(R.id.textViewDescriptionThree);

        facts = getResources().getStringArray(R.array.personsFacts);

        buttonInspiration.setOnClickListener(this::onInspirationButtonClick);
        imageViewOne.setOnClickListener(this::onImageViewClick);
        imageViewTwo.setOnClickListener(this::onImageViewClick);
        imageViewThree.setOnClickListener(this::onImageViewClick);
        buttonEditDescription.setOnClickListener(this::onEditDescriptionClick);

    }

    private void setupData() {

    }

    private void onInspirationButtonClick(View view) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
        showToast(facts[randomNum]);
    }

    private void onImageViewClick(View view) {
        view.setVisibility(View.INVISIBLE);
    }

    private void onEditDescriptionClick(View view) {
        Editable newDescription = editTextDescription.getText();
        if (newDescription != null && !newDescription.toString().equals("")) {
            editPersonDescription();
        } else {
            showToast("Please enter description");
        }
    }

    private void editPersonDescription() {
        int radioButtonId = radioGroupPersons.getCheckedRadioButtonId();
        View radioButton = radioGroupPersons.findViewById(radioButtonId);
        int index = radioGroupPersons.indexOfChild(radioButton);

        String newDescription = editTextDescription.getText().toString();

        switch (index) {
            case 0:
                textViewDescriptionOne.setText(newDescription);
                editTextDescription.setText("");
                break;
            case 1:
                textViewDescriptionTwo.setText(newDescription);
                editTextDescription.setText("");
                break;
            case 2:
                textViewDescriptionThree.setText(newDescription);
                editTextDescription.setText("");
                break;
            default:
                showToast("Please select person");
                break;
        }

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
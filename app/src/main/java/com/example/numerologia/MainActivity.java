package com.example.numerologia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numerologia.calculate.DescriptionEnum;
import com.example.numerologia.calculate.Numerology;
import com.example.numerologia.calculate.exceptions.EmptyStringException;
import com.example.numerologia.calculate.exceptions.NotRusLetterException;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText surename, name, middlename;
    private TextView dateOfBirth, textView2;

    private Button btnCaclulate, btnNumberOfFate, btnNumberOfSoul,
            btnNumberOfPersonality, btnNumberOfLifePath, btnBreak;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private Numerology numerology;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnNumberOfFate = (Button) findViewById(R.id.buttonNumberOfFate);
        btnNumberOfSoul = (Button) findViewById(R.id.buttonNumberOfSoul);
        btnNumberOfPersonality = (Button) findViewById(R.id.buttonNumberOfPersonality);
        btnNumberOfLifePath = (Button) findViewById(R.id.buttonNumberOfLifePath);
        btnBreak = (Button) findViewById(R.id.buttonBreak);

        btnNumberOfFate.setEnabled(false);
        btnNumberOfSoul.setEnabled(false);
        btnNumberOfPersonality.setEnabled(false);
        btnNumberOfLifePath.setEnabled(false);
        btnBreak.setEnabled(false);

        dateOfBirth = (TextView) findViewById(R.id.textViewDob);
        dateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_NoActionBar_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = dayOfMonth + "/" + month + "/" + year;
                dateOfBirth.setText(date);
            }
        };


    }


    public void onClickCalculate(View v) {
        surename = (EditText) findViewById(R.id.editTextSurename);
        name = (EditText) findViewById(R.id.editTextName);
        middlename = (EditText) findViewById(R.id.editTextMiddlename);
        dateOfBirth = (TextView) findViewById(R.id.textViewDob);
        btnCaclulate = (Button) findViewById(R.id.buttonCalculate);


/*
        surename.setText("Пушкfин");
        name.setText("Александр");
        middlename.setText("Сергеевич");
        dateOfBirth.setText("14/06/1982");

*/

        numerology = new Numerology(surename.getText().toString(), name.getText().toString(),
                middlename.getText().toString(), dateOfBirth.getText().toString());


        try {
            numerology.calculateAllNumbers();


            btnNumberOfFate.setEnabled(true);
            btnNumberOfSoul.setEnabled(true);
            btnNumberOfPersonality.setEnabled(true);
            btnNumberOfLifePath.setEnabled(true);
            btnBreak.setEnabled(true);


            String strToBtnNumberOfFate, strToBtnNumberOfSoul,
                    strToBtnNumberOfPersonality, strToBtnNumberOfLifePath;
            strToBtnNumberOfFate = "ваше число судьбы " + numerology.getNumberOfFate();
            strToBtnNumberOfSoul = "ваше число души " + numerology.getNumberOfSoul();
            strToBtnNumberOfPersonality = "ваше число личности " + numerology.getNumberOfPersonality();
            strToBtnNumberOfLifePath = "ваше число жизненного пути " + numerology.getNumberOfLifePath();


            btnNumberOfFate.setText(strToBtnNumberOfFate);
            btnNumberOfSoul.setText(strToBtnNumberOfSoul);
            btnNumberOfPersonality.setText(strToBtnNumberOfPersonality);
            btnNumberOfLifePath.setText(strToBtnNumberOfLifePath);

        } catch (NotRusLetterException e) {
            // e.printStackTrace();
            Toast.makeText(MainActivity.this,
                    "это не русская буква " + e.getLetter(),
                    Toast.LENGTH_LONG).show();

        } catch (EmptyStringException e) {
            // e.printStackTrace();
            Toast.makeText(MainActivity.this, " пустая строка ", Toast.LENGTH_LONG).show();
            //  Toast.makeText(MainActivity.this, " вводите только русские буквы  ", Toast.LENGTH_LONG).show();
        }


    }

    public void onClickBreak(View v) {
        btnNumberOfFate.setEnabled(false);
        btnNumberOfSoul.setEnabled(false);
        btnNumberOfPersonality.setEnabled(false);
        btnNumberOfLifePath.setEnabled(false);
        btnBreak.setEnabled(false);

        btnNumberOfFate.setText(R.string.buttonNumberOfFate);
        btnNumberOfSoul.setText(R.string.buttonNumberOfSoul);
        btnNumberOfPersonality.setText(R.string.buttonNumberOfPersonality);
        btnNumberOfLifePath.setText(R.string.buttonNumberOfLifePath);

        surename.setText("");
        name.setText("");
        middlename.setText("");
        dateOfBirth.setText("");


    }

    public void onClickNumberOfFate(View v) {
        String info = "empty";

        switch (numerology.getNumberOfFate()) {
            case 1:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_1.toString();
                break;
            case 2:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_2.toString();
                break;
            case 3:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_3.toString();
                break;
            case 4:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_4.toString();
                break;
            case 5:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_5.toString();
                break;
            case 6:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_6.toString();
                break;
            case 7:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_7.toString();
                break;
            case 8:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_8.toString();
                break;
            case 9:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_9.toString();
                break;
            case 11:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_11.toString();
                break;
            case 22:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_FATE_22.toString();
                break;
        }

        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("info", info);
        startActivity(intent);
    }

    public void onClickNumberOfSoul(View v) {
        String info = "empty";

        switch (numerology.getNumberOfSoul()) {
            case 1:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_1.toString();
                break;
            case 2:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_2.toString();
                break;
            case 3:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_3.toString();
                break;
            case 4:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_4.toString();
                break;
            case 5:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_5.toString();
                break;
            case 6:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_6.toString();
                break;
            case 7:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_7.toString();
                break;
            case 8:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_8.toString();
                break;
            case 9:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_SOUL_9.toString();
                break;

        }

        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("info", info);
        startActivity(intent);


    }

    public void onClickNumberOfPersonality(View v) {
        String info = "empty";

        switch (numerology.getNumberOfPersonality()) {
            case 1:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_1.toString();
                break;
            case 2:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_2.toString();
                break;
            case 3:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_3.toString();
                break;
            case 4:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_4.toString();
                break;
            case 5:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_5.toString();
                break;
            case 6:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_6.toString();
                break;
            case 7:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_7.toString();
                break;
            case 8:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_8.toString();
                break;
            case 9:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_PERSONALITY_9.toString();
                break;
        }
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("info", info);
        startActivity(intent);

    }

    public void onClickNumberOfLifePath(View v) {
        String info = "empty";

        switch (numerology.getNumberOfLifePath()) {
            case 1:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_1.toString();
                break;
            case 2:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_2.toString();
                break;
            case 3:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_3.toString();
                break;
            case 4:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_4.toString();
                break;
            case 5:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_5.toString();
                break;
            case 6:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_6.toString();
                break;
            case 7:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_7.toString();
                break;
            case 8:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_8.toString();
                break;
            case 9:
                info = DescriptionEnum.DESCRIPTION_OF_NUMBER_OF_LIFE_PARTH_9.toString();
                break;
        }
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra("info", info);
        startActivity(intent);


    }

}

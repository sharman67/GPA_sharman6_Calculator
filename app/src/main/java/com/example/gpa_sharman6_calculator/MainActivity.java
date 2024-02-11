package com.example.gpa_sharman6_calculator;
//Import libraries
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    EditText course1GradeInTx, course2GradeInTx, course3GradeInTx, course4GradeInTx, course5GradeInTx ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Logic to change Button back to Compute GPA after form is cleared and new grade is typed
        course1GradeInTx = findViewById(R.id.course1Grade);
        course2GradeInTx = findViewById(R.id.course2Grade);
        course3GradeInTx = findViewById(R.id.course3Grade);
        course4GradeInTx = findViewById(R.id.course4Grade);
        course5GradeInTx = findViewById(R.id.course5Grade);

        course1GradeInTx.addTextChangedListener(new TextWatcher() {

            Button btnTextInCh = findViewById(R.id.button);

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //Check if button text is Clear form and field is non empty
                if (btnTextInCh.getText().toString().equals(getString(R.string.btnTextClear)) && course1GradeInTx.length() != 0){
                    btnTextInCh.setText(R.string.btnText);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        course2GradeInTx.addTextChangedListener(new TextWatcher() {

            Button btnTextInCh = findViewById(R.id.button);

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Check if button text is Clear form and field is non empty
                if (btnTextInCh.getText().toString().equals(getString(R.string.btnTextClear)) && course2GradeInTx.length() != 0){
                    btnTextInCh.setText(R.string.btnText);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        course3GradeInTx.addTextChangedListener(new TextWatcher() {

            Button btnTextInCh = findViewById(R.id.button);

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Check if button text is Clear form and field is non empty
                if (btnTextInCh.getText().toString().equals(getString(R.string.btnTextClear)) && course3GradeInTx.length() != 0){
                    btnTextInCh.setText(R.string.btnText);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        course4GradeInTx.addTextChangedListener(new TextWatcher() {

            Button btnTextInCh = findViewById(R.id.button);

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Check if button text is Clear form and field is non empty
                if (btnTextInCh.getText().toString().equals(getString(R.string.btnTextClear)) && course4GradeInTx.length() != 0){
                    btnTextInCh.setText(R.string.btnText);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        course5GradeInTx.addTextChangedListener(new TextWatcher() {

            Button btnTextInCh = findViewById(R.id.button);

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Check if button text is Clear form and field is non empty
                if (btnTextInCh.getText().toString().equals(getString(R.string.btnTextClear)) && course5GradeInTx.length() != 0){
                    btnTextInCh.setText(R.string.btnText);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    // Do field validations and calcuate GPA
    public void fnCalculateGrade(View view){
        //Declare variables
        TextView outputGrade;

        boolean isAllFieldsChecked = false;
        boolean isGradeInRange = false;
        outputGrade = (TextView)findViewById(R.id.outputGrade);
        Button btnTextIn;
        String btnGPA = getString(R.string.btnText);
        String btnClear = getString(R.string.btnTextClear);
        btnTextIn = findViewById(R.id.button);
        course1GradeInTx = findViewById(R.id.course1Grade);
        course2GradeInTx = findViewById(R.id.course2Grade);
        course3GradeInTx = findViewById(R.id.course3Grade);
        course4GradeInTx = findViewById(R.id.course4Grade);
        course5GradeInTx = findViewById(R.id.course5Grade);

        View mainView = findViewById(R.id.layoutId);
        View root = mainView.getRootView();
        //For case where button value is Compute GPA
        if (btnTextIn.getText().toString().equals(btnGPA)){

            int finalGrade;

            isAllFieldsChecked = CheckAllFields();
            //Check if fields are non-empty and value is in range
            if (isAllFieldsChecked ) {
                isGradeInRange = isInRange();
                if (isGradeInRange) {
                    finalGrade = (Integer.parseInt(course1GradeInTx.getText().toString()) +
                            Integer.parseInt(course2GradeInTx.getText().toString()) +
                            Integer.parseInt(course3GradeInTx.getText().toString()) +
                            Integer.parseInt(course4GradeInTx.getText().toString()) +
                            Integer.parseInt(course5GradeInTx.getText().toString())) / 5;

                    outputGrade.setText(String.valueOf(finalGrade));
                    if (finalGrade < 60 ){
                        root.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                    } else if (finalGrade > 60 && finalGrade < 80){
                        root.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
                    } else if (finalGrade > 80){
                        root.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                    }
                    btnTextIn.setText(btnClear);
                }
            }
            //For case where button value is CLear Form
        } else if (btnTextIn.getText().toString().equals(btnClear)){
            course1GradeInTx.setText("");
            course2GradeInTx.setText("");
            course3GradeInTx.setText("");
            course4GradeInTx.setText("");
            course5GradeInTx.setText("");
            outputGrade.setText("");
            root.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        }

    }
    // Check fiend for non-empty
    private boolean CheckAllFields() {
        if (course1GradeInTx.length() == 0) {
            course1GradeInTx.setError("Grade is a required field");
            return false;
        }

        if (course2GradeInTx.length() == 0) {
            course2GradeInTx.setError("Grade is a required field");
            return false;
        }

        if (course3GradeInTx.length() == 0) {
            course3GradeInTx.setError("Grade is a required field");
            return false;
        }

        if (course4GradeInTx.length() == 0) {
            course4GradeInTx.setError("Grade is a required field");
            return false;
        }
        if (course5GradeInTx.length() == 0) {
            course5GradeInTx.setError("Grade is a required field");
            return false;
        }
        return true;
    }
    // Check field for value range
    private boolean isInRange() {
        if (Integer.parseInt(course1GradeInTx.getText().toString()) <  0 || Integer.parseInt(course1GradeInTx.getText().toString()) >  100) {
            course1GradeInTx.setError("Enter Grade from 0 to 100");
            return false;
        }
        if (Integer.parseInt(course2GradeInTx.getText().toString()) <  0 || Integer.parseInt(course2GradeInTx.getText().toString()) >  100) {
            course2GradeInTx.setError("Enter Grade from 0 to 100");
            return false;
        }
        if (Integer.parseInt(course3GradeInTx.getText().toString()) <  0 || Integer.parseInt(course3GradeInTx.getText().toString()) >  100) {
            course3GradeInTx.setError("Enter Grade from 0 to 100");
            return false;
        }
        if (Integer.parseInt(course4GradeInTx.getText().toString()) <  0 || Integer.parseInt(course4GradeInTx.getText().toString()) >  100) {
            course4GradeInTx.setError("Enter Grade from 0 to 100");
            return false;
        }
        if (Integer.parseInt(course5GradeInTx.getText().toString()) <  0 || Integer.parseInt(course5GradeInTx.getText().toString()) >  100) {
            course1GradeInTx.setError("Enter Grade from 0 to 100");
            return false;
        }

        return true;
    }
}
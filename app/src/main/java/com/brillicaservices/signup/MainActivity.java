package com.brillicaservices.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    EditText studentNameTF, studentPhoneTF, studentAddressTF,studentCollegeTF;
    Button addStudentBtn, displayStudentBtn;
    TextView displayStudentsResultTV;


    ArrayList<Student> studentArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studentNameTF = findViewById(R.id.student_name);
        studentPhoneTF = findViewById(R.id.enter_phone);
        studentAddressTF = findViewById(R.id.enter_address);

        addStudentBtn = findViewById(R.id.add_student_button);
        displayStudentBtn = findViewById(R.id.display_student_button);
        studentCollegeTF=findViewById(R.id.college_name);

        displayStudentsResultTV = findViewById(R.id.display_student_details_text_view);

        addStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String name = studentNameTF.getText().toString();
                int phone = Integer.parseInt(studentPhoneTF.getText().toString());
                String address = studentAddressTF.getText().toString();
                String collegeName= studentCollegeTF.getText().toString();


                studentArrayList.add(new Student(name, collegeName, phone, address));


                Toast.makeText(getApplicationContext(), "Student data saved successfully", Toast.LENGTH_LONG).show();
            }
        });

        displayStudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                for (int i=0; i<studentArrayList.size(); i++) {


                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Name is: " + studentArrayList.get(i).studentName + "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student College is: " + studentArrayList.get(i).studentCollege + "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Phone Number is: " + studentArrayList.get(i).studentPhoneNumber + "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Address is: " + studentArrayList.get(i).studentAddress + "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() + "****************\n\n");
                }
            }
        });

    }

}

package com.example.taxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText monthly_salary,taxvalue;
    Button btntax;
    TextView tax;

    Double salary,msalary,ysalary,taxAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

        btntax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (monthly_salary.getText().toString().trim().isEmpty()) {
                    monthly_salary.setError("Salary Required");
                }

                else {

                    displayTax();

                }
            }
        });

    }




    public void initComponents(){
        monthly_salary=findViewById(R.id.msalaryt);
        btntax=findViewById(R.id.taxbtn);
        tax=findViewById(R.id.taxval);

    }

    public void displayTax(){

        salary=Double.parseDouble(monthly_salary.getText().toString());

        Salary sal=new Salary(salary);

        msalary=sal.getMonthly_salary();

        ysalary=(msalary)*12;


        if(ysalary>0 && ysalary<=200000){

            taxAmount=0.01*ysalary;

            tax.setText(taxAmount + "");

            tax.setTextColor(getResources().getColor(R.color.colorPrimary));
//                    tax.setText();
            Toast.makeText(MainActivity.this, "Tax Amount is: "+taxAmount+"", Toast.LENGTH_SHORT).show();

        }
        else if( ysalary>200000&&ysalary<350000){

            taxAmount=0.01*200000+(ysalary-200000)*0.15;
            tax.setText(taxAmount + "");
            tax.setTextColor(getResources().getColor(R.color.Maroon));
            Toast.makeText(MainActivity.this, "Tax Amount is: "+taxAmount+"", Toast.LENGTH_SHORT).show();
        }
        else if(ysalary>350000){
            taxAmount=0.01*200000+0.15*150000+(ysalary-350000)*0.25;
            tax.setText(taxAmount + "");
            tax.setTextColor(getResources().getColor(R.color.Red));
            Toast.makeText(MainActivity.this, "Tax Amount is: "+taxAmount+"", Toast.LENGTH_SHORT).show();
        }





    }
}

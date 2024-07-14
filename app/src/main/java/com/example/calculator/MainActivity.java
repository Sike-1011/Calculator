package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    String s = "";
    double d = 0;

    TextView equationBox = null;
    TextView outputBox = null;

    Button buttonClear = null;
    Button buttonBackspace = null;
    Button buttonEquals = null;
    Button buttonDot = null;

    Button buttonNine = null;
    Button buttonEight = null;
    Button buttonSeven = null;
    Button buttonSex = null;
    Button buttonFive = null;
    Button buttonFour = null;
    Button buttonThree = null;
    Button buttonTwo = null;
    Button buttonOne = null;
    Button buttonZero = null;

    Button buttonPlus = null;
    Button buttonSubtract = null;
    Button buttonMultiply = null;
    Button buttonDivide = null;

    Button buttonAdd5 = null;
    Button buttonSub5 = null;
    Button buttonAdd18 = null;
    Button buttonSub18 = null;

    boolean isMathSignAdded = false;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        initiateAllViews();

        buttonClear.setOnClickListener(this);
        buttonBackspace.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonDot.setOnClickListener(this);

        buttonNine.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonSex.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonThree.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonOne.setOnClickListener(this);
        buttonZero.setOnClickListener(this);

        buttonPlus.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);

        buttonAdd5.setOnClickListener(this);
        buttonSub5.setOnClickListener(this);
        buttonAdd18.setOnClickListener(this);
        buttonSub18.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){

        int viewID = view.getId();

        if (viewID == R.id.button_clear){
            s = "";
            equationBox.setText("0");
            outputBox.setText("0");
        }

        else if (viewID == R.id.button_add_five_percent) performGST5add();
        else if (viewID == R.id.button_sub_five_percent) performGST5sub();
        else if (viewID == R.id.button_add_eighteen_percent) performGST18add();
        else if (viewID == R.id.button_sub_eighteen_percent) performGST18sub();

        else if (viewID == R.id.button_equals) performOperation();
        else if (viewID == R.id.button_backspace) {
            if (s != null && !s.isEmpty() && !s.equals("0")) s = s.substring(0, s.length() - 1);
            equationBox.setText(s);
        }

        else if (viewID == R.id.button_dot) {
            s = s + '.';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_nine) {
            s = s + '9';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_eight) {
            s = s + '8';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_seven) {
            s = s + '7';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_sex) {
            s = s + '6';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_five) {
            s = s + '5';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_four) {
            s = s + '4';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_three) {
            s = s + '3';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_two) {
            s = s + '2';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_one) {
            s = s + '1';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_zero) {
            s = s + '0';
            equationBox.setText(s);
        }

        else if (viewID == R.id.button_plus) {
            if(s.endsWith("+") || s.endsWith("-") || s.endsWith("x") || s.endsWith("/")){
                s = s.substring(0, s.length() - 1);
                s = s + '+';
            }
            else if(s.isEmpty()) return;
            else if(s.contains("+") || s.contains("-") || s.contains("x") || s.contains("/")) Toast.makeText(this, "Cannot do that!", Toast.LENGTH_SHORT).show();
            else s = s + '+';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_subtract) {
            if(s.endsWith("+") || s.endsWith("-") || s.endsWith("x") || s.endsWith("/")){
                s = s.substring(0, s.length() - 1);
                s = s + '-';
            }
            else if(s.isEmpty()) return;
            else if(s.contains("+") || s.contains("-") || s.contains("x") || s.contains("/")) Toast.makeText(this, "Cannot do that!", Toast.LENGTH_SHORT).show();
            else s = s + '-';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_multiply) {
            if(s.endsWith("+") || s.endsWith("-") || s.endsWith("x") || s.endsWith("/")){
                s = s.substring(0, s.length() - 1);
                s = s + 'x';
            }
            else if(s.isEmpty()) return;
            else if(s.contains("+") || s.contains("-") || s.contains("x") || s.contains("/")) Toast.makeText(this, "Cannot do that!", Toast.LENGTH_SHORT).show();
            else s = s + 'x';
            equationBox.setText(s);
        }
        else if (viewID == R.id.button_divide) {
            if(s.endsWith("+") || s.endsWith("-") || s.endsWith("x") || s.endsWith("/")){
                s = s.substring(0, s.length() - 1);
                s = s + '/';
            }
            else if(s.isEmpty()) return;
            else if(s.contains("+") || s.contains("-") || s.contains("x") || s.contains("/")) Toast.makeText(this, "Cannot do that!", Toast.LENGTH_SHORT).show();
            else s = s + '/';
            equationBox.setText(s);
        }

    }


    public void performOperation(){

        if(!(s.endsWith("+") || s.endsWith("-") || s.endsWith("x") || s.endsWith("/"))) {
            if (s.contains("+")) {

                String[] string = s.split("\\+");

                String a = string[0];
                String b = string[1];

                double d1 = Double.parseDouble(a.trim());
                double d2 = Double.parseDouble(b.trim());

                double result = d1 + d2;

                int res = (int) result;

                s = "";

                if (res == result) displaySet("0", res);
                else displaySet("0", result);

            } else if (s.contains("-")) {

                String[] string = s.split("\\-");

                String a = string[0];
                String b = string[1];

                double d1 = Double.parseDouble(a.trim());
                double d2 = Double.parseDouble(b.trim());

                double result = d1 - d2;

                int res = (int) result;

                s = "";

                if (res == result) displaySet("0", res);
                else displaySet("0", result);

            } else if (s.contains("x")) {
                String[] string = s.split("x");

                String a = string[0];
                String b = string[1];

                double d1 = Double.parseDouble(a.trim());
                double d2 = Double.parseDouble(b.trim());

                double result = d1 * d2;

                int res = (int) result;

                s = "";

                if (res == result) displaySet("0", res);
                else displaySet("0", result);

            } else if (s.contains("/")) {

                String[] string = s.split("\\/");

                String a = string[0];
                String b = string[1];

                double d1 = Double.parseDouble(a.trim());
                double d2 = Double.parseDouble(b.trim());

                double result = d1 / d2;;

                int res = (int) result;

                s = "";

                if (res == result) displaySet("0", res);
                else displaySet("0", result);
            }

        }
        else {
            Toast.makeText(this, "Invalid!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    public void performGST5add(){
        if(s.isEmpty() || s.contains("+") || s.contains("-") || s.contains("x") || s.contains("/")){
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            return;
        }

        d = Double.parseDouble(s);
        double final_val = 21 * d / 20;

        DecimalFormat df = new DecimalFormat("#.##");
        final_val = Double.valueOf(df.format(final_val));

        displaySet(s, final_val);
    }

    public void performGST5sub(){
        if(s.isEmpty() || s.contains("+") || s.contains("-") || s.contains("x") || s.contains("/")){
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            return;
        }
        d = Double.parseDouble(s);
        double final_val = 20 * d / 21;

        DecimalFormat df = new DecimalFormat("#.##");
        final_val = Double.valueOf(df.format(final_val));

        displaySet(s, final_val);
    }

    public void performGST18add(){
        if(s.isEmpty() || s.contains("+") || s.contains("-") || s.contains("x") || s.contains("/")){
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            return;
        }
        d = Double.parseDouble(s);
        double final_val = 59 * d / 50;

        DecimalFormat df = new DecimalFormat("#.##");
        final_val = Double.valueOf(df.format(final_val));

        displaySet(s, final_val);
    }

    public void performGST18sub(){
        if(s.isEmpty() || s.contains("+") || s.contains("-") || s.contains("x") || s.contains("/")){
            Toast.makeText(this, "Invalid", Toast.LENGTH_SHORT).show();
            return;
        }
        d = Double.parseDouble(s);
        double final_val = 50 * d / 59;

        DecimalFormat df = new DecimalFormat("#.##");
        final_val = Double.valueOf(df.format(final_val));

        displaySet(s, final_val);
    }

    public void displaySet(String str, double final_val){
        equationBox.setText(str);
        outputBox.setText(""+final_val);
        isMathSignAdded = false;
    }

    public void displaySet(String str, int final_val){
        equationBox.setText(str);
        outputBox.setText(""+final_val);
    }

    public void initiateAllViews(){

        equationBox = findViewById(R.id.equation_box);
        outputBox = findViewById(R.id.output_box);

        buttonClear = findViewById(R.id.button_clear);
        buttonBackspace = findViewById(R.id.button_backspace);
        buttonEquals = findViewById(R.id.button_equals);
        buttonDot = findViewById(R.id.button_dot);

        buttonNine = findViewById(R.id.button_nine);
        buttonEight = findViewById(R.id.button_eight);
        buttonSeven = findViewById(R.id.button_seven);
        buttonSex = findViewById(R.id.button_sex);
        buttonFive = findViewById(R.id.button_five);
        buttonFour = findViewById(R.id.button_four);
        buttonThree = findViewById(R.id.button_three);
        buttonTwo = findViewById(R.id.button_two);
        buttonOne = findViewById(R.id.button_one);
        buttonZero = findViewById(R.id.button_zero);

        buttonPlus = findViewById(R.id.button_plus);
        buttonSubtract = findViewById(R.id.button_subtract);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonDivide = findViewById(R.id.button_divide);
        buttonAdd5 = findViewById(R.id.button_add_five_percent);
        buttonSub5 = findViewById(R.id.button_sub_five_percent);
        buttonAdd18 = findViewById(R.id.button_add_eighteen_percent);
        buttonSub18 = findViewById(R.id.button_sub_eighteen_percent);
    }

}


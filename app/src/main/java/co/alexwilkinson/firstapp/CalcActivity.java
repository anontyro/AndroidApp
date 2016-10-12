package co.alexwilkinson.firstapp;

import android.net.wifi.p2p.WifiP2pManager;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener{

    TextView output;

    Button buZero, buOne, buTwo, buThree, buFour, buFive, buSix, buSeven,
            buEight,buNine,
            buAdd, buMinus, buDivide, buTimes, buEquals, buClear;

    int firstNum, secondNum;
    String operation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        output = (TextView) findViewById(R.id.result);

        buZero = (Button)findViewById(R.id.zero);
        buZero.setOnClickListener(this);

        buOne = (Button)findViewById(R.id.one);
        buOne.setOnClickListener(this);

        buTwo = (Button)findViewById(R.id.two);
        buTwo.setOnClickListener(this);

        buThree = (Button)findViewById(R.id.three);
        buThree.setOnClickListener(this);

        buFour = (Button)findViewById(R.id.four);
        buFour.setOnClickListener(this);

        buFive = (Button)findViewById(R.id.five);
        buFive.setOnClickListener(this);

        buSix = (Button)findViewById(R.id.six);
        buSix.setOnClickListener(this);

        buSeven = (Button)findViewById(R.id.seven);
        buSeven.setOnClickListener(this);

        buEight = (Button)findViewById(R.id.eight);
        buEight.setOnClickListener(this);

        buNine = (Button)findViewById(R.id.nine);
        buNine.setOnClickListener(this);

        buEquals = (Button)findViewById(R.id.equals);
        buEquals.setOnClickListener(this);

        buClear = (Button)findViewById(R.id.clear);
        buClear.setOnClickListener(this);

        buAdd = (Button)findViewById(R.id.add);
        buAdd.setOnClickListener(this);

        buMinus = (Button)findViewById(R.id.minus);
        buMinus.setOnClickListener(this);

        buTimes = (Button)findViewById(R.id.times);
        buTimes.setOnClickListener(this);

        buDivide = (Button)findViewById(R.id.divide);
        buDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int value = view.getId();

        if(output.getText().equals("Result")){
            output.setText("");
        }

        //button control structure for calculator
        if(value == R.id.zero){
            output.append("0");
        }
        else if(value == R.id.one){
            output.append("1");
        }
        else if(value == R.id.two){
            output.append("2");
        }
        else if(value == R.id.three){
            output.append("3");

        }
        else if(value == R.id.four){
            output.append("4");

        }
        else if(value == R.id.five){
            output.append("5");

        }
        else if(value == R.id.six){
            output.append("6");

        }
        else if(value == R.id.seven){
            output.append("7");

        }
        else if(value == R.id.eight){
            output.append("8");

        }
        else if(value == R.id.nine){
            output.append("9");

        }
        else if(value== R.id.add){
            if(firstNum == 0){
                firstNum = Integer.parseInt(output.getText().toString());
                output.setText("");
                operation ="add";
            }
            else{
                secondNum = Integer.parseInt(output.getText().toString());
                output.setText(String.valueOf(firstNum+secondNum));
                firstNum = 0;
                secondNum = 0;
            }
        }
        else if(value == R.id.minus){
            if(firstNum == 0){
                firstNum = Integer.parseInt(output.getText().toString());
                output.setText("");
                operation ="minus";
            }
            else{
                secondNum = Integer.parseInt(output.getText().toString());
                output.setText(String.valueOf(firstNum-secondNum));
                firstNum = 0;
                secondNum = 0;
            }
        }
        else if(value == R.id.times){
            if(firstNum == 0){
                firstNum = Integer.parseInt(output.getText().toString());
                output.setText("");
                operation ="times";
            }
            else{
                secondNum = Integer.parseInt(output.getText().toString());
                output.setText(String.valueOf(firstNum*secondNum));
                firstNum = 0;
                secondNum = 0;
            }
        }
        else if(value == R.id.divide){
            if(firstNum == 0){
                firstNum = Integer.parseInt(output.getText().toString());
                output.setText("");
                operation ="divide";
            }
            else{
                secondNum = Integer.parseInt(output.getText().toString());
                if(secondNum == 0){
                    output.setText("ERR Divide by Zero");

                }
                else {
                    output.setText(String.valueOf(firstNum / secondNum));
                }
                firstNum = 0;
                secondNum = 0;
            }
        }
        else if(value == R.id.clear){
            output.setText("");
            firstNum = 0;
            secondNum = 0;
        }
        //equals is else
        else{
            if(operation.equals("add")){
                secondNum = Integer.parseInt(output.getText().toString());
                output.setText(String.valueOf(firstNum+secondNum));
                firstNum = 0;
                secondNum = 0;
            }
            else if(operation.equals("minus")){
                secondNum = Integer.parseInt(output.getText().toString());
                output.setText(String.valueOf(firstNum-secondNum));
                firstNum = 0;
                secondNum = 0;
            }
            else if(operation.equals("times")){
                secondNum = Integer.parseInt(output.getText().toString());
                output.setText(String.valueOf(firstNum*secondNum));
                firstNum = 0;
                secondNum = 0;
            }
            else if(operation.equals("divide")){
                secondNum = Integer.parseInt(output.getText().toString());
                if(secondNum ==0){
                    output.setText("ERR Divide by Zero");
                }
                else {
                    output.setText(String.valueOf(firstNum / secondNum));
                }
                firstNum = 0;
                secondNum = 0;
            }
        }
    }
}

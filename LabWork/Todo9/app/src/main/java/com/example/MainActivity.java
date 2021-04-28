package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = "CalculatorActivity";

    private Calculator mCalculator;

    private EditText mOperandOneEditText;
    private EditText mOperandTwoEditText;

    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCalculator = new Calculator();
        mResultTextView = (TextView) findViewById(R.id.operation_result_text_view);
        mOperandOneEditText = (EditText) findViewById(R.id.operand_one_edit_text);
        mOperandTwoEditText = (EditText) findViewById(R.id.operand_two_edit_text);
    }


    public void onAdd(View view) {
        compute(Calculator.Operator.ADD);
    }

    public void onSub(View view) {
        compute(Calculator.Operator.SUB);
    }

    public void onDiv(View view) {
        compute(Calculator.Operator.DIV);
    }


    public void onMul(View view) {
        compute(Calculator.Operator.MUL);
    }


    private void compute(Calculator.Operator operator) {
        double operandOne= mOperandOne.getText().toString();;
        double operandTwo= mOperandTwo.getText().toString();;
        String result=" ";

        switch (operator) {
            case ADD:
                result = String.valueOf(mCalculator.add(Double.valueOf(operandOne), Double.valueOf(operandTwo)));
                break;
            case SUB:
                result = String.valueOf(mCalculator.sub(Double.valueOf(operandOne), Double.valueOf(operandTwo)));
                break;
            case DIV:
                result = String.valueOf(mCalculator.div(Double.valueOf(operandOne), Double.valueOf(operandTwo)));
                break;
            case MUL:
                result = String.valueOf(mCalculator.mul(Double.valueOf(operandOne), Double.valueOf(operandTwo)));
                break;
            default:
                Log.d("Calculator","Error");
                break;
        }
        mResultTextView.setText(result);
    }
}

package com.example.test2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    private TextView displayText;
    private TextView historyText;

    private String currentInput = "";
    private String currentOperator = "";
    private double operand1 = 0;
    private boolean isNewInput = true;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText = findViewById(R.id.displayText);
        historyText = findViewById(R.id.historyText);

        setupNumberButtons();
        setupOperatorButtons();
        setupFunctionButtons();
    }

    private void setupNumberButtons() {
        int[] numberButtonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    String number = button.getText().toString();

                    if (isNewInput) {
                        currentInput = number;
                        isNewInput = false;
                    } else {
                        currentInput += number;
                    }

                    displayText.setText(currentInput);
                }
            });
        }

        // 小数点按钮
        findViewById(R.id.btnDecimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewInput) {
                    currentInput = "0.";
                    isNewInput = false;
                } else if (!currentInput.contains(".")) {
                    currentInput += ".";
                }
                displayText.setText(currentInput);
            }
        });
    }

    private void setupOperatorButtons() {
        int[] operatorButtonIds = {
                R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide
        };

        for (int id : operatorButtonIds) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    String operator = button.getText().toString();

                    if (!currentInput.isEmpty()) {
                        if (!currentOperator.isEmpty()) {
                            // 如果已经有操作符，先计算
                            calculateResult();
                        }
                        operand1 = Double.parseDouble(currentInput);
                        currentOperator = operator;
                        historyText.setText(currentInput + " " + operator);
                        isNewInput = true;
                    }
                }
            });
        }
    }

    private void setupFunctionButtons() {
        // 等号按钮
        findViewById(R.id.btnEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentOperator.isEmpty() && !currentInput.isEmpty()) {
                    calculateResult();
                    currentOperator = "";
                    historyText.setText("");
                }
            }
        });

        // 清除按钮
        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculator();
            }
        });

        // 正负号按钮
        findViewById(R.id.btnPlusMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    double value = Double.parseDouble(currentInput);
                    value = -value;
                    currentInput = String.valueOf(value);
                    displayText.setText(currentInput);
                }
            }
        });

        // 百分比按钮
        findViewById(R.id.btnPercent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!currentInput.isEmpty()) {
                    double value = Double.parseDouble(currentInput);
                    value = value / 100;
                    currentInput = String.valueOf(value);
                    displayText.setText(currentInput);
                }
            }
        });
    }

    private void calculateResult() {
        if (currentInput.isEmpty()) return;

        double operand2 = Double.parseDouble(currentInput);
        double result = 0;

        switch (currentOperator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "×":
                result = operand1 * operand2;
                break;
            case "÷":
                if (operand2 != 0) {
                    result = operand1 / operand2;
                } else {
                    displayText.setText("Error");
                    return;
                }
                break;
        }

        // 如果结果是整数，显示为整数格式
        if (result == (long) result) {
            currentInput = String.valueOf((long) result);
        } else {
            currentInput = String.valueOf(result);
        }

        displayText.setText(currentInput);
        isNewInput = true;
    }

    private void clearCalculator() {
        currentInput = "";
        currentOperator = "";
        operand1 = 0;
        isNewInput = true;
        displayText.setText("0");
        historyText.setText("");
    }
}
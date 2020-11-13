package com.example.caculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button change;
    private TextView textExp;
    private Button num0;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button sin;
    private Button cos;
    private Button ac;
    private Button equal_op;
    private Button back;
    private Button div_op;
    private Button add_op;
    private Button sub_op;
    private Button dot;
    private Button multiply_op;
    private TextView org;
    private Button left_bracket;
    private Button right_bracket;

    private Button tan;

    private void initWidgets() {
        tan =  findViewById(R.id.tan);
        left_bracket = findViewById(R.id.left_bracket);
        right_bracket = findViewById(R.id.right_bracket);
        org = findViewById(R.id.org);
        div_op =  findViewById(R.id.div_op);
        add_op =findViewById(R.id.add_op);
        sub_op = findViewById(R.id.sub_op);
        multiply_op =  findViewById(R.id.multiply_op);
        dot = findViewById(R.id.dot);
        equal_op = findViewById(R.id.equal_op);
        back = findViewById(R.id.back);
        ac = findViewById(R.id.ac);
        change =  findViewById(R.id.change);
        textExp = findViewById(R.id.text_exp);
        num0 = findViewById(R.id.num_0);
        num1 =  findViewById(R.id.num_1);
        num2 =  findViewById(R.id.num_2);
        num3 =  findViewById(R.id.num_3);
        num4 =  findViewById(R.id.num_4);
        num5 =  findViewById(R.id.num_5);
        num6 =  findViewById(R.id.num_6);
        num7 =  findViewById(R.id.num_7);
        num8 = findViewById(R.id.num_8);
        num9 = findViewById(R.id.num_9);
        sin =  findViewById(R.id.sin);
        cos =  findViewById(R.id.cos);

    }

    /**
     * 数n的阶乘
     * @param n
     * @return
     */
    private int doFactorial(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 | n == 1) {
            return 1;
        } else {
            return n * doFactorial(n - 1);
        }
    }

    private void addEventListener() {



        left_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "(");
            }
        });
        right_bracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + ")");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + ".");
            }
        });
        add_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "+");
            }
        });
        sub_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "-");
            }
        });
        multiply_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "×");
            }
        });
        div_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + "÷");
            }
        });
        equal_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (org.getText().toString().contains("^")) {
                } else {
                    String orgText = textExp.getText().toString();
                    String excuteText = orgText;
                    excuteText = excuteText.replace("÷", "/");
                    excuteText = excuteText.replace("×", "*");
                    try {
                        double res = Util.executeExpression(excuteText + "=");
                        org.setText(orgText + " = " + String.valueOf(res));
                        textExp.setText("");
                    } catch (Exception e) {
                        try {
                            double res = Double.valueOf(orgText);
                            org.setText(orgText + " = " + String.valueOf(res));
                            textExp.setText("");
                        } catch (Exception e1) {
//                            textExp.setText("");
                            Toast.makeText(MainActivity.this, "表达式输入异常", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText("");
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textExpString = textExp.getText().toString();
                if (!"".equals(textExpString)) {
                    textExp.setText(textExpString.substring(0, textExpString.length() - 1));
                }
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChangeActivity.class);
                startActivity(intent);
            }
        });
        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num0.getText().toString());
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num1.getText().toString());
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num2.getText().toString());
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num3.getText().toString());
            }
        });
        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num4.getText().toString());
            }
        });
        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num5.getText().toString());
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num6.getText().toString());
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num7.getText().toString());
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num8.getText().toString());
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textExp.setText(textExp.getText().toString() + num9.getText().toString());
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.sin(Math.toRadians(Double.valueOf(excuteData)));
                org.setText("sin(" + excuteData + ") " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.cos(Math.toRadians(Double.valueOf(excuteData)));
                org.setText("cos(" + excuteData + ") " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String excuteData = textExp.getText().toString();
                if ("".equals(excuteData) | excuteData.contains("+") | excuteData.contains("-") | excuteData.contains("×") | excuteData.contains("÷")) {
                    return;
                }
                double res = Math.tan(Math.toRadians(Double.valueOf(excuteData)));
                org.setText("tan(" + excuteData + ") " + "= " + String.format("%.1f", res));
                textExp.setText("");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidgets();
        addEventListener();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Intent intent = new Intent(MainActivity.this, OrdinaryActivity.class);
            startActivity(intent);
        }
    }
}

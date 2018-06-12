package com.st18apps.fibontest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textViewTime;
    private TextView textViewResult;
    private RadioButton radioButtonFor;
    private RadioButton radioButtonRecursion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textViewResult = findViewById(R.id.textView_result);
        textViewTime = findViewById(R.id.textView_time);
        radioButtonFor = findViewById(R.id.radioButton_for);
        radioButtonRecursion = findViewById(R.id.radioButton_recursion);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioButtonFor.isChecked()) {
                    textViewResult.setText("");
                    textViewTime.setText(R.string.time);

                    Long startTimeRecursion = System.nanoTime();
                    int fibSeries[] = fib(Integer.parseInt(editText.getText().toString()));
                    for (int i = 0; i < fibSeries.length; i++) {
                        textViewResult.setText(textViewResult.getText() + " " + fibSeries[i] + " ");
                    }
                    Long stopTimeRecursion = System.nanoTime();

                    textViewTime.setText(textViewTime.getText() + "" + (stopTimeRecursion - startTimeRecursion));

                } else {
                    textViewResult.setText("");
                    textViewTime.setText(R.string.time);

                    Long startTimeRecursion = System.nanoTime();
                    int fibSeriesRec[] = fibByRec(Integer.parseInt(editText.getText().toString()));

                    for (int i = 0; i < fibSeriesRec.length; i++) {
                        textViewResult.setText(textViewResult.getText() + " " + fibSeriesRec[i] + " ");
                    }
                    Long stopTimeRecursion = System.nanoTime();

                    textViewTime.setText(textViewTime.getText() + "" + (stopTimeRecursion - startTimeRecursion));

                }
            }
        });
    }

    public static int[] fib(int num) {
        int fibSum[] = new int[num];
        for (int i = 0; i < num; i++) {
            if (i == 0) {
                fibSum[i] = i;
                continue;
            }

            if (i == 1 || i == 2) {
                fibSum[i] = 1;
                continue;
            }

            fibSum[i] = fibSum[i - 1] + fibSum[i - 2];

        }
        return fibSum;
    }

    public static int[] fibByRec(int num) {
        int fib[] = new int[num];

        for (int i = 0; i < num; i++) {
            fib[i] = fibRec(i);
        }

        return fib;
    }

    public static int fibRec(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1 || num == 2) {
            return 1;
        } else {
            return fibRec(num - 1) + fibRec(num - 2);
        }
    }
}

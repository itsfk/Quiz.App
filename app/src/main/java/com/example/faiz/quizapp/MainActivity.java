package com.example.faiz.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
       private Button button;
       private Button button2;
       private Button button3;
      private TextView questionTextView;
    private Question[] mQuestionBank=new Question[]{
            new Question(R.string.question_cities,false),
            new Question(R.string.question_river,true),
            new Question(R.string.question_game,false),
            new Question(R.string.question_cup,false),

    };
    private int mCurrentIndex =0;
    private  void checkAnswer(boolean UserPressedTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId =0;
        if (UserPressedTrue==answerIsTrue){
            messageResId=R.string.right_toast;
        }
        else {
            messageResId=R.string.incorrect_toast;
        }
        Toast.makeText(MainActivity.this,messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
     button2=(Button)findViewById(R.id.button2);
        button3=(Button)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                int question=mQuestionBank[mCurrentIndex].getTextResid();
                questionTextView.setText(question);
            }
        });
        questionTextView=(TextView)findViewById(R.id.textView);
        int question =mQuestionBank[mCurrentIndex].getTextResid();
        questionTextView.setText(question);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkAnswer(true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               checkAnswer(false);
            }
        });
    }
}

package com.example.a01_picturequiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int currentImageIndex = 0;

    private int[] mImageNames;

    private ImageView mImageView;

    private Button mCheckButton;

    private RadioGroup mGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
        mCheckButton = findViewById(R.id.checkButton);
        mGroup = findViewById(R.id.radioGroup);

        mImageNames = new int[]{R.drawable.image1, R.drawable.image2, R.drawable.image3};


        mCheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = mGroup.getCheckedRadioButtonId();
                View radioButton = mGroup.findViewById(radioButtonID);
                int answerIndex = mGroup.indexOfChild(radioButton);
                checkAnswer (answerIndex);
            }

            private void checkAnswer(int answer) {
                String message;
                if (answer == currentImageIndex) {
                    message = "Great";
                    nextPicture();
                } else {
                    message = "Wrong";
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }

            private void nextPicture(){
                currentImageIndex++;
                if (currentImageIndex >= mImageNames.length) {
                    currentImageIndex = 0;
                }
                mImageView.setImageResource(mImageNames[currentImageIndex]);
            }

        });

    }


}

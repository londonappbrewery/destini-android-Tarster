package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button Answer1,Answer2;
    TextView Storyline;

    public void answer1(){

        Storyline.setText(R.string.T3_Story);
        Answer1.setText(R.string.T3_Ans1);
        Answer2.setText(R.string.T3_Ans2);
        //Code to story end 6 from 3
        Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hidden(Answer1);
                hidden(Answer2);
                Storyline.setText(R.string.T6_End);
                End();
            }
        });
        //code to story end 5 form 3
        Answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Storyline.setText(R.string.T5_End);
                hidden(Answer1);
                hidden(Answer2);
                End();
            }
        });


    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        Answer1=(Button) findViewById(R.id.buttonTop);
        Answer2=(Button) findViewById(R.id.buttonBottom);
        Storyline=(TextView) findViewById(R.id.storyTextView);

        Storyline.setText(R.string.T1_Story);
        Answer1.setText(R.string.T1_Ans1);
        Answer2.setText(R.string.T1_Ans2);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        //Code to story 1 answer 1

        Answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {answer1();

            }

        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        //code to story 1 answer 2
        Answer2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Storyline.setText(R.string.T2_Story);
               Answer1.setText(R.string.T2_Ans1);
               Answer2.setText(R.string.T2_Ans2);
                //code to story end from 2
               Answer2.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Storyline.setText(R.string.T4_End);
                       hidden(Answer1);
                       hidden(Answer2);
                       End();
                   }
               });
             //Code to story 2 answer 1
                Answer1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        answer1();

                    }
                });

           }
       });



    }
    private void End() {
        {
            AlertDialog.Builder Alert = new AlertDialog.Builder(this);
            Alert.setTitle("STORY OVER!!");
            Alert.setCancelable(false);
            Alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                        }
                        });

            Alert.show();

        }
                }

   private void hidden(Button button){
        ViewGroup layout = (ViewGroup) button.getParent();
        if (null != layout) //for safety only  as you are doing onClick
            layout.removeView(button);
    }
}


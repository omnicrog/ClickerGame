package uk.co.zagor666hotmail.clickergame;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Stops the back button being used
    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Never go back, Morty!", Toast.LENGTH_SHORT).show();
    }
    //Loads the main game screen
    public void goToActivity(View view) {
        Intent intent = new Intent(this,NextActivity.class);
        startActivity(intent);
    }
    //Exits the game
    public void exit_game(View view){

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog,int which){
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:finish();break;
                    case DialogInterface.BUTTON_NEGATIVE:break;
                }
            }
        };
        ContextThemeWrapper ctw = new ContextThemeWrapper(this, R.style.MyTheme);

        AlertDialog.Builder builder= new AlertDialog.Builder(ctw);
        builder.setTitle("Exit?");
        builder.setMessage("Are you sure?").setPositiveButton("Yes",dialogClickListener).setNegativeButton("No",dialogClickListener).show();
    }
}

package com.example.androidassignments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TestToolbar extends AppCompatActivity {

    private String snackbarMessage = "You selected item 1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Random text", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    
    public boolean onCreateOptionsMenu(Menu m){
        getMenuInflater().inflate(R.menu.toolbar_menu, m );
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        switch(mi.getItemId()){
            case R.id.action_one:
                Log.d("Toolbar", snackbarMessage);
                Snackbar.make(getWindow().getDecorView().getRootView() ,snackbarMessage, Snackbar.LENGTH_SHORT).setAction("Action", null).show();
                break;

            case R.id.action_two:
                Log.d("Toolbar", "Option 2 selected");
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(R.string.title);
                // Add the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK button
                        finish();
                    }
                });
                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
                // Create the AlertDialog
                AlertDialog dialog = builder.create();
                dialog.show();
                //activity
                break;
            case R.id.action_three:
                Log.d("Toolbar", "Option 3 selected");
                //activity

                AlertDialog.Builder abuilder = new AlertDialog.Builder(this);
                // Get the layout inflater
                LayoutInflater inflater = LayoutInflater.from(this);

                View view = inflater.inflate(R.layout.custom_dialog,null);

                abuilder.setView(view)

                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                EditText inputText = view.findViewById(R.id.new_message);
                                String message = inputText.getText().toString();
                                snackbarMessage = message;


                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                AlertDialog adialog = abuilder.create();
                adialog.show();


                break;
            case R.id.action_about:
                Toast toast = Toast.makeText(this.getApplicationContext(), R.string.version, Toast.LENGTH_LONG);
                toast.show();

        }
        return true;

    }




    
}
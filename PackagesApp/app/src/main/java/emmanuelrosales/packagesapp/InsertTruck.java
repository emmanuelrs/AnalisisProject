package emmanuelrosales.packagesapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import java.util.ArrayList;
import android.content.DialogInterface;


public class InsertTruck extends ActionBarActivity {

    static private ArrayList<Truck> camiones = new ArrayList<>();
    static private EditText getLength;
    static private EditText getHeight;
    static private EditText getWidth;
    static private TextView txtLength;
    static private TextView txtHeight;
    static private TextView txttWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_truck);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insert_truck, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void InsertCTipo1(){
        Truck camion = new Truck(16,30,34);
    }
    public void InsertCTipo2(){
        Truck camion = new Truck(20,40,46);

    }
    public void InsertCTipo3(){
        Truck camion = new Truck(26,46,50);

    }

    public void mensaje(){
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Truck Added");
        alertDialog.setMessage("Congratulations a new truck was added");
        alertDialog.setButton("Thank you", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();

    }

    public void getValues(View view){
        getHeight =  (EditText)findViewById(R.id.inputTuckHeight);
        getLength =  (EditText)findViewById(R.id.inputTruckLength);
        getWidth = (EditText)findViewById(R.id.inputTruckWidth);
        Truck camion = new Truck(Integer.parseInt(getLength.getText().toString()),Integer.parseInt(getWidth.getText().toString()),Integer.parseInt(getHeight.getText().toString()));
        camiones.add(camion);
        txtLength = (TextView) findViewById(R.id.inputTruckLength);
        txtLength.setText("");
        txtHeight = (TextView) findViewById(R.id.inputTuckHeight);
        txtHeight.setText("");
        txttWidth = (TextView) findViewById(R.id.inputTruckWidth);
        txttWidth.setText("");
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Truck Added");
        alertDialog.setMessage("Congratulations a new truck was added");
        alertDialog.setButton("Thank you", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    public static ArrayList<Truck> getCamiones() {
        return camiones;

    }


    public void jumpHome(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);
    }
}

package emmanuelrosales.packagesapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import emmanuelrosales.packagesapp.Truck;
import android.view.View;

import java.util.ArrayList;


public class InsertTruck extends ActionBarActivity {

    static private ArrayList<Truck> camiones = new ArrayList<>();
    static private EditText getLength;
    static private EditText getHeight;
    static private EditText getWidth;

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

    public void getValues(View view){
        getHeight =  (EditText)findViewById(R.id.inputTuckHeight);
        getLength =  (EditText)findViewById(R.id.inputTruckLength);
        getWidth = (EditText)findViewById(R.id.inputTruckWidth);
        Truck camion = new Truck(Integer.parseInt(getLength.getText().toString()),Integer.parseInt(getWidth.getText().toString()),Integer.parseInt(getHeight.getText().toString()));
        camiones.add(camion);
    }

    public static ArrayList<Truck> getCamiones() {
        return camiones;
    }
}

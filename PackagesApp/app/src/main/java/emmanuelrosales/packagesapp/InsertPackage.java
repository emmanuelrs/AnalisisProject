package emmanuelrosales.packagesapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;

import java.util.ArrayList;


public class InsertPackage extends ActionBarActivity {
    private String array_spinner[];
    static private ArrayList<Package> paquetes = new ArrayList<>();
    static private EditText getLength;
    static private EditText getHeight;
    static private EditText getWidth;
    static private EditText getDescription;
    static private EditText getDate;

    static private TextView txtLength;
    static private TextView txtHeight;
    static private TextView txttWidth;
    static private TextView txtDate;
    InsertOwner cliente = new InsertOwner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_package);
        array_spinner=new String[cliente.getClientes().size() + 1];
        array_spinner[0]="Choice a Owner";
        for(int i = 0; i < cliente.getClientes().size(); i++){
            array_spinner[ i + 1] = cliente.getClientes().get(i).getOwnerName().toString();}
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, array_spinner);
        s.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insert_package, menu);
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
    public Owner returnOwner(String name){
        Owner CNombre = null;
        for(int i = 0; i < cliente.getClientes().size();i++){
            if(cliente.getClientes().get(i).getOwnerName() == name){
                CNombre = cliente.getClientes().get(i);

            }
        }
        return CNombre;
    }

    public static ArrayList<Package> getPaquetes() {
        return paquetes;
    }

    public void getValP(View view){

       Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        String txtFromSpinner = mySpinner.getSelectedItem().toString();
        Owner duenno = returnOwner(txtFromSpinner);


        getHeight =  (EditText)findViewById(R.id.inputPHeight);
        getLength =  (EditText)findViewById(R.id.inputPLenght);
        getWidth = (EditText)findViewById(R.id.inputPHeight);
        getDescription =(EditText)findViewById(R.id.inpuPname);
        getDate = (EditText)findViewById(R.id.inputDiasEntrega);
       // Package paquete = new Package(Integer.parseInt(getLength.getText().toString()),Integer.parseInt(getWidth.getText().toString()),
         //       Integer.parseInt(getHeight.getText().toString()),Integer.parseInt(getDate.getText().toString()),duenno);
        //paquetes.add(paquete);
        txtLength = (TextView) findViewById(R.id.inputTruckLength);
        txtLength.setText("");
        txtHeight = (TextView) findViewById(R.id.inputTuckHeight);
        txtHeight.setText("");
        txttWidth = (TextView) findViewById(R.id.inputTruckWidth);
        txttWidth.setText("");
        txtDate = (TextView)findViewById(R.id.inputDiasEntrega);
        txtDate.setText("");
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Package Added");
        alertDialog.setMessage("Congratulations a new package was added");
        alertDialog.setButton("Thank You", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });

        alertDialog.show();

    }

    public void jumpHome(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);
    }
}

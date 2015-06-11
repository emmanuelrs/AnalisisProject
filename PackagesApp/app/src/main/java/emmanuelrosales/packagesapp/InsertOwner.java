package emmanuelrosales.packagesapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.app.AlertDialog;
import java.util.ArrayList;
import android.content.DialogInterface;

import java.util.ArrayList;


public class InsertOwner extends ActionBarActivity {

    static private ArrayList<Owner> clientes = new ArrayList<>();
    static private EditText getOName;
    static private EditText getOAddress;
    static private EditText getStar;
    static private EditText getEnd;
    static private EditText getTravel;

    static private TextView txtName;
    static private TextView txtAddress;
    static private TextView txtStar;
    static private TextView txtEnd;
    static private TextView txtTravel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_owner);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_insert_owner, menu);
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

    public static void setClientes(){
        Owner cliente = new Owner("Emmanuel Rosales",6,15,"Atenas",1);
        clientes.add(cliente);
        Owner cliente1 = new Owner("Miuyin Yong Wong",8,20,"Santa Ana",1);
        clientes.add(cliente1);
        Owner cliente2 = new Owner("Ernesto Lang Oreamuno",9,15,"San José Centro",1);
        clientes.add(cliente2);
        Owner cliente3 = new Owner("Cristam Flores",10,22,"Coronado",1);
        clientes.add(cliente3);
        Owner cliente4 = new Owner("Luis Serrano",5,16,"Cartago",2);
        clientes.add(cliente4);
        Owner cliente5 = new Owner("Mark Brown",10,22,"Escazú",1);
        clientes.add(cliente5);
        Owner cliente6 = new Owner("Sharik Rosales",9,21,"Alajuela",2);
        clientes.add(cliente6);
        Owner cliente7 = new Owner("Chester Yong",11,19,"Heredia",1);
        clientes.add(cliente7);
    }

    public static ArrayList<Owner> getClientes() {
        return clientes;
    }

    public void getValues(View view){
        getOName = (EditText)findViewById(R.id.inputOwnerName);
        getOAddress = (EditText)findViewById(R.id.inputAddress);
        getStar = (EditText)findViewById(R.id.inputStart);
        getEnd = (EditText)findViewById(R.id.inputEnd);
        getTravel = (EditText)findViewById(R.id.inputTravel);

        Owner cliente = new Owner(getOName.getText().toString(),Integer.parseInt(getStar.getText().toString()),
                Integer.parseInt(getEnd.getText().toString()),getOAddress.getText().toString(),
                Integer.parseInt(getTravel.getText().toString()));
        clientes.add(cliente);

        txtName = (TextView)findViewById(R.id.inputOwnerName);
        txtName.setText("");
        txtAddress = (TextView)findViewById(R.id.inputAddress);
        txtAddress.setText("");
        txtStar = (TextView)findViewById(R.id.inputStart);
        txtStar.setText("");
        txtEnd = (TextView)findViewById(R.id.inputEnd);
        txtEnd.setText("");

        txtTravel = (TextView) findViewById(R.id.inputTravel);
        txtTravel.setText("");

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Person Added");
        alertDialog.setMessage("Congratulations a new person was added");
        alertDialog.setButton("Thank you", new DialogInterface.OnClickListener() {
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

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

import java.util.ArrayList;


public class InsertPackage extends ActionBarActivity {
    private String array_spinner[];
    static private ArrayList<DeliveryPackage> paquetes = new ArrayList<DeliveryPackage>();
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

    public static ArrayList<DeliveryPackage> getPaquetes() {
        return paquetes;
    }
    public void crearPaquetesDefault(){
        InsertOwner owner_default = new InsertOwner();
        DeliveryPackage paquete = new DeliveryPackage(1,1,1,10,owner_default.getClientes().get(0));
        paquetes.add(paquete);
        DeliveryPackage paquete1 = new DeliveryPackage(2,2,2,11,owner_default.getClientes().get(1));
        paquetes.add(paquete1);
        DeliveryPackage paquete2 = new DeliveryPackage(1,2,3,5,owner_default.getClientes().get(2));
        paquetes.add(paquete2);
        DeliveryPackage paquete3= new DeliveryPackage(3,2,1,6,owner_default.getClientes().get(3));
        paquetes.add(paquete3);
        DeliveryPackage paquete4 = new DeliveryPackage(2,2,1,8,owner_default.getClientes().get(4));
        paquetes.add(paquete4);
        DeliveryPackage paquete5 = new DeliveryPackage(3,2,2,10,owner_default.getClientes().get(5));
        paquetes.add(paquete5);
        DeliveryPackage paquete6 = new DeliveryPackage(1,1,2,3,owner_default.getClientes().get(6));
        paquetes.add(paquete6);
        DeliveryPackage paquete7 = new DeliveryPackage(3,3,2,7,owner_default.getClientes().get(0));
        paquetes.add(paquete7);
        DeliveryPackage paquete8 = new DeliveryPackage(3,3,3,12,owner_default.getClientes().get(0));
        paquetes.add(paquete8);
        DeliveryPackage paquete9 = new DeliveryPackage(2,1,2,10,owner_default.getClientes().get(1));
        paquetes.add(paquete9);
        DeliveryPackage paquete10 = new DeliveryPackage(2,2,2,13,owner_default.getClientes().get(2));
        paquetes.add(paquete10);
        DeliveryPackage paquete11 = new DeliveryPackage(3,1,2,4,owner_default.getClientes().get(3));
        paquetes.add(paquete11);
        DeliveryPackage paquete12 = new DeliveryPackage(5,3,1,13,owner_default.getClientes().get(4));
        paquetes.add(paquete12);
      //  DeliveryPackage paquete13 = new DeliveryPackage(2,2,2,7,owner_default.getClientes().get(5));
      //  paquetes.add(paquete13);
      //  DeliveryPackage paquete14 = new DeliveryPackage(1,2,3,5,owner_default.getClientes().get(6));
      //  paquetes.add(paquete14);
       // DeliveryPackage paquete15 = new DeliveryPackage(5,5,5,10,owner_default.getClientes().get(0));
       // paquetes.add(paquete15);
       // DeliveryPackage paquete16 = new DeliveryPackage(4,4,4,14,owner_default.getClientes().get(1));
      //  paquetes.add(paquete16);
    }

    public void getValP(View view) {

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        String txtFromSpinner = mySpinner.getSelectedItem().toString();
        Owner duenno = returnOwner(txtFromSpinner);

        try {
            getHeight = (EditText) findViewById(R.id.inputPHeight);
            getLength = (EditText) findViewById(R.id.inputPLenght);
            getWidth = (EditText) findViewById(R.id.inputPHeight);
            getDate = (EditText) findViewById(R.id.inputDiasEntrega);
            System.out.println(getHeight.getText());
            DeliveryPackage paquete = new DeliveryPackage(Integer.parseInt(getLength.getText().toString()), Integer.parseInt(getWidth.getText().toString()),
                    Integer.parseInt(getHeight.getText().toString()), Integer.parseInt(getDate.getText().toString()), duenno);

            paquetes.add(paquete);

            txtLength = (TextView) findViewById(R.id.inputPLenght);
            txtLength.setText("");
            txtHeight = (TextView) findViewById(R.id.inputPHeight);
            txtHeight.setText("");
            txttWidth = (TextView) findViewById(R.id.inputPWidth);
            txttWidth.setText("");
            txtDate = (TextView) findViewById(R.id.inputDiasEntrega);
            txtDate.setText("");
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            alertDialog.setTitle("DeliveryPackage Added");
            alertDialog.setMessage("Congratulations a new package was added");
            alertDialog.setButton("Thank You", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.show();
        } catch (Exception E) {
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();

            alertDialog.setTitle("Error");
            alertDialog.setMessage("Sorry, there was a problem inserting the package");
            alertDialog.setButton("Thank You", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    alertDialog.dismiss();
                }
            });

            alertDialog.show();

        }
    }

    public void jumpHome(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);
    }
}
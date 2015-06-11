package emmanuelrosales.packagesapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;


public class MainActivity extends ActionBarActivity {
    public boolean bandera = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(bandera){
            InsertOwner owner = new InsertOwner();
            owner.setClientes();
            InsertPackage pack = new InsertPackage();
            pack.crearPaquetesDefault();
            InsertTruck truck = new InsertTruck();
            truck.DefaultTrucks();
            bandera = false;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void jumpInsertT(View view) {
        Intent intent = new Intent(view.getContext(), InsertTruck.class);
        startActivityForResult(intent, 0);
    }
    public void jumpViewT(View view) {
        Intent intent1 = new Intent(view.getContext(), viewTrucks.class);
        startActivityForResult(intent1, 0);
    }
    public void jumpInsertOwner(View view) {
        Intent intent2 = new Intent(view.getContext(), InsertOwner.class);
        startActivityForResult(intent2, 0);
    }
    public void jumpViewOwner(View view) {
        Intent intent2 = new Intent(view.getContext(), ViewOwner.class);
        startActivityForResult(intent2, 0);
    }
    public void jumpInsertPackage(View view) {
        Intent intent2 = new Intent(view.getContext(), InsertPackage.class);
        startActivityForResult(intent2, 0);
    }
    public void jumpViewPackage(View view) {
        Intent intent5 = new Intent(view.getContext(), ViewPackage.class);
        startActivityForResult(intent5, 0);
    }
    public void jumpViewRoute(View view) {
        Intent intent6 = new Intent(view.getContext(), Routes.class);
        startActivityForResult(intent6, 0);
    }
}

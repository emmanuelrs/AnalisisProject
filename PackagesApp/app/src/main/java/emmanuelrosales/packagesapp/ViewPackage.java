package emmanuelrosales.packagesapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.SimpleTimeZone;


public class ViewPackage extends ActionBarActivity {

    InsertPackage paquete = new InsertPackage();
    String[] letters = new String[(paquete.getPaquetes().size() * 6)];
    GridView grid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_package);

        int j = 0;
        for(int i = 0; i < paquete.getPaquetes().size(); i++){
            letters[j] = String.valueOf(paquete.getPaquetes().get(i).getNombre());
            letters[j+1] = String.valueOf((paquete.getPaquetes().get(i).getOwner().getOwnerName()));
            letters[j+2] = String.valueOf(Integer.toString(paquete.getPaquetes().get(i).getPackageHeight()));
            letters[j+3] = String.valueOf(Integer.toString(paquete.getPaquetes().get(i).getPackageLength()));
            letters[j+4] = String.valueOf(Integer.toString(paquete.getPaquetes().get(i).getPackageWidth()));
            letters[j+5] = String.valueOf(Integer.toString(paquete.getPaquetes().get(i).getDiasEntrega()));
            j = j + 6;
        }
        System.out.println(letters[1]);
        grid =(GridView) findViewById(R.id.gridViewPackage);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, letters);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_package, menu);
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
    public void jumpHome(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);
    }
}

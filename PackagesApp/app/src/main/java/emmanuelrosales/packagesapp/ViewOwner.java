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


public class ViewOwner extends ActionBarActivity {

    InsertOwner cliente = new InsertOwner();
    String[] letters = new String[(cliente.getClientes().size() * 5)];
    GridView grid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_owner);

        int j = 0;
        for(int i = 0; i < cliente.getClientes().size(); i++){
            letters[j] = String.valueOf(cliente.getClientes().get(i).getOwnerName());
            letters[j+1] = String.valueOf(cliente.getClientes().get(i).getAddress());
            letters[j+2] = String.valueOf(String.valueOf(cliente.getClientes().get(i).getStartAvailablity()));
            letters[j+3] = String.valueOf(String.valueOf(cliente.getClientes().get(i).getEndAvailablity()));
            letters[j+4] = String.valueOf(cliente.getClientes().get(i).getTravelTime());
            j = j + 5;
        }

        grid = (GridView) findViewById(R.id.gridViewOwners);
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
        getMenuInflater().inflate(R.menu.menu_view_owner, menu);
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
    }public void jumpHomeO(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent, 0);
    }

}

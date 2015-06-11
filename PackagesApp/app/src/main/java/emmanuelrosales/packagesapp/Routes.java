package emmanuelrosales.packagesapp;

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

import java.util.ArrayList;

import BackEnd.*;


public class Routes extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        InsertPackage paquete = new InsertPackage();
        ArrayList<DeliveryPackage> totalPackages = paquete.getPaquetes();
        InsertOwner owner = new InsertOwner();
        ArrayList<Owner> totalOwner = owner.getClientes();
        InsertTruck Trucks = new InsertTruck();
        ArrayList<Truck> totalTrucks = Trucks.getCamiones();
        Truck truck;
        Individual individual;
        GridView grid;
        String[] letters = new String[5];
        letters[0] = "A";
        letters[1] = "B";
        letters[2] = "C";
        letters[3] = "D";
        letters[4] = "E";

        int truckCounter = 0;
        int indexLetter = 0;
        while(!totalPackages.isEmpty() && truckCounter < totalTrucks.size()){
            truck = totalTrucks.get(truckCounter);
            truck.organizeOwner(totalPackages);
            letters[indexLetter] = Integer.toString(truckCounter);
            System.out.println("-------------I--------------------------");

            truck.setPackagesToDeliver(totalPackages);
            truck.greedy(totalPackages.size());
            totalPackages = truck.getPossibleDeliveries();

            Population population = new Population(totalPackages);
            population.generatePopulation(15, totalPackages.size(), true, truck);

            System.out.println("---------------------------------");
            System.out.println("Paquetes para meter al camion: " + totalPackages.size());
            System.out.println("length: " + truck.getContainerLength());
            System.out.println("width: " +  truck.getContainerWidth());
            System.out.println("height: " + truck.getContainerHeight());

            int i = 0;
            if(totalPackages.size() > 1){
                while(i < 50){
                    population.generatePopulation(15, totalPackages.size(), false, truck);
                    i++;
                }
            }
            System.out.println(population.returnBestCandidate().getChromosome());
            System.out.println("Paquetes en el camion: " + population.returnBestCandidate().getFitness());
            individual = population.returnBestCandidate();
            individual.eliminatePackages(totalPackages);
            truck.addPackages(totalPackages);
            truckCounter++;
        }
        System.out.println("--------------------------------");
        System.out.println("Camiones utilizados: " + (truckCounter));
        if(!totalPackages.isEmpty()){
            System.out.println("No todos los paquetes se pudieron entregar en un dia.");
        }
        grid = (GridView) findViewById(R.id.gridViewRoutes);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, letters);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
            }
        });


        // Configuración Grid





        //----
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_routes, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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
    }
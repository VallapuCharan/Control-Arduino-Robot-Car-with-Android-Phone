package com.boxsand.udaybhasker.sandbox;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

import android.widget.TextView;
import android.content.Intent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;


import java.io.OutputStream;

import java.util.Set;
import java.util.ArrayList;
import java.lang.String;

public class MainActivity extends AppCompatActivity {

    ListView devicelist;
    ImageView B1;
    private BluetoothAdapter myblue = null;
    private Set<BluetoothDevice> pairedDevices;
    private OutputStream outstream = null;
    public static String EXTRA_ADDRESS = "device_address";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        devicelist=(ListView)findViewById(R.id.LV1);
        B1=(ImageView)findViewById(R.id.B1);
        myblue = BluetoothAdapter.getDefaultAdapter();
        if(myblue==null)
        {

            Toast.makeText(getApplicationContext(),"Bluetooth Device not available.",Toast.LENGTH_LONG).show();
            finish();
        }
        else
        {
            if(myblue.isEnabled()){}
            else
            {
                Intent turnOnBlue = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(turnOnBlue, 1);
            }
        }


    }
    public void pairedDevicesList(View v){

        pairedDevices= myblue.getBondedDevices();
        ArrayList list = new ArrayList();

        if (pairedDevices.size()>0)
        {
            for(BluetoothDevice bt : pairedDevices)
            {
                list.add(bt.getName() + "\n" + bt.getAddress()); //Get the device's name and the address
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(), "No Paired Bluetooth Devices Found.", Toast.LENGTH_LONG).show();
        }


        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list);
        devicelist.setAdapter(adapter);
        devicelist.setOnItemClickListener(myListClickListener); //Method called when the device from the list is clicked
    }
    private AdapterView.OnItemClickListener myListClickListener= new AdapterView.OnItemClickListener()
    {

        public void onItemClick(AdapterView<?>av, View v, int arg2, long arg3)
        {
// Get the device MAC address, the last 17 chars in the View
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);

// Make an intent to start next activity.
            Intent i = new Intent(MainActivity.this, Ledctrl.class);

//Change the activity.
            i.putExtra(EXTRA_ADDRESS, address); //this will be received at ledControl (class) Activity
            startActivity(i);
        }
    };
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
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

//noinspectionSimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

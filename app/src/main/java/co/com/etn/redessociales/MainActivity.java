package co.com.etn.redessociales;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{

    Spinner main_spinner_sync;
    CheckBox main_checkbox_notification;
    Button main_button_cerrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_spinner_sync = (Spinner) findViewById(R.id.main_spinner_sync);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this,R.array.main_spinner_sync,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        main_spinner_sync.setAdapter(adapter);
        main_spinner_sync.setOnItemSelectedListener(this);
        main_checkbox_notification = (CheckBox) findViewById(R.id.main_checkbox_notification);
        main_button_cerrar=(Button)findViewById(R.id.main_button_cerrar);
        main_checkbox_notification.setOnClickListener(this);
        main_button_cerrar.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String sync = (String)adapterView.getSelectedItem();
        Toast.makeText(this, getResources().getString(R.string.main_textview_sync)+sync, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_checkbox_notification:
                    Toast.makeText(this, getResources().getString(R.string.main_textview_notification)+main_checkbox_notification.isChecked(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_button_cerrar:
                Toast.makeText(this, getResources().getString(R.string.main_string_despedida)+" "+getResources().getString(R.string.main_textview_user), Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}

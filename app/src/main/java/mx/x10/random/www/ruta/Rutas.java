package mx.x10.random.www.ruta;

import android.location.Location;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Rutas extends AppCompatActivity {

    EditText tbLatitud;
    EditText tbLongitud;
    Button btnActualizar;
    Location lastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);

        tbLatitud = (EditText) findViewById(R.id.tbLatitud);
        tbLongitud = (EditText) findViewById(R.id.tbLongitud);
        btnActualizar = (Button) findViewById(R.id.btnActualizar);
    }

    private void updateUI(Location loc) {
        if (loc != null) {
            tbLatitud.setText("Latitud: " + String.valueOf(loc.getLatitude()));
            tbLongitud.setText("Longitud: " + String.valueOf(loc.getLongitude()));
        } else {
            tbLatitud.setText("Latitud: (desconocida)");
            tbLongitud.setText("Longitud: (desconocida)");
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        //Conectado correctamente a Google Play Services

        //...

        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(apiClient);

        updateUI(lastLocation);

        //...
    }

    @Override
    public void onConnectionSuspended(int i) {
        //Se ha interrumpido la conexión con Google Play Services

        Log.e(LOGTAG, "Se ha interrumpido la conexión con Google Play Services");
    }
}

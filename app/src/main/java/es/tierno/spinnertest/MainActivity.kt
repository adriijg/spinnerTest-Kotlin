package es.tierno.spinnertest

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// Versión con GridView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Versión con ListView
        // val lv: ListView = findViewById(R.id.listView)
        // lv.adapter = getAdapter()

        // Versión con Spinner
        // val sp: Spinner = findViewById(R.id.spinner)
        // sp.adapter = getAdapter()

        val gv: GridView = findViewById(R.id.gridView)
        gv.adapter = getAdapter()
        gv.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(view?.context, "Seleccionado $position", Toast.LENGTH_SHORT).show()
            }

            // Versión mostrando por pantalla la opción seleccionada
//            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
//                val ciudadSeleccionada = parent?.getItemAtPosition(position).toString()
//                Toast.makeText(view?.context, "Seleccionado: $ciudadSeleccionada", Toast.LENGTH_SHORT).show()
//            }
        }
    }

    fun getAdapter(): ArrayAdapter<String> {
        val ciudades = arrayOf("Parla", "Pinto", "Valdemoro")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, ciudades)
        return adapter;
    }
}

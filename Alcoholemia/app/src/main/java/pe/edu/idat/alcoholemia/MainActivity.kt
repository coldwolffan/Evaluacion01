package pe.edu.idat.alcoholemia

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextAlcoholLevel = findViewById<EditText>(R.id.editTextAlcoholLevel)
        val spinnerVehicleType = findViewById<Spinner>(R.id.spinnerVehicleType)
        val buttonCheck = findViewById<Button>(R.id.buttonCheck)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        val vehicleTypes = resources.getStringArray(R.array.vehicle_types)
        val alcoholLimits = mapOf(
            "Camión" to 0.3,
            "Autobús" to 0.3,
            "Turismo" to 0.5,
            "Motocicleta" to 0.3
        )

        buttonCheck.setOnClickListener {
            val alcoholLevel = editTextAlcoholLevel.text.toString().toDoubleOrNull()
            val vehicleType = spinnerVehicleType.selectedItem.toString()

            if (alcoholLevel == null) {
                textViewResult.text = "Por favor, ingrese una tasa de alcohol válida."
                return@setOnClickListener
            }

            val limit = alcoholLimits[vehicleType] ?: 0.0
            if (alcoholLevel > limit) {
                textViewResult.text = "Positivo en el control de alcoholemia para $vehicleType."
            } else {
                textViewResult.text = "Negativo en el control de alcoholemia para $vehicleType."
            }
        }
    }
}

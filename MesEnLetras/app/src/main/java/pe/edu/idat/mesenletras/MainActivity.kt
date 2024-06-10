package pe.edu.idat.mesenletras

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputMonthNumber = findViewById<EditText>(R.id.inputMonthNumber)
        val buttonShowMonth = findViewById<Button>(R.id.buttonShowMonth)
        val textMonthName = findViewById<TextView>(R.id.textMonthName)

        buttonShowMonth.setOnClickListener {
            val monthNumberStr = inputMonthNumber.text.toString()
            if (monthNumberStr.isNotEmpty()) {
                val monthNumber = monthNumberStr.toIntOrNull()
                if (monthNumber != null && monthNumber in 1..12) {
                    val monthName = getMonthName(monthNumber)
                    textMonthName.text = monthName
                } else {
                    Toast.makeText(this, "Por favor ingrese un número válido entre 1 y 12", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor ingrese un número", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getMonthName(month: Int): String {
        return when (month) {
            1 -> "Enero"
            2 -> "Febrero"
            3 -> "Marzo"
            4 -> "Abril"
            5 -> "Mayo"
            6 -> "Junio"
            7 -> "Julio"
            8 -> "Agosto"
            9 -> "Septiembre"
            10 -> "Octubre"
            11 -> "Noviembre"
            12 -> "Diciembre"
            else -> ""
        }
    }
}

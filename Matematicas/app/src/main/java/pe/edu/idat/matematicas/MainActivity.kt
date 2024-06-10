package pe.edu.idat.matematicas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1EditText = findViewById<EditText>(R.id.number1)
        val number2EditText = findViewById<EditText>(R.id.number2)
        val computeButton = findViewById<Button>(R.id.computeButton)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        computeButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toIntOrNull()
            val number2 = number2EditText.text.toString().toIntOrNull()

            if (number1 != null && number2 != null) {
                val result = when {
                    number1 == number2 -> number1 * number2
                    number1 > number2 -> number1 - number2
                    else -> number1 + number2
                }
                resultTextView.text = "Resultado: $result"
            } else {
                resultTextView.text = "Por favor, ingrese números válidos."
            }
        }
    }
}

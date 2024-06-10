package pe.edu.idat.sumadedigitos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultTextView: TextView = findViewById(R.id.resultTextView)

        var result = ""

        for (number in 23..99) {

            val sumOfDigits = sumDigits(number)

            result += "Número: $number, Suma de dígitos: $sumOfDigits\n"
        }

        resultTextView.text = result
    }

    private fun sumDigits(number: Int): Int {
        val digits = number.toString().map { it.toString().toInt() }
        return digits.sum()
    }
}


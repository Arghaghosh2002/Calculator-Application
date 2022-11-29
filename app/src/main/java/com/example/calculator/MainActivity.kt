package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import org.mariuszgromada.math.mxparser.Expression
import java.lang.StringBuilder
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    var check = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClear.setOnClickListener {
            binding.inputnumber.text = ""
            binding.result.text = ""
        }
        binding.button0.setOnClickListener {
            binding.inputnumber.append("0")
        }
        binding.button1.setOnClickListener {
            binding.inputnumber.append("1")
        }
        binding.button2.setOnClickListener {
            binding.inputnumber.append("2")
        }
        binding.button3.setOnClickListener {
            binding.inputnumber.append("3")
        }
        binding.button4.setOnClickListener {
            binding.inputnumber.append("4")
        }
        binding.button5.setOnClickListener {
            binding.inputnumber.append("5")
        }
        binding.button6.setOnClickListener {
            binding.inputnumber.append("6")
        }
        binding.button7.setOnClickListener {
            binding.inputnumber.append("7")
        }
        binding.button8.setOnClickListener {
            binding.inputnumber.append("8")
        }
        binding.button9.setOnClickListener {
            binding.inputnumber.append("9")
        }
        binding.buttonDot.setOnClickListener {
            binding.inputnumber.append(".")
        }
        binding.buttonPlus.setOnClickListener {
            binding.inputnumber.append(" + ")
        }
        binding.buttonMinus.setOnClickListener {
            binding.inputnumber.append(" - ")
        }
        binding.buttonMultiply.setOnClickListener {
            binding.inputnumber.append(" * ")
        }
        binding.buttonDivide.setOnClickListener {
            binding.inputnumber.append(" / ")
        }
        binding.buttonPercent.setOnClickListener {
            binding.inputnumber.append(" 00 ")
        }


        binding.buttonBackspace.setOnClickListener {
            var backspace: String? = null
            if (binding.inputnumber.text.isNotEmpty()) {
                val stringBuilder: StringBuilder = StringBuilder(binding.inputnumber.text)
                val find = binding.inputnumber.text.toString()
                val find2 = find.last()

                if (find2.equals('+') || find2.equals('-') || find2.equals('*') || find2.equals('/')) {
                    check = check - 1
                }
                stringBuilder.deleteCharAt(binding.inputnumber.text.length - 1)
                backspace = stringBuilder.toString()
                binding.inputnumber.setText(backspace)
            }
            binding.result.text = ""
        }
        binding.buttonEqual.setOnClickListener {
            try {
                val expression = getInputExpression()
                val output = Expression(expression).calculate()
                if (output.isNaN()) {
                    Toast.makeText(this, "Please Enter Valid Numbers", Toast.LENGTH_SHORT).show()
                } else {
                   binding.result.text= DecimalFormat("0.######").format(output).toString()
                    binding.result.setTextColor(ContextCompat.getColor(this, R.color.aqua))
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Please Enter Valid Numbers", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun getInputExpression(): String {
        var expression =binding.inputnumber.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }
}





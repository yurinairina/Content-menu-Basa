package com.example.contextmenu
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    private lateinit var textET: EditText
    private lateinit var randomNumberBTN: Button
    private var isRandomButtonClick: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textET = findViewById(R.id.textET)
        registerForContextMenu(textET)

        randomNumberBTN = findViewById(R.id.randomNumberBTN)
        randomNumberBTN.setOnClickListener {
            val getRandom = (1..50).random()
            textET.setText(getRandom.toString())
            isRandomButtonClick = true

        }

        textET.setOnClickListener{
            textET.text.clear()
            textET.setBackgroundColor(getColor(R.color.white))
            isRandomButtonClick = false

        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_change_color -> {
                if (!isRandomButtonClick) {
                    when (textET.text.toString()) {
                        "1" -> {
                            textET.setBackgroundColor(resources.getColor(R.color.orange))
                            Toast.makeText(this, "1-ОРАНЖЕВЫЙ", Toast.LENGTH_SHORT).show()
                        }
                        "2" -> {
                        textET.setBackgroundColor(resources.getColor(R.color.yellow))
                            Toast.makeText(this, "2-ЖЕЛТЫЙ", Toast.LENGTH_LONG).show()
                        }
                        "3" -> {
                            textET.setBackgroundColor(resources.getColor(R.color.green))
                            Toast.makeText(this, "3-ЗЕЛЕНЫЙ", Toast.LENGTH_LONG).show()
                        }
                        "4" -> {
                            textET.setBackgroundColor(resources.getColor(R.color.blue))
                            Toast.makeText(this, "4-СИНИЙ", Toast.LENGTH_LONG).show()
                        }
                        "5" -> {
                            textET.setBackgroundColor(resources.getColor(R.color.red))
                            Toast.makeText(this, "5-КРАСНЫЙ", Toast.LENGTH_LONG).show()
                        }
                        else -> {
                            textET.setBackgroundColor(getColor(R.color.white))
                            Toast.makeText(this, getString(R.string.text_mode), Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
                } else{
                    if (textET.text.toString().toInt() in 1..10) {
                        textET.setBackgroundColor(resources.getColor(R.color.red))
                    } else if (textET.text.toString().toInt() in 11..20) {
                        textET.setBackgroundColor(resources.getColor(R.color.orange))
                    } else if(textET.text.toString().toInt() in 21..30)  {
                        textET.setBackgroundColor(resources.getColor(R.color.yellow))
                    } else if(textET.text.toString().toInt() in 31..40){
                        textET.setBackgroundColor(resources.getColor(R.color.green))
                    } else if (textET.text.toString().toInt() in 41..50){
                        textET.setBackgroundColor(resources.getColor(R.color.blue))
                    } else {
                        textET.setBackgroundColor(resources.getColor(R.color.white))
                        Toast.makeText(
                            this,
                            getString(R.string.random_button), Toast.LENGTH_SHORT
                        ).show()
                    }
                }
                if (isRandomButtonClick) {
                    Toast.makeText(
                        this,
                        getString(R.string.numero_random), Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        this,
                        getString(R.string.application_text), Toast.LENGTH_SHORT
                    ).show()
                }
            }
            R.id.menu_exitMenuMain -> {
                finish()
                Toast.makeText(this, getString(R.string.exsit), Toast.LENGTH_SHORT).show()
            }
            else -> return super.onContextItemSelected(item)
        }
        return true
    }
}


//    private lateinit var textET: EditText
//    private lateinit var randomNumberBTN: Button
//    private var isRandomButtonClick: Boolean = false
//
//    @SuppressLint("MissingInflatedId", "SetTextI18n")
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//        textET = findViewById(R.id.textET)
//        registerForContextMenu(textET)
//        randomNumberBTN = findViewById(R.id.randomNumberBTN)
//        randomNumberBTN.setOnClickListener {
//            val getRandom = (1..50).random()
//            textET.setText(getRandom.toString())
//            isRandomButtonClick = true
//
//        }
//        textET.setOnClickListener {
//            textET.text.clear()
//            textET.setBackgroundColor(getColor(R.color.white))
//            isRandomButtonClick = false
//        }
//    }
//
//    override fun onCreateContextMenu(
//        menu: ContextMenu?,
//        v: View?, menuInfo: ContextMenu.ContextMenuInfo?
//    ) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        menuInflater.inflate(R.menu.context_menu, menu)
//    }
//
//
//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.menu_change_color -> {
//                val estimation = textET.text.toString()
//                when (estimation) {
//                    "1" -> {
//                        textET.setBackgroundColor(resources.getColor(R.color.orange))
//                        Toast.makeText(this, "1-ОРАНЖЕВЫЙ", Toast.LENGTH_LONG).show()
//                    }
//
//                    "2" -> {
//                        textET.setBackgroundColor(resources.getColor(R.color.yellow))
//                        Toast.makeText(this, "2-ЖЕЛТЫЙ", Toast.LENGTH_LONG).show()
//                    }
//
//                    "3" -> {
//                        textET.setBackgroundColor(resources.getColor(R.color.green))
//                        Toast.makeText(this, "3-ЗЕЛЕНЫЙ", Toast.LENGTH_LONG).show()
//                    }
//
//                    "4" -> {
//                        textET.setBackgroundColor(resources.getColor(R.color.blue))
//                        Toast.makeText(this, "4-СИНИЙ", Toast.LENGTH_LONG).show()
//                    }
//
//                    "5" -> {
//                        textET.setBackgroundColor((resources.getColor(R.color.red)))
//                        Toast.makeText(this, "5-КРАСНЫЙ", Toast.LENGTH_LONG).show()
//                    }
//
//                   else -> {
//                        textET.setBackgroundColor(null)
//                        Toast.makeText(this, "неформат $estimation", Toast.LENGTH_LONG).show()
//                    }
//                }
//           }
//
//            R.id.menu_exitMenuMain -> {
//               Toast.makeText(
//                    applicationContext,
//                    "Работа завершена",
//                   Toast.LENGTH_LONG
//               ).show()
//                finish()
//           }
//
//            else -> return super.onContextItemSelected(item)
//
//       }
//        return true
//            }
//        }
//
//
//
//        if (textET.text.toString().toInt() in 6..10) {
//            textET.setBackgroundColor(getColor(R.color.red))
//            // Toast.makeText(this, "Диапазон чисел -КРАСНЫЙ", Toast.LENGTH_LONG).show()
//        } else if (textET.text.toString().toInt() in 11..20) {
//            textET.setBackgroundColor(getColor(R.color.orange))
//            // Toast.makeText(this, "Диапазон чисел -ОРАНЖЕВЫЙ", Toast.LENGTH_LONG).show()
//        } else if (textET.text.toString().toInt() in 21..30) {
//            textET.setBackgroundColor(getColor(R.color.yellow))
//            Toast.makeText(this, "Диапазон чисел -ЖЕЛТЫЙ", Toast.LENGTH_LONG).show()
//        } else if (textET.text.toString().toInt() in 31..40) {
//            textET.setBackgroundColor(getColor(R.color.green))
//            Toast.makeText(this, "Диапазон чисел -ЗЕЛЕНЫЙ", Toast.LENGTH_LONG).show()
//        } else if (textET.text.toString().toInt() in 41..50) {
//            textET.setBackgroundColor(getColor(R.color.blue))
//            Toast.makeText(this, "Диапазон чисел - СИНИЙ", Toast.LENGTH_LONG).show()
//        } else if (textET.text.toString().toInt() in 50..1000) {
//            textET.setBackgroundColor(getColor(R.color.grey))
//            Toast.makeText(this, "Диапазон чисел - СЕРЫЙ", Toast.LENGTH_LONG).show()
//        } else {
//            textET.setBackgroundColor(getColor(R.color.white))
//            Toast.makeText(
//                this,
//                getString(R.string.no_text), Toast.LENGTH_SHORT
//            ).show()
//        }
//        if (isRandomButtonClick) {
//            Toast.makeText(
//                this,
//                getString(R.string.random_button), Toast.LENGTH_SHORT
//            ).show()
//        } else {
//            Toast.makeText(
//                this,
//                getString(R.string.text_input_mode), Toast.LENGTH_SHORT
//            ).show()
//        }
//
//
//        return true
//    }
//}


//Toast.makeText(this, "Меняем размер шрифта", Toast.LENGTH_LONG).show()


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets



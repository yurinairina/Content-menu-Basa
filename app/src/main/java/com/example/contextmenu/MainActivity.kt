package com.example.contextmenu

import android.annotation.SuppressLint
import android.content.ClipData
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var textET: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textET = findViewById(R.id.textET)
        registerForContextMenu(textET)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
       menuInflater.inflate(R.menu.context_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
           R.id.menu_change_color -> {
                 textET.setBackgroundColor(Color.RED)
                Toast.makeText(this, "Меняем цвет", Toast.LENGTH_LONG).show()

            }
            R.id.menu_change_text_size-> {
               textET.textSize = 24F
                Toast.makeText(this, "Меняем размер шрифта", Toast.LENGTH_LONG).show()

            }
            else -> return super.onContextItemSelected(item)
        }

        return true

    }


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
        }


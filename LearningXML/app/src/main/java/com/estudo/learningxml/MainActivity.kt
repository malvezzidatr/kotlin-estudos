package com.estudo.learningxml

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var myText: TextView
    lateinit var myButton1: Button
    lateinit var myButton2: Button

    lateinit var nameText: TextView

    lateinit var name: EditText

    lateinit var ok: Button

    lateinit var image: ImageView

    lateinit var showToastButton: Button
    lateinit var showSnackbarButton: Button
    lateinit var mainLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        showToastButton = findViewById(R.id.show_toast)
        showSnackbarButton = findViewById(R.id.show_snackbar)
        mainLayout = findViewById(R.id.main)
        myText = findViewById(R.id.textExample)
        myButton1 = findViewById(R.id.buttonExample1)
        myButton2 = findViewById(R.id.buttonExample2)
        myText.setTextColor(Color.YELLOW)
        myText.setText("This is an example")
        myText.setOnClickListener {
            myText.setTextColor(Color.GREEN)
        }

        myButton1.setOnClickListener {
            myButton1.setBackgroundColor(Color.BLACK)
            myText.setText("Button 1 has clicked")
            myText.isVisible = false
            myButton1.isVisible = false
        }

        myButton2.setOnClickListener {
            myText.isVisible = true
            myButton1.isVisible = true
        }

        ok = findViewById(R.id.confirm_button)
        nameText = findViewById(R.id.text_confirm)
        name = findViewById(R.id.edit_text)
        image = findViewById(R.id.imageView)

        ok.setOnClickListener {
            var userName: String = name.text.toString()
            nameText.setText(userName)
            image.setImageResource(R.drawable.image2)
        }

        showToastButton.setOnClickListener {
            Toast.makeText(applicationContext, "This is a toast message!", Toast.LENGTH_LONG).show()
        }

        showSnackbarButton.setOnClickListener {
            Snackbar
                .make(
                    mainLayout,
                    "This is a snackbar message",
                    Snackbar.LENGTH_INDEFINITE)
                .setAction("Close", View.OnClickListener {})
                .show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
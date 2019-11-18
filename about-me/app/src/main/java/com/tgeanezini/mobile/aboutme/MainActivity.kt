package com.tgeanezini.mobile.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.tgeanezini.mobile.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Tiago Geanezini")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val nicknameText = findViewById<TextView>(R.id.nickname_text)
//        val nicknameEdit = findViewById<EditText>(R.id.nickname_edit)

        binding.apply {
            //nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            view.visibility = View.GONE
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

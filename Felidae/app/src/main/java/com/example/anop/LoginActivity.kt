package com.example.anop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.anop.databinding.ActivityLoginBinding
import com.example.anop.databinding.ActivityPenjadwalanTugasBinding


class LoginActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener {

    private lateinit var mBinding: ActivityLoginBinding
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        mBinding.usernameEdt.onFocusChangeListener = this
        mBinding.passwordEdt.onFocusChangeListener = this

        etUsername = findViewById(R.id.username_edt)
        etPassword = findViewById(R.id.password_edt)

        val bundle = intent.extras
        if (bundle != null){
            etUsername.setText(bundle.getString("username"))
            etPassword.setText(bundle.getString("password"))
        }

        val btnLogin: Button = findViewById(R.id.login_btn)
        btnLogin.setOnClickListener(this)
    }

    private fun validateFullName(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.usernameEdt.text.toString()
        if (value.isEmpty()){
            errorMessage = "Invalid Username"
        }

        if (errorMessage != null){
            mBinding.etUsername.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }

    private fun validatePassword(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.passwordEdt.text.toString()
        if (value.isEmpty()) {
            errorMessage = "Invalid password"

        } else if (value.length < 6) {
            errorMessage = "Password must be 6 characters long"
        } else if (!value.matches(".*[A-Z].*".toRegex())) {
            errorMessage = "Must contain 1 upper-case character"
        } else if (!value.matches(".*[a-z].*".toRegex())) {
            errorMessage = "Must contain 1 lower-case character"
        } else if (!value.matches(".*[@#/$%^=+].*".toRegex())) {
            errorMessage = "Must contain 1 special character (@#/$%^=+)"
        } else if (!value.matches(".*[0123456789].*".toRegex())) {
            errorMessage = "Must contain 1 number character (0123456789)"
        }

        if (errorMessage != null){
            mBinding.etPassword.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }


    override fun onClick(view: View?) {



        when(view?.id){
            R.id.login_btn -> {
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivities(arrayOf(intent))
            }
        }
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {

        if (view != null){
            when(view.id){
                R.id.username_edt -> {
                    if (hasFocus){
                        if (mBinding.etUsername.isErrorEnabled){
                            mBinding.etUsername.isErrorEnabled = false
                        }
                    }else{
                        validateFullName()
                    }
                }
                R.id.password_edt -> {
                    if (hasFocus){
                        if (mBinding.etPassword.isErrorEnabled){
                            mBinding.etPassword.isErrorEnabled = false
                        }
                    }else{
                        validatePassword()
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }


}
package com.example.anop

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import com.example.anop.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener, View.OnFocusChangeListener, View.OnKeyListener
{

    private lateinit var mBinding: ActivityRegisterBinding
    private lateinit var etEmail: EditText
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)
        mBinding.emailEdt.onFocusChangeListener = this
        mBinding.usernameEdt.onFocusChangeListener = this
        mBinding.passwordEdt.onFocusChangeListener = this
        mBinding.konfirmasiEdt.onFocusChangeListener = this

        val items = listOf<String>("Siswa", "Mahasiswa", "Pekerja Kantoran", "Lainnya")
        val adapter = ArrayAdapter(this, R.layout.list_dropdown1, items)
        mBinding.dropdownField.setAdapter(adapter)

        etUsername = findViewById(R.id.username_edt)
        etEmail = findViewById(R.id.email_edt)
        etPassword = findViewById(R.id.password_edt)

        val btnRegist: Button = findViewById(R.id.btn_regist)
        btnRegist.setOnClickListener(this)
    }

    private fun validateEmail(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.emailEdt.text.toString()
        if (value.isEmpty()) {
            errorMessage = "Email is required"
        } else if (!Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            errorMessage = "Email Address is invalid"
        }

        if (errorMessage != null){
            mBinding.etEmail.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }

    private fun validateFullName(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.usernameEdt.text.toString()
        if (value.isEmpty()){
            errorMessage = "Username is required"
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
            errorMessage = "Password is required"
        } else if (value.length < 6) {
            errorMessage = "Password must be 6 characters long"
        } else if (!value.matches(".*[A-Z].*".toRegex())) {
            errorMessage = "Must contain 1 upper-case character"
        } else if (!value.matches(".*[a-z].*".toRegex())) {
            errorMessage = "Must contain 1 lower-case character"
        } else if (!value.matches(".*[@#/$%^=+].*".toRegex())) {
            errorMessage = "Must contain 1 special character (@#/$%^=+)"
        }else if (!value.matches(".*[0123456789].*".toRegex())) {
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

    private fun validateConfirmPass(): Boolean {
        var errorMessage: String? = null
        val value: String = mBinding.konfirmasiEdt.text.toString()
        if (value.isEmpty()) {
            errorMessage = "Confirm password is required"
        } else if (value.length < 6) {
            errorMessage = "Confirm password must be 6 characters long"
        }

        if (errorMessage != null){
            mBinding.etKonfirmasi.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }

    private fun validatePasswordAndConfirmPass(): Boolean{
        var errorMessage: String? = null
        val password = mBinding.passwordEdt.text.toString()
        val confirmPassword = mBinding.konfirmasiEdt.text.toString()
        if (password != confirmPassword){
            errorMessage = "Confirm Password doesn't match with Password"
        }

        if (errorMessage != null){
            mBinding.etKonfirmasi.apply {
                isErrorEnabled = true
                error = errorMessage
            }
        }

        return errorMessage == null
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn_regist -> {

                val bundle = Bundle()
                bundle.putString("username", etUsername.text.toString())
                bundle.putString("password", etPassword.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivities(arrayOf(intent))
            }
        }
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if (view != null){
            when(view.id){
                R.id.email_edt -> {
                    if (hasFocus){
                        if (mBinding.etEmail.isErrorEnabled){
                            mBinding.etEmail.isErrorEnabled = false
                        }
                    }else{
                        validateEmail()
                    }
                }
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
                        if (validatePassword() && mBinding.konfirmasiEdt.text!!.isNotEmpty() && validateConfirmPass()
                            && validatePasswordAndConfirmPass()){
                            if (mBinding.etKonfirmasi.isErrorEnabled){
                                mBinding.etKonfirmasi.isErrorEnabled = false
                            }
                            mBinding.etKonfirmasi.apply {
                                setStartIconDrawable(R.drawable.check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
                R.id.konfirmasi_edt -> {
                    if (hasFocus){
                        if (mBinding.etKonfirmasi.isErrorEnabled){
                            mBinding.etKonfirmasi.isErrorEnabled = false
                        }
                    }else{
                        if (validateConfirmPass() && validatePassword() && validatePasswordAndConfirmPass()){
                            if (mBinding.etPassword.isErrorEnabled){
                                mBinding.etPassword.isErrorEnabled = false
                            }
                            mBinding.etKonfirmasi.apply {
                                setStartIconDrawable(R.drawable.check_circle_24)
                                setStartIconTintList(ColorStateList.valueOf(Color.GREEN))
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onKey(view: View?, event: Int, keyEvent: KeyEvent?): Boolean {
        return false
    }
}



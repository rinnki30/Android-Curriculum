package com.example.androidcurriculum.ui.register

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidcurriculum.Activity.LoginActivity
import com.example.androidcurriculum.MyApplication
import com.example.androidcurriculum.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    private lateinit var registerViewModel: RegisterViewModel
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    //这个是FragmentRegisterBinding的实例，通过它可以访问到fragment_register.xml中的所有控件
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerViewModel = ViewModelProvider(
            this,
            RegisterViewModelFactory()
        ).get(RegisterViewModel::class.java)

        val etUsername = binding.etUsername
        val etPassword = binding.etPassword
        val etConfirmPassword = binding.etConfirmPassword
        val registerButton = binding.registerButton

        //这是一个观察者，当registerFormState发生变化时，会调用Observer的onChanged方法，更新UI
        registerViewModel.registerFormState.observe(viewLifecycleOwner,
            Observer { registerFormState ->
                if (registerFormState == null) {
                    return@Observer
                }
                registerButton.isEnabled = registerFormState.isDataValid
                registerFormState.usernameError?.let {
                    etUsername.error = getString(it)
                }
                registerFormState.passwordError?.let {
                    etPassword.error = getString(it)
                }
                registerFormState.confirmpasswordError?.let {
                    etConfirmPassword.error = getString(it)
                }
            })
        //这是一个观察者，当registerResult发生变化时，会调用Observer的onChanged方法，更新UI
        registerViewModel.registerResult.observe(viewLifecycleOwner,
            Observer { registerResult ->
                registerResult ?: return@Observer
                registerResult.error?.let {
                    showRegisterFailed(it)
                }
                registerResult.success?.let {
                    updateUiWithUser(it)
                }
            })
        //这是一个观察者，当registerResult发生变化时，会调用Observer的onChanged方法，更新UI
        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                // ignore
            }

            override fun afterTextChanged(s: Editable) {
                registerViewModel.registerDataChanged(
                    etUsername.text.toString(),
                    etPassword.text.toString(),
                    etConfirmPassword.text.toString()
                )
            }
        }
        //给etUsername，etPassword，etConfirmPassword添加文本变化监听器
        etUsername.addTextChangedListener(afterTextChangedListener)
        etPassword.addTextChangedListener(afterTextChangedListener)
        etConfirmPassword.addTextChangedListener(afterTextChangedListener)
        //给registerButton添加点击监听器
        registerButton.setOnClickListener {
            registerViewModel.register(
                etUsername.text.toString(),
                etPassword.text.toString(),
                etConfirmPassword.text.toString()
            )
            //延迟500毫秒跳转到登录界面
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(intent)
            }, 500) // 延迟500毫秒
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun updateUiWithUser(model: RegisteredUserView) {
        val register = model.username + " registered successfully"
        Toast.makeText(MyApplication.context, register, Toast.LENGTH_LONG).show()
    }

    private fun showRegisterFailed(@StringRes errorString: Int) {
        Toast.makeText(MyApplication.context, errorString, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
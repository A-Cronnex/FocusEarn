package com.example.focusearn.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.focusearn.R
import com.google.android.material.textfield.TextInputEditText
import android.text.Editable
import java.sql.Date


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [IntroAppFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val backButtonRegister = view.findViewById<ImageButton>(R.id.backButton_register)
        val registerButton = view.findViewById<AppCompatButton>(R.id.signIn)

        //Get Text Inputs

        val password = view.findViewById<TextInputEditText>(R.id.make_password)
        val date = view.findViewById<EditText>(R.id.birthDate)
        val username = view.findViewById<TextInputEditText>(R.id.username)
        val email = view.findViewById<TextInputEditText>(R.id.email)

        val checkList : MutableList<Boolean> = mutableListOf()

        backButtonRegister.setOnClickListener(){
            replaceFragment(IntroAppFragment())
        }

        registerButton.setOnClickListener(){
            if(password.text.toString().length < 8){
                Toast.makeText(requireActivity(), "La contraseña debe de tener más de 8 caracteres", Toast.LENGTH_SHORT).show()
            }

            if (checkList.size < 4){
                val list_text : List<Editable?> = listOf(password.text,date.text,username.text,email.text)

                for (i in list_text.indices) {
                    if (list_text[i]?.toString() == ""){
                        Toast.makeText(requireActivity(), "Por favor, termine de llenar las casillas", Toast.LENGTH_SHORT).show()
                        break
                    } else {
                        checkList.add(true)
                    }
                }
            }

            if (checkList.size == 4){
                Toast.makeText(requireActivity(), "Registrado", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun replaceFragment(fragment: Fragment){

        val main_activity = requireActivity()
        val manager = main_activity.supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.host, fragment)
        transaction.commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment IntroApp.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            IntroAppFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
package com.example.week4_160420136.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.week4_160420136.R
import com.example.week4_160420136.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {

    private  lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()
        observeViewModel(view)
    }
    fun observeViewModel(view: View) {
        viewModel.studentLD.observe(viewLifecycleOwner) {
            view.findViewById<EditText>(R.id.txtID).setText(it.id)
            view.findViewById<EditText>(R.id.txtName).setText(it.name)
            view.findViewById<EditText>(R.id.txtBod).setText(it.dob)
            view.findViewById<EditText>(R.id.txtPhone).setText(it.phone)
        }
    }
}
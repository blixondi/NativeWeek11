package com.ubaya160420092.adv160420092week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.ubaya160420092.adv160420092week4.R
import com.ubaya160420092.adv160420092week4.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel=ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.fetch()

        val txtStudentID=view.findViewById<TextInputEditText>(R.id.txtID)
        val txtStudentName=view.findViewById<TextInputEditText>(R.id.txtName)
        val txtBoD=view.findViewById<TextInputEditText>(R.id.txtBoD)
        val txtPhone=view.findViewById<TextInputEditText>(R.id.txtPhone)

        detailViewModel.studentLD.observe(viewLifecycleOwner){studentDetail ->
            txtStudentID.setText(studentDetail.id.toString())
            txtStudentName.setText(studentDetail.name.toString())
            txtBoD.setText(studentDetail.bod.toString())
            txtPhone.setText(studentDetail.phone.toString())
        }
    }
}
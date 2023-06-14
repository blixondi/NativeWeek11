package com.ubaya160420092.adv160420092week4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.ubaya160420092.adv160420092week4.R
import com.ubaya160420092.adv160420092week4.databinding.FragmentStudentDetailBinding
import com.ubaya160420092.adv160420092week4.util.loadImage
import com.ubaya160420092.adv160420092week4.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var detailViewModel: DetailViewModel
    private lateinit var dataBinding:FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var student_id=""
        val txtStudentID=view.findViewById<TextInputEditText>(R.id.txtID)
        val txtStudentName=view.findViewById<TextInputEditText>(R.id.txtName)
        val txtBoD=view.findViewById<TextInputEditText>(R.id.txtBoD)
        val txtPhone=view.findViewById<TextInputEditText>(R.id.txtPhone)

        arguments?.let {
            student_id=StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        }

        detailViewModel=ViewModelProvider(this).get(DetailViewModel::class.java)
        detailViewModel.fetch(student_id)

        var imageView = view.findViewById<ImageView>(R.id.imageView2)
        var progressBar = view.findViewById<ProgressBar>(R.id.progressBar)

        detailViewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
        })
        }
    }


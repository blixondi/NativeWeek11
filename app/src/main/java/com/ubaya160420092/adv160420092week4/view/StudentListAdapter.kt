package com.ubaya160420092.adv160420092week4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ubaya160420092.adv160420092week4.R
import com.ubaya160420092.adv160420092week4.model.Student

class StudentListAdapter(val studenList:ArrayList<Student>): RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentListAdapter.StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)

        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentListAdapter.StudentViewHolder, position: Int) {
        val txtID = holder.view.findViewById<TextView>(R.id.txtID)
        val txtName = holder.view.findViewById<TextView>(R.id.txtName)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        txtID.text = studenList[position].id
        txtName.text = studenList[position].name
        btnDetail.setOnClickListener{
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return studenList.size
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}
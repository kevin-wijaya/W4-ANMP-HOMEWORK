package com.example.week4_160420136.view

import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.week4_160420136.R
import com.example.week4_160420136.model.Student
import com.squareup.picasso.Picasso


class StudentListAdapter(val studentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    class StudentViewHolder (var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        with(holder.view) {
            findViewById<TextView>(R.id.txtID).text = studentList[position].id
            findViewById<TextView>(R.id.txtName).text = studentList[position].name
            Picasso.get()
                .load(studentList[position].photoUrl)
                .into(findViewById<ImageView>(R.id.imageViewStudent))
            findViewById<Button>(R.id.btnDetail).setOnClickListener{
                val action = StudentListFragmentDirections.actionStudentDetail()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}
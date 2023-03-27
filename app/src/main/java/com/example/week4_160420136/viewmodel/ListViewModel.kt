package com.example.week4_160420136.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week4_160420136.model.Student

class ListViewModel:ViewModel() {
    val studentsLD = MutableLiveData<ArrayList<Student>>()
    val studentLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778","https://picsum.photos/200")

        val student2 = Student("13312","Rich","1994/12/14","3925444073", "https://picsum.photos/200")

        val student3 = Student("11204","Dinny","1994/10/07","6827808747","https://picsum.photos/200")
        val studentList:ArrayList<Student> = arrayListOf<Student>(student1, student2, student3)
        studentsLD.value = studentList
        studentLoadErrorLD.value = false
        loadingLD.value = false
    }

}
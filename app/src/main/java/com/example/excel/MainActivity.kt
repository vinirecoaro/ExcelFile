package com.example.excel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.excel.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), ExportInterface {

    private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btGenerate.setOnClickListener {
            val xlsModelList : MutableList<XlsModel> = ArrayList()
            xlsModelList.add(XlsModel("1", "Alice", "Class A", "Bench 1", "18", "Female", "A+"))
            xlsModelList.add(XlsModel("2", "Bob", "Class B", "Bench 2", "17", "Male", "B"))
            xlsModelList.add(XlsModel("3", "Charlie", "Class C", "Bench 3", "16", "Male", "B-"))
            xlsModelList.add(XlsModel("4", "David", "Class A", "Bench 1", "18", "Male", "A"))
            xlsModelList.add(XlsModel("5", "Emma", "Class B", "Bench 2", "17", "Female", "C+"))
            xlsModelList.add(XlsModel("6", "Frank", "Class C", "Bench 3", "16", "Male", "C"))
            xlsModelList.add(XlsModel("7", "Grace", "Class A", "Bench 1", "18", "Female", "A-"))
            xlsModelList.add(XlsModel("8", "Henry", "Class B", "Bench 2", "17", "Male", "B+"))
            xlsModelList.add(XlsModel("9", "Ivy", "Class C", "Bench 3", "16", "Female", "B"))
            xlsModelList.add(XlsModel("10", "Jack", "Class A", "Bench 1", "18", "Male", "B-"))
            xlsModelList.add(XlsModel("11", "Kate", "Class B", "Bench 2", "17", "Female", "C"))

            val gson : Gson = Gson()
            var jsonArray = gson.toJsonTree(xlsModelList).asJsonArray

            var titles : Array<String> = arrayOf("ID", "Name", "Class", "Bench", "Age", "Gender", "Grade")
            var indexName : Array<String> = arrayOf("studentId", "studentName", "studentClass", "studentBench", "studentAge", "studentGender", "studentGrade")

            var file = generateXlsFile(this, titles, indexName, jsonArray, HashMap(), "Student Record", "students", 0)

        }

    }
}
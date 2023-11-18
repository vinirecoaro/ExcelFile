package com.example.excel

import android.app.Activity
import com.google.gson.JsonArray
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import java.io.File

interface ExportInterface {

    fun generateXlsFile(activity : Activity, titles : Array<String>,
                        indexName : Array<String>, jsonArray : JsonArray,
                        otherValueMap : HashMap<String, String>, sheetName : String,
                        fileName : String, otherRowItemCount : Int) : File {

        try{
            val wb : Workbook = HSSFWorkbook()
            val sheet : Sheet = wb.createSheet(sheetName)

        }catch (e : java.lang.Exception){
            e.printStackTrace()
        }

    }

}
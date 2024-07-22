package com.example.jetpackcompostcalculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

class CalculatorViewModel:ViewModel()
{
    private val _equationText= MutableLiveData("")
    val equationText: LiveData<String> = _equationText


    private val _result=MutableLiveData("0")
    val result : LiveData<String> = _result

    fun OnButtonClick(btn:String){


        _equationText.value?.let {

            if(btn=="AC")
            {
                _equationText.value=""
                _result.value="0"
                return
            }
            if(btn=="C")
            {
                if(it.isNotEmpty()){
                   _equationText.value=it.substring(0,it.length-1)
                }
                return
            }
            if(btn=="="){
                _equationText.value=_result.value
                return
            }

            _equationText.value=it+btn

            try {
                _result.value=calculationResult(_equationText.value.toString())
            }
            catch (_:Exception){}
        }
    }
}

fun calculationResult(equation : String):String{
    val context :Context=Context.enter()
    context.optimizationLevel=-1
    val scriptable:Scriptable=context.initStandardObjects()
    var finalresult=context.evaluateString(scriptable,
        equation,
        "Javascript",
        1,null).toString()
    if(finalresult.endsWith(".0"))
    {
        finalresult=finalresult.replace(".0","")
    }
    return finalresult
}
package viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Division
import com.example.myapplication.divisionList

class DivisionViewModel : ViewModel() {
    fun getDivisions(): ArrayList<Division> {
        return divisionList
    }
}
package viewModel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Division
import com.example.myapplication.divisionList

class DivisionViewModel : ViewModel() {
    private val _divisions = MutableLiveData<ArrayList<Division>>()
    val division: LiveData<ArrayList<Division>> get() = _divisions

    fun getItems(){
        val handler = Handler()
        handler.postDelayed({
            _divisions.value = divisionList
        }, 3000)

    }
}
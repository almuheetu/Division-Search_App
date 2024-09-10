package viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Thana
import com.example.myapplication.thanaList

class ThanaViewModel : ViewModel() {
    private val _thanas = MutableLiveData<ArrayList<Thana>>()
    val thanas: LiveData<ArrayList<Thana>> get() = _thanas
    init {
        _thanas.value = thanaList
    }

//    fun getThanas(districtName: String): ArrayList<Thana> {
//        return thanaList.filter { it.districtName == districtName } as ArrayList<Thana>
//    }
}
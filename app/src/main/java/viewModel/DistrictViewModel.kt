package viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.District
import com.example.myapplication.districtList

class DistrictViewModel : ViewModel() {
    private val _districts = MutableLiveData<ArrayList<District>>()
    val districts: LiveData<ArrayList<District>> get() = _districts
    init {
        _districts.value = districtList
    }
}
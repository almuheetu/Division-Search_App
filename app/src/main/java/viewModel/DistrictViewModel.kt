package viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.District
import com.example.myapplication.districtList

class DistrictViewModel : ViewModel() {
    fun getDistricts(districName: String): ArrayList<District> {
        return districtList.filter { it.divisionName == districName } as ArrayList<District>
    }
}
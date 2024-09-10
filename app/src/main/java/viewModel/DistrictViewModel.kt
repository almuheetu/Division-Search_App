package viewModel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.District
import com.example.myapplication.districtList

class DistrictViewModel : ViewModel() {
    private val _districts = MutableLiveData<ArrayList<District>>()
    val districts: LiveData<ArrayList<District>> get() = _districts

    fun getDistricts(){
        val handler = Handler()
        handler.postDelayed({
            _districts.value = districtList
        }, 3000)

    }
}
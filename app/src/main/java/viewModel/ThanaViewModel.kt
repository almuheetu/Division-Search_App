package viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Thana
import com.example.myapplication.thanaList

class ThanaViewModel : ViewModel() {
    fun getThanas(districtName: String): ArrayList<Thana> {
        return thanaList.filter { it.districtName == districtName } as ArrayList<Thana>
    }
}
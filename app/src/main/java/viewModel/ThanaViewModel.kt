package viewModel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Thana
import com.example.myapplication.thanaList

class ThanaViewModel : ViewModel() {
    private val _thanas = MutableLiveData<ArrayList<Thana>>()
    val thanas: LiveData<ArrayList<Thana>> get() = _thanas

    fun getThana(){
        val handler = Handler()
        handler.postDelayed({
            _thanas.value = thanaList
        }, 3000)
    }

}
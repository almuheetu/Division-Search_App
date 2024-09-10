package viewModel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Post
import com.example.myapplication.postList

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<ArrayList<Post>>()
    val posts: LiveData<ArrayList<Post>> get() = _posts

    fun getPosts(){
        val handler = Handler()
        handler.postDelayed({
            _posts.value = postList
        }, 3000)
    }

//    fun getPosts(districName: String): ArrayList<Post> {
//        return postList.filter { it.thanaName == districName } as ArrayList<Post>
//    }
}

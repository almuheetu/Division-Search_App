package viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Post
import com.example.myapplication.postList

class PostViewModel : ViewModel() {
    private val _posts = MutableLiveData<ArrayList<Post>>()
    val posts: LiveData<ArrayList<Post>> get() = _posts
    init {
        _posts.value = postList
    }

//    fun getPosts(districName: String): ArrayList<Post> {
//        return postList.filter { it.thanaName == districName } as ArrayList<Post>
//    }
}

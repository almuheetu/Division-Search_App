package viewModel

import androidx.lifecycle.ViewModel
import com.example.myapplication.Post
import com.example.myapplication.postList

class PostViewModel : ViewModel() {
    fun getPosts(districName: String): ArrayList<Post> {
        return postList.filter { it.thanaName == districName } as ArrayList<Post>
    }
}

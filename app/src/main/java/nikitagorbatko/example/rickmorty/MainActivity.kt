package nikitagorbatko.example.rickmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentCharacters =  FragmentCharacters(listener = {
            supportFragmentManager.commit {
                title = it.name
                replace(R.id.root, FragmentPerson(it))
                addToBackStack(null)
            }
        })

        supportFragmentManager.commit {
            title = "Characters"
            replace(R.id.root, fragmentCharacters)
        }
    }
}
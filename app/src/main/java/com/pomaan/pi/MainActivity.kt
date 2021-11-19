import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.pomaan.pi.PlantAdapter
import com.pomaan.pi.R
import com.pomaan.pi.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = PlantAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
        }
    }

    fun onClickResult(view: View){
        if(!isFieldEmpty()){
            val result = getString(R.string.result_info) + getResult()
            binding.tvResult.text = result
        }
    }

    private fun isFieldEmpty(): Boolean{
        binding.apply {
            if(edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            if(edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено"
            return  edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String{
        val a: Double
        val b: Double
        binding.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt((a.pow(2) + b.pow(2))).toString()
    }
}
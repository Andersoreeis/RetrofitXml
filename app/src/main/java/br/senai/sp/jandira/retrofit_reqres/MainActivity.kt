package br.senai.sp.jandira.retrofit_reqres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.google.gson.JsonObject
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiService = RetrofitHelper.getInstance().create(ApiService::class.java)

        // BOTÃO DE GET
        findViewById<Button>(R.id.btnGET).setOnClickListener() {
            getUserById()
        }

        // BOTÃO DE PUT
        findViewById<Button>(R.id.btnPUT).setOnClickListener() {
            updateUser()
        }

        // BOTÃO DE DELETE
        findViewById<Button>(R.id.btnDELETE).setOnClickListener() {
            deleteUser()
        }


        // BOTÃO DE POST
        findViewById<Button>(R.id.btnPOST).setOnClickListener() {
            createUser()
        }
    }

    // LISTAGEM DE USUÁRIOS
    private fun getUserById() {
        lifecycleScope.launch {
            val result = apiService.getUserById("2")
            if (result.isSuccessful) {
                Log.i("GETTING-DATA", "${result.body()?.data}")
            } else {
                Log.i("GETTING-DATA", "${result.message()}")
            }
        }
    }


    // INSERE USUÁRIO
    private fun createUser() {
        lifecycleScope.launch {
            val body = JsonObject().apply {
                addProperty("name", "Anderson")
                addProperty("job", "Desenvolvedor")


            }
            val result = apiService.createUser(body)
            if (result.isSuccessful) {
                Log.i("GETTING-DATA", "${result.body()}")
            } else {
                Log.i("GETTING-DATA", "${result.message()}")
            }
        }
    }

    // ATUALIZA O USUÁRIO
    private fun updateUser() {
        lifecycleScope.launch {

            val body = JsonObject().apply {
                addProperty("name", "KOTLIZINHO")
                addProperty("job", "Desenvolvedor")


            }

            val result = apiService.updateUser("10", body)
            if (result.isSuccessful) {
                Log.i("GETTING-DATA", "${result.body()}")
            } else {
                Log.i("GETTING-DATA", "${result.message()}")
            }
        }

    }

    //  DELETAR O USUÁRIO
    private fun deleteUser() {
        lifecycleScope.launch {
            val result = apiService.deleteUser("10")
            if (result.isSuccessful) {
                Log.i("GETTING-DATA", "${result}")
            } else {
                Log.i("GETTING-DATA", "${result.message()}")
            }
        }
    }

}
package com.arc.a2020_fingerprintauth


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val executor = Executors.newSingleThreadExecutor()
        val activity: FragmentActivity = this //reference to Activity
        val biometricPrompt = BiometricPrompt(activity,executor,object : BiometricPrompt.AuthenticationCallback(){

            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                if(errorCode == BiometricPrompt.ERROR_NEGATIVE_BUTTON){
                    Toast.makeText(this@MainActivity,"negative dipencet",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                success()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                failed()
            }
        })

        val promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Judul yang ditampilkan")
            .setSubtitle("Subtitle yang ditampilkan")
            .setDescription("Deskripsi yang ditampilkan")
            .setNegativeButtonText("Negatve Button")
            .build()

        authenticateButton.setOnClickListener {
            biometricPrompt.authenticate(promptInfo)
        }
    }


    fun success(){
        SuccessActivity.startThisActivity(this)
    }

    fun failed(){
        FailedActivity.startThisActivity(this)
    }
}

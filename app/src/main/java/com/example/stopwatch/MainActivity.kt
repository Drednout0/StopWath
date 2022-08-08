package com.example.stopwatch


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

     private var seconds = 0
     private var  running: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        runTimer()
    }
        fun onClickStart(view: View?) {
           running = true
      }
    fun onClickStop(view:View?){
        findViewById<Button>(R.id.stop_button)
         running  = false
      }
    fun onClickReset(view: View?){
        findViewById<Button>(R.id.reset_button)
         running  = false
         seconds = 0

      }

    private fun runTimer() {
        val timeView: TextView = findViewById(R.id.time_view)
        val handler = Handler(Looper.getMainLooper())
        handler.post(object: Runnable {

            override fun run() {
                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60
                val time = String.format(
                    "%d:%02d:%02d",
                    hours, minutes, secs)
                timeView.setText(time)
                if (running) {
                    seconds++
                }
                handler.postDelayed(this, 1000)
            }

        })
    }
}













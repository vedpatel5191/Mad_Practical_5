package com.example.madpra_5_90_5b6

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edit_text: EditText = findViewById(R.id.edit_text)
        var edittext_number: EditText = findViewById(R.id.edittext_number)
        var button_browser: Button = findViewById(R.id.button_browser)
        var button_call: Button = findViewById(R.id.button_call)
        var button_calllog: Button = findViewById(R.id.button_calllog)
        var button_gallery: Button = findViewById(R.id.button_gallery)
        var button_camera: Button = findViewById(R.id.button_camera)
        var button_alarm: Button = findViewById(R.id.button_alarm)

        button_browser.setOnClickListener{
            Intent(Intent.ACTION_VIEW,Uri.parse("https://$edit_text")).also { startActivity(it) }
        }

        button_call.setOnClickListener{
            Intent(Intent.ACTION_DIAL, Uri.parse("$edittext_number")).also { startActivity(it) }
        }

        button_calllog.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE) .also { startActivity(it) }
        }

        button_gallery.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("Images/*").also { startActivity(it) }
        }

        button_camera.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
        }

        button_alarm.setOnClickListener {
            Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
        }
    }
}
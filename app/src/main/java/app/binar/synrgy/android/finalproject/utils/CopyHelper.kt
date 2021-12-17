package app.binar.synrgy.android.finalproject.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService

object CopyHelper {
    fun copyToClipboard(context : Context,textview : String){

        val clipboardManager = getSystemService(context,ClipboardManager::class.java)
        val clipData = ClipData.newPlainText("text", textview)
        clipboardManager?.setPrimaryClip(clipData)

        Toast.makeText(context, "Copied to clipboard",Toast.LENGTH_SHORT).show()
    }
}
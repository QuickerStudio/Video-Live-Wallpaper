package moe.cyunrei.videolivewallpaper.utils

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.nio.channels.FileChannel

object FileUtils {
    fun copyFile(src: File?, dst: File?) {
        if (src == null || dst == null) return
        FileInputStream(src).use { fileInputStream ->
            FileOutputStream(dst).use { fileOutputStream ->
                val fileChannelInput = fileInputStream.channel
                val fileChannelOutput = fileOutputStream.channel
                try {
                    fileChannelInput.transferTo(0, fileChannelInput.size(), fileChannelOutput)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
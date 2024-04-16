package com.example.assignmenttwoproject

import android.content.Intent
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.Until

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private lateinit var device: UiDevice

    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        device.pressHome()

        val launcherPackage = device.launcherPackageName
        assertTrue(launcherPackage.isNotEmpty())
        device.wait(Until.hasObject(By.pkg(launcherPackage).depth(0)), 5000)

        val context = InstrumentationRegistry.getInstrumentation().context
        val intent = context.packageManager.getLaunchIntentForPackage("com.example.assignmenttwoproject")?.apply {
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) // Clear out any previous instances
        }
        context.startActivity(intent)
        assertTrue(device.wait(Until.hasObject(By.pkg("com.example.assignmenttwoproject").depth(0)), 5000))
    }

    @Test
    fun testStartActivityExplicitly() {
        val startActivityButton = device.findObject(By.desc("Second Activity Explicitly"))
        startActivityButton.click()

        assertTrue(device.wait(Until.hasObject(By.text("Mobile Software Engineering Challenges")), 3000))

        val challengePresent = device.findObject(By.textContains("Low Tolerance By Users"))
        assertTrue(challengePresent != null)
    }
}
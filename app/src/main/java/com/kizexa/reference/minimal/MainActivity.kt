package com.kizexa.reference.minimal

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Only the crash proof passes this extra; a normal launch never crashes.
        val taps = if (intent.getBooleanExtra("kizexa_crash", false)) CrashProbe("probe").run(4) else 0
        setContentView(TextView(this).apply { text = "KIZEXA Manage reference app $taps" })
    }
}

package com.kizexa.reference.minimal

// The crash proof (docs/verification/crash-formats.md) starts the app with the extra kizexa_crash=true and expects the
// retraced stack to name these functions and lines. accumulate and explode each have one caller, so R8 inlines them:
// the obfuscated trace shows one frame where the source has three.
class CrashProbe(private val label: String) {
    fun run(count: Int): Int {
        val total = accumulate(count)
        return total + label.length
    }

    private fun accumulate(count: Int): Int {
        var sum = 0
        for (i in 0 until count) sum += i
        return explode(sum)
    }

    private fun explode(sum: Int): Int {
        if (sum >= 0) throw IllegalStateException("KIZEXA Manage reference crash (sum $sum)")
        return sum
    }
}

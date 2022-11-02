package com.mhmdjalal.logincompose.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun BaseLayout(
    content: @Composable PaddingValues.() -> Unit
) {
    Scaffold(
        content = {
            content.invoke(it)
        }
    )
}
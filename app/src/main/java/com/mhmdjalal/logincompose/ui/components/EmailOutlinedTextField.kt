package com.mhmdjalal.logincompose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

/**
 * @author Created by Muhamad Jalaludin on 25/10/22
 */

@Composable
fun EmailOutlinedTextField(
    textValue: String,
    isReadOnly: Boolean,
    onValueChange: (String) -> Unit,
    onClickButton: () -> Unit,
    onNext: (KeyboardActionScope.() -> Unit)
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = "Email") },
        trailingIcon = {
            if (textValue.isNotEmpty() && !isReadOnly) {
                IconButton(
                    onClick = onClickButton
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Icon Clear",
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = onNext
        ),
        shape = CircleShape,
        readOnly = isReadOnly,
        singleLine = true
    )
}